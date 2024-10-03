package Repository_WEB_Objs;

import java.util.*;

public class ContactUs_Objs {

    // Creation of HashMap
    private static final Map<String, String> ContactUs;

    static {
        ContactUs = new HashMap<String, String>();
        ContactUs.put("contactUs_label", "//div[@class='new-page-header-inner new-contact-us-img']/h1");
        ContactUs.put("checkOrderStatus_link", "//*[@class='mk-impact-ul-sm']//li/a[contains(@href,'order-status')]");
        ContactUs.put("requestAQuote_link", "//li/a[contains(@href,'request-a-quote')]");
        ContactUs.put("initiateReturn_link", "//*[@class='mk-impact-ul-sm']//li/a[contains(@href,'return-a-product')]");
    }

    public String findLocator(String elementName) {
        if (ContactUs.containsKey(elementName)) {
            return (ContactUs.get(elementName.trim()));
        }

        return null;
    }
}
