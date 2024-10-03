package Repository_MOBILE_Objs;

import java.util.*;

public class Register_Objs {

    // Creation of HashMap
    private static final Map<String, String> Register;

    static {
        Register = new HashMap<String, String>();
        Register.put("register_link", "//*[@id='guestPar']//a");
        Register.put("registerNow_button", "//*[@id='page-container']/div[1]/a");
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
        Register.put("register_button", "//input[@id='registerValidate']");
        Register.put("mobileNumber_textbox", "//*[@id='mobilePhone1']");
        Register.put("businessAccount_radio", "//*[@class='radio inlineRadios']/span");
        Register.put("registerTitle_text", "//*[@id='page-container']/div[1]/h1");
        Register.put("alreadyRegistered_text", "//*[contains(@class,'loginLink')]");
        Register.put("login_link", "//*[contains(@class,'loginLink')]/a");
        Register.put("requiredField_text", "//*[@class='required-fields-message']");
        Register.put("usrnameAndPwdTitle_text", "//*[@class='reducedH2']");
        Register.put("usrname_label", "(//*[contains(@class,'formFields')])[2]/label");
        Register.put("password_label", "(//*[contains(@class,'formFields')])[3]/label");
        Register.put("showPassword_text", "//*[@id='showPasswordLabel']/label/span");
        Register.put("showPassword_checkbox", "//*[@id='showPasswordLabel']/label/span");
        Register.put("nameAndAddress_section", "(//*[@class='section'])[3]");
        Register.put("nameAndAddressSectionTitle_text", "(//*[@class='section'])[3]/h2");
        Register.put("preferences_section", "(//*[@class='section'])[4]");
        // Register.put("preferencesSectionTitle_text", "//*[@class='belowText']");
        Register.put(
            "nameAndAddressFormfields_list",
            "//*[@class='formFields labelLeft form-group']/label"
        );
        Register.put("yourInformationTitle_text", "(//*[@class='section'])[4]/h4");
        Register.put("yourInformationDetail_text", "(//*[@class='section'])[4]/p");
        Register.put("privacyPolicy_link", "(//*[@class='section'])[4]/p/a");
        Register.put("howShouldWeContactYou_text", "//*[@id='contactDetails']/h3");
        Register.put(
            "contactPreferences_list",
            "(//div[@class='section'])[4]//div[@class='formFields labelLeft checkbox clearfix']"
        );
        Register.put("selectAll_checkbox", "//*[@id='allOfAboveContacts']");
        Register.put("email_checkbox", "//*[@id='emailCheckBox']");
        Register.put("sms/mms_checkbox", "//*[@id='smsCheckBox']");
        Register.put("phone_checkbox", "//*[@id='phoneCheckBox']");
        Register.put("passwordValidation_list", "//*[@id='passwordValidator']/li");
        Register.put(
            "singleErrMessageHeading_text",
            "//*[@id='formErrors']//*[@class='labelHook']"
        );
        Register.put(
            "errInputFieldsInSingleError_list",
            "//*[@id='formErrors']/ul/li/ul/li"
        );
        Register.put("mobileNumber_label", "//*[@id='mobileNumber']/label");
        Register.put("emailInvalid_element", "//*[@class='emailValidator emailInvalid']");
        Register.put("pwdInvalidOutput_text", "//*[@id='personTitle']");
        Register.put("pwdValidOutput_text", "//*[@id='personTitle']");
        Register.put("existingUserError_text", "//*[@class='labelFeel']");
        Register.put("privacyTitle_text", "//*[@id='top']/div/h1");
        Register.put(
            "errMsgHeadingOfInvalidDataInMulErrors_text",
            "(//*[@class='labelHook'])[1]"
        );
        Register.put(
            "errInvalidInputFieldsInMulErrors_list",
            "//*[@id='formErrors']/ul[1]/li/ul/li"
        );
        Register.put(
            "errMsgHeadingOfBlankFieldsInMulErrors_text",
            "(//*[@class='labelHook'])[2]"
        );
        Register.put(
            "blankInputFieldLabelsInMulErrors_list",
            "//*[@id='formErrors']/ul[2]/li/ul/li"
        );
        Register.put(
            "emailInLineErrorMessage_text",
            "//*[@class='errorMsgEmailValidate']"
        );
        Register.put(
            "accountTypeTitle_text",
            "//*[@class='formFields labelLeft forceBreak form-group']/label"
        );
        Register.put("Business_label", "//*[@class='radioField']/label[1]");
        Register.put("Personal_label", "//*[@class='radioField']/label[2]");
        Register.put("Business_radio", "//*[@class='radioField']/label[1]/input");
        Register.put("Personal_radio", "//*[@class='radioField']/label[2]/input");
        Register.put(
            "registrationBenefitDesc_text",
            "//*[contains(@id,'ad_pf_registration')]/div/div"
        );
        Register.put(
            "reasonsToRegisterTitle_text",
            "//*[@class='mk-key-prop-8-mobile']/h3"
        );
        
        Register.put("privacyPolicyConsent_checkbox", "//*[@for='userDataConsent']");
        Register.put("privacyPolicyConsent_text", "//*[@for='userDataConsent']/span");
        Register.put("termsConditions_link", "//*[@id='userDataConsentContainer']//span/a[1]");
        // Register.put("privacyPolicy_link", "//*[@id='userDataConsentContainer']//span/a[2]");
        Register.put("termsConditionsTitle_text", "//h1");
        Register.put("privacyPolicyTitle_text", "//h1");
        Register.put("privacyPolicyTitle_text", "//h1");
        Register.put("privacyPolicyConsentError_link", "//*[@for='userDataConsent']");
        Register.put("privacyPolicyConsentError_text", "//*[@for='userDataConsent']");
        Register.put("marketingOptIn_text", "//*[contains(@class,'emailOptInRedesign')]/label");
        Register.put("premierFarnellGroup_link", "//*[contains(@class,'emailOptInRedesign')]//a");
        Register.put("termsOfAccessTitle_text", "//h1");
        Register.put("zipCodeError_text", "//*[@id='formErrors']//label[@for='zipCode']");
        Register.put("phoneNumberError_text", "//label[@for='phone1']");
        
        //Email Verification
        Register.put("accountActivation_text", "//*[@class='loginSuccessHeader']");
        Register.put("tradeAccount_text", "//*[@class='loginSuccessTxt']");
        Register.put("resendActivation_button", "//*[@id='thankYouPageContainer']//button");
        
        //Email Verification - Thank you page
        Register.put("thankYouTitle_text", "//h1");
        Register.put("thankYouHeader_text", "(//*[@id='thankYouPageContainer']//p)[1]");
        Register.put("firstStep_text", "//*[@id='thankYouPageContainer']//li[1]");
        Register.put("secondStep_text", "//*[@id='thankYouPageContainer']//li[2]");
        Register.put("thirdStep_text", "//*[@id='thankYouPageContainer']//li[3]");
        Register.put("itemsFromBasket_text", "(//*[@id='thankYouPageContainer']//p)[2]");
        Register.put("receiveEmailThankYou_text", "(//*[@id='thankYouPageContainer']//div)[8]");
        
        //Email Verification - Check Your Email page
        Register.put("checkYourEmail_text", "//h1");
        Register.put("activationEmailSent_text","//*[@class='loginSuccessHeader']");
        Register.put("emailActivate_text","(//*[@class='loginSuccessTxt'])[1]");
        Register.put("receiveEmailCheckEmail_text","(//*[@class='loginSuccessTxt'])[2]");
        
        Register.put("requiredMsg_text", "//*[@class='requiredMessage text-right']//p");
        Register.put("bannerKorea_text", "//*[@id='charRestrictionBanner']//p");
    }

    public String findLocator(String elementName) {
        if (Register.containsKey(elementName)) {
            return (Register.get(elementName.trim()));
        }

        return null;
    }
}
