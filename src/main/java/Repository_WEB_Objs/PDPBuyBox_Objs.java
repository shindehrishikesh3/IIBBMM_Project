package Repository_WEB_Objs;

import java.util.*;

public class PDPBuyBox_Objs {

    // Creation of HashMap
    private static final Map<String, String> PDPBuyBox;

    static {
        PDPBuyBox = new HashMap<String, String>();
        PDPBuyBox.put("requestaQuote_link", "//div[@class='quoteLink']/a");
        PDPBuyBox.put(
            "availabilityPriceContainer_element",
            "//div[@class='availabilityPriceContainer']"
        );
        PDPBuyBox.put(
            "availabilityHeading_text",
            "//*[@class='availabilityHeading available']"
        );
        PDPBuyBox.put("instock_icon", ".//*[contains(@class,'pdpInstockIcon')]");
        PDPBuyBox.put("cutOffTimeA_text", "//*[contains(@class,'pdpCutOffTimeTxtA')]/p");
        PDPBuyBox.put(
            "cutOffTimeB_text",
            "//*[contains(@class,'pdpCutOffTimeTxtB')]/p[1]"
        );
        PDPBuyBox.put("availabilityList_text", "//div[@class='availabilityList']");
        PDPBuyBox.put("cutOffTimeTooltip_icon", "//*[@class='pdpAwtInfolink']");
        PDPBuyBox.put(
            "tooltipContent_text",
            "//*[@class='pdpPopupInstock pdpToolTipPopup']"
        );
        PDPBuyBox.put(
            "exclVatPrice_text",
            "//*[contains(@class,'productPrice')]//span[contains(@class,'price')]"
        );
        PDPBuyBox.put("priceFor_text", "//div[@class='inventoryStatus']/dl/dt");
        PDPBuyBox.put("priceForValue_text", "//div[@class='inventoryStatus']/dl/dd");
        PDPBuyBox.put("multiple_text", "(//div[@class='multqty']/span)[1]");
        PDPBuyBox.put("minimum_text", "(//div[@class='multqty']/span)[2]");
        PDPBuyBox.put(
            "requestAQuoteTitle_text",
            ".//*[contains(@class,'request-a-quote')]/h1"
        );
        PDPBuyBox.put(
            "qtyLabel_text",
            ".//div[contains(@class,'qtyField')]/strong/label"
        );
        PDPBuyBox.put("qty_textbox", "(//*[contains(@id,'quantity')])[1]");
        PDPBuyBox.put("addToCart_button", "//*[@id='addToOrder']/a");
        PDPBuyBox.put("totalPriceLabelExcVAT_text", "//*[@id='excVatTotalPrice']");
        PDPBuyBox.put("totalPriceExcVAT_text", "//*[@id='_totalPriceEXCVat']");
        PDPBuyBox.put("totalPriceLabelIncVAT_text", "//*[@id='incVatTotalPrice']");
        PDPBuyBox.put("totalPriceIncVAT_text", "//*[@id='_totPriceincAndExcVat']");
        PDPBuyBox.put("addLineNote_link", ".//*[@id='Collapsable_0']");
        PDPBuyBox.put("addtoFavourites_link", ".//*[@id='requisitionList']");

        //Avnet section
        PDPBuyBox.put("avnetSection_element", "//aside/*[@class='partnerAvnetContainer']");
        PDPBuyBox.put(
            "viewPricingAvailability_link",
            "//aside//*[@id='avnetAvailabilityTooltipId']"
        );
        PDPBuyBox.put("avnetPopupTitle_text", ".//*[@class='titleHead']");
        PDPBuyBox.put("avnnetManufTitle_text", ".//*[@class='mfnTitle']");
        PDPBuyBox.put("avnetPopupTableHeader_list", ".//*[@class='avnetTable']//th");
        PDPBuyBox.put("viewAvnet_link", ".//*[@class='viewAvnetLink']/a");
        PDPBuyBox.put(
            "avnetPopupFooter_list",
            ".//*[@class='dijitDialogPaneContent']//*[@class='footer']/span"
        );

        // packaging elements
        PDPBuyBox.put("packagingType_text", "//*[@class='packagingType']/span/strong");
        PDPBuyBox.put(
            "packagingTypeValue_text",
            "//*[@class='productMainPackType']/strong"
        );
        PDPBuyBox.put(
            "additionalPackagingOptionsAvailable_link",
            "//*[@class='packageOption']"
        );
        PDPBuyBox.put(
            "packagingOptions_list",
            "//*[@class='productPackOptAvailArea']/span[@class='productPackType']"
        );
        PDPBuyBox.put("firstCheckStock_link", "//*[@class='priceTooltip']");
        PDPBuyBox.put(
            "firstSeeCutOffTimes_link",
            "(//*[contains(@id,'cutOffTimesTooltip') and (@class='clearBoth pdpToolTip')])[1]/a[1]"
        );
        PDPBuyBox.put("deliveryInformation_link", "//*[@class='deliveryInformation']");
        PDPBuyBox.put(
            "firstCheckStockAndLeadTimes_link",
            "//*[ @class='pdpCheckMoreStock']"
        );
        PDPBuyBox.put(
            "packCalculations_element",
            "(//*[@class='packCalFirst vatExcl']/span)[2]"
        );
        PDPBuyBox.put(
            "packTotalPrice_text",
            "(//*[@class='packPriceCalTotal vatExcl']/span)[2]"
        );
        PDPBuyBox.put("packagingPrefsRadio_list", "//*[@id='packageOptionsdiv']//input");
        PDPBuyBox.put("rereelingEAP1_text", "//*[@class='packaging']//strong");
        PDPBuyBox.put("rereelingEAP2_text", "//*[@class='packaging'][2]");
        PDPBuyBox.put("rereelMessage_text", "//*[@id='showReelMessage']");

        //Contract price
        PDPBuyBox.put("contractPrice_icon", "(//div[@class='yourPrice'])[1]");

        //No Longer Manufacturer
        PDPBuyBox.put("noLongerAvailable_text", "//*[@class='availTxtMsg']");
        PDPBuyBox.put("suggestedSubstitutes_text", "//*[@id='altType']");
        PDPBuyBox.put("nlmManufacturerName_text", "//*[@id='manuName']");

        PDPBuyBox.put("currentPrice_label", "//*[@class='currentPrice']");
        PDPBuyBox.put("wasPrice_label", "//*[@class='wasPrice']");
        
        //request quote
        PDPBuyBox.put("sendRequest_link", "//*[@class='btn btnPrimary v2']");
        PDPBuyBox.put("futureStock_text", "//*[@class='avalabilityContainer']/p[@id='pdpFutureInfo']");
        PDPBuyBox.put("requestQuote_link", "//*[@class='quoteLink']/a");
        PDPBuyBox.put("pdpQuote_label", "//*[@class='avalabilityContainer']/p[@id='pdpQuoteInfo']");
        PDPBuyBox.put("submit_button", "//*[@class='navigation-wrapper']/button");
        PDPBuyBox.put("fullname_textbox", "(//*[contains(@class,'ember-view FloatingLabel')]/input)[1]");
        PDPBuyBox.put("emailaddress_textbox", "(//*[contains(@class,'ember-view FloatingLabel')]/input)[2]");
        PDPBuyBox.put("companyname_textbox", "(//*[contains(@class,'ember-view FloatingLabel')]/input)[3]");
        PDPBuyBox.put("country_dropdown", "//*[@class='  ember-view Select form-field-select theme-text']/select");
        PDPBuyBox.put("manufacturename_textbox", "(//*[contains(@class,'ember-view FloatingLabel')]/input)[4]");
        PDPBuyBox.put("MPN_textbox", "(//*[contains(@class,'ember-view FloatingLabel')]/input)[5]");
        PDPBuyBox.put("Qty_textbox", "(//*[contains(@class,'ember-view FloatingLabel')]/input)[6]");
        PDPBuyBox.put("targetpricecurrency_textbox", "(//*[contains(@class,'ember-view FloatingLabel')]/input)[7]");
        PDPBuyBox.put("thankyou_text", "(//*[contains(@class,'theme-question js-questionTitle')])[2]");
        PDPBuyBox.put("thankyou2_text","(//*[contains(@class,'component-description theme-question')])[2]");
        PDPBuyBox.put("emailerror_text", "//*[@class='input-field-error']");
        PDPBuyBox.put("pdpBackOrder_text", "//*[@id='pdpMoreStockWraper']");
        PDPBuyBox.put("reReelCharges_text", "//*[@class='reReelCharges']");
        PDPBuyBox.put("bestSeller_element", "//*[@id='bestSellerTag']");
        
//       For Hazardous product
        PDPBuyBox.put("nCNR_text", "(//*[@class='availabilityDescription additionalDesc1 ncnrReturnMsg'])");
        PDPBuyBox.put("nCNRinfo_element", "//*[@class='pdpCutOffTimeWrap pdpAdvisoryMsg']//span[@class='pdpInfoIcon']");
        PDPBuyBox.put("nCNRinfotooltip_link", "//*[@id='NCNRReturnMsg']/div/a");
    }

    public String findLocator(String elementName) {
        if (PDPBuyBox.containsKey(elementName)) {
            return (PDPBuyBox.get(elementName.trim()));
        }

        return null;
    }
}
