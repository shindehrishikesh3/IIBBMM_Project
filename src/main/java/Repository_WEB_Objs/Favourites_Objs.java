package Repository_WEB_Objs;

import java.util.*;

public class Favourites_Objs {

    // Creation of HashMap
    private static final Map<String, String> Favourites;

    static {
        Favourites = new HashMap<String, String>();

        Favourites.put("favouritesTitle_element", "//*[@class='favHead']");
        Favourites.put(
            "newFavouriteListInPopup_link",
            "//a[contains(@id,'addToNewReqList')]"
        );
        Favourites.put("newFavouriteList_link", "//a[contains(@id,'AddNewList')]");
        Favourites.put("favouriteListName_text", "//*[@id='requisitionListName']");
        Favourites.put("createNew_button", ".//*[@id='createNew']");
        Favourites.put("createNewFavorites_button", "(//button[@type='submit'])[2]");
        Favourites.put("sendList_button", "//a[@id = \"emailFavs\"]");
        Favourites.put(
            "sendFavouritesListFrame_frame",
            "//iframe[contains(@class, 'popIframe')]"
        );
        Favourites.put("selectFavourite_dropdown", "//*[@id='filterOption']");
        Favourites.put("emailTo_text", "//*[@id = 'emailTo']");
        Favourites.put("message_text", "//*[@id = 'fav_list_message']");
        Favourites.put("submit_button", "//*[contains(@class,'addLoaderSubmit')]");
        Favourites.put("emailSuccessMessage_element", "//p[@class='success']");
        Favourites.put(
            "closeEmailShoppingCartFrame_link",
            "(//a[@class='closeTextWrap'])[2]"
        );
        Favourites.put("orderCode_textbox", "//input[@name='partNumber_1']");
        Favourites.put("quantity_textbox", "//input[@name='quantity_1']");
        Favourites.put("add_button", "//a[@id='addReqList']");
        Favourites.put("update_button", "//a[@id='favsUpdate']");
        Favourites.put("quantityInDetailTable_textbox", "//input[@name='quantity_2']");
        Favourites.put(
            "deleteInTable_link",
            "//a[contains(@id,'RequisitionListDetailTable')]"
        );
        Favourites.put(
            "cancel_button",
            "//div[contains(@class,'actionBox')]//a[@class='btn btnTertiary']"
        );
        Favourites.put(
            "deleteInDisplayTable_link",
            "(//a[contains(@id,'RequisitionListTableDisplay')])[2]"
        );
    }

    public String findLocator(String elementName) {
        if (Favourites.containsKey(elementName)) {
            return (Favourites.get(elementName.trim()));
        }

        return null;
    }
}
