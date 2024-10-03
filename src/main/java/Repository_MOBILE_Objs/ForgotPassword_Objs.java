package Repository_MOBILE_Objs;

import com.ctc.wstx.sw.BufferingXmlWriter;
import java.util.*;
import org.apache.velocity.runtime.directive.contrib.For;

public class ForgotPassword_Objs {

    // Creation of HashMap
    private static final Map<String, String> ForgotPassword;

    static {
        ForgotPassword = new HashMap<String, String>();

        ForgotPassword.put("email_textbox", "//*[@id='email1']");
        ForgotPassword.put("sendResetLink_button", "//*[@id='resetpwd']");

        // UiValidation locators with value of their text
        // Forgot your password
        ForgotPassword.put("forgottenYourPassword_text", "//*[@id='successMsg']/h1");
        // It happens from time to time. We are here to help you.
        ForgotPassword.put(
            "mobileDescriptionOne_element",
            "(//*[@class='section']/p)[1]"
        );
        // Enter your email and we'll send you instructions on how to reset your
        // password. Reset links are valid for 24 hours.
        ForgotPassword.put(
            "mobileDescriptionTwo_element",
            "(//*[@class='section']/p)[2]"
        );
        ForgotPassword.put("email_label", "//*[@for='email1']");
        ForgotPassword.put(
            "requiredFieldsMessage_text",
            "//*[@class='required-fields-message']"
        );
        // Error message: Please enter a valid Email Address
        ForgotPassword.put("enterValidEmailAddress_text", "//*[@id='errorMsg']/span");

        // Locators for final Success Screen
        ForgotPassword.put("resetEmailSent_text", "//*[@class='emailHeading']");
        // Farnell has sent an email with a link to reset your password to:
        ForgotPassword.put(
            "emailDescriptionOne_element",
            "(//*[@class='emailDescription'])[1]"
        );
        // Did not receive the email? Please check that you have a Farnell
        // account, the spelling of the email address and your spam folder.
        ForgotPassword.put(
            "emailDescriptionTwo_element",
            "(//*[@class='emailDescription'])[2]"
        );
        ForgotPassword.put("userEmailID_text", "//*[@id='dispEmailId']");

        //We found multiple accounts
        ForgotPassword.put("enhanceMultiuser_text", "//*[@id='enhance_multiuser']");
        ForgotPassword.put("returningCustomer_text", "//*[@class='subtitle']");
        //There are 27 usernames associated with your email: nvaish@premierfarnell.com
        ForgotPassword.put(
            "usernameAssociated_text",
            "(//*[@class='section mobileDescription']/p)[1]"
        );
        //In order to reset your password please supply the username for which you need to reset
        ForgotPassword.put(
            "multiUserDescription_text",
            "(//*[@class='section mobileDescription']/p)[2]"
        );
        ForgotPassword.put("username_text", "//*[@id='errorWrap']");
        ForgotPassword.put("username_textbox", "//*[@id='logonId']");
        //Enter a valid username
        ForgotPassword.put("enterValidUsernameError_message", "//*[@id='errorMsg']/span");
        ForgotPassword.put("continue_button", "(//*[@type='submit'])[2]");
        ForgotPassword.put("forgotPwdHeader_text", "//*[@id='forgotPwdContainer']/h1");
    }

    public String findLocator(String elementName) {
        if (ForgotPassword.containsKey(elementName)) {
            return (ForgotPassword.get(elementName.trim()));
        }

        return null;
    }
}
