package Repository_WEB_Objs;

import java.util.*;

public class Login_Objs {

    // Creation of HashMap
    private static final Map<String, String> Login;

    static {
        Login = new HashMap<String, String>();
        Login.put("username_textbox", "//*[@id='logonId']");
        Login.put("password_textbox", "//*[@id='logonPassword']");
        Login.put("login_button", "//*[@id='submitLogin']");
        Login.put("forgotUsername_link", "//*[contains(@href,'PFUserNameRetrieveView')]");
        Login.put(
            "forgotPassword_link",
            "//*[contains(@href,'ResetPasswordGuestErrorView?')]"
        );
        Login.put("login_element", ".//*[@class='pf_row loginHeading']/h1");
        Login.put("loginWithoutActivation_text","(//div[@id='invalidLogin']//p//strong)[1]");
        Login.put("resendActivationemail_button", "//button[@id='submitResendEmail']");
        Login.put("checkyourmail_text", "//div[@class='pf_row loginHeading']/h1");
        Login.put("ActivationEmail_text", "//p[@class='loginSuccessHeader']/strong");
        Login.put("visibilityOfEyeicon", "//span[@id='showHideEyeIcons']/span[1]");
        Login.put("invisibilityOfEyeicon", "//span[@id='showHideEyeIcons']/span[2]");
        Login.put("passwordtype_login","//div[@class='pf_row formFields labelLeft inputBorder']//input[@name='logonPassword']");
        Login.put("passwordtype_guestloginmodel", "//div[@class='formFields labelLeft']//input[@name='logonPassword']");
    }

    public String findLocator(String elementName) {
        if (Login.containsKey(elementName)) {
            return (Login.get(elementName.trim()));
        }

        return null;
    }
}
