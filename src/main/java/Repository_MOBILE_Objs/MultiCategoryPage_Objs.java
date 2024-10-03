package Repository_MOBILE_Objs;

import java.util.*;

public class MultiCategoryPage_Objs {

    // Creation of HashMap
    private static final Map<String, String> MultiCategoryPage;

    static {
        MultiCategoryPage = new HashMap<String, String>();
        MultiCategoryPage.put("resultFoundFor_text", "//*[@class='h1']");
        MultiCategoryPage.put("titleProductCount_value", "//*[@id='titleProdCount']");
        MultiCategoryPage.put(
            "refineResults_button",
            "//*[contains(@class,'filter-products')]"
        );
        MultiCategoryPage.put("searchWithin_textbox", "//input[@id='searchWithinTerm']");
        MultiCategoryPage.put("searchWithin_icon", "//button[@id='searchWithin']");
        MultiCategoryPage.put("multiCategories_section", "//*[@class='categories-0']");
        MultiCategoryPage.put(
            "onlyAtBottomShowAllProducts_button",
            "//a[contains(@class,'showAllProductsBottom')]"
        );
        MultiCategoryPage.put("resultFoundForSearchWithin_text", "//*[@class='h1']");
    }

    public String findLocator(String elementName) {
        if (MultiCategoryPage.containsKey(elementName)) {
            return (MultiCategoryPage.get(elementName.trim()));
        }

        return null;
    }
}
