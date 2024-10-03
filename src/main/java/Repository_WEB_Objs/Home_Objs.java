package Repository_WEB_Objs;

import java.util.*;

public class Home_Objs {

    // Creation of HashMap
    private static final Map<String, String> Home;

    static {
        Home = new HashMap<String, String>();

        // Menu bar elements
        Home.put("favorites_link", "//*[@id='ad_pf_megamenu_espot_05_defer']/a");
        Home.put("lhsSuperCategories_list", ".//*[@class='superCats subnav']/li/a");
        Home.put(
            "popularmanufacturer_label",
            "//*[@id='ad_pf_megamenu_espot_01_defer']/ul/li/h3"
        );
        Home.put(
            "resources_list",
            "//*[@id='ad_pf_megamenu_espot_02_defer']/ul/li/ul/li[@class='heading']"
        );
        Home.put(
            "element14_image",
            "//*[@id='ad_pf_megamenu_espot_03_defer']/ul/li[1]/a[1]/img"
        );

        // Super categories section
        Home.put("subCategory_element", "//*[@id='pf_homepage_espot_03']/div/div/div[2]");
        Home.put("subCategory_list", "//*[@id='mkt-supercat-btns']/div/ul/li");
        Home.put(
            "subCategoryAutomation_element",
            "//*[@id='mkt-supercat-btns']/div/ul/li"
        );
        Home.put("automationCategory_link", "//*[@id='mkt-automation-menu']/ul/li/h4/a");

        // service proposition section
        Home.put(
            "sameDayShipSection_element",
            "//*[@class='services-block ser-icon-1 small-margin']/p[1]"
        );
        Home.put(
            "sameDayShipProducts_element",
            "//*[@class='services-block ser-icon-1 small-margin']/p[2]"
        );
        Home.put(
            "unParalleledCustomerService_element",
            "//*[@class='services-block ser-icon-3 small-margin']/p[1]"
        );
        Home.put(
            "unParallelCustomerServiceSubtitle_element",
            "//*[@class='services-block ser-icon-3 small-margin']/p[2]"
        );
        Home.put(
            "serviceTitle_element",
            "//*[@class='services-block ser-icon-2 small-margin']/p[1]"
        );
        Home.put(
            "serviceSubtitle_element",
            "//*[@class='services-block ser-icon-2 small-margin']/p[2]"
        );
        Home.put(
            "marketLeadingTitle_element",
            "//*[@class='services-block ser-icon-4 small-margin']/p[1]"
        );
        Home.put(
            "marketLeadingSubtitle_element",
            "//*[@class='services-block ser-icon-4 small-margin']/p[2]"
        );

        // New products section
        Home.put("newProducts_label", "//*[@class='prod-mod-header new-prod-header']");
        Home.put(
            "newProductCaroselBack_button",
            "(//*[@class='product-carousel-btn-back'])[2]"
        );
        Home.put(
            "newProductsForwardCarosel_button",
            "(//*[@class='product-carousel-btn-forward'])[2]"
        );
        Home.put(
            "newProductsValues_list",
            "(//*[@class='panel panel-default product-carousel-dev2 small-margin'])[2]/ul/li//p[@class='pro-mod-man']"
        );

        // Great deal section
        Home.put("greatDeal_label", "//*[@class='prod-mod-header great-deal-header']");
        Home.put(
            "greatDealCaroselBack_button",
            "(//*[@class='product-carousel-btn-back'])[3]"
        );
        Home.put(
            "greatDealForwardCarosel_button",
            "(//*[@class='product-carousel-btn-forward'])[3]"
        );
        Home.put(
            "greatDealValues_list",
            //            "(//*[@class='panel panel-default product-carousel-dev2 small-margin'])[3]/ul/li//p"
            "//*[@id='pf_homepage_espot_04']/div/div[1]/div/div[3]//ul/li//p"
        );

        // featured products section
        Home.put(
            "featuredProduct_label",
            "//*[@class='prod-mod-header featured-prod-header']"
        );
        Home.put(
            "featuredProductCaroselBack_button",
            "(//*[@class='product-carousel-btn-back'])[3]"
        );
        Home.put(
            "featuredProductForwardCarosel_button",
            "(//*[@class='product-carousel-btn-forward'])[3]"
        );
        Home.put(
            "featuredProductValues_list",
            "(//*[@class='panel panel-default product-carousel-dev2 small-margin'])[4]/ul/li//p"
        );

        // Manufacturers section
        Home.put("manufactureHeader_label", "//*[@class='manu-header']");
        Home.put(
            "manufacturerList_image",
            "//*[@class='panel panel-default small-margin border-sm']/div[2]/div[contains(@class,'manf-logo')]/a"
        );
        Home.put(
            "customerSerive_label",
            "//*[@class='row small-margin-bottom']/div[1]/div/div"
        );
        Home.put(
            "quickLinks_label",
            "//*[@class='row small-margin-bottom']/div[2]/div/div"
        );
        Home.put("aboutUs_label", "//*[@class='row small-margin-bottom']/div[3]/div/div");
        Home.put("signUp_button", "//*[@class='row small-margin-bottom']/div[4]/div/p/a");
        Home.put("visa_image", "//*[@class='payment-card payment-card-visa']");
        Home.put(
            "masterCard_image",
            "//*[@class='payment-card payment-card-mastercard']"
        );
        Home.put("americanExpress_image", "//*[@class='payment-card payment-card-amex']");
        Home.put(
            "tradeAccount_image",
            "//*[contains(@class,'payment-card payment-card-trade-account')]"
        );
        Home.put("youtube_icon", "//*[@class='social-logos social-logos-youtube']");
        Home.put("facebook_icon", "//*[@class='social-logos social-logos-facebook']");
        Home.put("twitter_icon", "//*[@class='social-logos social-logos-twitter']");
        Home.put("linkedin_icon", "//*[@class='social-logos social-logos-linkedin']");
        Home.put("privacy_link", "//*[@class='footer-quick-links-small']/ul/li[1]/a");
        Home.put(
            "termsOfAccess_link",
            "//*[@class='footer-quick-links-small']/ul/li[2]/a"
        );
        Home.put(
            "legalCopyRight_link",
            "//*[@class='footer-quick-links-small']/ul/li[3]/a"
        );
        Home.put(
            "termsOfPurchase_link",
            "//*[@class='footer-quick-links-small']/ul/li[4]/a"
        );
        Home.put(
            "cookieSettings_link",
            "//*[@class='footer-quick-links-small']/ul/li[5]/a"
        );
        
        Home.put(
        		"sitemapEU_link",
        		"//*[@class='footer-quick-links-small']/ul/li[6]/a"
        		);
        Home.put(
        		"sitemapAPAC_link",
        		"//*[@class='footer-quick-links-small']/ul/li[4]/a"
        		);
        Home.put(
        		"sitemapNWK_link",
        		"//*[@class='footer-quick-links-small']/ul/li[5]/a"
        		);

        Home.put(
            "allBuyingtools_link",
            ".//*[contains(@data-dtm-eventinfo,'buying-tools')]"
        );
        Home.put(
            "allServices_link",
            "(.//*[@id='ad_pf_megamenu_espot_02_defer']//ul[1]/li[@class='viewAll']/a)[1]"
        );
        Home.put(
            "alltechnicalResources_link",
            ".//a[@data-dtm-eventinfo='technical-resources|Header Navigation']"
        );
        Home.put("help_link", ".//a[@data-dtm-eventinfo='help|Header Navigation']");
        //Home.put("viewAllProducts", ".//a[@data-dtm-eventinfo='All Products|Header Navigation']");
        Home.put("viewAllProducts", "//div[@id='ad_pf_megamenu_supercats_espot_02']/a[1]");
        Home.put(
            "community_link",
            "(//*[@id='ad_pf_megamenu_espot_03_defer']//ul/li/a)[1]"
        );

        //cpc elements
        Home.put("featuredAccess_link", "//*[@class='megaMenu']/ul/li[2]/div/div/a");
        Home.put(
            "powerTools_label",
            "//*[@class='col-xs-12 col-md-6 copy-box-wrap']/div/h1"
        );
        Home.put("cpcTools_link", "//*[@class='megaMenu']/ul/li[3]/div/div/a");
        Home.put("cpcTools_list", "//*[@class='megaMenu']/ul/li[3]/div/div/ul/li");
        Home.put("cpcQuickBuy_link", "//*[@class='megaMenu']/ul/li[3]/div/div/ul/li[1]");
        Home.put("cpcResource_link", "//*[@id='ad_pf_megamenu_espot_03']/a");
        Home.put("cpcResource_list", "//*[@class='subnav column3']/li/ul/li/a");
        //Home.put("deliveryInfo_link", "(//*[@class='marketing promo-head group']/following::a/h3)[1]");
        Home.put(
            "deliveryInfo_link",
            "(//*[@class='marketing promo-head group']/ul/li/a)[1]"
        );
        //Home.put("collectInStore_link", "(//*[@class='marketing promo-head group']/following::a/h3)[2]");
        Home.put(
            "collectInStore_link",
            "(//*[@class='marketing promo-head group']/ul/li/a)[2]"
        );
        Home.put(
            "FirstFeaturedAccess_link",
            "//*[@id='ad_pf_megamenu_espot_01']/ul/li/ul/li[1]/a"
        );
        Home.put(
            "FirstFeaturedAccess_text",
            "//*[@class='col-xs-12 col-md-6 copy-box-wrap']/div/h1"
        );
        Home.put("cpcSubCategory_list", "//*[@class='col-xs-1']/a");
        Home.put("cpcSubCategoryAudioVisual_link", "(//*[@class='col-xs-1']/a)[1]");
        Home.put(
            "cpcFreeUKDelivery_tab",
            "//*[@class='row home-service-tiles']/div[1]/a/h4"
        );
        Home.put(
            "cpcCollectDelivery_tab",
            "//*[@class='row home-service-tiles']/div[2]/a/h4"
        );
        Home.put(
            "cpcNeedSomehelp_tab",
            "//*[@class='row home-service-tiles']/div[3]/a/h4"
        );
        Home.put(
            "trade_tab",
            "//*[@class='container home-service-tiles']/div[1]/div[1]/a/h4"
        );
        Home.put(
            "quote_tab",
            "//*[@class='container home-service-tiles']/div[1]/div[2]/a/h4"
        );
        Home.put(
            "delivery_tab",
            "//*[@class='container home-service-tiles']/div[1]/div[3]/a/h4"
        );
        Home.put(
            "contact_tab",
            "//*[@class='container home-service-tiles']/div[2]/div[1]/a/h4"
        );
        Home.put(
            "counter_tab",
            "//*[@class='container home-service-tiles']/div[2]/div[2]/a/h4"
        );
        Home.put(
            "catalogue_tab",
            "//*[@class='container home-service-tiles']/div[2]/div[3]/a/h4"
        );
        Home.put(
            "publication_tab",
            "//*[@class='container home-service-tiles']/div[3]/div[1]/a/h4"
        );
        Home.put(
            "emails_tab",
            "//*[@class='container home-service-tiles']/div[3]/div[2]/a/h4"
        );
        Home.put(
            "manufacturers_tab",
            "//*[@class='container home-service-tiles']/div[3]/div[3]/a/h4"
        );
        Home.put(
            "cpcPrivacyStatement_link",
            "//*[@class='footer-quick-links-small']/ul/li[1]/a"
        );
        Home.put(
            "cpcTermsOfAccess_link",
            "//*[@class='footer-quick-links-small']/ul/li[2]/a"
        );
        Home.put(
            "cpcTermsOfPurchase_link",
            "//*[@class='footer-quick-links-small']/ul/li[3]/a"
        );
        Home.put(
            "cpcCookieSettings_link",
            "//*[@class='footer-quick-links-small']/ul/li[4]/a"
        );

        //china
        Home.put(
            "chinaLegalNotice_link",
            "//*[@class='footer-quick-links-small']/ul/li[2]/a"
        );
        Home.put(
            "chinaTermAndCondition_link",
            "//*[@class='footer-quick-links-small']/ul/li[3]/a"
        );
        Home.put("weChat_image", "//*[@class='payment-card-wechat']");
        Home.put("aliPay_image", "//*[@class='payment-card payment-card-alipay']");
        Home.put(
            "cardOnDelivery_image",
            "//*[@class='payment-card payment-card-on-delivery']"
        );
        Home.put(
            "cardbanktransfer_image",
            "//*[@class='payment-card payment-card-bank-transfer']"
        );
        Home.put(
        		"login_button",
        		"//*[@class='btn btnPrimary disAfterSub']"
        		);

        //china center
        Home.put("register_link", "//*[contains(@class,'registerLink col-sm-6')]/a");
        Home.put(
            "rightFixedMenuSectionlink_list",
            "//*[@class='right-fixed-menu mkt']/div/a"
        );
        Home.put("topSearches_tab", "//ul[@role='tablist']");
        Home.put(
            "topTradingSearchTermstab_list",
            "//div[@class='tab-pane active']//ol/li"
        );
        Home.put(
            "firstTopTradingSearchTerms_link",
            "//div[@class='tab-pane active']//ol/li[1]/a"
        );
        Home.put("topHotSearchProducts_tab", "//ul[@role='tablist']/li[2]/a");
        Home.put("topHotSearchProducts_list", "//div[@class='tab-pane active']//ol/li");
        Home.put(
            "secondTopHotSearchProducts_link",
            "//div[@class='tab-pane active']//ol/li[2]/a"
        );
        Home.put(
            "specialOffersFirstSection_element",
            "//*[@class='col-sm-12 so-section']/div/div[1]/p"
        );
        Home.put("specialOffersFirstSectionSeeMore_link", "//*[@class='so-page']");
        Home.put(
            "specialOffersFirstSection_list",
            "//*[contains(@class,'special-offer-tile')]/a/div[1]/h3"
        );
        Home.put(
            "firstSpecialOffer_link",
            "(//*[contains(@class,'special-offer-tile')]/a/div[1]/h3)[1]"
        );
        Home.put(
            "popularProductsSecondSection_element",
            "(//*[@class='h4 small-margin-top small-margin-bottom'])[1]"
        );
        Home.put(
            "popularProductsSecondSection_list",
            "//*[@class='row no-gutters-sm']/div/div/a/div[1]/h3"
        );
        Home.put(
            "secondpopularProduct_link",
            "(//*[@class='row no-gutters-sm']/div/div/a/div[1]/h3)[2]"
        );
        Home.put(
            "manufacturersThirdSection_element",
            "//*[@class='row smaller-margin-bottom no-gutters-sm']//p"
        );
        Home.put(
            "manufacturersThirdSection_list",
            "//*[@class='row large-margin-bottom']/div/a"
        );
        Home.put(
            "firstManufacturer_link",
            "(//*[@class='row large-margin-bottom']/div/a)[1]"
        );
        Home.put(
            "exclusiveBrandForthSection_element",
            "//*[@class='col-sm-12 exclusive-brands-hp']"
        );
        Home.put(
            "exclusiveBrandUnderstandMore_link",
            "//*[@class='col-sm-12 exclusive-brands-hp']//a"
        );
        Home.put(
            "superCategoriesFifthSection_element",
            "//*[@class='row row-eq-height']"
        );
        Home.put(
            "superCategoriesRightSection_list",
            "//*[@class='row hp-level1s no-gutters-sm']/div/a"
        );
        Home.put(
            "superCategoriesLeftsideHeading_text",
            "//*[@class='row row-eq-height']/div/h4"
        );
        Home.put(
            "cableAndConnecterRightsectionHeading_element",
            "(//*[@class='row bg-blue-light blue-bar']/div/h4)[1]"
        );
        Home.put(
            "cableAndConnecterSuperCategorieSection_list",
            "(//*[@class='row hp-level1s no-gutters-sm'])[1]/div/a/h4"
        );
        Home.put(
            "firstcableAndConnecterSection_link",
            "((//*[@class='row hp-level1s no-gutters-sm'])[1]/div/a/h4)[1]"
        );
        Home.put(
            "semiconductorsSectionHeading_element",
            "(//*[@class='row bg-blue-light blue-bar']/div/h4)[2]"
        );
        Home.put(
            "semiconductorsSection__list",
            "(//*[@class='row hp-level1s no-gutters-sm'])[2]/div/a/h4"
        );
        Home.put(
            "firstSemiconductorsSection_link",
            "((//*[@class='row hp-level1s no-gutters-sm'])[2]/div/a/h4)[1]"
        );
        Home.put(
            "passivesSectionHeading_element",
            "(//*[@class='row bg-blue-light blue-bar']/div/h4)[3]"
        );
        Home.put(
            "passivesSection__list",
            "(//*[@class='row hp-level1s no-gutters-sm'])[3]/div/a/h4"
        );
        Home.put(
            "firstPassivesSection_link",
            "((//*[@class='row hp-level1s no-gutters-sm'])[3]/div/a/h4)[1]"
        );
        Home.put(
            "devBoardsSectionHeading_element",
            "(//*[@class='row bg-blue-light blue-bar']/div/h4)[4]"
        );
        Home.put(
            "devBoardsSection__list",
            "(//*[@class='row hp-level1s no-gutters-sm'])[4]/div/a/h4"
        );
        Home.put(
            "thirdDevBoardSection_link",
            "((//*[@class='row hp-level1s no-gutters-sm'])[4]/div/a/h4)[3]"
        );
        Home.put(
            "optoelectronicsSectionHeading_element",
            "(//*[@class='row bg-blue-light blue-bar']/div/h4)[5]"
        );
        Home.put(
            "optoelectronicsSection__list",
            "(//*[@class='row hp-level1s no-gutters-sm'])[5]/div/a/h4"
        );
        Home.put(
            "firstOptoelectronicsSection_link",
            "((//*[@class='row hp-level1s no-gutters-sm'])[5]/div/a/h4)[1]"
        );
        Home.put(
            "electronicsSectionHeading_element",
            "(//*[@class='row bg-blue-light blue-bar']/div/h4)[6]"
        );
        Home.put(
            "electronicsSection__list",
            "(//*[@class='row hp-level1s no-gutters-sm'])[6]/div/a/h4"
        );
        Home.put(
            "firstElectronicsSection_link",
            "((//*[@class='row hp-level1s no-gutters-sm'])[6]/div/a/h4)[1]"
        );
        Home.put(
            "powerandCircuitsSectionHeading_element",
            "(//*[@class='row bg-blue-light blue-bar']/div/h4)[7]"
        );
        Home.put(
            "powerandCircuitsSection__list",
            "(//*[@class='row hp-level1s no-gutters-sm'])[7]/div/a/h4"
        );
        Home.put(
            "firstPowerandCircuitsSection_link",
            "((//*[@class='row hp-level1s no-gutters-sm'])[7]/div/a/h4)[1]"
        );
        Home.put(
            "test&MeasurementSectionHeading_element",
            "(//*[@class='row bg-blue-light blue-bar']/div/h4)[8]"
        );
        Home.put(
            "test&MeasurementSection__list",
            "(//*[@class='row hp-level1s no-gutters-sm'])[8]/div/a/h4"
        );
        Home.put(
            "firstTest&MeasurementSection_link",
            "((//*[@class='row hp-level1s no-gutters-sm'])[8]/div/a/h4)[1]"
        );
        Home.put(
            "toolsSectionHeading_element",
            "(//*[@class='row bg-blue-light blue-bar']/div/h4)[9]"
        );
        Home.put(
            "toolsSectionHeading__list",
            "(//*[@class='row hp-level1s no-gutters-sm'])[9]/div/a/h4"
        );
        Home.put(
            "firstToolsSection_link",
            "((//*[@class='row hp-level1s no-gutters-sm'])[9]/div/a/h4)[1]"
        );
        Home.put(
            "featuredProductsSection_element",
            "//*[@class='col-sm-12 mk-featuredProds']"
        );
        Home.put("featuredProductsPrevButton_link", "//*[@class='mk-button-prev']");
        Home.put("featuredProductsNextButton_link", "//*[@class='mk-button-next']");
        Home.put("GeolocationNo_button", "//*[@id='enhanceGeoCancelButton']");
        Home.put("footer_section", "//*[@id='footer']");
    }

    public String findLocator(String elementName) {
        if (Home.containsKey(elementName)) {
            return (Home.get(elementName.trim()));
        }

        return null;
    }
}
