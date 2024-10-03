package Repository_WEB_Objs;

import java.util.*;

public class MyAccount_Objs {

    // Creation of HashMap
    private static final Map<String, String> MyAccount;

    static {
        MyAccount = new HashMap<String, String>();

        MyAccount.put("AccountSummary_link", "//*[@id='myAccountSummary']");

        // My Orders Link
        MyAccount.put("orderHistoryTracking_link", "//*[@id='trackOrderStatus']");
        MyAccount.put("billOfMaterialsUpload_link", "//*[@id='uploadBillOfMaterials']");
        MyAccount.put("requestAnInvoiceCopy_link", "//*[@id='requestCopyInvoice']");
        MyAccount.put("returns_link", "//*[@id='returns']");

        // Settings link
        MyAccount.put("profileInformation_link", "//*[@id='personalInformation']");
        MyAccount.put("addresses_link", "//*[@id='addressBook']");
        MyAccount.put("paymentCards_link", "//*[@id='paymentCards']");
        MyAccount.put("orderPreferences_link", "//*[@id='orderPreferences']");

        // Favourites link
        MyAccount.put("favourites_link", "//*[@id='favourites']");

        // Notifications link
        MyAccount.put(
            "notificationPreferences_link",
            "//*[@id='notificationPreferences']"
        );

        // Quotes link
        MyAccount.put("notificationPreferences_link", "//*[@id='myEQuotes']");
        MyAccount.put("requestAQuote_link", "//*[@id='myReqaQuote']");

        // Saved Baskets link
        MyAccount.put("savedBaskets_link", "//*[@id='savedBaskets']");

        //My Profile link
        MyAccount.put(
            "applyForTradeAccount_link",
            "(//a[contains(@href,'trade-account')])[1]"
        );

        //iBuy Admin
        MyAccount.put("iBuyAdmin_text", "//*[@id='accNav']//h4[text() = 'iBuy Admin']");

        MyAccount.put("iBuyMenu_list", "//li[*]/strong/parent::li/following-sibling::li");

        MyAccount.put("companyList_link", "//*[@id='companyList']");
        MyAccount.put("companyName_text", "//*[@id='accNav']//strong");
        MyAccount.put("addAccount_link", ".//*[@id='addAccount']");
        MyAccount.put("companyStructure_link", "//*[@id='companyStructure']");
        MyAccount.put("users_link", "//*[@id='users']");
        MyAccount.put("catalogRestrictions_link", "//*[@id='catalogRestrictions']");
        MyAccount.put("customization_link", "//*[@id='customization']");
        MyAccount.put("orders/Reports_link", "//*[@id='ordersReports']");
        MyAccount.put("editCompany_link", "//*[@id='editCompany']");
        MyAccount.put("importUsers_link", "//*[@id='importUsers']");
        MyAccount.put("addAccount_link", "//*[@id='addAccount']");
        MyAccount.put("retrieveInvoices_link", "//*[@id='eInvoicing']");
        
        MyAccount.put("approvePopUp_element", "//div[@class='actionBox actionFullWidth']/a[2]");
        MyAccount.put("viewNow_button", "//*[@class='actionBox actionFullWidth']/a[2]");
      

        MyAccount.put("", "");
        MyAccount.put("", "");
        MyAccount.put("", "");
        ////*[@id ='limitsAndBudgets']
        
        //Email Verification
        MyAccount.put("accountActivation_text", "//*[@class='loginSuccessHeader']");
        MyAccount.put("followingBenefit_text", "(//*[@class='loginSuccessTxt'])[1]");
        MyAccount.put("tradeAccount_text", "(//*[@class='loginSuccessTxt'])[2]");
        
    }

    public String findLocator(String elementName) {
        if (MyAccount.containsKey(elementName)) {
            return (MyAccount.get(elementName.trim()));
        }

        return null;
    }
}
