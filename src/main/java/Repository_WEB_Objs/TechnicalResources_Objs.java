package Repository_WEB_Objs;

import java.util.*;

public class TechnicalResources_Objs {

    // Creation of HashMap
    private static final Map<String, String> TechnicalResources;

    static {
        TechnicalResources = new HashMap<String, String>();
        TechnicalResources.put(
            "technicalResources_text",
            "//*[@class='text-reverse padding-bottom']"
        );
        TechnicalResources.put(
        		"glosseryContent_text",
        		"//*[@class='section']/div/div[2]"
        		);
        TechnicalResources.put(
        		"glosseryContentInner_links",
        		"//*[@class='section']/div/div[2]//a"
        		);
    }

    public String findLocator(String elementName) {
        if (TechnicalResources.containsKey(elementName)) {
            return (TechnicalResources.get(elementName.trim()));
        }

        return null;
    }
}
