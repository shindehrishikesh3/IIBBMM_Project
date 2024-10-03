package Repository_WEB_Objs;

import java.util.*;

public class iBuyAddCompany_Objs {

    // Creation of HashMap
    private static final Map<String, String> iBuyAddCompany;

    static {
        iBuyAddCompany = new HashMap<String, String>();

        iBuyAddCompany.put("addCompanyHeader_text", "//h1[text()='Add Company']");
        iBuyAddCompany.put("addCompanyName_textbox", "//*[@id ='orgEntityName']");
        iBuyAddCompany.put("add_button", "//input[@class='btn btnPrimary']");
        iBuyAddCompany.put("companyExists_label", "//span[@class='labelFeel']");
        iBuyAddCompany.put("companyNameInTable_label", "//label[@for='comp_1']/a");
        iBuyAddCompany.put(
            "errorMessage_label",
            "//*[@id ='formErrors']//li/span[@class ='labelFeel']"
        );
    }

    public String findLocator(String elementName) {
        if (iBuyAddCompany.containsKey(elementName)) {
            return (iBuyAddCompany.get(elementName.trim()));
        }

        return null;
    }
}
