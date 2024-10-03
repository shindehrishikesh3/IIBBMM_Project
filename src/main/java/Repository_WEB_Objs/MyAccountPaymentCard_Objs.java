package Repository_WEB_Objs;

import java.util.HashMap;
import java.util.Map;

public class MyAccountPaymentCard_Objs {

    // Creation of HashMap
    private static final Map<String, String> MyAccountPaymentCard;

    static {
        MyAccountPaymentCard = new HashMap<String, String>();

        // Card Details
        MyAccountPaymentCard.put("addPaymentCard_text", "//*[@id='addCardTitle']");
        MyAccountPaymentCard.put("cardType_dropdown", "//*[@id='cardType']");
        MyAccountPaymentCard.put("cardNumber_textbox", "//*[@id='cardNumber']");
        MyAccountPaymentCard.put("cardNumberWebTokenize_textbox", "//*[@id='PAN']");
        MyAccountPaymentCard.put("expiryMonth_dropdown", "//*[@id='validExpiryMonth']");
        MyAccountPaymentCard.put("expiryYear_dropdown", "//*[@id='validExpiryYear']");
        MyAccountPaymentCard.put("expiryYear_dropdown", "//*[@id='validExpiryYear']");
        MyAccountPaymentCard.put("nameOnCard_textbox", "//*[@id='nameOnCard']");
        MyAccountPaymentCard.put("cardHolderPhone_textbox", "//*[@id='cardHolderPhone']");
        MyAccountPaymentCard.put("phoneExtension_textbox", "//*[@id='phone1Ext']");

        // Card holder Details
        MyAccountPaymentCard.put(
            "organizationName_textbox",
            "//*[@id='organizationName']"
        );
        MyAccountPaymentCard.put(
            "forTheAttentionOff_textbox",
            "//*[@id='forTheAttentionOf']"
        );

        // Card holder Address
        MyAccountPaymentCard.put("selectAddress_dropdown", "//*[@id='selectAddress']");
        MyAccountPaymentCard.put("addressLine1_textbox", "//*[@id='address1']");
        MyAccountPaymentCard.put("addressLine2_textbox", "//*[@id='address2']");
        MyAccountPaymentCard.put("addressLine3_textbox", "//*[@id='address3']");
        MyAccountPaymentCard.put("city_textbox", "//*[@id='city']");
        MyAccountPaymentCard.put("state_textbox", "//*[@id='state']");
        MyAccountPaymentCard.put("stateUS_dropdown", "//*[@id='state']");
        MyAccountPaymentCard.put("zipCode_textbox", "//*[@id='zipCode']");
        MyAccountPaymentCard.put("Country_dropdown", "//*[@id='country']");
        MyAccountPaymentCard.put("Cancel_button", "//*[@id='cancelNew']");
        MyAccountPaymentCard.put("Save_button", "//*[@id='saveNew']");

        // Message
        MyAccountPaymentCard.put("cardSaved_text", "//*[@id='ErrorMessageText']/p");
    }

    public String findLocator(String elementName) {
        if (MyAccountPaymentCard.containsKey(elementName)) {
            return (MyAccountPaymentCard.get(elementName.trim()));
        }

        return null;
    }
}
