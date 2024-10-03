package Repository_WEB_Objs;

import java.util.*;

public class OrderHistory_Objs {

    // Creation of HashMap
    private static final Map<String, String> OrderHistory;

    static {
        OrderHistory = new HashMap<String, String>();
        OrderHistory.put("recentOrders_text", "(//*[@class='section'])[2]/h2");
        OrderHistory.put(
            "firstPONumber_element",
            "//a[contains(@href,'NonAjaxOrderDetail')]"
        );
        OrderHistory.put("viewAllOrders_button", "//*[@class='btnPrimary btn']");
        OrderHistory.put("txt_OrderHistory&Tracking", "//*[@id='article']/h1");
        OrderHistory.put("MyOrderDetails_text", "//*[@class='smMarginTop']");
        OrderHistory.put("orderSearch_button", "//*[@id='searchMultiCal']");
        OrderHistory.put(
            "addAllToBasket_button",
            "//*[@class='actionBar']//a[@class='btn btnPrimary reOrderItems']"
        );
        OrderHistory.put("firstPONumber_text", "//*[@class='thisPoNumber']");

        OrderHistory.put("orderHistory_table", "//*[@class='orderStatus']");
        OrderHistory.put(
            "exportOrdersAsXLS_button",
            "//*[@class='orderHistButton btn btnTertiary']"
        );
        OrderHistory.put("orderDetailsReport_link", "//*[@id='csvExp']");
        OrderHistory.put("lineDetailsReport_link", "//*[@id='csvExpLine']");
        OrderHistory.put("downloadReport_popUp", "//*[@class='popBody']/div/h3");
        OrderHistory.put(
            "downloadReportPopUpClose_button",
            "//*[@id='closeLinkcsvExport']"
        );
        OrderHistory.put("Cancel_button", "//a[@class='btn btnTertiary']"); 
        OrderHistory.put("searchBy_dropdown", "//select[@id='searchField']");
        OrderHistory.put("searchValue_textbox", "(//*[@id='searchValue'])[1]");
        OrderHistory.put("openOrdersReport_button", "//button[contains(@onclick,'triggerOpenOrders')]");
        OrderHistory.put("downloadProgress_modal", "//*[@id='progressMask']");
        OrderHistory.put("errorGeneratingReport_label", "//*[@class='view errorView']//*[@data-generic-title='Error']");
        OrderHistory.put("contactUsNow_button", "//*[@class='view errorView']//*[@class='btn btnPrimary']");
        OrderHistory.put("orderStatus_dropdown", "//*[@name='selectedStatus']");
        OrderHistory.put("tierName_dropdown", "//*[@id='selectedOrg']");
        OrderHistory.put("completeStatus_label", "//*[@class='greenState']/*[@class='statusLabel' and contains(@id,'toolTip')]");
        OrderHistory.put("cancelledStatus_label", "//*[@class='cancelOrHoldState']/*[@class='statusLabel' and contains(@id,'toolTip')]");

        //for CPC
        OrderHistory.put("poNo_link", "//*[@class='resDataHide']/a");
       
        OrderHistory.put("DeptCode_element","(//div[@class='orderInfo headCol']//p//strong)[8]");
        OrderHistory.put("DeptCode_text","(//div[@class='orderInfo headCol']//p)[8]");
        OrderHistory.put("CostCode_element","(//div[@class='orderInfo headCol']//p//strong)[9]");
        OrderHistory.put("CostCode_text","(//div[@class='orderInfo headCol']//p	)[9]");
        OrderHistory.put("LineNote_element","//table[@class='standard']//tbody//tr[2]//p/span[@class='title']//span");
        OrderHistory.put("ProjCode_element","(//table[@class='standard']//tbody//tr[2]//p/span[@class='title'])[2]");
        OrderHistory.put("LineNote_text", "(//table[@class='standard']//tbody//tr[2]//p/span[@class='text'])[1]");
        OrderHistory.put("ProjCode_text", "(//table[@class='standard']//tbody//tr[2]//p/span[@class='text'])[2]");
        OrderHistory.put("OrderInfo_elements", "//div[@class='orderInfo headCol']//p//strong");
        
    }
  
    public String findLocator(String elementName) {
        if (OrderHistory.containsKey(elementName)) {
            return (OrderHistory.get(elementName.trim()));
        }

        return null;
    }
}
