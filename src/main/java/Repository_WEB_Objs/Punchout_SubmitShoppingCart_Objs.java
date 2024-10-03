package Repository_WEB_Objs;

import java.util.*;

public class Punchout_SubmitShoppingCart_Objs {

    // Creation of HashMap
    private static final Map<String, String> Punchout_SubmitShoppingCart;

    static {
        Punchout_SubmitShoppingCart = new HashMap<String, String>();


	// punchout specific shoopping cart objs
	Punchout_SubmitShoppingCart.put("editBasket_button", ".//*[@class='rightCartActions poActionUpdate']/*[@class='btn btnSecondary']");
	Punchout_SubmitShoppingCart.put("top_SendBasket_button", ".//*[@class='rightCartActions poActionUpdate']/*[@class='btn btnTertiary'][1]");
	Punchout_SubmitShoppingCart.put("bottom_SendBasket_button", "(.//*[@class='rightCartActions poActionUpdate']/*[@class='btn btnTertiary'])[2]");
	Punchout_SubmitShoppingCart.put("poLink_text",".//*[@class='poLinks']/span");
	Punchout_SubmitShoppingCart.put("poOrderDetailsTableHeaders_elements",".//*[@id='poOrderDetails']//tr/th");
	Punchout_SubmitShoppingCart.put("poOrderDetailsTableBodyRows_elements",".//*[@id='poOrderDetails']/tbody/tr");
    }

    public String findLocator(String elementName) {
        if (Punchout_SubmitShoppingCart.containsKey(elementName)) {
            return (Punchout_SubmitShoppingCart.get(elementName.trim()));
        }

        return null;
    }
}
