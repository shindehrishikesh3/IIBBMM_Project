package Repository_WEB_Objs;

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
		RaspberryPi.put("productListingAllUrls_link", "//*[@id='ALL']/endeca/section//a");
		RaspberryPi.put("backToTop_link", "//*[@id='productListing']/div/div/div[2]/a");
		RaspberryPi.put("raspiBanner_image", "//*[@id='manuFacturer']/img");
		RaspberryPi.put("raspiBanner3_link", "//*[@id='raspi-banner3-link']");
		RaspberryPi.put("raspiBanner4_link", "//*[@id='raspi-banner4-link']");
		RaspberryPi.put("raspiBanner5_link", "//*[@id='raspi-banner5-link']");
		RaspberryPi.put("raspiBanner6_link", "//*[@id='raspi-banner6-link']");
		RaspberryPi.put("raspiBanner7_link", "//*[@id='raspi-banner7-link']");
		
		
	}
	
	public String findLocator(String elementName) {
        if (RaspberryPi.containsKey(elementName)) {
            return (RaspberryPi.get(elementName.trim()));
        }

        return null;
    }
}
