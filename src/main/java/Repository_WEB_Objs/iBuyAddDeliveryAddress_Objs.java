package Repository_WEB_Objs;

import java.util.HashMap;
import java.util.Map;

public class iBuyAddDeliveryAddress_Objs {
	// Creation of HashMap
    private static final Map<String, String> iBuyAddDeliveryAddress;

    static {
    	iBuyAddDeliveryAddress = new HashMap<String, String>();
    	iBuyAddDeliveryAddress.put("deliveryAddress_text", "//h1[contains(text(),'Addresses -')]");
    	iBuyAddDeliveryAddress.put("addNewAddress_button", "//*[@class='actionTable']");
    	iBuyAddDeliveryAddress.put("saveAddress_button", "//input[@class='btn btnPrimary']");
    	iBuyAddDeliveryAddress.put("newlyAddedAddress_link", "//*[@class='standard infoTable']//tr[1]/td[1]/a");
    	iBuyAddDeliveryAddress.put("deliveryAddressEnable_checkbox", "//*[@id=\"activeCompanyNickName-1\"]");
    	  				    	
    }

    public String findLocator(String elementName) {
        if (iBuyAddDeliveryAddress.containsKey(elementName)) {
            return (iBuyAddDeliveryAddress.get(elementName.trim()));
        }

        return null;
    }

}
