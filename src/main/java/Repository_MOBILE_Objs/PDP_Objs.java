package Repository_MOBILE_Objs;

import java.util.*;

public class PDP_Objs {

    // Creation of HashMap
    private static final Map<String, String> PDP;

    static {
        PDP = new HashMap<String, String>();

        PDP.put("addToCart_button", "//*[contains(@class,'ajaxAddToCart')]");

        // Product Details
        PDP.put("productHeading_text", "//h1[@class='productHeading']");
        PDP.put("productCatName_text", "//span[@class='pdpBlackText']");
        PDP.put("productAttributes_text", "//span[@class='pdpGreyText']");

        // all sections
        PDP.put("imagesSection_element", "//section[@id='productImages']");
        PDP.put("priceSection_element", "//section[@id='price-section']");
        PDP.put("productInfoSection_element", "//section[@id='pinfo-section']");
        PDP.put("productOverviewSection_element", "//section[@id='pdpSection_FAndB']");
        PDP.put(
            "legislationAndEnvSection_element",
            "//*[@id='legislationEnvironmental']"
        );
        PDP.put("technicalDocSection_element", "//*[@id='technicalDocsSection']");

        // Images Section
        PDP.put("imageSection_text", "//section[@id='productImages']//h3");
        PDP.put("imageSectionExpanded_section", "//*[@class='product-images collapsable-outlined open']");
        PDP.put("productImage_image", "//*[@id='mainImageArea']");
        PDP.put("thumbnailImageSection_element", "//*[contains(@class, 'altImages')]");
        PDP.put("underImagetext_text", "//*[@class='text-muted']");
        PDP.put("videoImage_image", "//*[contains(@class, 'pfIcon pfLargeVideo')]");
        PDP.put("thumbnaiImage2_image", "//*[contains(@id, '1_2')]");

        // Price section
        PDP.put("priceSection_text", "//section[@id='price-section']//h3");
        PDP.put("priceTableAttribute_text", "//div[@id='price-content']/table[1]//th");
        PDP.put("priceFor_text", "//*[@id='price-content']//td[3]");
        PDP.put(
            "price_text",
            "//*[@class='price']"
        );
        PDP.put("partNoToolTip_element", "//*[@id='pdpPartNoTooltip']");
        PDP.put("lineNoteToolTip_element", "//*[@id='pdpLineNoteTooltip']");
        PDP.put("yourPartNo_link", "//*[@class='lineCollapsableTrigger']");
        PDP.put("yourPartNo_text", "//*[@for='custPartNum']");
        PDP.put("yourPartNo_textbox", "//*[@name='custPartNum']");
        PDP.put("lineNote_textbox", "//*[@name='comment']");
        PDP.put("lineNote_text", "//*[@for='lineNote']");
        PDP.put("quantity_text", "//*[contains(@class,'quantity-label')]");
        PDP.put("quantity_textbox", "//*[@type='number']");
        PDP.put(
            "addToCart_button",
            "//*[@class='ajaxAddToCart btn btn-primary btn-block']"
        );
        PDP.put("addToCartPopup_text", "//*[@id='added-to-basket-label']");
        PDP.put("continueShopping_button", "//*[text()='Continue Shopping']");
        PDP.put("price_list", "//table[@class='table price-group']");

        // Product Info Section
        PDP.put("productInfoSection_text", "//section[@id='pinfo-section']//h3");
        PDP.put("manufacturerLogo_link", "//*[@id='supplier_logo']");
        PDP.put(
            "orderCode_text",
            "//*[contains(@id, 'pinfo-content')]//table//tr[4]//td"
        );
        PDP.put("technicalDataSheet_text", "//*[@id='descTechnicalDatasheet']");
        PDP.put("viewAllTechDoc_link", "//*[@id='descTechnicalDatasheet']/following-sibling::td/p[1]/a");
        PDP.put("prodInfo_table", "//*[@id='pinfo-content']//tbody//tr");
        PDP.put(
            "manufacturerName_link",
            "//div[@id='pinfo-content']/table[1]/tbody/tr[2]/td/a"
        );
        PDP.put(
            "manufacturerName_text",
            "//div[@id='pinfo-content']/table[1]/tbody/tr[2]/th"
        );
        PDP.put("manufacturerPartNumber_label", "//*[@class='attrRestraint']");
        PDP.put("manufacturerPartNumber_value", "//*[@id='pinfo-content']//tr[1]/td");

        // Product Overview Section
        PDP.put(
            "productOverviewSection_text",
            "//section[@id='pdpSection_FAndB']/div[@class='heading collapsable-trigger']//h3"
        );
        PDP.put("viewAll_text", "//*[@id='viewAllCatPLPUrl']");
        PDP.put("prodOverview_text", "//*[@class='contents']");
        PDP.put("viewAllCategory_link", "//*[@id='viewAllCatPLPUrl']/a");

        // Technical Documents
        PDP.put("technicalDocSection_element", "//*[@id='technicalDocsSection']");
        PDP.put("technicalDocSection_text", "//*[@id='technicalDocsSection']//h3");
        PDP.put(
            "techDocsCountInHeader_text",
            "//*[@id='technicalDocsSection']/div[1]/h3/span"
        );
        PDP.put("techDocSheetList_list", "//*[@class='techDataSheetList']");
        PDP.put("techDocCadInfoDoc_list", "//div[@id='cadInformation']/ul");

        // Legislation and Environmental
        PDP.put(
            "legislationAndEnvSection_text",
            "//*[contains(@id, 'legislationEnvironmental')]//h3"
        );
        PDP.put("prodComplianceCert_link", "//*[@class='certificateRohs']");
        PDP.put("pDFCert_link", "//*[@id='pdfRoHSCertificateForm']");
        PDP.put("hTMLCert_link", "//*[@id='htmlRoHSCertificateForm']/a");
        PDP.put(
            "closeProdCompCert_button",
            "//*[@class='modal-footer']/button[text()='Close']"
        );
        PDP.put("legalContent_table", "//*[contains(@id,'legal-content')]//th");
        PDP.put("roHSCompliantIcon_element", "//*[contains(@class,'pfRohsCompliance')]");
        PDP.put("roHSToolTip_text", "//*[contains(@class,'rohs_tooltip')]");
        PDP.put(
            "roHSToolTipIcon1_element",
            "//*[contains(@id,'rohsCode_tooltip_1')]//span"
        );
        PDP.put(
            "roHSToolTipIcon_description",
            "//*[@class='rohsCode_tooltip_Description svhcDescription showTooltip']"
        );
        PDP.put("roHS_table", "//*[@class='rohsTable']");
        PDP.put("roHSDate_text", "//*[@class='rohsTable']/tbody/tr[5]/td[2]/strong");
        PDP.put("roHSOrderCode_text", "//*[@class='rohsTable']/tbody/tr[1]/td[2]/strong");
        PDP.put("roHS_customerName", "//*[@id=\"article\"]/table[3]/tbody/tr[6]/td[2]/strong");
        PDP.put("checkout_button", "(//*[@class='modal-footer'])[1]/a");
        PDP.put("rohsCompliant_link", "(//*[@class='pdpRohsCompliantLinkText'])[1]");

        // Alternatives section
        PDP.put("alternatives_text", ".//*[@id='ProductSubstitutes']");
        PDP.put("alternativesTable_list", "//*[@id='prodSubstitutes']/div[1]/div");
        PDP.put(
            "alternativeProducts_list",
            "//*[@id='prodSubstitutes']/div[@class='row ']"
        );
        PDP.put(
            "manufacturerPartNo_link",
            "//*[@id='prodSubstitutes']//*[@class='image cell']//a[@class='skulink mfrnum']"
        );
        PDP.put("mnp_text", "//*[@id='pinfo-section']//table/tbody/tr[1]/td");
        PDP.put("mfgName_text", "//*[@id='pinfo-section']//table/tbody/tr[2]/td/a");
        PDP.put("popularSearchHeadingOfProduct_text", "//*[@class='popularSearch']/h3");
        PDP.put("popularSearchOfProduct_text", "//*[@class='popularSearch']/p");
        PDP.put("popularSearchOfProduct_links", "//*[@class='popularSearch']/p/a");
    }

    public String findLocator(String elementName) {
        if (PDP.containsKey(elementName)) {
            return (PDP.get(elementName.trim()));
        }

        return null;
    }
}
