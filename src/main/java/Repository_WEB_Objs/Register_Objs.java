package Repository_WEB_Objs;

import java.util.*;

public class Register_Objs {

    // Creation of HashMap
    private static final Map<String, String> Register;

    static {
        Register = new HashMap<String, String>();
        Register.put("register_link", "//*[@id='loginRegister']//a[2]");
        Register.put("requiredMsg_text", "//*[@class='requiredMessage'][1]/p");
        Register.put("bannerKorea_text", "//*[@id='charRestrictionBanner']/p");
        Register.put("username_textbox", "//*[@id='logonId']");
        Register.put("password_textbox", "//*[@id='logonPassword']");
        Register.put("title_dropdown", "//*[@id='personTitle']");
        Register.put("firstName_textbox", "//input[@id='firstName']");
        Register.put("lastName_textbox", "//input[@id='lastName']");
        Register.put("fullName_textbox", "//input[@id='firstName']");
        Register.put("emailAddress_textbox", "//input[@id='email1']");
        Register.put("phoneNumber_textbox", "//input[@id='phone1']");
        Register.put("extensionNumber_textbox", "//input[@id='phone1Ext']");
        Register.put("vatNumber_textbox", "//*[@id='vatRegNum']");
        Register.put("postalCode_textbox", "//input[@id='zipCode']");
        Register.put("companyName_textbox", "//input[@id='organizationName']");
        Register.put("primaryRole_dropdown", "//select[@id='primaryRole']");
        Register.put("primaryUse_dropdown", "//select[@id='primaryUse']");
        Register.put("rememberMe_checkbox", "//*[@for='rememberMe']//span");
        Register.put("register_button", "//input[@id='registerValidate']");
        Register.put("registerWithUserName_link", "//a[@id='registerWithUserName']");
        Register.put("mobileNumber_textbox", "//*[@id='mobilePhone1']");
        Register.put("marketingPrefrence_checkbox", "//*[@class='mkOptInedt']");
        Register.put("businessAccount_radio", "//*[@class='radio inlineRadios']/span");
        Register.put("registerTitle_text", ".//*[@id='Register']");
        
        Register.put("privacyPolicyConsent_checkbox", "//*[@for='userDataConsent']");
        Register.put("privacyPolicyConsent_text", "//*[@for='userDataConsent']/span");
        Register.put("termsConditions_link", "//*[@id='userDataConsentContainer']//span/a[1]");
        Register.put("privacyPolicy_link", "//*[@id='userDataConsentContainer']//span/a[2]");
        Register.put("termsConditionsTitle_text", "//h1");
        Register.put("privacyPolicyTitle_text", "//h1");
        Register.put("privacyPolicyTitle_text", "//h1");
        Register.put("privacyPolicyConsentError_link", "//*[@for='userDataConsentContainer']");
        Register.put("privacyPolicyConsentError_text", "//*[@for='userDataConsentContainer']");
        Register.put("marketOptIn_text", "//*[@for='emailCheckBox']/span");
        Register.put("premierFarnellGroup_link", "//span[@class='mkOptInTxt']/a");
        Register.put("termsOfAccessTitle_text", "//h1");
        Register.put("zipCodeError_text", "//*[@id='formErrors']//label[@for='zipCode']");
        Register.put("phoneNumberError_text", "//*[@id='formErrors']//label[@for='phone1']");
        
        // user data consent kr store
        Register.put("consent_checkbox", "//*[@for='userDataConsent']/span");
        
        //Email Verification
        Register.put("resendActivation_button", "//*[@id='thankYouPageContainer']//button");
        
        //Email Verification - Thank you page
        Register.put("thankYouTitle_text", "//h1");
        Register.put("thankYouHeader_text", "//*[@class='pf_row marginBottom']//h3");
        Register.put("firstStep_text", "//*[@class='pf_row marginBottom']//li[1]");
        Register.put("secondStep_text", "//*[@class='pf_row marginBottom']//li[2]");
        Register.put("thirdStep_text", "//*[@class='pf_row marginBottom']//li[3]");
        Register.put("itemsFromBasket_text", "(//*[@id='thankYouPageContainer']//*[@class='pf_row']//p)[1]");
        Register.put("receiveEmailThankYou_text", "(//*[@id='thankYouPageContainer']//*[@class='pf_row']//p)[2]");
        
        //Email Verification - Check Your Email page
        Register.put("checkYourEmail_text", "//h1");
        Register.put("activationEmailSent_text","//*[@class='loginSuccessHeader']");
        Register.put("emailActivate_text","(//*[@class='loginSuccessTxt'])[1]");
        Register.put("receiveEmailCheckEmail_text","(//*[@class='loginSuccessTxt'])[2]");
        
    }

    public String findLocator(String elementName) {
        if (Register.containsKey(elementName)) {
            return (Register.get(elementName.trim()));
        }

        return null;
    }
}
