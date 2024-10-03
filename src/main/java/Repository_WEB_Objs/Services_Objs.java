package Repository_WEB_Objs;

import java.util.*;

public class Services_Objs {

    // Creation of HashMap
    private static final Map<String, String> Services;

    static {
        Services = new HashMap<String, String>();
        Services.put("services_link", "//*[@id='nav']/div[1]/h3/a");
    }

    public String findLocator(String elementName) {
        if (Services.containsKey(elementName)) {
            return (Services.get(elementName.trim()));
        }

        return null;
    }
}
