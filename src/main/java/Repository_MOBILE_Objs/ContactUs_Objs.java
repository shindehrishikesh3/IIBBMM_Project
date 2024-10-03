package Repository_MOBILE_Objs;

import java.util.*;

public class ContactUs_Objs {

    // Creation of HashMap
    private static final Map<String, String> ContactUs;

    static {
        ContactUs = new HashMap<String, String>();
        ContactUs.put("breadcrumbContactUs_text", "//*[@id='breadcrumbs']//li[2]");
        ContactUs.put(
            "contctUsHeadingEU_text",
            "//*[contains(@class,'new-contact-us')]/h1"
        );
        ContactUs.put(
        		"contctUsHeadingAPAC_text",
        		"//*[@class='new-page-header-inner new-contact-us-img']/h1"
        		);
        ContactUs.put(
        		"contctUsHeadingNWK_text",
        		"//*[contains(@class,'hero-banner-panel')]/h1"
        		);
        ContactUs.put(
        		"contctUsHeading_text",
        		"(//div[contains(@class,'hero-banner-panel')]/h1) | (//div[contains(@class,'new-page-header-inner new-contact-us-img')]/h1)"
        		);
    }

    public String findLocator(String elementName) {
        if (ContactUs.containsKey(elementName)) {
            return (ContactUs.get(elementName.trim()));
        }

        return null;
    }
}
