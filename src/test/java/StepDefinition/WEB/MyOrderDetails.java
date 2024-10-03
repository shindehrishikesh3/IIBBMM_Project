package StepDefinition.WEB;

import static org.junit.Assume.assumeTrue;

import java.util.List;

import Common.HELPERS.UIVerificationMethods;
import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class MyOrderDetails extends WebDriverConfig {

    private ContextStore context;
    private static final Logger logger = LogManager.getLogger(CheckoutSteps.class);
    String FilePath =
        System.getProperty("user.dir") +
        "//src//test//resources//TestData//" +
        getEnv().toUpperCase() +
        "//";

    String store = getStore();
    String env = getEnv();
    String region = getRegionName();

    public MyOrderDetails(ContextStore context) {
        this.context = context;
    }
    
    @Then("Verify that order details page is displayed")
    public void VerifyOrderDetailsPageDisplayed() {
    	Assert.assertTrue(
                "Order details page not displayed",
                uiMethods.isElementDisplayed("MyOrderDetails.viewAllOrders_button"));
    }
    
    @Then("Verify that Return CTA is available for returnable product")
    public void VerifyReturnCTA() {
    	Assert.assertTrue(
                "Return item CTA not displayed",
                uiMethods.isElementDisplayed("MyOrderDetails.retrunItems_button"));
    }
    
    @Then("Verify that {string} is available for returnable product")
    public void VerifyReturnMessageDisplayed(String returnMessage) throws Exception {
    	boolean bFlag = false;
    	List<WebElement> objReturnMessage = actionMethods.getMutipleLocators("MyOrderDetails.nonReturnableMessage_label");
    	for (int iLoop=0;iLoop<objReturnMessage.size();iLoop++) {
    		if (objReturnMessage.get(iLoop).getText().equalsIgnoreCase(returnMessage)) {
    			bFlag = true;
    			break;
    		}
    	}
    	Assert.assertTrue(
                "Non-returnable message "+returnMessage+" not displayed in my oder details page",
                bFlag==true);
    }
    
    @Then("Verify that {string} is available when return period expired")
    public void VerifyReturnPeriodEnded(String returnPeriodEnded) throws Exception {
    	boolean bFlag = false;
    	List<WebElement> objReturnMessage = actionMethods.getMutipleLocators("MyOrderDetails.returnPeriodExpired_label");
    	for (int iLoop=0;iLoop<objReturnMessage.size();iLoop++) {
    		if (objReturnMessage.get(iLoop).getText().equalsIgnoreCase(returnPeriodEnded)) {
    			bFlag = true;
    			break;
    		}
    	}
    	Assert.assertTrue(
                "Message "+returnPeriodEnded+" not displayed in my oder details page",
                bFlag==true);
    }
    
    @And("User enters {string},{string} and {string}")
    public void EnterOrderTrackingInfo(String orderConfirmationNumber, String emailaddress, String postcode) throws Exception {
    	actionMethods.enterText(emailaddress, "MyOrderDetails.emailAddress_text");
    	actionMethods.click("MyOrderDetails.emailAddress_text");
    	actionMethods.enterText(orderConfirmationNumber, "MyOrderDetails.orderConfirmationNumber_text");
    	actionMethods.click("MyOrderDetails.orderConfirmationNumber_text");
    	actionMethods.enterText(postcode, "MyOrderDetails.zipCode_text");
    	Thread.sleep(1000);
    	actionMethods.click("MyOrderDetails.zipCode_text");
    	actionMethods.pressTabKey("MyOrderDetails.zipCode_text");
    	Thread.sleep(10000);
    }
}
