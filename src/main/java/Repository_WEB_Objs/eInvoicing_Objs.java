package Repository_WEB_Objs;

import java.util.HashMap;
import java.util.Map;

public class eInvoicing_Objs {

    // Creation of HashMap
    private static final Map<String, String> eInvoicing;

    static {
    	eInvoicing = new HashMap<String, String>();

        // Search box in Header
    	eInvoicing.put("ordernumber_text", "//*[@id='orderNumber']");
    	eInvoicing.put("ponumber_text", "//*[@id='poNumber']");
    	eInvoicing.put("invoicenumber_text", "//*[@id='invoiceNumber']");
    	eInvoicing.put("enddate_text", "//*[@id='widget_toDate']");
    	eInvoicing.put("startdate_text", "//*[@id='fromDate']");
    	eInvoicing.put("status_list", "//*[@id='invoiceStatus']");
    	eInvoicing.put("invoicetype_list", "//*[@id='invoiceType']");
    	eInvoicing.put("search_button", "//*[@data-dd-event-callback='invoiceFilters']");
    	eInvoicing.put("searchedordernumber_link", "//*[@class='standard']//tbody/tr/td[4]/a");
    	eInvoicing.put("resetallfields_button", "//*[@id='resetAll']");
    }

    public String findLocator(String elementName) {
        if (eInvoicing.containsKey(elementName)) {
            return (eInvoicing.get(elementName.trim()));
        }

        return null;
    }
}
