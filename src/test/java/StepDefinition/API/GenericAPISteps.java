package StepDefinition.API;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Assert;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import io.cucumber.java.en.And;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.config.RedirectConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GenericAPISteps extends WebDriverConfig {
	 private ContextStore context;

	    private static final Logger logger = LogManager.getLogger(PunchoutAPISteps.class);

	    public GenericAPISteps(ContextStore context) {
	        this.context = context;
	    }

	    @And ("^make get request in \"([^\"]*)\" store to fetch the response for \"([^\"]*)\" parameter without auto redirection$")
	    public void validate_response_without_auto_redirect(String storeName, String pathParameter) throws IOException {
	    	HashMap<String, String> headers = new HashMap<String, String>();
	    	HashMap<String, String> queryParams = new HashMap<String, String>();
	    	//RestAssured.proxy(getProxyHost(), getProxyPort());
		apiBaseMethods.setRestAssuredProxy();
	        // prepare environment
	        setBaseURI(storeName);
	    	this.context.config = RestAssuredConfig
	                .config().redirect(RedirectConfig.redirectConfig().followRedirects(false));
	    	context.response = apiBaseMethods.getRequest(this.context.config, headers, queryParams, pathParameter);
	    }

	    @And ("^verify response status code for hyperlinks is \"([^\"]*)\".*$")
	    public void verify_hyperlink_status_code(int statusCode) {

		apiBaseMethods.setRestAssuredProxy();

	    	 if (!context.urls.isEmpty()) {
	             for (String key : context.urls.keySet()) {
	            	 Response response =RestAssured
	                         .given()
	                         .log()
	                         .all()
	                         .when()
	                         .get(context.urls.get(key));
	                 this.context.softAssertions.assertThat(response.statusCode()).overridingErrorMessage("Unable to navigate to inner hyperlink: %s as the status code is %d",
	                		 context.urls.get(key), response.statusCode()).isEqualTo(statusCode);
	             }
	         }else
	         	this.context.scenario.log("No hyperlinks to validate");
	    }
	    
}
