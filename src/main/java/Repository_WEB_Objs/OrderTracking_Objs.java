package Repository_WEB_Objs;

import java.util.*;

public class OrderTracking_Objs {

    // Creation of HashMap
    private static final Map<String, String> OrderTracking;

    static {
        OrderTracking = new HashMap<String, String>();
        OrderTracking.put("emailaddress_textbox", "//input[@id='emailAdd']");
        OrderTracking.put("orderConfirmation_textbox", "//input[@id='orderConfNumber']");
        OrderTracking.put("postcode_textbox", "//input[@id='shippedZipCode']");
        OrderTracking.put("findorder_button", "//button[@id='viewOrder']");
        OrderTracking.put("orderDetails_text", "//*[@class='content logIn']/h1");
        OrderTracking.put(
            "orderStatus&Tracking_text",
            "//p[@class='orderStatusHeading']"
        );
        OrderTracking.put("MyOrderDetails_text", "//*[@class='smMarginTop']");
        OrderTracking.put("orderRefNum_text", "//span[@class='thisPoNumber']");
        OrderTracking.put(
            "orderTrackingShare_button",
            "//*[@class='actionBar']//a[@class='btn btnTertiary']"
        );
        OrderTracking.put("sendOrdertracking_button", "//*[@class='shareEmail']//button");
        OrderTracking.put(
            "reorder_button",
            "//*[@class='btn btnPrimary btnSmall ajaxAddToCart omTagEvt ']"
        );
        OrderTracking.put("paymentInformation_text", "//*[@class='paymentInfo headCol restrictedData']/div/p");

    }

    public String findLocator(String elementName) {
        if (OrderTracking.containsKey(elementName)) {
            return (OrderTracking.get(elementName.trim()));
        }

        return null;
    }
}
