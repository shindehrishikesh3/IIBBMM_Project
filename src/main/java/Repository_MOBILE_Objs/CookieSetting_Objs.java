package Repository_MOBILE_Objs;

import java.util.*;

public class CookieSetting_Objs {

    // Creation of HashMap
    private static final Map<String, String> CookieSetting;

    static {
        CookieSetting = new HashMap<String, String>();
        CookieSetting.put(
            "oneTrustCookie_button",
            "//*[@id='onetrust-accept-btn-handler']"
        );
        CookieSetting.put("cookieSettings_link", "//*[@class='cookie-setting-link']");
        CookieSetting.put(
            "savePreferences_button",
            "//*[contains(@class,'save-preference')]"
        );
        CookieSetting.put("cookieebanner_element", "//*[@id='onetrust-banner-sdk']");
        CookieSetting.put("cookieeTitle_element", "//*[@id='onetrust-policy-title']");
        CookieSetting.put("moreinfo_link", "//*[@id='onetrust-policy-text']/a");
        CookieSetting.put("cookieSettings_element", "//*[@class='cookie-setting-link']");
        CookieSetting.put("cookieeprefrence_element", "//*[@id='ot-pc-title']");
        CookieSetting.put("preferenceClose_element", "//*[@id='close-pc-btn-handler']");
        CookieSetting.put("paypalPage_button", "//button[@id='acceptAllButton']");
    }

    public String findLocator(String elementName) {
        if (CookieSetting.containsKey(elementName)) {
            return (CookieSetting.get(elementName.trim()));
        }

        return null;
    }
}
