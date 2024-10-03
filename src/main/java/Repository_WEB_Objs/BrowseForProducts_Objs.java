package Repository_WEB_Objs;

import java.util.*;

public class BrowseForProducts_Objs {

    // Creation of HashMap
    private static final Map<String, String> BrowseForProducts;

    static {
        BrowseForProducts = new HashMap<String, String>();
        BrowseForProducts.put("firstCategory_link", "(//div[@class='catHeader']//a)[1]");
        BrowseForProducts.put("secondCategory_link", "(//div[@class='catHeader']//a)[2]");
        BrowseForProducts.put(
            "allProducts_links",
            "(//div[@class='categoryContainer']//ul//li/a)"
        );
        BrowseForProducts.put("allCategory_links", "//*[@class='catHeaderWrapper']//a");
        BrowseForProducts.put("allSubCategory_links", "//*[@class='filterCategoryLevelOne']//a");
        BrowseForProducts.put(
            "allCategoryProductCount_text",
            "//*[@class='catHeader']/span"
        );
        BrowseForProducts.put(
            "allSubCategoryProductCount_text",
            "//*[@class='filterCategoryLevelOne']//span"
        );
    }

    public String findLocator(String elementName) {
        if (BrowseForProducts.containsKey(elementName)) {
            return (BrowseForProducts.get(elementName.trim()));
        }

        return null;
    }
}
