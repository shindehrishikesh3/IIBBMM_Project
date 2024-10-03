package StepDefinition.WEB;

import static org.junit.Assume.assumeTrue;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import io.cucumber.java.en.And;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

public class OrderTrackingSteps extends WebDriverConfig {

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

    public OrderTrackingSteps(ContextStore context) {
        this.context = context;
    }

    @And("^Guest user submits the Order tracking details$")
    public void enter_order_details_form() throws Exception {
        if (
            !ContextStore.ORDER_TRACKING_ORDER_CONFIRMATION_NUM.matches(
                "^[a-zA-Z0-9\\s]{1,}$"
            )
        ) {
            assumeTrue(
                "The confirmation reference number is not in numeric format",
                false
            );
        } else {
            actionMethods.enterText(
                ContextStore.ORDER_TRACKING_EMAIL,
                "OrderTracking.emailaddress_textbox"
            );
            this.context.scenario.log(
                    "User entered email address: " + ContextStore.ORDER_TRACKING_EMAIL
                );
            actionMethods.enterText(
                ContextStore.ORDER_TRACKING_ORDER_CONFIRMATION_NUM,
                "OrderTracking.orderConfirmation_textbox"
            );
            this.context.scenario.log(
                    "User entered order confirmation number: " +
                    ContextStore.ORDER_TRACKING_ORDER_CONFIRMATION_NUM
                );
            actionMethods.enterText(
                ContextStore.ORDER_TRACKING_ZIPCODE,
                "OrderTracking.postcode_textbox"
            );
            this.context.scenario.log(
                    "User entered zipcode: " + ContextStore.ORDER_TRACKING_ZIPCODE
                );
        }

        // submit the order details form
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('FindSingleOrderDetail').submit();");
    }

    @And("^user verifies the Order Ref number on My Order details page$")
    public void match_order_ref_number() throws Exception {
        actionMethods.waitForElementToAppear(
            this.context.constants.getMediumWaitSeconds(),
            "OrderTracking.orderRefNum_text"
        );
        String getOrderRefFrommPage = actionMethods
            .getValue("OrderTracking.orderRefNum_text")
            .trim();

        this.context.scenario.log(
                "Actual Order Reference Number: " + getOrderRefFrommPage
            );

        this.context.scenario.log(
                "Expected Order Reference Number: " + ContextStore.ORDER_TRACKING_PO_NUM
            );

        Assert.assertTrue(
            "Order Ref numbers are not matching",
            getOrderRefFrommPage.equalsIgnoreCase(ContextStore.ORDER_TRACKING_PO_NUM)
        );
    }

    @And("^.*verify PO Number \"([^\"]*)\" of recently placed order.* \"([^\"]*)\"$")
    public void verifyText(String locator, String value) throws Exception {
        String act_Value = actionMethods.getValueUsingAttribute(locator, "innerText");
        logger.info("Actual value obtained from WebSite: " + act_Value);
        Assert.assertEquals(value, act_Value);
    }
}
