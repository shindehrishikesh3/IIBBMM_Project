package StepDefinition.WEB;

import static org.junit.Assume.assumeTrue;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import com.jayway.jsonpath.ReadContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HomeSteps extends WebDriverConfig {

    private ContextStore context;
    private static final Logger logger = LogManager.getLogger(HomeSteps.class);
    String FilePath =
        System.getProperty("user.dir") +
        "//src//test//resources//TestData//" +
        getEnv().toUpperCase() +
        "//";

    public HomeSteps(ContextStore context) {
        this.context = context;
    }

    @And("^User navigate to community URL using file \"([^\"]*)\"$")
    public void navigate_Community_URL(String FileName) throws Throwable, IOException {
        String path = FilePath + FileName;

        String lookupVal = getRegionName();
		
        if(store.equalsIgnoreCase("cpc")) {
        	lookupVal = store;
        } 
        
        List<Map<String, String>> testData = ExcelUtil.getData(path, lookupVal);

        String sku1 = testData.get(0).get("firstSku");
        String q1 = testData.get(0).get("firstSkuQuantity");
        String sku2 = testData.get(0).get("secondSku");
        String q2 = testData.get(0).get("secondSkuQuantity");

        String baseURL = getSiteBaseUrl();

        String communityURL = baseURL.concat(
            "jsp/extlink.jsp?action=buy&product=" +
            sku1 +
            "~" +
            q1 +
            "~" +
            sku2 +
            "~" +
            q2 +
            "&COM=superwidget-link"
        );
        logger.info("Community URL: " + communityURL);
        driver.get(communityURL);
    }

    @And("^I enter ordercode in Searchbox to navigate to PDP page$")
    public void enter_order_code() throws Exception {
        String expectedOrderCode = this.context.constants.getOrderCode();
        actionMethods.enterText(expectedOrderCode, "Header.searchBox_textbox");
        this.context.scenario.log("ordercode: " + expectedOrderCode);
    }

    @Given("^.*enter \"([^\"]*)\".* from file \"([^\"]*)\" in searchbox$")
    public void enter_order_code_from_file(String key, String filename) throws Exception {
        String path = FilePath + filename;
        List<Map<String, String>> testData = ExcelUtil.getData(path, getStore());
        String searchterm = testData.get(0).get(key);
        if (searchterm == null || searchterm.equalsIgnoreCase("")) {
            assumeTrue("Data missing.NA for this store. product Type:" + key, false);
        } else {
            actionMethods.enterText(searchterm, "Header.searchBox_textbox");
            this.context.scenario.log("searchterm :" + searchterm);
            this.context.ORDER_CODE = searchterm;
        }
    }

    @Given("^.*enter \"([^\"]*)\".* from json \"([^\"]*)\" in searchbox$")
    public void enter_order_code_from_json_file(String key, String filename)
        throws Exception {
        String path = FilePath + filename;
        ReadContext rx = JsonUtil.getJsonDocument(path);
        String searchterm = rx.read("$.data." + getStore() + "." + key);
        if (searchterm == null || searchterm.equalsIgnoreCase("")) {
            assumeTrue("Data missing.NA for this store. product Type:" + key, false);
        } else {
            actionMethods.enterText(searchterm, "Header.searchBox_textbox");
            this.context.scenario.log("searchterm :" + searchterm);
            this.context.ORDER_CODE = searchterm;
        }
    }
}
