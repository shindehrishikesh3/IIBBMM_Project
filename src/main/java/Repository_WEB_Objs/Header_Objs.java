package Repository_WEB_Objs;

import java.util.HashMap;
import java.util.Map;

public class Header_Objs {

    // Creation of HashMap
    private static final Map<String, String> Header;

    static {
        Header = new HashMap<String, String>();
        
        //meganav
        Header.put("allProducts_link", "(//*[@class='megaMenu']/ul/li[1]/a)[1]");
        Header.put("allProductsOverlay_element", "(//*[@class='megaMenu']/ul/li[1]/a)[1]/parent::li/ul/li");
        Header.put("allL0CategoryProducts_link", "(//*[@class='megaMenu']/ul/li[1]/a)[1]/parent::li/ul/li/a");
        Header.put("manufacturers_link", "//*[@id='ad_pf_megamenu_espot_01_defer']/a");
        Header.put("allManufacturers_link", "//*[@id='ad_pf_megamenu_espot_01_defer']/a/following-sibling::ul//a");
        Header.put("resource_link", "//*[@id='ad_pf_megamenu_espot_02_defer']/a");
        Header.put("allResource_link", "//*[@id='ad_pf_megamenu_espot_02_defer']/a/following-sibling::ul//a");
        Header.put("community_tab", "//*[@id='ad_pf_megamenu_espot_03_defer']/a");
        Header.put("allCommunity_link", "//*[@id='ad_pf_megamenu_espot_03_defer']/a/following-sibling::ul//a");
        
        // Search box in Header
        Header.put("all_list", "//*[@id='lookAhead']/div[1]/div[1]");
        Header.put("all_text", "//*[@id='demo']");
        Header.put("anyCategory_dropdown", "//select[@id='categoryIdBox']");
        Header.put("searchBox_textbox", "//*[@id='SimpleSearchForm_SearchTerm']");
        Header.put("searchIcon_button", "//*[@id='searchMain']");
        Header.put("companylogo_element", ".//*[@id='ad_storeLogoESpot']");

        Header.put("category_dropdown", "//*[@id='categoryIdBox']/option[6]");
        Header.put(
            "searchProductList_link",
            "//*[@id='LookAheadProdIdContainer']//tr[1]"
        );
        Header.put("wildcard_text","//*[@id='wildCardMesgAlert']");
        Header.put("wildcardDismiss_button","//*[@id='wildCardMesgAlertDismiss']");

        // Header right side section
        Header.put("login_link", "//*[@id='guestPar']/a[1]");
        Header.put("register_link", "//*[@id='guestPar']/a[2]");

       //Header.put("userFirstName_text", "//*[@id='loggedInPar']/span[1]");
        Header.put("userFirstName_text", "//*[@class='userFirstNameLoggedInn']");
        Header.put("amtBlankCart_text", "//*[@class='price-total']");
        Header.put("trackOrders_link", "//a[@href='/order-status']");
        Header.put("miniBasket_link", "//*[@class='shopcart-white']");
        Header.put("itemsInMiniBasket_text", "//*[@class='items-qty']");
        Header.put("itemAddedPopUp_element", "//*[@class='orderItemAdded']");
        Header.put(
            "miniShopcartProductAdded_element",
            "//*[@id='MiniShopCartProductAdded']"
        );
        Header.put("wholeHeader_element", "//*[@id='head']");
        Header.put("miniBasketClose_link", "//*[@class='closeLink closeTextWrap']");
        Header.put("userIcon_image", "//*[contains(@class,'cart-user')]//img");

        // Header Top right tabs
        Header.put(
            "offer_link",
            "//*[contains(@data-dtm-eventinfo,'Special Offers')][1]"
        );
        Header.put(
            "contactus_link",
            "//*[contains(@data-dtm-eventinfo,'Contact Us')][1]"
        );
        Header.put("help_link", "//*[contains(@data-dtm-eventinfo,'Help')][1]");
        Header.put(
            "Specialoffer_text",
            "//*[@class='page-header-inner inner-header-so']/div/h1"
        );
        Header.put(
            "Contactusheader_text",
            "//*[@class='new-page-header-inner new-contact-us-img']/h1"
        );
        Header.put(
            "helpheader_text",
            "//*[@class='panel-heading small-padding-top small-padding-bottom']/h2[contains(@class,'text-center')]"
        );
        Header.put("trackorderheader_text", "//*[@id='article']/h1");

        // Country dropdown
        Header.put("flag_link", "//div[@data-widget='countryselector']");
        Header.put("country_text", "//*[@id='countrySelector']/div[2]/div[2]/div/div/h2");
        Header.put("country_dropdown", "//*[@class='bsselect']/select");
        Header.put("continue_button", "//*[@class='mini-action']/a");

        // Myaccount Summary dropdown
        Header.put("myAccount_dropdown", "//*[@class='collection-title']/a");
        Header.put(
            "accountSummary_link",
            ".//*[contains(@data-dtm-eventinfo,'User Account')]"
        ); // "//*[@class='list15']/a");
        Header.put("orderHistory_link",".//*[contains(@data-dtm-eventinfo,'orderHistory')]");
        Header.put("managingYourAccount_link",".//*[contains(@data-dtm-eventinfo,'managingYourAccount')]");
        Header.put("orderHistory_list", "//*[@class='list2']/a");
        Header.put("logout_button", ".//*[contains(@data-dtm-eventinfo,'Log Out')]");
        Header.put(
            "myAccountHeaders_text",
            "(//*[@id='ad_pf_header_espot_myacc']/ul/li[@class='headerList'])"
        );
        Header.put(
            "myaccount_text",
            "//*[@id='ad_pf_header_espot_myacc']/ul/li[contains(@class, 'list')]/a"
        );
        Header.put(
            "myAccount_list",
            "//*[@id='ad_pf_header_espot_myacc']//li[contains(@class,'list')]"
        );
        Header.put(
            "profileInfo_link",
            "//a[contains(@href,'UserRegistrationForm?editRegistration')]"
        );
        Header.put("logout_button", "//a[contains(@href,'LOGOUT')]");
        Header.put(
            "savedBasket_button",
            "//a[contains(@data-dtm-eventinfo,'Saved Basket')]"
        );
        Header.put("bomUpload_link", "//a[contains(@href,'BOM-UPLOAD')]");
        Header.put("cpcMyAccount_list", "//*[@id='ad_pf_header_espot_myacc']/ul/li/a");
        Header.put("cpcFlag_link", "//*[@class='home-flag flags en_UK']");

        // tools dropdown elements
        Header.put("tools_link", "//*[@id='ad_pf_megamenu_espot_04_defer']/a");
        Header.put("tools_list", "//*[@id='ad_pf_megamenu_espot_04_defer']/ul/li/a");
        Header.put("quickBuy_link", "(//*[@class='subnav simpleList']/li[1]/a)[1]");
        Header.put(
            "BOMUploadTools_link",
            "//ul[@role='menu']//a[contains(@data-dtm-eventinfo,\"BOM\")]"
        );

        // header top-left sections
        Header.put("communities_link", "//*[@id='ad_pf_megamenu_espot_03_defer']/a");
        Header.put(
            "community_text",
            "//*[@class='subnav banner megamenu-community']/li[1]/a[2]"
        );
        Header.put( "orders&reports_link",".//*[contains(@data-dtm-eventinfo,'Orders Reports')]");
        
    }

    public String findLocator(String elementName) {
        if (Header.containsKey(elementName)) {
            return (Header.get(elementName.trim()));
        }

        return null;
    }
    // ******************************************************

}
