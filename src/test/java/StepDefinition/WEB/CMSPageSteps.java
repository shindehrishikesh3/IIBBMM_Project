package StepDefinition.WEB;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import io.cucumber.java.en.And;

public class CMSPageSteps extends WebDriverConfig {
	private ContextStore context;
	
	public CMSPageSteps(ContextStore context) {
		this.context = context;
	}
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	@And ("^.*validate.* \"([^\"]*)\" ajax call is happening.*$")
	public void validate_ajax_call(String value) {
		Object ajaxCalls = js.executeScript("return window.performance.getEntriesByType('resource');");
		List<String> ajaxURLs = new ArrayList<>();
		boolean isAjaxCallMade = false;
		for(Object ajaxCall : (ArrayList<?>) ajaxCalls) {
			Object url = ((Map<?,?>) ajaxCall).get("name");
			ajaxURLs.add((String)url);
		}
		
		System.out.println("All Ajax Calls: "+ ajaxURLs);
		
		for(String url : ajaxURLs) {
			if(url.contains(value)) {
				isAjaxCallMade = true;
				break;
			}
		}
			
		if(isAjaxCallMade)
			this.context.scenario.log("======> BTF ajax call was made");
		else {
			this.context.scenario.log("======> BTF ajax call was not made");
			Assert.fail();
		}
	}
	
	@And ("^.*validate.* \"([^\"]*)\" ajax call is not happening.*$")
	public void validate_ajax_call_not_made(String value) {
		
		Object ajaxCalls = js.executeScript("return window.performance.getEntriesByType('resource');");
		List<String> ajaxURLs = new ArrayList<>();
		boolean isAjaxCallMade = false;
		for(Object ajaxCall : (ArrayList<?>) ajaxCalls) {
			Object url = ((Map<?,?>) ajaxCall).get("name");
			ajaxURLs.add((String)url);
		}
		
		System.out.println("All Ajax Calls: "+ ajaxURLs);
		
		for(String url : ajaxURLs) {
			if(url.contains(value)) {
				isAjaxCallMade = true;
				break;
			}
		}
			
		if(!isAjaxCallMade)
			this.context.scenario.log("========> BTF ajax call was not made");
		else {
			this.context.scenario.log("========> BTF ajax call was made");
			Assert.fail();
		}
	}
	
	@And ("^.*validate.* \"([^\"]*)\" image size is compressed from \"([^\"]*)\"$")
	public void compare_image_size(String value, double oldImageSize) throws IOException {
		
		Object allCalls = js.executeScript("return window.performance.getEntriesByType('resource');");
		List<String> allURLs = new ArrayList<>();
		
		for(Object call : (ArrayList<?>) allCalls) {
			Object url = ((Map<?,?>)call).get("name");
			allURLs.add((String)url);
			if(url.toString().contains(value)) {
				Object size = ((Map<?,?>)call).get("transferSize");
				double newImageSize = (long)size/1000;
				this.context.softAssertions.assertThat(newImageSize).isLessThan(oldImageSize);
				this.context.scenario.log("=====>Old Image size: " + oldImageSize + "kB and new image size: " + newImageSize + "kB");
			}
		}
		
	}
}
