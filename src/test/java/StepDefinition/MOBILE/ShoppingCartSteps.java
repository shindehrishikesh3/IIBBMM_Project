package StepDefinition.MOBILE;

import static org.junit.Assume.assumeTrue;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import io.cucumber.java.en.And;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

public class ShoppingCartSteps extends WebDriverConfig {

    private static final Logger logger = LogManager.getLogger(CheckoutSteps.class);
    private ContextStore context;
    String FilePath =
        System.getProperty("user.dir") +
        "//src//test//resources//TestData//" +
        getEnv().toUpperCase() +
        "//";

    public ShoppingCartSteps(ContextStore context) {
        this.context = context;
    }

    @And("^.*verify.*\"([^\"]*)\" does not match.*\"([^\"]*)\".*\"([^\"]*)\" attribute$")
    public void verify_shopping_cart_quantity(String loc1, String loc2, String attr)
        throws Exception {
        String EnteredQuantity = actionMethods.getValueUsingAttribute(loc1, attr);
        String OrderedQuantity = actionMethods.getValueUsingAttribute(loc2, attr);
        Assert.assertNotEquals(EnteredQuantity, OrderedQuantity);
    }

    @And(
        "^I enter \"([^\"]*)\" order Code in textbox \"([^\"]*)\" from file \"([^\"]*)\"$"
    )
    public void enter_order_code_in_shopping_cart_searchbar(
        String orderCode,
        String locator,
        String fileName
    ) throws Exception {
        String path = FilePath + fileName;
        List<Map<String, String>> testData = ExcelUtil.getData(path, getStore());
        String searchterm = testData.get(0).get(orderCode);
        if (searchterm == null || searchterm.equalsIgnoreCase("")) {
            assumeTrue(
                "Data missing.NA for this store. product Type:" + orderCode,
                false
            );
        } else {
            actionMethods.enterText(searchterm, locator);
            this.context.scenario.log("searchterm :" + searchterm);
        }
    }

    @And("^I verify error message from file \"([^\"]*)\" for \"([^\"]*)\" product$")
    public void verify_error_message_in_cart(String fileName, String product)
        throws Exception {
        String path = FilePath + fileName;
        List<Map<String, String>> testData = ExcelUtil.getData(path, getStore());
        String ExpectedMessage = testData.get(1).get(product);
        String ActualMessage = actionMethods.getValue("ShoppingCart.errorMessage_text");
        if (ExpectedMessage == null || ExpectedMessage.equalsIgnoreCase("")) {
            assumeTrue("No Error Messge is expected:", true);
        } else {
            Assert.assertTrue(ActualMessage.contains(ExpectedMessage));
            this.context.scenario.log(
                    "Error Message is played as :" +
                    ActualMessage +
                    " for " +
                    product +
                    " product"
                );
        }
    }

    @And("^.*clicked on \"([^\"]*)\" or \"([^\"]*)\".*dynamic element.*$")
    public void click_dynamic_element_based_on_stores(String loc1, String loc2)
        throws Exception {
        if (region.equalsIgnoreCase("eu")) {
            actionMethods.click(loc1);
        } else if (region.equalsIgnoreCase("newark")) {
            actionMethods.click(loc2);
        } else {
            actionMethods.click(loc1);
        }
    }
}
