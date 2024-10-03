package StepDefinition.API;

import static Common.CONSTANTS.GlobalConstants.CONTENT_TYPE_CONST;
import static Common.CONSTANTS.GlobalConstants.CONTENT_TYPE_XML;
import static Common.CONSTANTS.GlobalConstants.IFRAME_TEMPLATE_HTML;
import static Common.CONSTANTS.GlobalConstants.STORE_ID_CONST;
import static Common.CONSTANTS.GlobalConstants.XMLPATH_CXML_PL;
import static Common.CONSTANTS.GlobalConstants.XMLPATH_CXML_STATUSCODE;
import static Common.CONSTANTS.GlobalConstants.XMLPATH_CXML_STATUSTEXT;
import static Common.CONSTANTS.GlobalConstants.ZERO_CONST;

import Common.CONSTANTS.GlobalConstants;
import Common.HELPERS.ActionMethods;
import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import com.jayway.jsonpath.ReadContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Assert;

public class PunchoutAPISteps extends WebDriverConfig {

    private ContextStore context;

    private static final Logger logger = LogManager.getLogger(PunchoutAPISteps.class);

    public PunchoutAPISteps(ContextStore context) {
        this.context = context;
    }

    @When(
        ".*^post \"([^\"]*)\" request for \"([^\"]*)\" protocol with body \"([^\"]*)\"$"
    )
    public void post_request_punchout(String resourceName, String protocol, String xmlFileName)
        throws Throwable {
        String xmlfilePath = fileOperations
            .getPunchoutAPIDataStoreLevelPath()
            .concat(xmlFileName);
        String body = generateStringFromResource(xmlfilePath);

	// Generate random data for useremail and user
	ContextStore.USER_NAME = actionMethods.generateRandomNumberString("new");
	this.context.userEmail = ContextStore.USER_NAME.concat(this.context.constants.getEmailDomain());
	this.context.scenario.log("user: " + ContextStore.USER_NAME);
	this.context.scenario.log("user email: " + this.context.userEmail);

	if(xmlFileName.contains("RegisterUser")){
	body = body.replace("{newuseremail}", this.context.userEmail).replace("{newuser}", ContextStore.USER_NAME);
	}
	post_request_with_body(resourceName,protocol,body);
    }


    private void post_request_with_body(String resourceName, String protocol, String body){
	HashMap<String, String> headers = new HashMap<String, String>();
        HashMap<String, String> queryParams = new HashMap<String, String>();

        headers.put(CONTENT_TYPE_CONST, CONTENT_TYPE_XML);
        queryParams.put(STORE_ID_CONST, ZERO_CONST);

	String resourcePath = applicationConfig.getProperty(
		(GlobalConstants.PROP_KEY_PREFIX).concat(protocol)
		    .concat(".")
		    .concat(resourceName)
	    );
	    this.context.response =
		apiBaseMethods.postRequest(
		    this.context.config,
		    headers,
		    queryParams,
		    resourcePath,
		    body
		);

    }

    @When("^.*get punchoutSAPLogin url for \"([^\"]*)\" company with oci protocol$")
    public void get_oci_request(String companyType) {
        ReadContext rx = JsonUtil.getJsonDocument(
            fileOperations.getPunchoutAPIDataPath() + "PunchoutSAPLoginUrls.json"
        );
	// Generate random data for useremail and user
	ContextStore.USER_NAME = actionMethods.generateRandomNumberString("new");
	this.context.userEmail = ContextStore.USER_NAME.concat(this.context.constants.getEmailDomain());

        String url = JsonUtil.getStringKeyValueFromStoreSpecificJson(rx, getStore(), companyType);
	    if(companyType.equalsIgnoreCase("newlyRegistered")){
		    url = url.replace("[newuseremail]", this.context.userEmail).replace("[newuser]",ContextStore.USER_NAME);
        }
        this.context.punchooutResponseURL = url;
        this.context.scenario.log("URL: " + this.context.punchooutResponseURL);
    }

    @Then("status code \"([^\"]*)\"$")
    public void response_status_code(int statusCode) {
        Assert.assertEquals(
            "Status code is incorrect",
            statusCode,
            this.context.response.statusCode()
        );
    }

    @And("^response body contains status code \"([^\"]*)\" and text \"([^\"]*)\"$")
    public void verify_response_body(String expectedCode, String expectedText) {
        String statusCode = apiBaseMethods.getxmlPathFromCxmlResponse(
            this.context.response,
            XMLPATH_CXML_STATUSCODE
        );
        String statusText = apiBaseMethods.getxmlPathFromCxmlResponse(
            this.context.response,
            XMLPATH_CXML_STATUSTEXT
        );
        this.context.scenario.log(
                String.format("status code:%s \n status text: %s", statusCode, statusText)
            );
        Assert.assertEquals("Status code is incorrect", expectedCode, statusCode);
        Assert.assertEquals("Status text is incorrect", expectedText, statusText);
    }

    @Then("^response body contains cxml login url")
    public void verify_xml_response_contains_response_url() {
        this.context.punchooutResponseURL =
            apiBaseMethods.getxmlPathFromCxmlResponse(
                this.context.response,
                XMLPATH_CXML_PL
            );
        this.context.scenario.log("Response URL: " + this.context.punchooutResponseURL);
        Assert.assertTrue(
            "Response url is null",
            !this.context.punchooutResponseURL.isEmpty()
        );
    }

    public String generateStringFromResource(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }

    @When("^.* open response url in browser in iframe$")
    public void open_response_url_in_browser_in_iframe() throws IOException {
        String html = generateStringFromResource(
            fileOperations.getPunchoutAPIDataPath().concat(IFRAME_TEMPLATE_HTML)
        );
        // Parse the html string into a document
        Document doc = Jsoup.parse(html, "UTF-8");
        Element a = doc.getElementById("urlid");

        // Create html element with response url
        Element add = new Element("a");
        add.attr("href", this.context.punchooutResponseURL);
        add.attr("target", "iframe_a");
        add.attr("id", "responseurl");
        add.html("Launch Punchout website");
        a.after(add);
        a.remove();

        // Generate filename
        String fileName = store
            .concat(getEnv())
            .concat("_")
            .concat(String.valueOf(ActionMethods.getEpochSeconds()))
            .concat(".html");
        String filepath = fileOperations.getTestOutputPath().concat(fileName);

        File f = new File(filepath);
        FileUtils.writeStringToFile(f, doc.html(), StandardCharsets.UTF_8);

        this.getDriver().get("file://" + filepath);
    }

    @Then("^response body contains punchout url")
    public void verify_html_response_contains_punchout_url() {
        Document doc = Jsoup.parse(this.context.response.body().asString(), "UTF-8");
        List<Element> element = doc.getElementsByAttributeValue("language", "JavaScript");
        String innerText = element.get(0).html().replaceAll("\"", "").replaceAll(";", "");
        String[] url = innerText.split("location.href=");
        this.context.punchooutResponseURL = url[1];
        this.context.scenario.log("URL: " + url[1]);
    }

    @When("^.* open response url in browser$")
    public void open_response_url_in_browser() throws IOException {
        getDriver().get(this.context.punchooutResponseURL);
    }
}
