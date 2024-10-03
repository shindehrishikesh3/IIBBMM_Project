package Repository_MOBILE_Objs;

import java.util.*;

public class BrowseForProducts_Objs {

    // Creation of HashMap
    private static final Map<String, String> BrowseForProducts;

    static {
        BrowseForProducts = new HashMap<String, String>();
        BrowseForProducts.put(
            "firstCategory_link",
            "//*[@class='filterCategoryLevelOne']//a"
        );
        BrowseForProducts.put("firstCategory_image", "//*[@class='categoryImg']/img");
        BrowseForProducts.put("firstCategory_text", "(//*[@class='catHeader']/h2)[1]");
        BrowseForProducts.put("secondSubCategory_link", "(//*[@class='filterCategoryLevelOne']//a)[2]");
        BrowseForProducts.put(
            "allProducts_links",
            "//*[@class='categoryList']//a"
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
