package Repository_WEB_Objs;

import java.util.*;

public class CookieSetting_Objs {

    // Creation of HashMap
    private static final Map<String, String> CookieSetting;

    static {
        CookieSetting = new HashMap<String, String>();
        CookieSetting.put("cookiePolicy_dialogBox", "//*[@id='onetrust-policy']");
        CookieSetting.put(
            "oneTrustCookie_button",
            "//*[@id='onetrust-accept-btn-handler']"
        );
        CookieSetting.put(
            "cookieAcceptanceNonUK_button",
            "//*[@id='mktg_Cookie_button']"
        );
        CookieSetting.put("cookieSettings_link", "//*[@class='cookie-setting-link']");
        CookieSetting.put(
            "savePreferences_button",
            "//*[contains(@class,'save-preference')]"
        );
        CookieSetting.put("cookieAllowAll_Button","//*[@id='accept-recommended-btn-handler']");

        CookieSetting.put("cookieFunctional_Switch","//label[@for='ot-group-id-C0003']/span[1]");
        CookieSetting.put("cookieTargeting_Switch", "//label[@for='ot-group-id-C0004']/span[1]");
        CookieSetting.put("cookiePerformance_Switch", "//label[@for='ot-group-id-C0002']/span[1]");
        CookieSetting.put("aboutCookies_element", "//*[@class='mk-col-100']");
        CookieSetting.put("moreinfo_link", "//*[@id='onetrust-policy-text']/a");

        //Paypal window element
        CookieSetting.put("paypalPage_button", "//button[@id='acceptAllButton']");
    }

    public String findLocator(String elementName) {
        if (CookieSetting.containsKey(elementName)) {
            return (CookieSetting.get(elementName.trim()));
        }

        return null;
    }
}
