package Repository_MOBILE_Objs;

import java.util.*;

public class Login_Objs {

    // Creation of HashMap
    private static final Map<String, String> Login;

    static {
        Login = new HashMap<String, String>();
        Login.put("username_textbox", "//*[@id='logonId']");
        Login.put("password_textbox", "//*[@id='logonPassword']");
        Login.put("login_button", "//input[@type='submit']");
        Login.put("login_element", ".//*[@name='Logon']");
        Login.put("register_now_button", "//*[@id='page-container']/div[1]/a");
        Login.put("logInHeading_text", "//*[@class='section']/h1");
        Login.put("newCustomer_text", "//*[@class='section']/p");
        Login.put("returningCustomer_text", "//*[@class='section']/h2");
        Login.put("requiredField_text", "//*[@class='required-fields-message']");
        Login.put("username_label", "//*[@id='Logon']/div[1]/label");
        Login.put("password_label", "//*[@id='Logon']/div[2]/label");
        Login.put("forgotYourPassword_link", "//a[contains(@href,'=forgetpassword')]");
        Login.put(
            "forgotYourUsername_link",
            "//*[contains(@href,'PFUserNameRetrieveView')]"
        );
        Login.put("section_text", "//*[@id='page-container']/div[2]/p[1]");
        Login.put("customerService_link", "//*[@id='page-container']/div[2]/p[1]/a");
        Login.put("registerNow_button", "//*[@id='page-container']/div[1]/a");
        Login.put("loginTitle_text", "//*[@class='section']/h1");

        //Blankerror messages
        //Please enter all required information. The following was not entered:
        Login.put("topHeaderError_text", "//*[@class='labelHook']");
        Login.put("usernameError_text", "(//*[@for='logonId'])[1]");
        Login.put("passwordError_text", "(//*[@for='logonPassword'])[1]");

        //Error message for invalid data
        Login.put("invalidUsernameOrPassword_text", "//*[@class='labelFeelError']");
        Login.put("loginWithoutActivation_Text", "//div[@id='invalidLogin']//p[@class='headerText']//strong");
        Login.put("resendActivationemail_Button", "//button[@id='submitResendEmail']");
        Login.put("checkyourmail_text", "//div[@class='pf_row loginHeading']/h1");
        Login.put("ActivationEmail_text", "//p[@class='loginSuccessHeader']/strong");
        Login.put("passwordtype_text", "//form[@id='Logon']/div[2]/input");
        Login.put("showpassword_checkbox", "//input[@id='showPassword']");
    }

    public String findLocator(String elementName) {
        if (Login.containsKey(elementName)) {
            return (Login.get(elementName.trim()));
        }

        return null;
    }
}
