package Repository_MOBILE_Objs;

import java.util.HashMap;
import java.util.Map;

public class CMS_Objs {
	
	private static final Map<String, String> CMS;
	
	static {
		CMS = new HashMap<String, String>();
		
		CMS.put("tsReadLess_link", "//*[@id='mk-less-1']");
	}
	
	public String findLocator(String elementName) {
        if (CMS.containsKey(elementName)) {
            return (CMS.get(elementName.trim()));
        }

        return null;
    }

}
