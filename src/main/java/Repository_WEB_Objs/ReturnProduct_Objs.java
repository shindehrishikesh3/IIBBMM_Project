package Repository_WEB_Objs;

import java.util.*;

public class ReturnProduct_Objs {

    // Creation of HashMap
    private static final Map<String, String> ReturnProduct;

    static {
        ReturnProduct = new HashMap<String, String>();

        ReturnProduct.put(
            "returnProductHeader_text",
            "//div[contains(@class,'simple-heade')]//h1"
        );
        ReturnProduct.put("returnProduct_table", ".//*[@id='mk-return-a-product-form']");
        ReturnProduct.put(
            "firstOrderCode_textbox",
            "//*[(@id='Mkt_checkbox1__c' and @type='text') or @id='orderCode1']"
        );
        ReturnProduct.put(
            "firstQuantity_textbox",
            "//*[@id='quantity1' or (@id='Mkt_checkbox1__c'  and @type='text')]"
        );
        ReturnProduct.put(
            "firstReason_textbox",
            "//*[(@id='Mkt_checkbox1__c'  and @maxlength='190' )or @id='reason1']"
        );
        ReturnProduct.put(
            "telephone_textbox",
            "//*[@class='mk-fieldset']//input[contains(@id,'phone')]"
        );
        ReturnProduct.put(
            "compnayName_textbox",
            "//*[@class='mk-fieldset']//input[contains(@id,'company')]"
        );
        ReturnProduct.put(
            "accountNumber_textbox",
            "//*[@class='mk-fieldset']//input[contains(@id,'accountNumber') or contains(@id,'00N20000002DaIS')]"
        );
        ReturnProduct.put(
            "despatchNoteNumber_textbox",
            ".//*[@id='poNumber' or (@id='Additional_Comments__c' and @type='text')]"
        );
        ReturnProduct.put("customerID_textbox", ".//*[@id='cid' or @id='PIN__c']");
        ReturnProduct.put(
            "comments_textbox",
            ".//*[@id='comment' or (@id='Additional_Comments__c' and @placeholder='Geben Sie Ihr Feedback oder Ihre Frage ein') ]"
        );
        ReturnProduct.put("submit_button", ".//*[@class='mk-primary-btn mk-btn3']");
        ReturnProduct.put(
            "agreeTerms_checkbox",
            ".//*[@id='AgreeTerms' or @id='Mkt_checkbox6__c']"
        );
        ReturnProduct.put(
            "messageThankYou_text",
            ". //*[@class='mk-fluid-simple-header']//hgroup//h1"
        );
    }

    public String findLocator(String elementName) {
        if (ReturnProduct.containsKey(elementName)) {
            return (ReturnProduct.get(elementName.trim()));
        }

        return null;
    }
}
