package Repository_MOBILE_Objs;

import com.sun.msv.reader.relax.HedgeRefState;
import java.util.*;
import org.openqa.selenium.By;

public class Header_Objs {

    // Creation of HashMap
    private static final Map<String, String> Header;

    static {
        Header = new HashMap<String, String>();
        Header.put("cookiePolicy_dialogBox", "//*[@id='onetrust-policy']");
        Header.put("companylogo_element", ".//*[@id='ad_storeLogoESpot']");
        Header.put(
            "burgerNav_Button",
            "//*[@class='navbar-brand']/preceding-sibling::button"
        );

        // Search box in Header
        Header.put("searchBox_textbox", "//*[@id='SimpleSearchForm_SearchTerm']");
        Header.put("searchIcon_button", "//*[@id='searchMain']");

        Header.put("userFirstName_text", "//*[@id='loggedInPar']/span[1]");
        Header.put("miniBasket_link", "//*[@class='shopcart-white']");
        Header.put("itemsInMiniBasket_text", "//*[@class='items-qty']");
        Header.put("itemAddedPopUp_element", "//*[@class='added-to-basket-label']");
        Header.put("login_link", "//*[@id='guestPar']/a");
        Header.put("miniBasketGoToCheckout_button", "//*[@id='MiniShoppingCart']//*[@class='btn btn-primary']");

        //Country Selector Icon
        Header.put(
            "countrySelector_icon",
            "//*[contains(@data-widget,'countryselector')]"
        );

        //Toggle bar
        Header.put(
            "countrySelector_icon",
            "//*[contains(@data-widget,'countryselector')]"
        );
        Header.put("logOut_button", "//*[@class='authentication-drawer']/p/a[2]");
    }

    public String findLocator(String elementName) {
        if (Header.containsKey(elementName)) {
            return (Header.get(elementName.trim()));
        }

        return null;
    }
    // ******************************************************

}
