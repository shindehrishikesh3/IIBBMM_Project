package Repository_WEB_Objs;

import java.util.*;

public class MyOrderDetails_Objs {

    // Creation of HashMap
    private static final Map<String, String> MyOrderDetails;

    static {
    	MyOrderDetails = new HashMap<String, String>();
    	MyOrderDetails.put("viewInvoice_button", "//*[@id='PFInvoiceSearch']/button");
    	MyOrderDetails.put("addAllToCart_button", "//*[@id='orderDataContent']//*[@class='actionBar']/a[1]");
    	MyOrderDetails.put("shareOrder_button", "//*[@id='orderDataContent']//*[@class='actionBar']/a[2]");
    	MyOrderDetails.put("exportToCSV_button", "//button[@id='csvExpLineV2']");
    	MyOrderDetails.put("viewAllOrders_button", "//*[@id='orderDataContent']//*[@class='marginBottom']/a");
    	MyOrderDetails.put("nonReturnableMessage_label", "//*[@class='orderDetailsBox']//*[@class='returnError']");
    	MyOrderDetails.put("returnPeriodExpired_label", "//*[@class='orderDetailsBox']//*[@class='returnPeriodExpire']");
    	MyOrderDetails.put("retrunItems_button", "//a[@id='returns']"); 
    	MyOrderDetails.put("emailAddress_text", "//*[@id='emailAdd']");
    	MyOrderDetails.put("orderConfirmationNumber_text", "//*[@id='orderConfNumber']");
    	MyOrderDetails.put("zipCode_text", "//*[@id='shippedZipCode']");
    	MyOrderDetails.put("findOrder_button", "//*[@id='viewOrder']");
    	
    	//iBuy
    	MyOrderDetails.put("approver_button", "//*[@id='approve']");
    	MyOrderDetails.put("orderApproved_text", "//*[@id='orderDataContent']/h1");
    	MyOrderDetails.put("approvedBy_text", "//*[@class='approve_by']");
    	MyOrderDetails.put("approveDate_text", "//*[@class='approve_date']");
    	MyOrderDetails.put("rejectButton","//*[@id='reject']");
    	MyOrderDetails.put("rejectReason","//*[@id='comments']");
    	MyOrderDetails.put("orderRejected_text","//*[text()=' Order Rejected ']");
    	MyOrderDetails.put("rejectDate_text","//*[@id='orderDataContent']/p[3]");
    	MyOrderDetails.put("rejectedByUser_text","//*[@id='orderDataContent']/p[2]");


    	
    	

    }

    public String findLocator(String elementName) {
        if (MyOrderDetails.containsKey(elementName)) {
            return (MyOrderDetails.get(elementName.trim()));
        }
        return null;
    }
}
