package Repository_WEB_Objs;

import java.util.*;

public class iBuyCompanyStructure_Objs {

    // Creation of HashMap
    private static final Map<String, String> iBuyCompanyStructure;

    static {
        iBuyCompanyStructure = new HashMap<String, String>();

        iBuyCompanyStructure.put(
            "companyStructure_text",
            "//h1[text()='Company Structure']"
        );
        iBuyCompanyStructure.put(
            "addCompanyTier_button",
            "//*[@class='btn btnPrimary'][text()='Add Company Tier']"
        );
        iBuyCompanyStructure.put(
            "cancel_button",
            "//*[@class='btn btnTertiary'][text()='Cancel']"
        );
        //Structure
        iBuyCompanyStructure.put(
            "structureTopLevel_text",
            "//*[@id='structure']/ul/li/a"
        );

        iBuyCompanyStructure.put("companyStructure_link", "//*[@id='companyStructure']");
    }

    public String findLocator(String elementName) {
        if (iBuyCompanyStructure.containsKey(elementName)) {
            return (iBuyCompanyStructure.get(elementName.trim()));
        }

        return null;
    }
}
