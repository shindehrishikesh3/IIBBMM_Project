package Repository_WEB_Objs;

import java.util.HashMap;
import java.util.Map;

public class MyAccountProfileInformation_Objs {

    // Creation of HashMap
    private static final Map<String, String> MyAccountProfileInformation;

    static {
        MyAccountProfileInformation = new HashMap<String, String>();

        //Profile Information
        MyAccountProfileInformation.put("personTitle_dropdown", "//*[@id='personTitle']");
        MyAccountProfileInformation.put("firstName_textbox", "//input[@id='firstName']");
        MyAccountProfileInformation.put("lastName_textbox", "//input[@id='lastName']");
        MyAccountProfileInformation.put("emailAddress_textbox", "//input[@id='email1']");
        MyAccountProfileInformation.put("primaryRole_dropdown", "//*[@id='primaryRole']");
        MyAccountProfileInformation.put("primaryUse_dropdown", "//*[@id='primaryUse']");
        MyAccountProfileInformation.put("phoneNumber_textbox", "//*[@id='phone1']");
        MyAccountProfileInformation.put("vatNumber_textbox", "//*[@id='vatRegNum']");
        MyAccountProfileInformation.put(
            "specialOffers_checkbox",
            "//label[@for='specialOffers']/span"
        );
        MyAccountProfileInformation.put(
            "selectAll_checkbox",
            "//*[@for='allOfAboveContacts']/span"
        );
        MyAccountProfileInformation.put(
            "email_checkbox",
            "//*[@for='emailCheckBox']//span"
        );
        MyAccountProfileInformation.put(
            "mobileNumber_textbox",
            "//input[@id='mobilePhone1']"
        );
        MyAccountProfileInformation.put(
            "companyName_textbox",
            "//input[@id='organizationName']"
        );
        MyAccountProfileInformation.put(
            "successMessage_text",
            "//*[@id='SuccessMessageText']/p"
        );
        MyAccountProfileInformation.put(
            "save_button",
            "//input[contains(@class,'savePersonalInfo')]"
        );
        MyAccountProfileInformation.put(
            "extensionNumber_textbox",
            "//input[@id='phone1Ext']"
        );
        MyAccountProfileInformation.put(
            "addressLineOne_textbox",
            "//input[@id='address1']"
        );
        MyAccountProfileInformation.put(
            "addressLineTwo_textbox",
            "//input[@id='address2']"
        );
        MyAccountProfileInformation.put("city_textbox", "//input[@id='city']");
        MyAccountProfileInformation.put("province_textbox", "//input[@id='state']");
        MyAccountProfileInformation.put("postcode_textbox", "//input[@id='aPostCode']");

        //change password
        MyAccountProfileInformation.put(
            "changePassword_text",
            "//*[@id='UpdateUserPassword']/h2"
        );
        MyAccountProfileInformation.put(
            "currentPassword_textbox",
            "//input[@id='logonPasswordOld']"
        );
        MyAccountProfileInformation.put(
            "newPassword_textbox",
            "//input[@id='logonPassword']"
        );
        MyAccountProfileInformation.put(
            "change_button",
            "(//input[@class='btn btnPrimary addLoaderSubmit'])[1]"
        );
        
    }

    public String findLocator(String elementName) {
        if (MyAccountProfileInformation.containsKey(elementName)) {
            return (MyAccountProfileInformation.get(elementName.trim()));
        }

        return null;
    }
}
