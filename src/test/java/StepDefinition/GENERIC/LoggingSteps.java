package StepDefinition.GENERIC;

import static org.junit.Assert.assertEquals;
import static org.junit.Assume.assumeTrue;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import StepDefinition.WEB.EVoucherSteps;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.PathNotFoundException;
import com.jayway.jsonpath.ReadContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public class LoggingSteps extends WebDriverConfig {

    LogEntries logs;
    List<String> analyticsUrl = new ArrayList<>();
    String requestId;
    String currentPage;
    Map<String, String> queryParamsMap = new HashMap<String, String>();

    ReadContext readContext;
    private static final Logger logger = LogManager.getLogger(UtilitySteps.class);

    private ContextStore context;

    public LoggingSteps(ContextStore context) {
        this.context = context;
    }

    @And("^I can see the log entry of the page$")
    public void log_entry() {
        // Mentioning type of Log
        LogEntries entry = getDriver().manage().logs().get(LogType.BROWSER);
        // Retrieving all log
        List<LogEntry> logs = entry.getAll();
        // Print one by one
        for (LogEntry e : logs) {
            logger.info(e);
        }

        // Printing details separately
        for (LogEntry e : logs) {
            logger.info("Message is: " + e.getMessage());
            context.scenario.log("Message is: " + e.getMessage());
            logger.info("Level is: " + e.getLevel());
            context.scenario.log("Level is: " + e.getLevel());
            context.scenario.log(
                "========================================================"
            );
        }
    }

    @And("^get performance logs$")
    public void get_performance_logs() {
        logs = getDriver().manage().logs().get(LogType.PERFORMANCE);
    }

    @And("^verify visitorAPI call based on ADOBE_VISITORAPI_IN_LAUNCH xcomreg$")
    public void verify_visitorAPI_requests() {
        String visitoAPICall = "VisitorAPI." + getGlobalRegion() + ".js";

        String referer = getDriver().getCurrentUrl();
        this.context.scenario.log("Current page URL:" + referer);

        boolean visitorAPIFlag = false;

        for (LogEntry entry : logs) {
            if (
                entry.toString().contains("\"Network.requestWillBeSent\"") &&
                entry.toString().contains(visitoAPICall)
            ) {
                try {
                    ReadContext readContext = JsonPath.parse(entry.getMessage());
                    String url = readContext
                        .read("$.message.params.request.url")
                        .toString();
                    if (url.contains(visitoAPICall)) {
                        this.context.scenario.log("VisitorAPI url:" + url);
                        //Assert.assertTrue("VisitorAPI  is not present", true);
                        if (!getRegionName().equalsIgnoreCase("europe")) {
                            visitorAPIFlag = true;
                        } else if (
                            readContext
                                .read("$.message.params.hasUserGesture")
                                .equals(true)
                        ) {
                            String initiator = readContext
                                .read("$.message.params.initiator..callFrames[:1].url")
                                .toString();
                            this.context.scenario.log(
                                    "VisitorAPI Initiator:" + initiator
                                );
                            Assert.assertTrue(initiator.contains("otBannerSdk.js"));
                            visitorAPIFlag = true;
                            break;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

	if(xcomregConfig.getProperty("ADOBE_VISITORAPI_IN_LAUNCH").equalsIgnoreCase("true")){
		if (visitorAPIFlag) {
			this.context.softAssertions
			.assertThat(true)
			.overridingErrorMessage("Negative validation failed - Visitor API call happened, ADOBE_VISITORAPI_IN_LAUNCH=%s",xcomregConfig.getProperty("ADOBE_VISITORAPI_IN_LAUNCH"))
			.isEqualTo(false);
		} else {
			this.context.scenario.log("ADOBE_VISITORAPI_IN_LAUNCH=true & Visitor API is not present as expected");
		}
	} else {

		if (visitorAPIFlag) {
			this.context.scenario.log("ADOBE_VISITORAPI_IN_LAUNCH=false and Visitor API is present as expected");
		} else {
			this.context.softAssertions
			.assertThat(true)
			.overridingErrorMessage("Negative validation failed - Visitor API call did not happen, ADOBE_VISITORAPI_IN_LAUNCH=%s",xcomregConfig.getProperty("ADOBE_VISITORAPI_IN_LAUNCH"))
			.isEqualTo(false);
		}
	}
    }

    @And("^verify \"([^\"]*)\" call exists$")
    public void verify_presence_of_http_request_in_network_traffic(String urlKey) {
        String currentPageUrl = getDriver().getCurrentUrl();
        String expUrl = null;
        Boolean isPresent = false;
        this.analyticsUrl.clear();
        switch (urlKey.toLowerCase()) {
            case "appmeasurement":
                expUrl = "AppMeasurement." + getGlobalRegion() + ".js";
                break;
            case "/ss":
                expUrl = "/ss/";
                break;
                
            case "decibel":
                expUrl = "di" + ".js";
                break;
        }

        System.out.println("Current page URL:" + currentPageUrl);

        for (LogEntry entry : logs) {
            if (
                entry.toString().contains("\"Network.requestWillBeSent\"") &&
                entry.toString().contains("\"documentURL\":\"" + currentPageUrl + "\"")
            ) {

            	if (entry.toString().contains(expUrl)) {
                    try {
                        ReadContext readContext = JsonPath.parse(entry.getMessage());
                        String url = readContext
                            .read("$.message.params.request.url")
                            .toString();
                        if (url.contains(expUrl)) {
                            System.out.println(urlKey + " url:" + url);
                            Assert.assertTrue(urlKey + " Call is not present", true);
                            requestId =
                                readContext.read("$.message.params.requestId").toString();
                            try {
                                if (
                                    readContext
                                        .read("$.message.params.request.hasPostData")
                                        .toString() ==
                                    "true"
                                ) {
                                    url =
                                        url +
                                        "?" +
                                        readContext.read(
                                            "$.message.params.request.postData"
                                        );
                                }
                            } catch (PathNotFoundException e) {}

                            this.analyticsUrl.add(url);
                            isPresent = true;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        if (!isPresent) {
            Assert.fail("Error! " + expUrl + " call is not present. ");
        }
        
    }

    @And("^verify \"([^\"]*)\" call does not exist$")
    public void verify_absence_of_http_request_in_network_traffic(String urlKey) {
        String currentPageUrl = getDriver().getCurrentUrl();
        String expUrl = null;
        Boolean isPresent = false;
        this.analyticsUrl.clear();
        switch (urlKey.toLowerCase()) {
        	case "appmeasurement":
        		expUrl = "AppMeasurement." + getGlobalRegion() + ".js";
        		break;
            case "/ss":
                expUrl = "/ss/";
                break;
        }
        System.out.println("Current page URL:" + currentPageUrl);
        for (LogEntry entry : logs) {
        	if (entry.toString().contains(expUrl)) {
        		Assert.fail("Error! " + expUrl + " call is present. ");
        	}
        }
    }
    
    @And("^verify status code is \"([^\"]*)\" in logs$")
    public void verify_status_code(String statusCode) {
        for (LogEntry entry : logs) {
            if (entry.toString().contains("\"Network.responseReceived\"")) {
                try {
                    ReadContext readContext = JsonPath.parse(entry.getMessage());
                    if (
                        readContext.read("$.message.params.requestId").equals(requestId)
                    ) {
                        assertEquals(
                            statusCode,
                            readContext.read("$.message.params.response.status")
                        );
                    }
                } catch (Exception e) {}
            }
        }
    }

    public String getGlobalRegion() {
        String globalRegion = null;
        if (getRegionName().equalsIgnoreCase("europe")) {
            globalRegion = "europe";
        } else if (getRegionName().equalsIgnoreCase("apac")) {
            globalRegion = "apac";
        } else {
            globalRegion = "americas";
        }
        return globalRegion;
    }

    @And("^get all query string parameters for \"([^\"]*)\"$")
    public void analytics_process(String keyword) throws URISyntaxException {
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        this.currentPage = keyword;

        switch (keyword.toLowerCase()) {
            case "cart-addition":
                for (String url : this.analyticsUrl) {
                    if (url.contains("events=scAdd")) {
                        params =
                            URLEncodedUtils.parse(new URI(url), Charset.forName("UTF-8"));
                    }
                }
                break;
            case "order-info-page-load":
                for (String url : this.analyticsUrl) {
                    if (url.contains("events=scCheckout")) {
                        params =
                            URLEncodedUtils.parse(new URI(url), Charset.forName("UTF-8"));
                    }
                }
                break;
            case "order-confirmation-page-load":
                for (String url : this.analyticsUrl) {
                    if (url.contains("events=purchase")) {
                        params =
                            URLEncodedUtils.parse(new URI(url), Charset.forName("UTF-8"));
                    }
                }
                break;
            default:
                params =
                    URLEncodedUtils.parse(
                        new URI(this.analyticsUrl.get(0)),
                        Charset.forName("UTF-8")
                    );
        }

        this.context.scenario.log("==========" + keyword + "=============");
        queryParamsMap.clear();
        for (NameValuePair element : params) {
            queryParamsMap.put(element.getName(), element.getValue());
        }
        this.context.scenario.log("Actual key=Value pairs:        " + queryParamsMap);
        if (queryParamsMap.isEmpty()) {
            Assert.fail("Something went wrong, no query params added");
        }
    }

    @And("^below query string parameter key exists and its value is a exact match$")
    public void query_params_exact_match(DataTable table) {
        Map<String, String> expectedMap = new HashMap<String, String>(
            table.asMap(String.class, String.class)
        );
        checkQueryParamsMapContainsKeys(expectedMap.keySet());

        if (expectedMap.keySet().contains("products")) {
            String productValue = expectedMap.get("products");
            String productValue1 = productValue.replace(
                "{orderCode}",
                this.context.ORDER_CODE
            );
            expectedMap.put("products", productValue1);
        }

        for (String key : expectedMap.keySet()) {
            this.context.softAssertions.assertThat(queryParamsMap.get(key))
                .overridingErrorMessage(
                    "Page: %s, key:%s \n Expected: %s & Actual: %s",
                    this.currentPage,
                    key,
                    expectedMap.get(key),
                    queryParamsMap.get(key)
                )
                .isEqualTo(expectedMap.get(key));
        }
    }

    @And("^below query string parameter key exists and its value contains text$")
    public void query_params_contains(DataTable table) {
        Map<String, String> expectedContainsMap = table.asMap(String.class, String.class);
        checkQueryParamsMapContainsKeys(expectedContainsMap.keySet());

        for (String key : expectedContainsMap.keySet()) {
            this.context.softAssertions.assertThat(queryParamsMap.get(key))
                .overridingErrorMessage(
                    "Page: %s, key:%s \n Expected: %s & Actual: %s",
                    this.currentPage,
                    key,
                    expectedContainsMap.get(key),
                    queryParamsMap.get(key)
                )
                .contains(expectedContainsMap.get(key));
        }
    }

    @And("^below query string parameter key exists and its value matches regex$")
    public void query_params_matches_regex(DataTable table) {
        Map<String, String> expectedContainsMap = table.asMap(String.class, String.class);

        checkQueryParamsMapContainsKeys(expectedContainsMap.keySet());

        for (String key : expectedContainsMap.keySet()) {
            this.context.softAssertions.assertThat(queryParamsMap.get(key))
                .overridingErrorMessage(
                    "Page: %s, key:%s \n Expected : %s & Actual   : %s",
                    this.currentPage,
                    key,
                    expectedContainsMap.get(key),
                    queryParamsMap.get(key)
                )
                .matches(expectedContainsMap.get(key));
        }
    }

    @And("^below query string parameter key exists and its value starts with text$")
    public void query_params_starts_with(DataTable table) {
        HashMap<String, String> expectedContainsMap = new HashMap<String, String>(
            table.asMap(String.class, String.class)
        );
        //<<<<<<< HEAD
        //        );
        //        Assert.assertTrue(
        //            "Keys are missing",
        //            queryParamsMap.keySet().containsAll(expectedContainsMap.keySet())
        //        );

        checkQueryParamsMapContainsKeys(expectedContainsMap.keySet());

        if (expectedContainsMap.keySet().contains("products")) {
            String productValue = expectedContainsMap.get("products");
            String productValue1 = productValue.replace(
                "{orderCode}",
                this.context.ORDER_CODE
            );
            expectedContainsMap.put("products", productValue1);
        }
        for (String key : expectedContainsMap.keySet()) {
            this.context.softAssertions.assertThat(queryParamsMap.get(key))
                .overridingErrorMessage(
                    "Page: %s, key:%s \n Expected : %s & Actual   : %s",
                    this.currentPage,
                    key,
                    expectedContainsMap.get(key),
                    queryParamsMap.get(key)
                )
                .startsWith(expectedContainsMap.get(key));
        }
    }

    @And(
        "^query string parameter key \"([^\"]*)\" value contains keyword \"([^\"]*)\" with \"([^\"]*)\" occurances$"
    )
    public void query_params_contains_occurances(
        String key,
        String containsKeyword,
        int count
    ) {
        this.context.softAssertions.assertThat(queryParamsMap.get(key))
            .overridingErrorMessage(
                "Page: %s, key:%s \n Expected : %s & Actual   : %s",
                this.currentPage,
                key,
                containsKeyword,
                queryParamsMap.get(key)
            )
            .contains(containsKeyword);

        int actCount = StringUtils.countMatches(queryParamsMap.get(key), containsKeyword);

        this.context.softAssertions.assertThat(actCount)
            .overridingErrorMessage(
                "Page: %s, key:%s \n Expected count: %s & Actual count: %s",
                this.currentPage,
                key,
                count,
                actCount
            )
            .isEqualTo(count);
    }

    @And(
        "^query string parameters key1 \"([^\"]*)\" and key2 \"([^\"]*)\" have exact same values$"
    )
    public void query_params_have_same_values(String key1, String key2) {
        this.context.softAssertions.assertThat(queryParamsMap.get(key1))
            .overridingErrorMessage(
                "Page: %s \n Key1/value: %s/%s & Key2/value: %s/%s",
                this.currentPage,
                key1,
                queryParamsMap.get(key1),
                key2,
                queryParamsMap.get(key2)
            )
            .isEqualTo(queryParamsMap.get(key2));
    }

    public void checkQueryParamsMapContainsKeys(Set<String> expkeys) {
        this.context.softAssertions.assertThat(
                queryParamsMap.keySet().containsAll(expkeys)
            )
            .overridingErrorMessage(
                "Missing keys. Page: %s \n expected keys: %s & Actual keys: %s",
                this.currentPage,
                expkeys,
                queryParamsMap.keySet()
            )
            .isTrue();
    }



	@And("skip rest of the script in live environment")
	public void skipInLive() {
		if (getEnv().equalsIgnoreCase("live")) {
			assumeTrue("NA for live environment", false);
		}
	}

	@SuppressWarnings("unchecked")
	@And("verify _satellite object is defined")
	public void verifySateliteObject() {
		JavascriptExecutor jse = (JavascriptExecutor) getDriver();
		Map<String, Object> results = null;
		try{
		results = (Map<String, Object>) (jse.executeScript("return _satellite"));
		System.out.println("_Satelite : "+results.toString());
		}catch(JavascriptException e){
			this.context.scenario.log("Error --> "+ e.getMessage());
		}
		this.context.softAssertions
		.assertThat(results).overridingErrorMessage("_satelite object is not defined")
		.isNotNull();
		
		
	}
	
}


