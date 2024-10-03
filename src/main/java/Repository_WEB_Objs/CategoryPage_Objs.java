package Repository_WEB_Objs;

import java.util.*;

public class CategoryPage_Objs {

    // Creation of HashMap
    private static final Map<String, String> CategoryPage;

    static {
        CategoryPage = new HashMap<String, String>();
        CategoryPage.put(
                "showAllProducts_button",
                "//*[contains(@class,'showAllProductsBottom')]");
        CategoryPage.put("section_category", "//*[@class='lhs_categories']");
        CategoryPage.put(
                "firstCategoryInCategories_link",
                "//*[@class='categoryList']//ul/li[1]/a");
        CategoryPage.put(
                "categoryHeader_label",
                "//*[contains(@id,'ad_pf_cnode_espot_01')]/div/div/h1");

        CategoryPage.put("categorySection_label", "//*[@class='lhs_categories']/div");
        CategoryPage.put("categorySection_background", "//*[@class='lhs_categories']");
        CategoryPage.put("categoryList_label", "//*[@class='categoryList']/li//nav/ul");
        CategoryPage.put(
                "categoryHeaderSection_label",
                "//*[@class='categoryList']/li//h2/span");
        CategoryPage.put(
                "categorySection_link",
                "//*[@class='categoryList']/li//nav/ul/li[1]/a");
        CategoryPage.put(
                "catgoeryPageCount_label",
                "//ul[@class='categoryList']//ul//li[1]/span");
        CategoryPage.put("categoryPLPcount_label", "//*[@id='titleProdCount']");
        CategoryPage.put(
                "categoery_label",
                "//*[@id=\"catRefine\"]/ul/li/nav/ul/li[1]/a");
        CategoryPage.put("categoryPLP_label", "//*[@id='prodResultHeader']/h1");
        CategoryPage.put("category_Images", "//*[@id='paraSearch']//ul");
        CategoryPage.put("category_list", "//*[@class='filterCategoryLevelOne']");
        CategoryPage.put(
                "subCategory_urls",
                "//*[@aria-label='Category List Item']/ul/li/a");
        CategoryPage.put(
                "specificCategoryContent_text",
                "//*[@id='shrinkMe']");
        CategoryPage.put(
                "categoryContent_text",
                "//*[contains(@class,'mk-col-100')]//p");
        CategoryPage.put(
                "altCategoryContent_text",
                "//*[contains(@class,'mk-col-100')]/div");
        CategoryPage.put(
                "altCategoryContentURL_link",
                "//*[contains(@class,'mk-col-100')]/div//a");
        CategoryPage.put(
                "categoryContentURL_link",
                "//*[contains(@class,'mk-col-100')]//p//a");
        CategoryPage.put("categoryContainer_section", "//*[@class='categoryContainer']");
        CategoryPage.put(
                "delkinContent_text",
                "//*[contains(@id,'ad_pf_plnode_espot')]/div");
        CategoryPage.put(
                "filterManufacturer_text",
                "//*[@id='paraSearch']/section[2]//div[@class='prodListMarked ']/span");
        CategoryPage.put(
                "delkinContentURLs_link",
                "(//*[contains(@id,'ad_pf_plnode_espot')]/div//a)");
        CategoryPage.put("subCategory_link", "//*[@class='productName']/a");
        CategoryPage.put("categoryHeader_text", "//*[@id='paraSearch']//h1");
        CategoryPage.put(
                "categoryAltContent_text",
                "//*[@id='paraSearch']//h1/following-sibling::p");
        CategoryPage.put(
                "categoryAltContentInner_links",
                "//*[@id='paraSearch']//h1/following-sibling::p/a");
        CategoryPage.put(
                "firstRelatedCategory_text",
                "//div[@id='paraSearch']//section[1]//div//h2[contains(text(),'Related Categories')]");
        // category related moves into second place after filters applied
        CategoryPage.put(
                "secondRelatedCategory_text",
                "//div[@id='paraSearch']//section[2]//div//h2[contains(text(),'Related Categories')]");
//        CategoryPage.put(
//                "moreText_link",
//                "//*[@id='shrinkMeMoreLink']");
        CategoryPage.put(
                "moreText_link",
                "//*[@id='morelessBtn']");        
        CategoryPage.put(
                "appliedFilters_section",
                "//ul[@id='filteredList']/li");

    }

    public String findLocator(String elementName) {
        if (CategoryPage.containsKey(elementName)) {
            return (CategoryPage.get(elementName.trim()));
        }

        return null;
    }
}
