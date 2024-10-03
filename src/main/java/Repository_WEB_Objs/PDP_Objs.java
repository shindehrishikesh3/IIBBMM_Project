package Repository_WEB_Objs;

import java.util.*;

public class PDP_Objs {

    // Creation of HashMap
    private static final Map<String, String> PDP;

    static {
        PDP = new HashMap<String, String>();

        //Top Section of Product with image and description
        PDP.put("productTitle_text", ".//*[@class='pdpEnhanceTitle']/h1");
        PDP.put("productSubtitle_text", ".//*[@class='pdpEnhanceTitle']/h2");
        PDP.put("manufDescription_text", "//*[@class='pdpDesc']/p");
        PDP.put("manuf_text", "(//*[@class='proDescAndReview']//a/span[1])[1]");
        PDP.put("manufPartNo_text", "//*[@class='ManufacturerPartNumber']/span");
        PDP.put(
            "descriptionTable_list",
            "//*[contains(@class,'productDescription')]//dt"
        );
        PDP.put(
            "detailsTableValues_list",
            "//*[contains(@class,'productDescription')]//dd"
        );
        PDP.put("comaparePageTitle_text", "//*[@class = 'comparePage']//h1");
        PDP.put(
            "manufacturerLogo_image",
            "//div[@class='brandLogo']//img[@id='supplier_logo']"
        );
        PDP.put("manufacturerPageTitle_text", "//*[@id='manuFacturer']");
        PDP.put(
            "addToCompare_link",
            "//a[@class='addToCompareMiddle addCompareForPDP omTagEvt']"
        );
        PDP.put("productVideo_icon", ".//*[@class='pfIcon pfLargeVideo']");
        PDP.put("productVideoContainer_element", ".//*[contains(@class,'showVideo')]");
        PDP.put("productGallery_image", "//div[@class='mediaThumbsScroller']//img");
        PDP.put("productMain_image", "//img[@id='productMainImage']");
        PDP.put("product360image_icon", "//div[@class='thumb thumb360 omTagEvt']");
        PDP.put("product360ImageContainer_element", "//*[@class='360ImageContainer']");
        PDP.put(
            "product360ImageContainerCanvas_element",
            "//*[@class='360ImageContainer']//canvas"
        );

        // Product information section
        PDP.put("productInfoSection_text", ".//*[@id='pdpSection_pdpProdDetails']");
        PDP.put("attributes_checkbox", ".//*[@class='descAttributeCheckbox']");
        PDP.put("findSimilarProducts_button", "//*[@id='filterToolButton']");
        PDP.put("firstProperty_checkbox", "(//input[@type='checkbox'])[3]");

        // Technical documents section
        PDP.put("technicalDocument_text", ".//*[@id='techDocsHook']//h2");
        PDP.put("techicalDocuments_list", "//*[@id='technicalData']/li");
        PDP.put("techDocsCountInHeader_text", "//*[@id='techDocsHook']/div/h2/span");

        // Alternatives section
        PDP.put("alternatives_text", ".//*[@id='ProductSubstitutes']");
        PDP.put("alternativesTable_list", "//*[@id='prodSubstitutes']/div[1]//div[@class='pad']");
        PDP.put(
            "alternativeProducts_list",
            "//*[@id='prodSubstitutes']/div[@class='row ']"
        );
        PDP.put(
            "manufacturerPartNo_link",
            "//*[@id='prodSubstitutes']//*[@class='image cell']//a[@class='skulink mfrnum']"
        );
        PDP.put(
            "manufacturerPartNo_image",
            "//*[@id='prodSubstitutes']//*[@class='image cell']//img[@class='prodThumb']"
        );
        PDP.put("suggestedAlternatives_link", ".//a[@class='alternativeType']");
        PDP.put(
            "ordercode_link",
            "//*[@id='prodSubstitutes']//*[@class='wide cell']//a[@class='skulink']"
        );
        PDP.put(
            "manuDescription_link",
            "//*[@id='prodSubstitutes']//*[@class='manu cell']//a[@class='skulink']"
        );
        PDP.put(
            "manuName_link",
            "//*[@id='prodSubstitutes']//*[@class='manu cell']//a[@class='skulink']/p[1]"
        );
        PDP.put(
            "availabilityFirstProduct_text",
            ".//*[@id='prodSubstitutes']//div[@class='cell']//span[@class='stock']"
        );
        PDP.put(
            "firstAddInAltSection_button",
            "(//*[@id='prodSubstitutes']//span[not(contains(@class,'displayNone'))]//a[contains(@class,'ajaxAddToCart')])[1]"
        );

        // Associated Products section
        PDP.put("associatedProducts_text", ".//*[@id='ProductAccessories']");
        PDP.put("associatedProductsTable_list", "//*[@id='prodAccessories']/div[1]/div");
        PDP.put(
            "manufacturerPartNoAssociatedProd_link",
            "//*[@id='prodAccessories']//*[@class='image cell']//a[@class='skulink mfrnum']"
        );
        PDP.put(
            "manufacturerPartNoAssociatedProd_image",
            "//*[@id='prodAccessories']//*[@class='image cell']//img[@class='prodThumb']"
        );
        PDP.put(
            "ordercodeAssociatedProd_link",
            "//*[@id='prodAccessories']//*[@class='wide cell']//a[@class='skulink']"
        );
        PDP.put(
            "manuDescriptionAssociatedProd_link",
            "//*[@id='prodAccessories']//*[@class='manu cell']//a[@class='skulink']"
        );
        PDP.put(
            "availabilityFirstProdAssociatedProd_text",
            "//*[@id='prodAccessories']//div[@class='cell']//span[@class='stock']"
        );
        PDP.put(
            "firstAddInAssociatedProdSection_button",
            "(//*[@id='prodAccessories']//span[not(contains(@class,'displayNone'))]//a[contains(@class,'ajaxAddToCart')])[1]"
        );

        //Related cateogies section
        PDP.put(
            "relatedCategories_text",
            ".//*[@id='pdpSection_PF_RelatedCategories']//h2"
        );
        PDP.put("firstRelatedCategory_link", ".//*[@class='rel-category']/a");
        PDP.put("firstRelatedCategory_image", ".//*[@class='rel-category-img']/img");

        // Product overview section
        PDP.put("productOverview_text", ".//*[@id='pdpSection_FAndB']//h2");
        PDP.put(
            "productOverviewBody_text",
            ".//*[@id='pdpSection_FAndB']//div[@class='collapsable-content']"
        );

        //Delivery & services section - NA for APAC
        PDP.put("deliveryServices_text", ".//*[@id='delivery-info-test']//h2");

        // Legislation and Environmental section
        PDP.put(
            "legislationEnvironmental_text",
            ".//*[@id='pdpSection_ProductLegislation']/div[1]/h2"
        );
        PDP.put(
            "legislationEnvironmentalTableLabels_element",
            "//*[@class='details-table-desktop']//tr/th"
        );
        PDP.put(
            "legEnvTablefirstRowvalue_text",
            "//*[@class='details-table-desktop']//tr[1]/td"
        );

        // Customer review section
        PDP.put(
            "customerReview_text",
            ".//*[@id='pdpSection_PF_PDP_Prod_Review_ID']/div[1]/h2"
        );

        // Customer review section
        PDP.put(
            "customerQAExchange_text",
            ".//*[@id='pdpSection_PF_PDP_Prod_QAndA_ID']/div[1]/h2"
        );

        // Customer review section
        PDP.put("community_text", ".//*[@id='pdpSection_PF_PDP_Community']/div[1]/h2");

        // Avnet container section
        PDP.put("avnetPricingContainer_element", ".//*[@class='avnetDropShipContainer']");
        PDP.put("additionalAvnetStock_text", ".//*[@class='avnetDropShipContainer']//h3");
        PDP.put("avnetlogo_icon", ".//*[@class='imgLogo']");
        PDP.put("avnetTableHeader_list", "//table[@class='avnetTable']/thead/tr/th");
        PDP.put("avnetView_link", "//*[@class='viewAvnetLink']/a");
        PDP.put("avnetTooltip_icon", "//*[@id='avnetHeaderTooltipId']");
        PDP.put(
            "avnetTooltip_text",
            "//*[@class='dijitTooltipContainer dijitTooltipContents']//*[@class='bodyarea avnetTooltipContent']"
        );

        //Favourites section
        PDP.put("addToFavourites_link", "//div[@class='addToFavourites']");
        PDP.put("addFavouriteFrame_frame", ".//iframe[@class='popIframe bom-RAQIframe']");

        //Avnet Container on PDP
        PDP.put("avnetBox_element", "(//*[@id='avnetAvailabilityTooltipId'])[2]");
      
        //Filter Tool Popup
        PDP.put("filterPopup_element","(//*[@id='popup'])");
        
      //breadcrumbs
        PDP.put("breadcrumbs_link", "//*[@data-om='Breadcrumb Click']");
        
        //AddtoOrder
        PDP.put("addtoOrder_link", "//*[@id='addToOrder']/a");
        
     // Packaging elements
        PDP.put("cutTape_radio", ".//input[contains(@id,'cutTapepackageOpt')]");
        PDP.put("reReel_radio", ".//input[contains(@id,'rereelpackageOpt')]");
        PDP.put("reReel_text", ".//label[contains(@for,'rereelpackageOpt')]");
        PDP.put("quantity_textbox", ".//div[@id='addToOrder']//input[contains(@id,'quantity') and @type='text']");        
        PDP.put("addToCart_button", "//a[contains(@class,'ajaxAddToCart')]/span[1]");
        PDP.put("imageCaption_text", "//p[@class='imageCaption']");
        PDP.put("minOrderQty_text", ".//div[@class='multqty']/span[2]/strong");
        PDP.put("availability_text", "//span[@class='availTxtMsg']");
        PDP.put("popularSearchHeadingOfProduct_text", "//*[@class='popularSearch leftAlign']/h2");
        PDP.put("popularSearchOfProduct_text", "//*[@class='popularSearch leftAlign']/p");
        PDP.put("popularSearchOfProduct_links", "//*[@class='popularSearch leftAlign']/p/a");

    }

    public String findLocator(String elementName) {
        if (PDP.containsKey(elementName)) {
            return (PDP.get(elementName.trim()));
        }

        return null;
    }
}
