package StepDefinition.MOBILE;

import java.util.List;

import org.openqa.selenium.WebElement;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import io.cucumber.java.en.And;

public class ManufacturerPageSteps extends WebDriverConfig {
	
	private ContextStore context;

    public ManufacturerPageSteps(ContextStore context) {
        this.context = context;
    }
    
    //Raspberry pi steps
    
    @And ("^.*store.*all the urls under \"([^\"]*)\" in Raspberry PI page mobile$")
    public void store_all_raspberrypi_urls(String locator) throws Exception {
    	List<WebElement> allURLs = getMutipleLocators(locator);
    	for(WebElement url: allURLs) {
    		String key = url.getText().trim();
    		String value = url.getAttribute("href");
    		context.urls.put(key, value);
    	}
    }

}
