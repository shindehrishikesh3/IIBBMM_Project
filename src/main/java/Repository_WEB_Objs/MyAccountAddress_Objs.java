package Repository_WEB_Objs;

import java.util.*;

public class MyAccountAddress_Objs {

    // Creation of HashMap
    private static final Map<String, String> MyAccountAddress;

    static {
        MyAccountAddress = new HashMap<String, String>();

        MyAccountAddress.put("addAddress_text", "//*[@id='addAddressTitle']");
        MyAccountAddress.put("addressNickname_textbox", "//*[@id='nickName']");
        MyAccountAddress.put("forTheAttentionOf_textbox", "//*[@id='forTheAttentionOf']");
        MyAccountAddress.put("companyName_textbox", "//*[@id='organizationName']");
        MyAccountAddress.put("addressLine1_textbox", "//*[@name='address1']");
        MyAccountAddress.put("addressLine2_textbox", "//*[@id='address2']");
        MyAccountAddress.put("addressLineThree_textbox", "//*[@id='address3']");
        MyAccountAddress.put("city_textbox", "//*[@id='city']");
        MyAccountAddress.put("countryProvince_textbox", "//*[@id='state']");
        MyAccountAddress.put("state_dropdown", "//select[@id='state']");
        MyAccountAddress.put("zipCode_textbox", "//*[@id='zipCode']");
        MyAccountAddress.put("country_dropdown", "//select[@id='country']");
        MyAccountAddress.put("saveAddress_button", "//input[@id='addressSaveButton']");
        MyAccountAddress.put("addressUpdateSave_text", "//p[@class='successMessage']");
        MyAccountAddress.put("deleteAddress_button", "//*[@id='removeAddress']");
        MyAccountAddress.put("confirmDelete_button", "//*[@id='confConfirm']");
        MyAccountAddress.put("update_button", "//input[@id='addressSubmit']");
        MyAccountAddress.put("countryProvince_dropdown", "//select[@id='state']");
        MyAccountAddress.put("addressValidation_popup", "//div[@id='verificationPopupContent']");
        MyAccountAddress.put("youEntered_radio", "//legend[text()='You Entered']");
        MyAccountAddress.put("confirmAddress_button", "//div[@class='footerButtonContainer']/a[@class='btn btnPrimary']");      
    }

    public String findLocator(String elementName) {
        if (MyAccountAddress.containsKey(elementName)) {
            return (MyAccountAddress.get(elementName.trim()));
        }

        return null;
    }
}
