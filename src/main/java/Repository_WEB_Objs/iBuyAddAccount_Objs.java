package Repository_WEB_Objs;

import java.util.*;

public class iBuyAddAccount_Objs {

    // Creation of HashMap
    private static final Map<String, String> iBuyAddAccount;

    static {
        iBuyAddAccount = new HashMap<String, String>();

        iBuyAddAccount.put("addAccount_text", "//h1[text()='Add Account']");
        iBuyAddAccount.put(
            "billingAccount_text",
            "//*[@id='accountDetails']/div[1]/div[1]/div"
        );
        iBuyAddAccount.put("save_button", "//input[@class='btn btnPrimary']");
        iBuyAddAccount.put("cancel_button", "//*[@id='cancelAddAccountBtn']");
        iBuyAddAccount.put("addNewAccount_button", "//*[@id='addNewAccount']");
        iBuyAddAccount.put("addNewCard_button", "//*[@class='actionTable']//a");
    }

    public String findLocator(String elementName) {
        if (iBuyAddAccount.containsKey(elementName)) {
            return (iBuyAddAccount.get(elementName.trim()));
        }

        return null;
    }
}
