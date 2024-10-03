package Repository_MOBILE_Objs;

import java.util.HashMap;
import java.util.Map;

public class AboutUs_Objs {

    // Creation of HashMap
    private static final Map<String, String> AboutUs;

    static {
        AboutUs = new HashMap<String, String>();
        AboutUs.put("aboutUs_text", "//*[@id='navbarDropdownMenuLink']");
    }

    public String findLocator(String elementName) {
        if (AboutUs.containsKey(elementName)) {
            return (AboutUs.get(elementName.trim()));
        }

        return null;
    }
}
