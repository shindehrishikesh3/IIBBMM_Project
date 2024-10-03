package Repository_WEB_Objs;

import java.util.*;

public class iBuyRetrieveAccount_Objs {

    // Creation of HashMap
    private static final Map<String, String> iBuyRetrieveAccount;

    static {
        iBuyRetrieveAccount = new HashMap<String, String>();

        iBuyRetrieveAccount.put(
            "retrieveAccount_text",
            "//h1[text()='Retrieve Account']"
        );
        iBuyRetrieveAccount.put("accountNumber_textbox", "//*[@id='accountNumber']");
        iBuyRetrieveAccount.put(
            "companyId_dropdown",
            "//*[(@id = 'companyId') and (@disabled ='disabled')]"
        );
        iBuyRetrieveAccount.put(
            "searchUsers_button",
            "//*[@id='getAccountForm']/div[3]/input"
        );
        iBuyRetrieveAccount.put(
            "cancel_button",
            "//*[@class='btn btnTertiary'][text()='Cancel']"
        );
    }

    public String findLocator(String elementName) {
        if (iBuyRetrieveAccount.containsKey(elementName)) {
            return (iBuyRetrieveAccount.get(elementName.trim()));
        }

        return null;
    }
}
