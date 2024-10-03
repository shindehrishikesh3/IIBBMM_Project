package Repository_MOBILE_Objs;

import java.util.*;

public class ShoppingCart_Objs {

    // Creation of HashMap
    private static final Map<String, String> ShoppingCart;

    static {
        ShoppingCart = new HashMap<String, String>();
        ShoppingCart.put("firstOrderCode_textbox", "//*[contains(@id,'partNumber_Add')]");
        ShoppingCart.put("updateBasket_button", "//*[starts-with(@id,'toolTipHook')]");
        ShoppingCart.put(
            "checkoutNow_button",
            "(//*[contains(@class,'checkoutContinue')])[1]"
        );
        ShoppingCart.put(
            "checkoutNowBttom_button",
            "(//*[contains(@class,'checkoutContinue')])[2]"
        );
        ShoppingCart.put(
            "checkoutNowSticky_button",
            "(//*[contains(@class,'checkoutContinue')])[3]"
        );
        ShoppingCart.put(
            "checkoutWithoutRegistering_button",
            "//*[@id='guestCheckoutOption']"
        );
        ShoppingCart.put(
            "partLineNo_input",
            "//*[starts-with(@id,'collapsable_linenote')]"
        );
        ShoppingCart.put("partNo_input", "//*[starts-with(@id,'custPartNum')]");
        ShoppingCart.put("lineNo_input", "//*[starts-with(@id,'lineNote')]");
        ShoppingCart.put("voucherCode_textBox", "//*[@id='promotionCode']");
        ShoppingCart.put("voucherCodeApply_button", "//*[@name='applyVoucherCode']");
        ShoppingCart.put(
            "voucherCode_text",
            "//*[@id='summaryTotals']/tbody/tr[1]/td[1]"
        );
        ShoppingCart.put("voucherName_text", "//*[@class='voucherName']");
        ShoppingCart.put("emailBasket_button", "//a[@id='emailBasket']");
        ShoppingCart.put("emailShopingCartFrame_frame", "//iframe[@class='popIframe']");
        ShoppingCart.put("email_text", "//input[@id='emailTo']");
        ShoppingCart.put("message_text", "//*[@id='email_message']");
        ShoppingCart.put("sendEmail_button", "//button[@name='submit']");
        ShoppingCart.put("emailSuccessMessage_element", "//p[@class='success']");
        ShoppingCart.put(
            "closeEmailShoppingCartFrame_EUlink",
            "(//button[@class='close'])[5]"
        );
        ShoppingCart.put(
            "closeEmailShoppingCartFrame_USlink",
            "(//button[@class='close'])[4]"
        );
        ShoppingCart.put("selectAll_link", "//*[@id='selectAll']");
        ShoppingCart.put("deleteAll_link", "//a[@id='removeItems']");
        ShoppingCart.put(
            "save/loadBasket_button",
            "//div[contains(@class,'load-save-basket')]/div[1]"
        );
        ShoppingCart.put("loadBasket_button", "//input[@id='loadBasketSubmit']");
        ShoppingCart.put("shoppingCart_icon", "//*[@id='shoppingCartBar']");
        ShoppingCart.put("errorMessage_text", "//*[@id='formErrors']/div/ul/li/ul/li");
        ShoppingCart.put("deleteProduct_button", "//*[@id='icon_1']");
        ShoppingCart.put("quantity_textbox", "//input[@name='quantity_Add']");
        ShoppingCart.put("shoppingcartMain_section", "//*[@id='ShopCartPagingDisplay']");
        ShoppingCart.put(
            "orderCode_text",
            "//*[@id='basketContent']/div[1]/div[3]/div[1]/a"
        );
        ShoppingCart.put("additionalInformation_button", "(//*[@class='collapsable-trigger'])[1]");
        ShoppingCart.put("basketContent_section", "//*[@id='basketContent']");
        ShoppingCart.put("register_button","(//*[@class='contPopAction']/a)[1]");
        ShoppingCart.put("newCustomer_button","(//*[@class='contPopAction']/a)[2]");
    }

    public String findLocator(String elementName) {
        if (ShoppingCart.containsKey(elementName)) {
            return (ShoppingCart.get(elementName.trim()));
        }

        return null;
    }
}
