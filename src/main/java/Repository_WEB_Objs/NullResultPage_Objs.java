package Repository_WEB_Objs;

import java.util.HashMap;
import java.util.Map;

public class NullResultPage_Objs {

    private static final Map<String, String> NullResultPage;

    static {
        NullResultPage = new HashMap<String, String>();

        //Null Search Page
        NullResultPage.put("Nullresultpage", "//*[@id = 'nullResultsPage']");
        NullResultPage.put("searchMessage_label", "//*[@id='noSearchResults-header']");
        NullResultPage.put("SearchAPAC_label", "//*[@id='noSearchResults']//h2");
        NullResultPage.put("SearchUS_label", "//*[@id='no-results-header']");
        NullResultPage.put(
            "searchtips_label",
            "(//*[contains (@class,'mk-search-top')]//h2)[1]"
        );
        NullResultPage.put(
            "searchPagehelp_label",
            "(//*[contains (@class,'mk-search-top')]//h2)[2]"
        );
        NullResultPage.put("ProductCategories_label", "//*[@class='mk-pullout-header']");
        NullResultPage.put(
            "espot_Image",
            "//*[@class='row larger-margin-bottom border-sm-mpr']"
        );
        NullResultPage.put("searchTerm_label", "//*[@class = 'toBeReplaced']");
    }

    public String findLocator(String elementName) {
        if (NullResultPage.containsKey(elementName)) {
            return (NullResultPage.get(elementName.trim()));
        }

        return null;
    }
}
