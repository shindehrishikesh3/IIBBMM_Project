package Repository_WEB_Objs;

import java.util.*;

public class ForgotUsername_Objs {

    // Creation of HashMap
    private static final Map<String, String> ForgotUsername;

    static {
        ForgotUsername = new HashMap<String, String>();
        ForgotUsername.put("email_text", "//input[@id='email1']");
        ForgotUsername.put("sendUsername_button", "//button[@id='resetUsername']");
        ForgotUsername.put("email_label", "//label[contains(text(),'Email')]");
        ForgotUsername.put("successMessage_text", "//p[@class='loginSuccessHeader']");
        ForgotUsername.put(
            "forgotUsernameconfirmation_element",
            "//h1[@id='forgorUserEnhance']"
        );
        ForgotUsername.put("enterUsename_text", "//div[@id='multipleUserHeader']");
        ForgotUsername.put("username_text", "//input[@id='logonId']");
        ForgotUsername.put("continueUsername_button", "(//button[@type='submit'])[2]");
       
    }

    public String findLocator(String elementName) {
        if (ForgotUsername.containsKey(elementName)) {
            return (ForgotUsername.get(elementName.trim()));
        }

        return null;
    }
}
