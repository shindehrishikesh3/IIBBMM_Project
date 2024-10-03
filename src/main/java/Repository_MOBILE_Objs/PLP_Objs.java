package Repository_MOBILE_Objs;

import java.util.*;

public class PLP_Objs {

    // Creation of HashMap
    private static final Map<String, String> PLP;

    static {
        PLP = new HashMap<String, String>();
        PLP.put(
            "firstOrderCode_text",
            "(//*[@id='product-list']//*[@class='col-xs-4']/span[2])[1]"
        );
        PLP.put("firstAdd_button", "(//*[contains(@class,'ajaxAddToCart')])[1]");
        PLP.put("PLP_element", "//*[@id='product-list']");
        PLP.put("breadcrumb_link", "//*[@id='page-container']/a");
        PLP.put("titleProductCount_value", "//*[@id='titleProdCount']");
        PLP.put("category_text", "//*[@class='productName']");
        PLP.put(
            "firstPurchasableOrderCode_text",
            "(//*[@class='inStockBold'])[1]/ancestor::li/div/div/div/div[2]/div/div[2]/span[2]"
        );

        PLP.put("sortby_dropdown", "//*[@id='sort-by']/select");
        PLP.put("firstPagination_text", "//*[@id='filterCol']/div[2]/div[1]/div/p");
        PLP.put("secondPagination_text", "//*[@id='filterCol']/div[2]/div[2]/div/p");
        PLP.put(
            "pageNavigation_element",
            "//*[@id='filterCol']/div[2]/div[2]/div/nav/ul"
        );
        PLP.put("searchWithin_button", "//*[@id='searchWithin']");
        PLP.put("category_text", "//*[@class='productName']");
        PLP.put("titleProductCount_value", "//*[@id='titleProdCount']");
        PLP.put(
            "firstPdt_element",
            "(//*[@class='listed-product outlined-section']//div)[1]"
        );
        // pdt details
        PLP.put("firstPdtDetails_element", "(//*[@class='main-details row'])[1]");
        PLP.put(
            "firstOrderCode_text",
            "(//*[@id='product-list']//*[@class='col-xs-4']/span[2])[1]"
        );
        PLP.put(
            "firstManufacturerPartNo_link",
            "//*[@id='product-list']/li[1]/div/div[1]/div[1]/div[2]/div/div[1]/a/span"
        );
        PLP.put(
            "firstProdDetails_text",
            "//*[@id='product-list']/li[1]/div/div[1]/div[2]/div/h2"
        );
        PLP.put(
            "firstProdImage_link",
            "//*[@id='product-list']/li[1]/div/div[1]/div[1]/div[1]/div/img"
        );
        PLP.put(
            "firstavailAndPrice_element",
            "(//*[@class='main-attributes row section'])[1]"
        );
        PLP.put("firstPdtStock_element", "(//div[contains(@id,'vn_avail')])[1]");
        PLP.put(
            "firstProdStock_text",
            "(//*[contains(@id,'vn_avail')])[1]/p/span[2]/span/span"
        );
        PLP.put(
            "firstProdFullAvailability_link",
            "//*[@id='full_availability_Collapsable_0']/p"
        );
        PLP.put(
            "firstProdFullAvailability_text",
            "//*[@id='full_availability_Collapsable_0']/div/div"
        );
        // pricing
        PLP.put("firstPdtPrice_element", "(//div[@id='priceList_0'])[1]");
        PLP.put(
            "firstProdMorePricing_link",
            "//*[@id='priceList_0']//span[@class='morePricingSearch']"
        );
        PLP.put(
        		"prodMorePricing_link",
        		"//span[@class='morePricingSearch']"
        		);
        PLP.put(
            "firstProdPricelist_text",
            "//*[@id='product-list']/li[1]/div/div[2]/div[2]"
        );
        // extended attributes
        PLP.put(
            "firstProdExtAttr_section",
            "(//div[@class='extended-attributes row section'])[1]"
        );
        PLP.put("firstProdExtendedAttr_link", "//*[@id='Collapsable_0']");
        PLP.put("firstProdExtendedAttr_text", "//*[@id='Collapsable_0']/div/table/tbody");
        // RoHS
        PLP.put(
            "firstROHSlogo_link",
            "//*[@id='Collapsable_0']/div/table/tbody/tr[9]/td[2]/span/a/div"
        );
        PLP.put(
            "roHSCertificatePopup_text",
            "//*[@id='RoHSCertificatePopup']/div/div/div[2]"
        );
        // Qnty and add to cart
        PLP.put(
            "firstProdQty_text",
            "(//*[contains(@id,'vn_qty')])[1]/form/span[1]/div/label"
        );
        PLP.put("firstProdQty_textbox", "(//*[contains(@id,'pkQuantity')])[1]");
        PLP.put(
            "firstProdAdd_button",
            "(//*[contains(@id,'vn_qty')])[1]/form/span[1]/span/div[2]"
        );

        PLP.put("PLPTable_list", "//*[@id='product-list']/li");
        PLP.put("sortByOptions_list", "//*[@class='form-control ']//option");
        PLP.put(
            "firstProdExpagination_texttendedAttr_link",
            "//*[@id='Collapsable_0']/p"
        );
        PLP.put(
            "navLastPage_button",
            "//li[@class='paginNext pageLink']/preceding-sibling::li[1]/a"
        );
        PLP.put("notAvailable_text", "(//*[contains(@id,'avail')])[1]/p[2]");
        PLP.put(
            "navFirstPage_button",
            "//li[@class='paginPrevArrow']/following-sibling::li[1]/a"
        );
        PLP.put("productlist_element", "//*[@id='product-list']/li");
        PLP.put("availabilityType_text", "//p[@class='relaxed-text redTextNLS ']");
        PLP.put(
            "descriptionPage_link",
            "//p[@class='relaxed-text redTextNLS ']/parent::div/parent::div/parent::div/preceding-sibling::div//a"
        );
        
        PLP.put("header_text", "//*[@class='products-showing']");
        PLP.put("body_element", "//*[@id='page-container']");
    }

    public String findLocator(String elementName) {
        if (PLP.containsKey(elementName)) {
            return (PLP.get(elementName.trim()));
        }

        return null;
    }
}
