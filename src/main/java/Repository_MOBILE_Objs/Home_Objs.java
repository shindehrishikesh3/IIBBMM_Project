package Repository_MOBILE_Objs;

import java.util.HashMap;
import java.util.Map;

public class Home_Objs {

    // Creation of HashMap
    private static final Map<String, String> Home;

    static {
        Home = new HashMap<String, String>();

        Home.put("username_text", "//*[@class='userFirstNameLoggedInn']");
        Home.put(
            "navigationToggleBar_button",
            "//button[@class='navbar-toggle collapsed']//span[2]"
        );
        Home.put("myAccount_link", "//*[@class='loggedInUserClass']/a[1]");
        Home.put(
            "category1_list",
            "//*[@class='categories-container level-1-category-selected']"
        );
        Home.put("backArrow_link", "(//*[@class='btn btn-default backLeftArrow'])[1]");
        Home.put("navToggle_button", "//button[@class='navbar-toggle collapsed']");
        Home.put("truck_image", "//*[@id='body_1']");
        Home.put("title_element", "(//*[@class='service-title'])[1]");
        Home.put("subtitle_element", "//*[@class='service-subtitle']");

        Home.put("espot_element", "//*[@id='mk-lb-outer-wrap']/a/div");
        Home.put("categorySection_element", "//*[@id='mkt-supercat-btns']");
        Home.put("subcategory_list", "//*[@id='mkt-supercat-btns']/div/ul/li");
        Home.put("category_link", "//*[@id='mkt-supercat-btns']/div/ul/li[1]/a/p");
        Home.put("allCategory_link", "//*[@id='mkt-supercat-btns']//li/a");
        Home.put("allSubCategory_element", "//*[@class='prod-cat-content']");
        Home.put("allSubCategory_link", "//*[@class='prod-cat-content']//li/a");
        Home.put("sticky_element", "//*[@class='prod-cat-content']");
        Home.put("stickyclose_element", "(//*[@class='supercat-close'])[1]");
        Home.put("viewAll_link", "(//*[@class='prod-cat-viewall'])[1]");
        Home.put("paneltitle_element", "//*[@class='panel-title']");
        Home.put(
            "quicklaunch_list",
            "//*[@id='pf_homepage_espot_01']/div[1]/div[2]/div[3]/div/div"
        );
        Home.put(
            "ecommbanner_list",
            "//*[@id='pf_homepage_espot_01']/div[1]/div[2]/div[4]/div/div"
        );

        Home.put("newProducts_label", "//*[@class='prod-mod-header new-prod-header']");
        Home.put("newProductviewAll_link", "(//*[@class='prod-mod-browse'])[1]");
        Home.put(
            "newProducts_list",
            "(//*[@class='panel panel-default product-carousel-dev2 small-margin'])[1]/ul/li"
        );
        Home.put("greatDeals_label", "//*[@class='prod-mod-header great-deal-header']");
        Home.put("greatDealsviewAll_link", "(//*[@class='prod-mod-browse'])[2]");
        Home.put(
            "greatDeals_list",
            "(//*[@class='panel panel-default product-carousel-dev2 small-margin'])[2]/ul/li"
        );
        Home.put(
            "featuredproducts_label",
            "//*[@class='prod-mod-header featured-prod-header']"
        );
        Home.put(
            "featured_list",
            "(//*[@class='panel panel-default product-carousel-dev2 small-margin'])[3]/ul/li"
        );
        Home.put("manufacture_label", "//*[@class='manu-header']");
        Home.put("manufacturevieAll_link", "//*[@class='manu-index']");
        Home.put(
            "manufacturerList_image",
            "//*[@class='panel panel-default small-margin border-sm']/div[2]/div[contains(@class,'manf-logo')]/a"
        );

        Home.put("services_list", "//*[@class='mb-fstack']/a/li");
        Home.put("faceBook_icon", "//*[@class='mb-img'][1]");
        Home.put("twitter_icon", "//*[@class='mb-img'][2]");
        Home.put("copyright_element", "//*[@class='mb-copyright']");

        Home.put("desktopSite_link", "//*[@id='RequestBrowserView_0']");
        Home.put(
            "termsOfpurchase_link",
            "//*[@data-om='Footer: Sub Navigation - Terms of Purchase']"
        ); //EU
        Home.put(
            "termsOfAccess_link",
            "//*[@data-om='Footer: Sub Navigation - Terms of Access']"
        ); //EU
        Home.put(
            "cookieeSetting_link",
            "//*[@data-om='Footer: Sub Navigation - Cookies']"
        ); //EU
        Home.put("services_link", "//*[@data-om='Footer: Services']");
        Home.put("technicalRes_link", "//*[@data-om='Footer: Technologies']");
        Home.put("help_link", "//*[@data-om='Footer: Help']");
        Home.put(
            "termsOfuse_link",
            "//*[@id='ad_pf_footer_espot_01']/div/div/ul[2]/li[3]//a"
        );
        Home.put(
            "termsconditions_link",
            "//*[@id='ad_pf_footer_espot_01']/div/div/ul[2]/li[5]/span/a"
        );
        Home.put("resources_link", "//div[contains(@id,'pf_megamenu')]/a");
        Home.put(
            "calculators_link",
            "//div[@class='content-subnav-template category level-2-category panel panel-primary']//li[1]"
        );
        Home.put("logo_link", ".//*[@id='ad_storeLogoESpot']//a");

        Home.put("geoLocationbanner_element", "//*[@id='enhanceGeoLocationContainer']");
        Home.put("geoLocationYes_button", "//*[@id='enhanceGeoContinueButton']");
        Home.put("geoLocationNo_button", "//*[@id='enhanceGeoCancelButton']");
        Home.put("geoLocationcountry_link", "//*[@id='enhanceChooseCountry']");
        Home.put("geoLocationremember_text", "//*[@id='enhanceGeoLocRemmember']");
        Home.put("geoLocationremember_checkbox", "//*[@id='geoRememberMe']");
        Home.put("clearbrowsingData_button", "//*[@id='clearBrowsingDataConfirm']");
        Home.put("countrySelector_element", "//*[@id='countrySelector']");
        Home.put("countrySelect_dropdown", "//*[@class='bsselect']//child::select");
        Home.put("geoLocationPrefercountry_text", "//*[@id='enhancePreferCountry']");
        Home.put("geoLocationclose_button", "//*[@class='col-xs-1 pfCloseButton']");
        Home.put("selectCountyContinue_button", "//*[text()='Continue']");

        //Footer Links
        Home.put(
            "viewAllProducts_link",
            "//a[contains(@href,'browse-for-products')]/li"
        );
        Home.put("shoppingCart_link", "//a[contains(@href,'calculationUsageId')]/li");
        Home.put(
            "myFooterAccount_link",
            "//a[contains(@href,'UserAccountView')]/li"
        );
        Home.put(
            "orderHistoryAndTracking_link",
            "//ul[@class='mb-fstack']//a[4]/li"
        );
        Home.put(
            "calculatorsAndCharts_link",
            "//a[contains(@href,'calculators-conversion-tools')]/li"
        );
        Home.put(
        	"viewAllManufacturers_link",
        	"//a[contains(@href,'manufacturers')]/li"
        );
        Home.put(
            "engineeringGlossary_link",
            "//a[contains(@href,'engineering-glossary')]/li"
        );
        Home.put("contactUs_link", "//a[contains(@href,'contact-us')]/li");
        Home.put("aboutUs_link", "//a[contains(@href,'https://www.farnell.com/') and @target='_blank']/li");
    }

    public String findLocator(String elementName) {
        if (Home.containsKey(elementName)) {
            return (Home.get(elementName.trim()));
        }

        return null;
    }
}
