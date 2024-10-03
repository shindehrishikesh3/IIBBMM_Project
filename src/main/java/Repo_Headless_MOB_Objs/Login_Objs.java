package Repo_Headless_MOB_Objs;

import java.util.*;

public class Login_Objs {

    // Creation of HashMap
    private static final Map<String, String> Login;

    static {
        Login = new HashMap<String, String>();
        Login.put("username_textbox", "xpath://*[@data-testid='authentication.login.form__username-input']");
        Login.put("password_textbox", "xpath://*[@data-testid='authentication.login.form__password-input']");
        Login.put("login_button", "xpath://*[@data-testid='authentication.login.form__submit-button']");
        Login.put("login_element", "xpath://*[contains(@class,'LoginFormstyles')]//form");
        Login.put("registerNow_button", "xpath://*[@data-testid='authentication.login.register-link']");
        Login.put("loginTitle_text", "xpath://*[contains(@class,'FormTitle')]");

	//These elements are not present in headless mobile page
	Login.put("register_now_button", "xpath://*[@id='page-container']/div[1]/a");
	Login.put("newCustomer_text", "xpath://*[@class='section']/p");
        Login.put("returningCustomer_text", "xpath://*[@class='section']/h2");
	Login.put("requiredField_text", "xpath://*[@class='required-fields-message']");
	Login.put("section_text", "//*[@id='page-container']/div[2]/p[1]");
        Login.put("customerService_link", "//*[@id='page-container']/div[2]/p[1]/a");
	//----------

	Login.put("logInHeading_text", "xpath://*[contains(@class,'LoginFormstyles')]//form/div[1]");
	Login.put("username_label", "//label[@for='login_username']");
        Login.put("password_label", "//label[@for='login_password']");
        Login.put("forgotYourPassword_link", "xpath://*[@data-testid='authentication.login.forgot-pw-link']");
        Login.put(
            "forgotYourUsername_link",
            "xpath://*[@data-testid='authentication.login.forgot-usr-link']"
        );

        //Blankerror messages
        //Please enter all required information. The following was not entered:
	// In headless, there is a generic message for required fields
        Login.put("topHeaderError_text", "xpath://*[contains(@class,'FormHeaderstyles')]/*[@kind='error']");
        Login.put("usernameError_text", "xpath://*[contains(@class,'FormHeaderstyles')]/*[@kind='error']");
        Login.put("passwordError_text", "xpath://*[contains(@class,'FormHeaderstyles')]/*[@kind='error']");

        //Error message for invalid data
	// In headless, there is a generic message
        Login.put("invalidUsernameOrPassword_text", "xpath://*[contains(@class,'FormHeaderstyles')]/*[@kind='error']");
    }

    public String findLocator(String elementName) {
        if (Login.containsKey(elementName)) {
            return (Login.get(elementName.trim()));
        }

        return null;
    }
}
