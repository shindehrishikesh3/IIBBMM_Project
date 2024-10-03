package StepDefinition.WEB;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import io.cucumber.java.en.And;

public class PaypalSteps extends WebDriverConfig {

    //private ContextStore context;

    @SuppressWarnings("unused")
    private ContextStore context;

    public PaypalSteps(ContextStore context) {
        this.context = context;
    }

    @And("^.*Accept Cookies paypal Page")
    public void accept_cookies_paypal() throws Exception {
        actionMethods.scrollDownPage(500);
        actionMethods.click("CookieSetting.paypalPage_button");
    }

    @And("^.*Login Paypal$")
    public void enter_your_details() throws Exception {
    	if(!getEnv().equalsIgnoreCase("live")) {    		
    		actionMethods.enterText(
    				context.constants.getPaypalUsername(),
    				"Paypal.loginUserName_text"
    				);
    		this.context.scenario.log(
    				"Paypal Username:" + context.constants.getPaypalUsername()
    				);
    		actionMethods.click("Paypal.next_button");
    		actionMethods.enterText(
    				context.constants.getPaypalPassword(),
    				"Paypal.loginPassword_text"
    				);
    		this.context.scenario.log(
    				"Paypal Username:" + context.constants.getPaypalPassword()
    				);
    		actionMethods.click("Paypal.loginButton_button");
    		actionMethods.scrollDownPage(500);
    		if (uiMethods.isElementDisplayed("CookieSetting.paypalPage_button"))
            {
    			actionMethods.clickUsingJSExecutor("CookieSetting.paypalPage_button");
            }
    		Thread.sleep(3000);
    		actionMethods.clickUsingJSExecutor("Paypal.paymentSubmit_button");
    	}else {
    		context.scenario.log("NA for LIVE sites");
    	}
    }
}
