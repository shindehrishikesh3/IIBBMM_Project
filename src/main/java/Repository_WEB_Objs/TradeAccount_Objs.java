package Repository_WEB_Objs;

import java.util.*;

public class TradeAccount_Objs {

    // Creation of HashMap
    private static final Map<String, String> TradeAccount;

    static {
        TradeAccount = new HashMap<String, String>();

        //Header section
        TradeAccount.put("headerTitle_element", "//h1");

        //Customer details section
        TradeAccount.put("firstName_textbox", "//input[@name='firstName']");
        TradeAccount.put("lastName_textbox", "//input[@name='lastName']");
        TradeAccount.put("jobRole_dropdown", "//select[@name='jobRole']");
        TradeAccount.put("contactEmailAddress_textbox", "//input[@name='contactEmail']");
        TradeAccount.put("accountType_dropdown", "//select[@name='accountType']");
        TradeAccount.put("averageMonthlySpend_textbox", "//input[@name='monthlySpend']");

        //Company details section
        TradeAccount.put(
            "companyTradingName_textbox",
            "//input[@name='fullCompanyName']"
        );
        TradeAccount.put(
            "companyRegistrationBusiness_textbox",
            "//input[@name='companyRegistration']"
        );
        TradeAccount.put("companyWebsite_textbox", "//input[@name='companyWebsite']");
        TradeAccount.put("existingAccountNumber_textbox", "//input[@name='accountOrID']");
        TradeAccount.put("legalTradingEntry_list", "//select[@name='legalEntity']");
        TradeAccount.put("landlinePhoneNumber_textbox", "//input[@name='landlinePhone']");
        TradeAccount.put("accountPayableEmail_textbox", "//input[@name='accountsEmail']");
        TradeAccount.put(
            "formVatNumberBuisness_textbox",
            "//input[@name='formVatNumber']"
        );

        //Invoice Address section
        TradeAccount.put("address1_textbox", "//input[@name='address1']");
        TradeAccount.put("address2_textbox", "//input[@name='address2']");
        TradeAccount.put("townCity_textbox", "//input[@name='town']");
        TradeAccount.put("county_textbox", "//input[@name='county']");
        TradeAccount.put("postcode_textbox", "//input[@name='postcode']");
        TradeAccount.put("country_dropdown", "//select[@name='country']");

        TradeAccount.put("submit_button", "//div[@class='actionBox labelLeft regAction']//input[@type='submit']");
        TradeAccount.put(
            "tradeAccountConfirmation_message",
            "(//div[contains(@id,'trade-account')]//h2)[1]"
        );
        TradeAccount.put("vatNum_textbox", "//input[@id='formVatNumber']");
    }

    public String findLocator(String elementName) {
        if (TradeAccount.containsKey(elementName)) {
            return (TradeAccount.get(elementName.trim()));
        }

        return null;
    }
}
