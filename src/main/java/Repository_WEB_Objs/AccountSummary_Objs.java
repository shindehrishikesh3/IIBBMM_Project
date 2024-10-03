package Repository_WEB_Objs;

import java.util.*;

public class AccountSummary_Objs {

    // Creation of HashMap
    private static final Map<String, String> AccountSummary;

    static {
        AccountSummary = new HashMap<String, String>();
        AccountSummary.put("edit_button", "//div[@class='section']/a");
        AccountSummary.put("welcome_text", "(//div[@class='section']//h2)[1]");
        AccountSummary.put("backOfficeAccount_text", "//*[@id='PFUserAccountUpdate']//p");
        AccountSummary.put("accountSummary_link", ".//*[@id='myAccountSummary']");
        AccountSummary.put("accountName_text", "//*[@class='account noBorder noLabelBckg']");
        AccountSummary.put("myAccountSummary_text", "//*[@id='article']//h1");
        AccountSummary.put("emailUpdate_banner", "//*[@id='maEmailUpdate']");
        
    }

    public String findLocator(String elementName) {
        if (AccountSummary.containsKey(elementName)) {
            return (AccountSummary.get(elementName.trim()));
        }

        return null;
    }
}
