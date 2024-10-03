package Repository_MOBILE_Objs;

import java.util.HashMap;
import java.util.Map;

public class AccountSummary_Objs {

    // Creation of HashMap
    private static final Map<String, String> AccountSummary;

    static {
        AccountSummary = new HashMap<String, String>();

        AccountSummary.put(
            "profileInformation_section",
            "//*[@class='profile-information outlined-section']"
        );
        AccountSummary.put(
            "editProfile_button",
            "//*[@class='profile-information outlined-section']/a"
        );
        AccountSummary.put("currentPassword_input", "//*[@id='logonPasswordOld']");
        AccountSummary.put(
            "changePassword_button",
            "//*[@id='UpdateUserPassword']//input[@type='submit']"
        );
        AccountSummary.put("errorMsg_text", "//*[@id='formErrors']/ul//ul/li/label");
        AccountSummary.put(
            "firstErrorMsg_text",
            "//*[@id='formErrors']/ul//ul/li[1]/label"
        );
        AccountSummary.put("confirmPassword_input", "//*[@id='logonPasswordVerify']");
        AccountSummary.put("myAccountSummary_text", "//*[@id='article']/h1");
    }

    public String findLocator(String elementName) {
        if (AccountSummary.containsKey(elementName)) {
            return AccountSummary.get(elementName.trim());
        }
        return null;
    }
}
