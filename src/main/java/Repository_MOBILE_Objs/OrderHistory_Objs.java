package Repository_MOBILE_Objs;

import java.util.*;
import org.apache.tools.ant.taskdefs.condition.Or;

public class OrderHistory_Objs {

    // Creation of HashMap
    private static final Map<String, String> OrderHistory;

    static {
        OrderHistory = new HashMap<String, String>();
        OrderHistory.put(
            "recentOrderHistoryTable_element",
            "//*[@id='OrderStatusTableDisplay_div_1']"
        );
        OrderHistory.put(
            "viewAllOrders_button",
            "//*[@class='btn btn-primary btn-block disAfterSub']"
        );
        OrderHistory.put(
            "orderDate_text",
            "(//div[@class='order-date col-xs-8']/span[2])[1]"
        );
        OrderHistory.put(
            "orderHistoryTracking_text",
            "//*[@id='page-container']/div[1]/h1"
        );
        OrderHistory.put("recentOrders_text", "//*[@class='outlined-section']/h2");
        OrderHistory.put(
            "orderHistoryHeading_text",
            "//*[contains(text(),'Order Details')]"
        );
        OrderHistory.put("emailaddress_textbox", "//input[@id='emailAdd']");
        OrderHistory.put("orderConfirmation_textbox", "//input[@id='orderConfNumber']");
        OrderHistory.put("postcode_textbox", "//input[@id='shippedZipCode']");
        OrderHistory.put("findorder_button", "//input[@id='viewOrder']");
        OrderHistory.put("orderDetails_section", "//*[@class='orderDetailsView']");
        OrderHistory.put("orderDateText_text", "//*[@class='order-date']/span[1]");
        OrderHistory.put("orderInfo_section", "//*[@id='collapsable_']");
        OrderHistory.put("deliveryAddress_section", "//*[@id='collapsableDelivery_']");
        OrderHistory.put("deliveryInfo_section", "//*[@id='collapsableShipping_']");
        OrderHistory.put("paymentInfo_section", "//*[@id='collapsablePayment_']");
        OrderHistory.put("NotShippedProduct_section", "//*[@id='AddAllItemsToCartForm']");
        OrderHistory.put("reorder_link", "(//*[@class='nonRestrictedData']/a)[1]");
        OrderHistory.put(
            "orderCode_text",
            "//*[@id='collapsableNotShipped_']/div[2]/table/tbody/tr[1]/td[2]/a"
        );
        OrderHistory.put(
            "shippedOrderCode_text",
            "((//*[@class='outlined-section'])[1]//a)[1]"
        );
        OrderHistory.put(
            "moreDetails_link",
            "(//*[@class='order-item outlined-section'])[1]/div/div[2]/a"
        );
        OrderHistory.put(
            "otherDetails_section",
            "(//*[@class='order-item outlined-section'])[1]//table"
        );
        OrderHistory.put(
        		"paymentmethod_text",
        		"//*[@id='collapsablePayment_']/div[2]/table/tbody/tr[1]/td[2]"
        		);
    }

    public String findLocator(String elementName) {
        if (OrderHistory.containsKey(elementName)) {
            return (OrderHistory.get(elementName.trim()));
        }

        return null;
    }
}
