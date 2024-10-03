package Repository_WEB_Objs;

import java.util.HashMap;
import java.util.Map;

public class StoreTextKeys_Objs {

    // Creation of HashMap
    private static final Map<String, String> StoreTextKeys;

    static {
        StoreTextKeys = new HashMap<String, String>();
        StoreTextKeys.put("login_page", "//*[@id='loginContainer']");
        StoreTextKeys.put("header_element", "//*[@id='head']");
        StoreTextKeys.put("home_page", "//*[@id='article']");
        StoreTextKeys.put("register_page", "//*[@id='userRegistrationContainer']");
    }

    public String findLocator(String elementName) {
        if (StoreTextKeys.containsKey(elementName)) {
            return (StoreTextKeys.get(elementName.trim()));
        }

        return null;
    }
}
