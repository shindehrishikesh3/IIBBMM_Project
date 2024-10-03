package Repository_WEB_Objs;

import java.util.HashMap;
import java.util.Map;

public class ManufacturePage_Objs {

    private static final Map<String, String> ManufacturePage;

    static {
        ManufacturePage = new HashMap<String, String>();

        // products table elements

        ManufacturePage.put("menuSectionAll_link", "(//*[@class='manuSymbols']/ul/li)");
        ManufacturePage.put(
            "viewAllManufacturers_link",
            "//*[@id='ad_pf_megamenu_espot_01_defer']//a[@class='viewAll']"
        );
        ManufacturePage.put("allSection_link", "//*[@id='pageTop']/div[84]//ul/li/a");
        ManufacturePage.put(
            "showAllProduct_button",
            "//*[@id='manuFacturer']/div/section[2]/a"
        );
        ManufacturePage.put(
            "manufacture_checkbox",
            "(//*[@class='filterInnerListContainer '])[2]/input"
        );
        ManufacturePage.put("hash3com_link", "//*[@id=\"pageTop\"]/div[84]/ul/li[3]/a");
        ManufacturePage.put("manufacturerPageTitle", "//*[@id='manuFacturer']");
        ManufacturePage.put("BOSCHManufacturer_link", "//a[contains(text(),'BOSCH')]");
        ManufacturePage.put("CODEBUGManufacturer_link", "//a[contains(text(),'CODEBUG')]");
        ManufacturePage.put("EAOManufacturer_link", "//a[contains(text(),'EAO')]");
    }

    public String findLocator(String elementName) {
        if (ManufacturePage.containsKey(elementName)) {
            return (ManufacturePage.get(elementName.trim()));
        }

        return null;
    }
}
