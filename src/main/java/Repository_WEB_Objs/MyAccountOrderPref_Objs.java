package Repository_WEB_Objs;

import java.util.HashMap;
import java.util.Map;

public class MyAccountOrderPref_Objs {

    // Creation of HashMap
    private static final Map<String, String> MyAccountOrderPref;

    static {
        MyAccountOrderPref = new HashMap<String, String>();

        MyAccountOrderPref.put("orderPreferences_text", "//div[@class='section']/h1");
        MyAccountOrderPref.put("paymentType_dropdown", "//*[@id='prefPaymentType']");
        MyAccountOrderPref.put("prefDeliveryMethod_dropdown", "//*[@id='prefShipMode']");
        MyAccountOrderPref.put(
            "prefShipAccountNumber_textbox",
            "//*[@id='prefShipAccountNumber']"
        );
        MyAccountOrderPref.put(
            "prefDeliveryAddress_dropdown",
            "//*[@id='prefShipAddress']"
        );
        MyAccountOrderPref.put(
            "taxExemptYes_radio",
            "//*[@id='taxpreference'and @value='Y']"
        );
        MyAccountOrderPref.put(
            "taxExemptNo_radio",
            "//*[@id='taxpreference'and @value='N']"
        );
        MyAccountOrderPref.put("Save_button", "//input[@type='submit']");
        MyAccountOrderPref.put("orderPrefSaved_text", ".//*[@id='MessageArea']/p");
        MyAccountOrderPref.put("accountNumber_dropdown", "//*[@id='prefAccountNumber']");
    }

    public String findLocator(String elementName) {
        if (MyAccountOrderPref.containsKey(elementName)) {
            return (MyAccountOrderPref.get(elementName.trim()));
        }

        return null;
    }
}
