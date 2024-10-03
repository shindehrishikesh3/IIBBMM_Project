package Repository_WEB_Objs;

import java.util.*;

public class iBuyEditCompany_Objs {

    // Creation of HashMap
    private static final Map<String, String> iBuyEditCompany;

    static {
        iBuyEditCompany = new HashMap<String, String>();

        iBuyEditCompany.put("editCompany_text", "//h1[text()='Edit Company']");
        iBuyEditCompany.put("companyName_textbox", "//*[@id='companyName']");
        iBuyEditCompany.put("accountNumber_link", "//*[@id='editPFAccount']");
        iBuyEditCompany.put("save_button", "//input[@class='btn btnPrimary']");
        iBuyEditCompany.put("cancel_button", "//a[@id='cancelCustomisationBtn']");
        iBuyEditCompany.put("editCompany_link", "//a[text()='Edit']");
        iBuyEditCompany.put(
            "editCompanyAcctandPayment",
            "//*[@id='editTier']/table/tbody/tr[3]/td[1]/a"
        );
        iBuyEditCompany.put(
            "enableCheckbox",
            "//*[@id='methodTable']/thead[1]/tr/th[2]/label/span"
        );
        iBuyEditCompany.put("editCompanyTier_text", "//h1[text()='Edit Company Tier']");
        iBuyEditCompany.put(
            "users_link",
            "//table[@class='infoTable standard restricted']//tr[5]/td/a"
        );
        iBuyEditCompany.put("save_button", "(//*[@class='btn btnPrimary'])[2]");
    }

    public String findLocator(String elementName) {
        if (iBuyEditCompany.containsKey(elementName)) {
            return (iBuyEditCompany.get(elementName.trim()));
        }

        return null;
    }
}
