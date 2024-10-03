package StepDefinition.WEB;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import io.cucumber.java.en.And;

public class MyAccountOrderPrefSteps extends WebDriverConfig {

    private ContextStore context;

    public MyAccountOrderPrefSteps(ContextStore context) {
        this.context = context;
    }

    @And("^.*select Order Preferences in page$")
    public void select_order_Preferences() throws Exception {
        String cardNumber = null;
        String accountNumber = null;
        cardNumber = context.creditCardNum.substring(context.creditCardNum.length() - 4);
        if (getRegionName().equalsIgnoreCase("newark")) {
            accountNumber = context.tradeAccountNum;
            actionMethods.selectValueByText(
                "Card-" + cardNumber,
                "MyAccountOrderPref.paymentType_dropdown"
            );
            actionMethods.selectValueByIndex(
                3,
                "MyAccountOrderPref.prefDeliveryMethod_dropdown"
            );
            if (!store.equalsIgnoreCase("mexico")) {
                actionMethods.enterText(
                    accountNumber,
                    "MyAccountOrderPref.prefShipAccountNumber_textbox"
                );
            } else {
                actionMethods.selectValueByText(
                    "Premier",
                    "MyAccountOrderPref.prefDeliveryAddress_dropdown"
                );
            }
        } else {
            actionMethods.selectValueByText(
                "Card-" + cardNumber,
                "MyAccountOrderPref.paymentType_dropdown"
            );
            actionMethods.selectValueByIndex(
                1,
                "MyAccountOrderPref.prefDeliveryMethod_dropdown"
            );
        }
        actionMethods.selectValueByText(
            "Premier",
            "MyAccountOrderPref.prefDeliveryAddress_dropdown"
        );
        System.out.println("Account Number "+accountNumber);
    }
    
    @And("^.*Select Order Preferences as page.* \"([^\"]*)\"$")
    public void select_order_Preferences_paypal(String orderPreference) throws Exception {
        String cardNumber = null;
        String accountNumber = null;
        String Order_Preference="";
        if (orderPreference == "PayPal")
        {
        	Order_Preference = orderPreference;
        }else if(orderPreference == "Card-"){
        	Order_Preference = orderPreference+cardNumber;
        }
        
        cardNumber = context.creditCardNum.substring(context.creditCardNum.length() - 4);
        if (getRegionName().equalsIgnoreCase("newark")) {
            accountNumber = context.tradeAccountNum;
            actionMethods.selectValueByText(
            	orderPreference,
                "MyAccountOrderPref.paymentType_dropdown"
            );
            
            actionMethods.selectValueByText("2nd Day Air (For same day shipping order by 9:00 PM EST)", "MyAccountOrderPref.prefDeliveryMethod_dropdown");
//            actionMethods.selectValueByIndex(
//               3,
//               "MyAccountOrderPref.prefDeliveryMethod_dropdown"
//            );
            if (!store.equalsIgnoreCase("mexico")) {
                actionMethods.enterText(
                    accountNumber,
                    "MyAccountOrderPref.prefShipAccountNumber_textbox"
                );
            } else {
                actionMethods.selectValueByText(
                    "Premier",
                    "MyAccountOrderPref.prefDeliveryAddress_dropdown"
                );
            }
        } else {
            actionMethods.selectValueByText(
                "Card-" + cardNumber,
                "MyAccountOrderPref.paymentType_dropdown"
            );
            actionMethods.selectValueByIndex(
                1,
                "MyAccountOrderPref.prefDeliveryMethod_dropdown"
            );
        }
        actionMethods.selectValueByText(
            "Premier",
            "MyAccountOrderPref.prefDeliveryAddress_dropdown"
        );
    }
}
