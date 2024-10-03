package Repository_MOBILE_Objs;

import java.util.HashMap;
import java.util.Map;

public class CountryPopUp_Objs {

    // Creation of HashMap
    private static final Map<String, String> CountryPopUp;

    static {
        CountryPopUp = new HashMap<String, String>();
        CountryPopUp.put("countries_element", "//*[@id='countrySelector']");
        CountryPopUp.put(
            "continue_button",
            "//*[@id='countrySelector']/div/div/div[2]/div/div/div[3]/a"
        );
        CountryPopUp.put(
            "export_link",
            "//*[@id='countrySelector']/div/div/div[2]/div/div/div[3]/p/a"
        );
        CountryPopUp.put("close_icon", "//*[@class='pfIcon pfClose']");
        CountryPopUp.put("languageFirst_button", "//*[@id='countryAnchor_0']");
        CountryPopUp.put("languageSecond_button", "//*[@id='countryAnchor_1']");
        CountryPopUp.put("languageThird_button", "//*[@id='countryAnchor_2']");
    }

    public String findLocator(String elementName) {
        if (CountryPopUp.containsKey(elementName)) {
            return (CountryPopUp.get(elementName.trim()));
        }

        return null;
    }
}
