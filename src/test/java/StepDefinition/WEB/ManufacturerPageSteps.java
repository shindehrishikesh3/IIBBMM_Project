package StepDefinition.WEB;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import io.cucumber.java.en.And;

public class ManufacturerPageSteps extends WebDriverConfig {

	private ContextStore context;
	
	private static final Logger logger = LogManager.getLogger(MCLPSteps.class);
        
    public ManufacturerPageSteps(ContextStore context) {
    	this.context = context;
    }
    
    @And ("^customer stores all the urls under \"([^\"]*)\" in Raspberry PI page$")
    public void store_raspberyPI_product_listing_urls(String locator) throws Exception {
    	List<WebElement> allURLs = getMutipleLocators(locator);
    	for(WebElement url: allURLs) {
    		String key = url.getText().trim();
    		String value = url.getAttribute("href");
    		context.urls.put(key, value);
    	}
    }
}
