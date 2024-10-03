package Repository_MOBILE_Objs;

import java.util.*;

public class Search_Objs {

    // Creation of HashMap
    private static final Map<String, String> Search;

    static {
        Search = new HashMap<String, String>();
        Search.put("response_search", "//*[@id='lookAheadResponse']");
        Search.put("lookAheadSKU_link", "//td[@class='leftcolumn']/a[1]");
        Search.put("attributes_text", "//*[@id='lookAheadResponse']/div/div[2]/p");
        Search.put(
            "attributes_list",
            "//*[@id='lookAheadResponse']/div/ul[1]/table/tbody/tr"
        );
        Search.put("productCategories_text", "//*[@id='lookAheadResponse']/div/div[3]/p");
        Search.put(
            "productCategories_list",
            "//*[@id='lookAheadResponse']/div/ul[2]/table/tbody/tr"
        );
        Search.put("manufacturers_text", "//*[@id='lookAheadResponse']/div/div[4]/p");
        Search.put(
            "manufacturers_list",
            "//*[@id='lookAheadResponse']/div/ul[3]/table/tbody/tr"
        );
        Search.put("products_text", "//*[@id='lookAheadResponse']/div/div[4]/p");
        Search.put(
            "products_list",
            "//*[@id='LookAheadProdIdContainer']/ul/table/tbody/tr"
        );
        Search.put("productsHeader_text", "//*[@class='products-showing']/span");
        Search.put("breadCrumb_element", "//*[@id='page-container']/a");
        Search.put("resultFoundForSearchTerm_text", "//*[@class='h1']");
        Search.put("FirstOptionSelection", "//*[@id='lookAheadResponse']/div/ul/table/tbody/tr[1]/td/a");
    }

    public String findLocator(String elementName) {
        if (Search.containsKey(elementName)) {
            return (Search.get(elementName.trim()));
        }

        return null;
    }
}
