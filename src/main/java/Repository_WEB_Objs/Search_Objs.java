package Repository_WEB_Objs;

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
        Search.put(
            "productsList_link",
            "//*[@id='LookAheadProdIdContainer']/ul/table/tbody/tr[2]"
        );
        Search.put("productsHeader_text", "//*[@id='prodResultHeader']");
        Search.put(
            "searchLookAheadHeaders_list",
            "//*[@id='lookAheadResponse']/div/div/p"
        );
        Search.put("searchFirst_text", "(//*[@id='LookAheadProdIdContainer']//a)[2]");
        Search.put("manufacturers_list", "//table[@class=\"manufactures\"]//tr");

        //BreadCrumb of Category page
        Search.put("breadCrumb_element", "//*[@id='breadcrumb']");
        Search.put("breadcrumbCount_list", "//*[@id='breadcrumb']/ul/li");
        Search.put("productCount_text", "//span[@id='titleProdCount']");
        Search.put("breadcrumbLinks_link", "//*[@id='breadcrumb']/ul/li/a");
        Search.put("noSearchResultsleft_element","//div[@class='col-md-6 gc-padding-left']//h2");
        Search.put("noSearchResultsright_element","//div[@class='col-md-6 padding-left-none']//h2");
        Search.put("noSearchResultsleft_text","//div[@class='col-md-6 gc-padding-left']//ol//li");
        Search.put("noSearchResultsright_text","//div[@class='col-md-6 padding-left-none']//ol//li");
        Search.put("requestAQuote_btn","//div[@class='col-md-6 gc-padding-left']//a[@class='btn btn-primary']");
        Search.put("enquireNow_btn","//div[@class='col-md-6 padding-left-none']//a[@class='btn btn-primary']");
        Search.put("customcomponentPage_element","//div[@class='col-sm-7 margin-top margin-bottom']//strong");
        Search.put("customcomponentPageHeader_element","//div[@class='col-xs-12 large-margin-bottom large-padding-top large-padding-bottom']//h1");
        Search.put("surveyPage_element","//input[@id='ember1027']");
        Search.put("cartPrice_element","//div[@class='price-total vatExcl']");
        Search.put("leftComponentCurreny_element","//div[@id='action_insert_167954858578912517']//div[@class='col-md-6 gc-padding-left']//li[3]");
    }

    public String findLocator(String elementName) {
        if (Search.containsKey(elementName)) {
            return (Search.get(elementName.trim()));
        }

        return null;
    }
}
