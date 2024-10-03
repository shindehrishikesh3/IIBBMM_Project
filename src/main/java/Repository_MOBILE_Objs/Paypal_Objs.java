package Repository_MOBILE_Objs;

import java.util.*;

public class Paypal_Objs {

    // Creation of HashMap
    private static final Map<String, String> Paypal;

    static {
        Paypal = new HashMap<String, String>();

        Paypal.put("loginUserName_text", "//input[@id='email']");
        Paypal.put("loginPassword_text", "//input[@id='password']");
        Paypal.put("next_button", "//button[@value='Next']");
        Paypal.put("loginButton_button", "//button[@value='Login']");
        Paypal.put("paymentSubmit_button", "//button[@id='payment-submit-btn']");
    }

    public String findLocator(String elementName) {
        if (Paypal.containsKey(elementName)) {
            return (Paypal.get(elementName.trim()));
        }

        return null;
    }
}
