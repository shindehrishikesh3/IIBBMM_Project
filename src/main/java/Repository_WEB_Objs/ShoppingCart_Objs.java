package Repository_WEB_Objs;

import java.util.*;

public class ShoppingCart_Objs {

    // Creation of HashMap
    private static final Map<String, String> ShoppingCart;

    static {
        ShoppingCart = new HashMap<String, String>();

        // order detail table
        ShoppingCart.put("shoppingBasket_text", "//*[@class='breadCrumbWrap']/h1");
        ShoppingCart.put(
            "firstProductOnCart_text",
            "(//*[@class='productProdCodeList'])[1]/li[2]/span"
        );
        ShoppingCart.put(
            "secondProductOnCart_text",
            "(//*[@class='productProdCodeList'])[2]/li[2]/span"
        );
        ShoppingCart.put("checkoutNow_button", "//*[@class = 'checkout-button']/a[contains(@class,'btn btnPrimary checkoutContinue')]");
        ShoppingCart.put("clearAll_link", "//a[@class = 'removeAllLink ']");
        ShoppingCart.put("confirmOnOverlay_button", "//a[@id= 'clearAllConfirm']");
        ShoppingCart.put("updateBasket_button", "//*[@name='update']");
        ShoppingCart.put("loader_element", ".//*[@id='loadingWindow_undefined']");
        ShoppingCart.put("shoppingCart_icon", "//*[@id='shoppingCartBar']");
        ShoppingCart.put(
            "rohsCertificateOfCompliance_icons",
            "//div[starts-with(@class, 'pfIcon pfRohsCompliance')]"
        );
        ShoppingCart.put("quantityFirstProduct_textbox", "//input[@name='quantity_1']");
        ShoppingCart.put("selectAll_link", "//*[@id='selectAll']");
        ShoppingCart.put("deleteSelected_link", "//p[@id='checkCount']");

        ShoppingCart.put("enteryourPartno_link", "//*[@class='trigger']");
        ShoppingCart.put("update_link", "//*[@class='quantity-update similarLinktxt']");

        ShoppingCart.put("contractPrice_icon", "//*[@id='tooltip_1']");
        ShoppingCart.put(
            "partNoFirstProductOnCart_textbox",
            "//*[@id='customerPartNumber_1']"
        );
        ShoppingCart.put("lineNoteFirstProductOnCart_textbox", "//*[@id='lineNote_1']");
        ShoppingCart.put("delete_link", "//*[@id='removeItem']");

        ShoppingCart.put("productCodeOnCart_list", "(//*[@class='productProdCodeList'])");
        ShoppingCart.put(
            "partNumberOnCartPartial_element",
            "//*[@id='customerPartNumber_"
        );
        ShoppingCart.put("lineNoteOnCartPartial_element", "//*[@id='lineNote_");
        ShoppingCart.put("quantityOnCartPartial_element", "//input[@name='quantity_");
        ShoppingCart.put("registerUserTaxExemptMessage_text", "//*[@class='taxExemptCont']");
	ShoppingCart.put("product_image",".//img[@class='product-image']");
    	ShoppingCart.put("orderCodePartial_element", "//*[@class='productProdCodeList']/li[2]/span[text()='");
	

        //Quick add section
        ShoppingCart.put("firstOrderCode_textbox", "//*[contains(@id,'partNumber_Add')]");
        ShoppingCart.put("quantity_textbox", "//input[@name='quantity_Add']");
        ShoppingCart.put("quickadd_label", "//*[@class='quick-bar-title']");
        ShoppingCart.put("addbasket_button", "//*[@id='addToBasket']");
      

        // Guest checkout pop-up
        ShoppingCart.put(
            "checkoutWithoutRegistering_radio",
            "//*[@id='guestCheckoutOption']/label/span"
        );
        ShoppingCart.put(
            "checkoutWithoutRegistering_button",
            "//*[@class='show']/div/div/a[1]"
        );
        ShoppingCart.put(
            "checkoutWithoutRegisteringB2B_button",
            "//*[@class='contPopAction']/input"
        );
        ShoppingCart.put("companyNameGuestCheckout_textbox", "//*[@id='companyName']");
        ShoppingCart.put("confirmB2B_checkbox", "//*[@class='confirmationBox']/label");
        ShoppingCart.put("guestUserTaxExemptContainer_element", "//*[@class='guestUserMsgContainer']");
        ShoppingCart.put("guestUserTaxExemptMessage_text", "//*[@class='guestUserMsg']/div[2]");
        ShoppingCart.put("newCustomer_radio","//*[@id='checkoutRegister']/parent::label/span");
        ShoppingCart.put("newCustomer_button","//*[@id='registerButton']");
        
        // order pricing sticky side bar
        ShoppingCart.put("e-voucher_link", "//label[@class='voucherLabel']");
        ShoppingCart.put("totalprice_element", "//span[@id='Total_price']");
        ShoppingCart.put("vouchercode_text", "//input[@id='promotionCode']");
        ShoppingCart.put("applyEvoucher_button", "//input[@id='applyVoucherCode']");
        ShoppingCart.put("discountPrice_message", "//span[@class='discountText']");
        ShoppingCart.put(
            "voucherDiscount_message",
            "//tbody//tr[contains(@class,'strong vouchersTd')]"
        );
        ShoppingCart.put("subTotalPrice_element", "//span[@id='allItemTotal_price']");
        ShoppingCart.put(
            "discountSubTotalMerchandise_element",
            "//span[@id='subTotal_price']"
        );

        // schedule order section
        ShoppingCart.put("createSchedule_radio", "//input[@id='scheduleCreate']");
        ShoppingCart.put(
            "okCreateSchedule_button",
            "//p[@class='actionButtons']//button[2]"
        );
        ShoppingCart.put("selectAll_link", "//a[contains(@class,'selectAllLink')][1]");
        ShoppingCart.put("deleteAll_link", "//a[@id='removeItems']");
        ShoppingCart.put(
            "createSchedule_button",
            "//a[contains(@class,'scheduleCreate')]"
        );
        ShoppingCart.put("deleteSchedule_button", "//a[@id='deletescheduleBtn']");
        ShoppingCart.put("confirmDeleteSchedule_button", "//*[@id='confConfirm']");
        ShoppingCart.put(
            "orderscheduledconfirmation_message",
            "//span[@class='scheduleLabel']"
        );
        ShoppingCart.put(
            "savedBasketconfirmation_message",
            "(//p[@class='errorText'])[1]"
        );

        // Bottom action group
        ShoppingCart.put("viewAllSavedBasket_button", "//li[@class='last']");
        ShoppingCart.put(
            "save/loadBasket_button",
            "//div[contains(@class,'load-save-basket')]/div[1]"
        );
        ShoppingCart.put("basketName_text", "//input[@name='savedBasketName']");
        ShoppingCart.put("saveBasket_button", "//button[@id='saveCartAndUpdateBasket']");
        ShoppingCart.put("downloadBasket_button", "//div[@id='downloadBasketBtn']");
        ShoppingCart.put(
            "downloadinPopup_button",
            "//button[@id='downloadBasketSubmit']"
        );
        ShoppingCart.put("fileType_dropdown", "//select[@id='documentType']");
        ShoppingCart.put(
            "emailShopingCartFrame_frame",
            "//iframe[@class='popIframe bom-RAQIframe']"
        );
        //ShoppingCart.put("sendEmail_button", "//input[@value='Send']");
        ShoppingCart.put(
            "sendEmail_button",
            "//*[@id='BasketEmailSendForm']/div[4]/input"
        );
        ShoppingCart.put("emailSuccessMessage_element", "//p[@class='success']");
        ShoppingCart.put(
            "closeEmailShoppingCartFrame_link",
            "(//*[@class='close closeOverlay closeOverlayWrap '])[1]"
        );
        ShoppingCart.put("loadBasket_button", "//input[@id='loadBasketSubmit']");

        //top action group
        ShoppingCart.put("emailBasket_button", "//a[@id='emailBasket']");
        ShoppingCart.put("email_text", "//input[@id='emailTo']");
        ShoppingCart.put("message_text", "//*[@id='email_message']");

        //BOM reference
        ShoppingCart.put("bomReference_icon", "//*[@class='pfIcon pfQuote']");
        ShoppingCart.put("quoteMessage_text", "//*[@class='warningAlone']");

        //iBuy custom field
        ShoppingCart.put("lineNoteCustomfield_text", "//*[@for='comment_1']");
        ShoppingCart.put("lineNoteCustomfield_dropdown", "//*[@id='comment_1']");
        ShoppingCart.put("customFieldOne_text", "//*[@for='ibuyfield1_1']");
        ShoppingCart.put("customFieldOne_dropdown", "//*[@id='ibuyfield1_1']");
        //My Account E-spot
        ShoppingCart.put("myAccount_link", "//*[@class='collection-title']/a");
        ShoppingCart.put("orderPreferences_link", "//*[@id='ad_pf_header_espot_myacc']//li[3]");

        // Packaging Type icon.
        ShoppingCart.put("packTypeRereel_icon", "//span[@class='pfPackOptIcon_RR'][1]");
        ShoppingCart.put("packTypeCutTape_icon", "//span[@class='pfPackOptIcon_TC']");
        ShoppingCart.put("packTypeReel_icon", "//span[@class='pfPackOptIcon_TR']");
        ShoppingCart.put("pkgOptAvail_link", "//a[@class='associatedProductsAvailable']/span");
        ShoppingCart.put("backOrdered_text", "//div[contains(@class,'enhanceQuantityErrorWrapper')]//p//strong");
        ShoppingCart.put("minOrderQtyError_text", "//div[@id='formErrors']//p[@class='errorText'][1]");
    }

    public String findLocator(String elementName) {
        if (ShoppingCart.containsKey(elementName)) {
            return (ShoppingCart.get(elementName.trim()));
        }

        return null;
    }
}
