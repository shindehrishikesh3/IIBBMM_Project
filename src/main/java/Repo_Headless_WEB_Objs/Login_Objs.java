package Repo_Headless_WEB_Objs;

import java.util.*;

/**
 * Value format is "locatorType:locatorString"
 * Locator types are as follows:
 *  {"xpath","css","id","className","tagName","linkText","partialLinkText","name"}
 */
public class Login_Objs {

    // Creation of HashMap
    private static final Map<String, String> Login;

    static {
        Login = new HashMap<String, String>();
        Login.put("username_textbox", "id:login_username");
        Login.put("password_textbox", "id:login_password");
        Login.put("login_button", "xpath:.//*[@data-testid='authentication.login.form__submit-button']");
        Login.put("forgotUsername_link", "xpath://*[contains(@href,'PFUserNameRetrieveView')]");
        Login.put(
            "forgotPassword_link",
            "xpath://*[contains(@href,'ResetPasswordGuestErrorView?')]"
        );
        Login.put("login_element", "xpath:.//label[@for='login_username']");
    }

    public String findLocator(String elementName) {
        if (Login.containsKey(elementName)) {
            return (Login.get(elementName.trim()));
        }

        return null;
    }
}
