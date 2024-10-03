package Repository_MOBILE_Objs;

import java.util.HashMap;
import java.util.Map;

public class ManufacturerListPage_Objs {

    // Creation of HashMap
    private static final Map<String, String> ManufacturerListPage;

    static {
        ManufacturerListPage = new HashMap<String, String>();
        
        ManufacturerListPage.put("menuSectionAll_link", "(//*[@class='manuSymbols']/ul/li)");
        ManufacturerListPage.put("ManufacturerList_text", "//*[@id='pageTop']/h1");
        ManufacturerListPage.put("ManufacturerC_section", "//*[@id='man_C']");
        ManufacturerListPage.put("CODEBUGManufacturer_link", "//a[contains(text(),'CODEBUG')]");
    }

    public String findLocator(String elementName) {
        if (ManufacturerListPage.containsKey(elementName)) {
            return (ManufacturerListPage.get(elementName.trim()));
        }

        return null;
    }
}
