package Repository_MOBILE_Objs;

import java.util.*;

public class Filters_Objs {

    // Creation of HashMap
    private static final Map<String, String> Filters;

    static {
        Filters = new HashMap<String, String>();
        Filters.put(
            "refineResults_button",
            "//*[contains(@class,'refineResultWrapper')]//a"
        );
        Filters.put("searchWithinTermBox_textbox", "//*[@id='searchWithinTerm']");
        Filters.put(
            "plusSignOfAvailability_image",
            "//*[@id='allStaticFilters']/div[1]/span"
        );
        Filters.put(
            "plusSignOfManufacturer_image",
            "//*[@id='staticFiltersmftr']/div[1]/span"
        );
        Filters.put("instock_checkbox", "//*[@id='Filtershide']/div[2]");
        Filters.put(
            "applyFilters_button",
            "//*[contains(@class,'apply_filters btn btnPrimary')]"
        );
        Filters.put("filtersSelected_text", "//*[contains(@class,'appliedFilter')]");
        Filters.put("filtersApplied_text", "//*[contains(@class,'filter-products')]");
        Filters.put("clearAllFilters_button", "//*[contains(@class,'clear_filter_btn')]");
        Filters.put("firstManuf_checkbox", "//*[@id='manufacturerHide']/div[1]/input");
        Filters.put("filtersCount_text", "//*[@id='titleProdCount']");
        Filters.put("mfrProductCount_text", "//label[starts-with(@for,'pa_mfName_ntk')]/span");
        Filters.put("checkedMfrFilter_checkbox", "//input[starts-with(@id,'pa_mfName_ntk') and @checked = 'checked']");
    }

    public String findLocator(String elementName) {
        if (Filters.containsKey(elementName)) {
            return (Filters.get(elementName.trim()));
        }

        return null;
    }
}
