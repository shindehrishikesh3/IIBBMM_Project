package Repository_WEB_Objs;

import java.util.HashMap;
import java.util.Map;

public class iBuyEditCompanyTier_Objs {

    // Creation of HashMap
    private static final Map<String, String> iBuyEditCompanyTier;

    static {
        iBuyEditCompanyTier = new HashMap<String, String>();

        iBuyEditCompanyTier.put(
            "editCompanyTier_text",
            "//*[@class='section my_account']/h1"
        );
        iBuyEditCompanyTier.put(
            "customFieldsInTable_link",
            "(//*[@class='altRow']/td/a)[1]"
        );
        iBuyEditCompanyTier.put("editCompanyTier_text", ".//*[@id='article']/div/h1");
        iBuyEditCompanyTier.put("limitsAndBudget_link",".//*[@id='editTier']/table/tbody/tr[1]/td[1]/a");
        iBuyEditCompanyTier.put("user_link","//*[@id='editTier']/table/tbody/tr[5]/td[1]/a");
        iBuyEditCompanyTier.put("saUser_link","//*[@id='removeFRM']/table/tbody/tr[1]/td[1]/a");
        iBuyEditCompanyTier.put("taUser_link","//*[@id='removeFRM']/table/tbody/tr[2]/td[1]/a");
        iBuyEditCompanyTier.put("iBuyUserRole_link","//*[@class='infoTable standard']/tbody/tr[3]/td[1]/a");
        iBuyEditCompanyTier.put("limitBudgetAndDeliveryMethod_link","//*[@id='editUserFRM']/table/tbody/tr[1]/td[1]/a");
        iBuyEditCompanyTier.put("allocateMoreApprover_button","//*[@id='approvers']/div[4]/a[1]");
        
    }

    public String findLocator(String elementName) {
        if (iBuyEditCompanyTier.containsKey(elementName)) {
            return (iBuyEditCompanyTier.get(elementName.trim()));
        }

        return null;
    }
}
