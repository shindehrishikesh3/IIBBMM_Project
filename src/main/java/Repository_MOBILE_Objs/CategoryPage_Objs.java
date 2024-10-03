package Repository_MOBILE_Objs;

import java.util.*;

public class CategoryPage_Objs {

    // Creation of HashMap
    private static final Map<String, String> CategoryPage;

    static {
        CategoryPage = new HashMap<String, String>();
        CategoryPage.put("section_category", "//*[@class='categories outlined-section']");
        CategoryPage.put("multiCategorySection_element", "//*[@class='categories multi-cat outlined-section']");
        CategoryPage.put(
            "firstCategoryInCategories_link",
            "(//ul[@class='categories-0']//li//a)[1]"
        );
        CategoryPage.put("breadcrumb_link", "(//*[@id='page-container']/a)[1]");
        CategoryPage.put("category_heading", "//*[@class='productName']");
        CategoryPage.put("titleProductCount_value", "//*[@id='titleProdCount']");
        CategoryPage.put(
            "categoryFirstParagraph_text",
            "(//*[@class='searchParagraph'])[1]"
        );
        CategoryPage.put(
            "categorySubParagraph_text",
            "(//*[@class='searchParagraph'])[4]"
        );
        CategoryPage.put(
            "categorySubParagraph_link",
            "(//*[@class='searchParagraph'])[4]/a"
        );
        CategoryPage.put("cateogoryMainDescription_text", "//*[@class='clearfix']//p");
        CategoryPage.put(
            "refineResults_button",
            "//*[contains(@class,'filter-products')]"
        );
        CategoryPage.put("categories_text", "//*[@class='cat_title']/h2");
        CategoryPage.put("categoriesSection_list", "//ul[@class='categories-1']/li");
        CategoryPage.put(
            "categoriesSectionFirst_link",
            "//ul[@class='categories-1']/li[1]/a"
        );
        CategoryPage.put("sortBy_dropdown", "//*[@id='sort-by']");
        CategoryPage.put(
            "topPagination_text",
            "(//*[contains(@class,'pfPagination')])[1]"
        );
        CategoryPage.put("categorylisterProducts_section", "//*[@id='product-list']/li");
        CategoryPage.put(
            "bottomPagination_text",
            "(//*[contains(@class,'pfPagination')])[2]"
        );
        CategoryPage.put("currentPageSelected_text", "//*[@class='current']");
        CategoryPage.put("moreText_link", "//*[@id='shrinkMeMoreLink']");
        CategoryPage.put("expandedContents_text", "//*[@id='shrinkMe']/span");
        CategoryPage.put("expandedContentsInner_link", "//*[@id='shrinkMe']/span//a");
        CategoryPage.put("contents_text", "//*[contains(@id,'ad_pf_plnode_espot')]//p");
        CategoryPage.put(
            "contentInner_link",
            "//*[contains(@id,'ad_pf_plnode_espot')]//p//a"
        );
        CategoryPage.put(
                "categoryContent_text",
                "//*[contains(@class,'mk-col-100')]//p"
            );
        CategoryPage.put(
                "altCategoryContent_text",
                "//*[contains(@class,'mk-col-100')]/div"
            ); 
        CategoryPage.put(
                "altCategoryContentURL_link",
                "//*[contains(@class,'mk-col-100')]/div//a"
            );
        CategoryPage.put(
            "specificCategoryContent_text",
            "//*[@id='shrinkMe']"
        );
        CategoryPage.put(
                "categoryContentURL_link",
                "//*[contains(@class,'mk-col-100')]//p//a"
            );
        CategoryPage.put(
            "spcificCategoryContentURL_link",
            "//*[@id='shrinkMe']//p//a"
        );
        CategoryPage.put(
        		"popularSearchHeading_text",
        		"//*[starts-with(@id,'ad_pf_popularsearch')]/div/p[1]"
        		);
        CategoryPage.put(
        		"popularSearch_text",
        		"//*[starts-with(@id,'ad_pf_popularsearch')]/div/p[2]"
        		);
        CategoryPage.put(
        		"popularSearch_links",
        		"//*[starts-with(@id,'ad_pf_popularsearch')]/div/p[2]/a"
        		);
        
//        CategoryPage.put("moreText_link", "//*[@id='shrinkMeMoreLink']");
        CategoryPage.put("moreText_link", "//*[@id='morelessBtn']");
    }

    public String findLocator(String elementName) {
        if (CategoryPage.containsKey(elementName)) {
            return (CategoryPage.get(elementName.trim()));
        }

        return null;
    }
}
