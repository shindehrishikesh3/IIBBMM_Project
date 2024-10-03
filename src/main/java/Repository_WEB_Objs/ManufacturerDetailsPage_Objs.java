package Repository_WEB_Objs;

import java.util.*;

public class ManufacturerDetailsPage_Objs {

    // Creation of HashMap
    private static final Map<String, String> ManufacturerDetailsPage;

    static {
        ManufacturerDetailsPage = new HashMap<String, String>();

        ManufacturerDetailsPage.put(
                "ManufacturerName_imgText",
                "//*[@class='mk-sf-logoholder']/img");
        ManufacturerDetailsPage.put(
                "ManufacturerDescription_element",
                "//*[@class='manuDetailsPage']/div");
        ManufacturerDetailsPage.put(
                "EaoBanner_link",
                "//*[@class='eao-banner']/a");
        ManufacturerDetailsPage.put(
                "mfrContent_text",
                "//*[@id='mk-extended-content-1']");
        ManufacturerDetailsPage.put(
                "mfrContentHeader_text",
                "//*[@id='mk-extended-content-1']/h3");

    }

    public String findLocator(String elementName) {
        if (ManufacturerDetailsPage.containsKey(elementName)) {
            return (ManufacturerDetailsPage.get(elementName.trim()));
        }

        return null;
    }
}
