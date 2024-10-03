package Repository_MOBILE_Objs;

import java.util.HashMap;
import java.util.Map;

public class TechnicalResources_Objs {

	 private static final Map<String, String> TechnicalResources;
	 
	 static {
		 TechnicalResources = new HashMap<String, String>();
		 
		// Engineering Glossery
		 TechnicalResources.put("glosseryContent_text", "//*[@class='section']/div/div[2]");
		 TechnicalResources.put("glosseryContentInner_links", "//*[@class='section']/div/div[2]//a");
	 }
	 
	 public String findLocator(String elementName) {
	        if (TechnicalResources.containsKey(elementName)) {
	            return (TechnicalResources.get(elementName.trim()));
	        }

	        return null;
	    }
}
