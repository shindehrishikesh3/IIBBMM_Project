package Repository_MOBILE_Objs;

import java.util.HashMap;
import java.util.Map;

public class RaspberryPi_Objs {

private static final Map<String, String> RaspberryPi;
	
	static {
		
		RaspberryPi = new HashMap<String, String>();
		
		RaspberryPi.put("nav_element", "//*[@id='piHeader']");
		RaspberryPi.put("header_element", "//*[@id='hero-header']//h1");
		RaspberryPi.put("productListingSection_element", "//*[@id='ALL']/endeca/section");
		RaspberryPi.put("productListingSectionHeader_text", "//*[@id='ALL']/endeca/section/h2");
		RaspberryPi.put("footer_element", "//*[@id='pf_footer_espot_01']");
		RaspberryPi.put("showAllProduct_button", "//*[@id='ALL']/endeca/section//*[@class='btn btn-default']");
		RaspberryPi.put("product_links", "//*[@id='ALL']/endeca/section//a");
		RaspberryPi.put("backToTop_link", "//*[@id='mbProductListing']/div/div/div[2]/a");
	}
	
	public String findLocator(String elementName) {
        if (RaspberryPi.containsKey(elementName)) {
            return (RaspberryPi.get(elementName.trim()));
        }

        return null;
    }
}
