package Repository_WEB_Objs;

import java.util.*;

public class SavedBasket_Objs {

    // Creation of HashMap
    private static final Map<String, String> SavedBasket;

    static {
        SavedBasket = new HashMap<String, String>();

        SavedBasket.put("update_button", "//input[@type='submit']");
        SavedBasket.put("addtoShoppingCart_checkbox", "//td[@class='add']//label//span");
        SavedBasket.put("deleteCart_checkbox", "//td[@class='delete']//label//span");
        SavedBasket.put(
            "deleteAllSavedBasket_checkbox",
            "//label[@for='deleteAllSavedBasket']"
        );
    }

    public String findLocator(String elementName) {
        if (SavedBasket.containsKey(elementName)) {
            return (SavedBasket.get(elementName.trim()));
        }

        return null;
    }
}
