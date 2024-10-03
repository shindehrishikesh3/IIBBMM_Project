package StepDefinition.WEB;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import com.jayway.jsonpath.ReadContext;
import io.cucumber.java.en.And;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.openqa.selenium.By;

public class ShoppingCartSteps extends WebDriverConfig {

    private ContextStore context;
    String firstOrderCode;
    String firstOrderQuantity;

    public ShoppingCartSteps(ContextStore context) {
        this.context = context;
    }

    @And("^I enter the ordercode saved from PLP to update the basket to place order$")
    public void enter_saved_order_Code() throws Exception {
        actionMethods.enterText(
            this.context.ORDER_CODE,
            "ShoppingCart.firstOrderCode_textbox"
        );
    }

    @And("^.*enter \"([^\"]*)\" ordercode in quick add part number textbox$")
    public void enter_ordercode_of_type(String productType) throws Exception {
        ReadContext rx = JsonUtil.getJsonDocument(
            fileOperations.getEnvFolderPath() + "orderCodes.json"
        );
        this.context.ORDER_CODE = rx.read("$.data." + getStore() + "." + productType);
        actionMethods.enterText(
            this.context.ORDER_CODE,
            "ShoppingCart.firstOrderCode_textbox"
        );
    }

    @And(
        "^.*populate company details if B2Bonly store and click checkout without registering button"
    )
    public void guest_checkout_popup_company_name() throws Exception { // DE is the only B2Bonly store with guest checkout enabled, xcomreg flag B2B_ONLY=true
        if (getStore().equalsIgnoreCase("de") && appName.equalsIgnoreCase("web")) {
            actionMethods.enterText(
                this.context.constants.getCompanyName(),
                "ShoppingCart.companyNameGuestCheckout_textbox"
            );
            Thread.sleep(4000);
            actionMethods.clickUsingJSExecutor("ShoppingCart.confirmB2B_checkbox");
            this.context.scenario.log(
                    "Company name: " + this.context.constants.getCompanyName()
                );
            actionMethods.click("ShoppingCart.checkoutWithoutRegisteringB2B_button");
        } else {
            actionMethods.click("ShoppingCart.checkoutWithoutRegistering_button");
        }
    }

    @And("^.*clear items from shopping cart if any present$")
    public void clear_items_from_shoping_cart() throws Exception {
        actionMethods.click("Header.miniBasket_link");
        actionMethods.waitForByElementToAppear(
            this.context.constants.getLongWaitSeconds(),
            "ShoppingCart.shoppingBasket_text"
        );
        if (uiMethods.isElementDisplayed("ShoppingCart.firstProductOnCart_text")) {
            actionMethods.clickUsingJSExecutor("ShoppingCart.selectAll_link");
            actionMethods.click("ShoppingCart.deleteSelected_link");
	    actionMethods.waitForElementToDisappear(20, "ShoppingCart.loader_element");
        } else context.scenario.log("No items in Cart");
    }

    @And("^.*enter ordercode in textbox.* \"([^\"]*)\"$")
    public void enter_order_code(String locator) throws Exception {
        String expectedOrderCode = this.context.constants.getOrderCode();
        actionMethods.enterText(expectedOrderCode, locator);
    }

    @And("^.*save ordercode and quantity of firstorder in ShoppingCart")
    public void saveOrderCode() throws Exception {
        firstOrderCode = actionMethods.getValue("ShoppingCart.firstProductOnCart_text");
        firstOrderQuantity =
            actionMethods.getValueUsingAttribute(
                "ShoppingCart.quantityFirstProduct_textbox",
                "value"
            );
        this.context.scenario.log(
                "First Order Code is " +
                firstOrderCode +
                " and Quantity is " +
                firstOrderQuantity
            );
    }

    @And(
        "^.*verify orderCode and quantity of firstorder in ShoppingCart updated from Basket"
    )
    public void verifyOrderCode() throws Exception {
        String BasketfirstOrderCode = actionMethods.getValue(
            "ShoppingCart.firstProductOnCart_text"
        );
        String BasketfirstOrderQuantity = actionMethods.getValueUsingAttribute(
            "ShoppingCart.quantityFirstProduct_textbox",
            "value"
        );
        this.context.scenario.log(
                "From Basket First Order Code is " +
                BasketfirstOrderCode +
                " and Quantity is " +
                BasketfirstOrderQuantity
            );
        Assert.assertTrue(
            "Ordercode is not matched",
            firstOrderCode.equalsIgnoreCase(BasketfirstOrderCode)
        );
        Assert.assertTrue(
            "Ordercode is not matched",
            firstOrderQuantity.equalsIgnoreCase(BasketfirstOrderQuantity)
        );
    }

    @And("^I click on Create Schedule on Shopping cart page")
    public void createSchedule() throws Exception {
        actionMethods.clickUsingJSExecutor("ShoppingCart.createSchedule_button");
        if (getRegionName().equalsIgnoreCase("APAC")) {
            actionMethods.clickUsingJSExecutor("ShoppingCart.createSchedule_button");
            actionMethods.switchToWindow();
            Thread.sleep(5000);
            actionMethods.clickUsingJSExecutor("ShoppingCart.createSchedule_radio");
            actionMethods.click("ShoppingCart.okCreateSchedule_button");
        }
    }

    @And("^.*verify price is greater than the set limit i.e.* \"([^\"]*)\"$")
    public void price_greater_than_setLimit(String setLimitValue) throws Exception {
    	String  actualPrice;
    	actualPrice= actionMethods.getValueUsingAttribute("ShoppingCart.totalprice_element","data-amt");
    	if (getRegionName().equalsIgnoreCase("newark"))
    	{
    		  actualPrice = actionMethods.getValueUsingAttribute("ShoppingCart.subTotalPrice_element","data-amt");
    	} 	
    	
        Assert.assertTrue(
                "Total Price should be greater than the set limit",
                Float.parseFloat(setLimitValue) <=
                Float.parseFloat(actualPrice)
            );

    }
    @And("^.*verify price is less than the set limit i.e.* \"([^\"]*)\"$")
    public void price_less_than_setLimit(String setLimitValue) throws Exception {
    	String  actualPrice;
    	actualPrice= actionMethods.getValueUsingAttribute("ShoppingCart.totalprice_element","data-amt");
    	if (getRegionName().equalsIgnoreCase("newark"))
    	{
    		  actualPrice = actionMethods.getValueUsingAttribute("ShoppingCart.subTotalPrice_element","data-amt");
    	}
    	
        Assert.assertTrue(
                "Total Price should be lesser than the set limit",
                Float.parseFloat(setLimitValue) >=
                Float.parseFloat(actualPrice)
            );

    }

	@And("^.*verify that the product searched and added to BOM is available in basket$")
	public void verify_saved_order_Code() throws Exception {
		String OrderCode = this.context.constants.getOrderCode();
		String orderCode_xpath =actionMethods.getLocatorString("ShoppingCart.orderCodePartial_element") +OrderCode +"']";
		Assert.assertTrue(actionMethods.getDriver().findElement(By.xpath(orderCode_xpath)).isDisplayed());

	}
    
}
