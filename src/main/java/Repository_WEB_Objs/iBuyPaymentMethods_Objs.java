package Repository_WEB_Objs;

import java.util.HashMap;
import java.util.Map;

public class iBuyPaymentMethods_Objs {
	// Creation of HashMap
    private static final Map<String, String> iBuyPaymentMethods;

    static {
    	iBuyPaymentMethods = new HashMap<String, String>();
    	iBuyPaymentMethods.put("paymentMethod_text", "//h1[contains(text(),'Payment Methods')]");
    	iBuyPaymentMethods.put("existingAccount_link", "//*[@id='methodTable']//tr[1]/td[1]/a");
    	iBuyPaymentMethods.put("enableAccount_checkbox", "//*[@id='accountStatus_1']");
    	iBuyPaymentMethods.put("returnToPrevPage_button", "//div[@class='actionBox actionFullWidth actionBelow']//a[contains(@class,'btn btnSecondary')]");
    	  				    	
    }

    public String findLocator(String elementName) {
        if (iBuyPaymentMethods.containsKey(elementName)) {
            return (iBuyPaymentMethods.get(elementName.trim()));
        }

        return null;
    }

}
