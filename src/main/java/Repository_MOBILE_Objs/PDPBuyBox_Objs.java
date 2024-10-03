package Repository_MOBILE_Objs;

import java.util.*;

public class PDPBuyBox_Objs {

    // Creation of HashMap
    private static final Map<String, String> PDPBuyBox;

    static {
        PDPBuyBox = new HashMap<String, String>();
        PDPBuyBox.put("addToCart_button", "//*[contains(@class,'ajaxAddToCart')]");
        PDPBuyBox.put(
            "availabilitySection_text",
            "//*[contains(@id, 'availability-section')]//h3"
        );
        PDPBuyBox.put(
            "availabilitySection_element",
            "//section[@id='availability-section']"
        );
        PDPBuyBox.put(
            "availableStock_text",
            "//*[@class='availabilityHeading available']"
        );

        // common
        PDPBuyBox.put("seeCutOffTime_link", "//*[@class='tooltipLink']");
        PDPBuyBox.put(
            "seeCutOffTime_text",
            "//*[contains(@id, 'tt-cutOffTimesTooltip')]//p"
        );
        PDPBuyBox.put("morestockinfo_text", "//*[@id='availability-content']//p[3]");
        PDPBuyBox.put("availabilityAltContainer_element", "//div[@id='altContainer']");

        // NLS NLM
        PDPBuyBox.put(
            "nLSNLM_text",
            "//*[@class='collapsable-outlined open'][@id='availability-section-clone']//div[@class='collapsable-content']/p"
        );

        // AFB
        PDPBuyBox.put("contactWhenBackInStock_link", "//*[@class='pdpCheck']");
        PDPBuyBox.put(
            "closeContactMeOverlay_button",
            "//*[@id='contactMeOverlay']//span"
        );
        PDPBuyBox.put("contactMeOverlyOrderCode_text", "//span[@id='emOrderCode']");

        // US stock
        PDPBuyBox.put("usStock_link", "//*[@class='tooltipLink']");
        PDPBuyBox.put(
            "usStockPopup_text",
            "//*[@id='tt-internalDirectShipTooltip-1']//p"
        );
        PDPBuyBox.put("deliveryCharge_text", "//*[@id='availability-content']//p[2]");
        PDPBuyBox.put("deliveryMsg_text", "//*[@id='availability-content']//p[3]");

        // SDS
        PDPBuyBox.put("sDS_link", "//*[@id='supplierDirectShipTooltip-1']");
        PDPBuyBox.put("sDSPopup_text", "//*[@id='tt-supplierDirectShipTooltip-1']//p");
        PDPBuyBox.put(
            "nonCancelNonReturn_text",
            "//*[contains(@class, 'availabilityDescription')]"
        );

        // video
        PDPBuyBox.put("videoImage_image", "//*[@class='pfIcon pfLargeVideo']");
        PDPBuyBox.put(
            "videoPopup_element",
            "//*[@aria-labelledby='videoImagePopup_title']"
        );
        PDPBuyBox.put(
            "closeVideoPopup_element",
            "//*[@class='close videoPopupClose']//span[@class='pfIcon pfClose']"
        );

        //No Longer Manufacturer
        PDPBuyBox.put(
            "noLongerAvailable_text",
            "//section[@id='availability-section-clone']/div[2]/p"
        );
        PDPBuyBox.put("suggestedSubstitutes_text", "//*[@id='altType']");
        PDPBuyBox.put("nlmManufacturerName_text", "//*[@id='manuName']");
        PDPBuyBox.put("nlmManufacturerDesc_link", "//*[@id='mnDes']");
        PDPBuyBox.put("contactMeBackIframe_element", "//*[@class='popIframe']");
    }

    public String findLocator(String elementName) {
        if (PDPBuyBox.containsKey(elementName)) {
            return (PDPBuyBox.get(elementName.trim()));
        }

        return null;
    }
}
