package StepDefinition.MOBILE;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.jayway.jsonpath.ReadContext;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import io.cucumber.java.en.And;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class EngineeringGlosseryPageSteps extends WebDriverConfig  {
	
	 private static final Logger logger = LogManager.getLogger(CheckoutSteps.class);
	    private ContextStore context;
	    private ReadContext readContext;
	    
	    String FilePath =
	        System.getProperty("user.dir") +
	        "//src//test//resources//TestData//" +
	        getEnv().toUpperCase() +
	        "//";

	    public EngineeringGlosseryPageSteps(ContextStore context) {
	        this.context = context;
	    }
	    
//	    Map<String, String> actualWordAndUrls = new HashMap<String, String>();
	    
	    @And("^open \"([^\"]*)\" url for \"([^\"]*)\".*from json \"([^\"]*)\" in mobile$")
	    public void open_url_from_category_json(String key, String categoryName, String jsonFileName ){
	        String path = fileOperations.getEnvFolderPath()+ jsonFileName;
	        System.out.println("FilePath: " + path);
	        readContext = JsonUtil.getJsonDocument(path);
	        List<String> url = readContext.read("$.HEADERS[?(@.TITLE=='"+categoryName+"')]."+key);
	        String finalurl = getSiteBaseUrl() + storeText.getStoreText(url.get(0));
	        this.context.scenario.log("url: " + finalurl);
	        driver.get(finalurl);
	    }
	    
	    @And ("^verify \"([^\"]*)\".*description with \"([^\"]*)\" in mobile$")
	    public void verify_category_description(String categoryName, String locator) throws Exception{
	        List<String> expectedContent = readContext.read("$.HEADERS[?(@.TITLE=='"+categoryName+"')].CONTENT");
	        String actualContent = actionMethods.getValueUsingAttribute(locator, "innerText").trim();
//	        String actualContent = actionMethods.getValueUsingAttribute(locator, "innerText").replace("\n", " ").trim();
	        String expcontent = expectedContent.get(0).replace("<br>", "\n\n");
	        Assert.assertEquals("Description is not as expected",expcontent, actualContent);
	    }
	    
	    @And ("^verify hyperlinked text in the description with \"([^\"]*)\" for.*\"([^\"]*)\" if any in mobile$")
	    public void verifyHyperLinkedTextAndLinks(String locator, String categoryName) throws Exception{
	        // Get expected data from json
	        List<Boolean> hrefPresent = readContext.read("$.HEADERS[?(@.TITLE=='"+categoryName+"')].HYPERLINK?");

	        HashMap<String, String>  expectedWordAndUrls = new  HashMap<String, String>();
	        if(hrefPresent.get(0).equals(true)){
	            List<Map<String, String>> expectedLinks = readContext.read("$.HEADERS[?(@.TITLE=='"+categoryName+"')].LINKS");
	 
	        for(String key :  expectedLinks.get(0).keySet()){
	        	String url = storeText.getStoreText(expectedLinks.get(0).get(key));
	        	String value = key.contains("blog")?url:getSiteBaseUrl()+url;
	            expectedWordAndUrls.put(key,value);
	        }

	        // Get actual urls
	        List<WebElement> actualLinksWE = actionMethods.getMutipleLocators(locator);
	  
	        for(WebElement element: actualLinksWE){ 
	        	String linkText = element.getAttribute("innerText").trim();
	            context.urls.put(linkText , element.getAttribute("href").trim());
	        }
	        this.context.scenario.log("Actual word=url pairs:"+context.urls);

	        // compare expected and actual
	        this.context.softAssertions.assertThat(context.urls)
	        .overridingErrorMessage("Category: %s, Actual:%s \n Expected: %s",
	        categoryName,
	        context.urls,
	        expectedWordAndUrls)
	        .isEqualTo(expectedWordAndUrls);
	        }
	    }
	    
}
