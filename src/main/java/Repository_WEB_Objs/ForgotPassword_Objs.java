package Repository_WEB_Objs;

import java.util.HashMap;
import java.util.Map;

public class ForgotPassword_Objs {

    private static final Map<String, String> ForgotPassword;

    static {
        ForgotPassword = new HashMap<String, String>();
        ForgotPassword.put("forgotYourPassword_text", "//*[@class='pf_row']/h1[1]");
        ForgotPassword.put("email_textbox", "//input[@id='email1']");
        ForgotPassword.put("sendResetLink_button", "//button[@id='resetpwd']");
        ForgotPassword.put(
            "greenTickMarkResetMail_icon",
            "//*[@class='loginSuccessIcn']"
        );
        ForgotPassword.put("resetEmailSent_text", "//*[@id='successHeader']");
        ForgotPassword.put("forgotYourPassword_link","(//*[@class='pf_row formFields forgottenLinks alignLinks']/ul/li)[2]/a");
        ForgotPassword.put("subtitlesuccessMessage_text", "//p[@id='successMessage']");
        ForgotPassword.put("loginSuccessMessage_text", "(//p[@class='loginSuccessMsg'])[1]");
        ForgotPassword.put("tryToRegister_text", "//p[@id='tryToRegister']/a");
    }

    public String findLocator(String elementName) {
        if (ForgotPassword.containsKey(elementName)) {
            return (ForgotPassword.get(elementName.trim()));
        }

        return null;
    }
}
