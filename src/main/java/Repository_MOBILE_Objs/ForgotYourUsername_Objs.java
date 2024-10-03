package Repository_MOBILE_Objs;

import com.ctc.wstx.sw.BufferingXmlWriter;
import java.util.*;
import org.apache.velocity.runtime.directive.contrib.For;

public class ForgotYourUsername_Objs {

    // Creation of HashMap
    private static final Map<String, String> ForgotYourUsername;

    static {
        ForgotYourUsername = new HashMap<String, String>();
        ForgotYourUsername.put("email_textbox", "//*[@id='email1']");
        ForgotYourUsername.put(
            "sendUsername_button",
            "//*[@class='submit btn btn-primary section']"
        );
        ForgotYourUsername.put(
            "userNameHasBeenSent_text",
            "//*[@id='userNameSuccessMsg']/span"
        );
        // If the name and email you entered belongs to a Premier Farnell
        // account, we will recover your username.
        ForgotYourUsername.put("emailDescription_text", "//*[@class='emailDescription']");

        // UiValidation locators with value of their text
        // Forgotten your username?
        ForgotYourUsername.put(
            "forgottenYourUsername_text",
            "//*[@id='forgorUserEnhance']"
        );
        // 'Retrieve Username
        ForgotYourUsername.put(
            "subTitleDescription_element",
            "//*[@class='subtitle mobileDescription']"
        );
        // It happens from time to time. We're here to help you.
        ForgotYourUsername.put(
            "mobileDescriptionOne_element",
            "(//*[@class='mobileDescription'])[1]"
        );
        // Enter your email and we will recover your username for you.
        ForgotYourUsername.put(
            "mobileDescriptionTwo_element",
            "(//*[@class='mobileDescription'])[2]"
        );
        ForgotYourUsername.put("email_label", "//*[@for='email1']");
        ForgotYourUsername.put(
            "requiredFieldsMessage_text",
            "//*[@class='required-fields-message']"
        );
        // Error message: Please enter a valid Email Address
        ForgotYourUsername.put("enterValidEmailAddress_text", "//*[@id='errorMsg']/span");
    }

    public String findLocator(String elementName) {
        if (ForgotYourUsername.containsKey(elementName)) {
            return (ForgotYourUsername.get(elementName.trim()));
        }

        return null;
    }
    // ******************************************************

}
