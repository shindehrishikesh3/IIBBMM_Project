package Repository_WEB_Objs;

import java.util.*;

public class iBuyCompanyList_Objs {

    // Creation of HashMap
    private static final Map<String, String> iBuyCompanyList;

    static {
        iBuyCompanyList = new HashMap<String, String>();

        iBuyCompanyList.put("companyListHeader_text", "//h1[text()='Company List']");
        iBuyCompanyList.put("companyName_textbox", "//*[@id='companyName']");
        iBuyCompanyList.put("accountNumber_textbox", ".//*[@id='accountNumber']");
        iBuyCompanyList.put("addNewCompany_button", ".//*[@id='companies']/div[3]/a[2]");
        iBuyCompanyList.put("addCompanyName_textbox", "//*[@id ='orgEntityName']");
        iBuyCompanyList.put("add_button", "//input[@class='btn btnPrimary']");
        iBuyCompanyList.put("companyExists_label", "//span[@class='labelFeel']");
        iBuyCompanyList.put("companyNameInTable_label", "//label[@for='comp_1']/a");
        iBuyCompanyList.put("searchUsers_button", "(//*[@class='btn btnPrimary'])[2]");
        //iBuyCompanyList.put("listOfCompaniesTable_element","//table[@class= 'standard infoTable']");
        iBuyCompanyList.put("searchUsers_button","(//*[@class='btn btnPrimary'])[2]");

    }

    public String findLocator(String elementName) {
        if (iBuyCompanyList.containsKey(elementName)) {
            return (iBuyCompanyList.get(elementName.trim()));
        }

        return null;
    }
}
