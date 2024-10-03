package StepDefinition.WEB;

import Common.UTILS.ContextStore;
import Common.UTILS.ScreenshotUtil;
import Common.UTILS.WebDriverConfig;
import StepDefinition.GENERIC.BaseSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public class EVoucherSteps extends WebDriverConfig {

    private ContextStore context;
    private static final Logger logger = LogManager.getLogger(EVoucherSteps.class);
    String FilePath =
        System.getProperty("user.dir") +
        "//src//test//resources//TestData//" +
        getEnv().toUpperCase() +
        "//";

    public EVoucherSteps(ContextStore context) {
        this.context = context;
    }

    @And("^.*get the Total Price before applying E-voucher$")
    public void pre_evoucher_price() throws Exception {
        String amount;
        if (!region.equalsIgnoreCase("NEWARK")) {
            actionMethods.waitForElementToAppear(
                this.context.constants.getShortWaitSeconds(),
                "ShoppingCart.totalprice_element"
            );
            this.context.scenario.log(
                    actionMethods.getValue("ShoppingCart.totalprice_element")
                );
            amount =
                actionMethods
                    .getValue("ShoppingCart.totalprice_element")
                    .replaceAll("[^0-9.]", "");
        } else {
            actionMethods.waitForElementToAppear(
                this.context.constants.getShortWaitSeconds(),
                "ShoppingCart.subTotalPrice_element"
            );
            this.context.scenario.log(
                    actionMethods.getValue("ShoppingCart.subTotalPrice_element")
                );
            amount =
                actionMethods
                    .getValue("ShoppingCart.subTotalPrice_element")
                    .replaceAll("[^0-9.]", "");
        }
        this.context.PRE_EVOUCHER_PRICE = actionMethods.getAmount(amount);
    }

    @And("^.*verify the Total Price after applying E-voucher$")
    public void post_evoucher_price() throws Exception {
        if (!region.equalsIgnoreCase("NEWARK")) {
            actionMethods.waitForElementToAppear(
                this.context.constants.getShortWaitSeconds(),
                "ShoppingCart.totalprice_element"
            );
            this.context.scenario.log(
                    actionMethods.getValue("ShoppingCart.totalprice_element")
                );
            this.context.POST_EVOUCHER_PRICE =
                actionMethods.getAmount(
                    actionMethods.getValue("ShoppingCart.totalprice_element")
                );
        } else {
            actionMethods.waitForElementToAppear(
                this.context.constants.getShortWaitSeconds(),
                "ShoppingCart.discountSubTotalMerchandise_element"
            );
            this.context.scenario.log(
                    actionMethods.getValue(
                        "ShoppingCart.discountSubTotalMerchandise_element"
                    )
                );
            this.context.POST_EVOUCHER_PRICE =
                actionMethods.getAmount(
                    actionMethods.getValue(
                        "ShoppingCart.discountSubTotalMerchandise_element"
                    )
                );
        }
        Assert.assertTrue(
            "Voucher Code is not applied",
            Double.parseDouble(this.context.POST_EVOUCHER_PRICE) <
            Double.parseDouble(this.context.PRE_EVOUCHER_PRICE)
        );
    }

    @And("^.*verify the Total Price after applying E-voucher in Checkout Page$")
    public void total_price_checkout() throws Exception {
        String priceOrderInfo;
        if (!region.equalsIgnoreCase("NEWARK")) {
            actionMethods.waitForElementToAppear(
                this.context.constants.getShortWaitSeconds(),
                "Checkout.totalprice_element"
            );
            this.context.scenario.log(
                    actionMethods.getValue("Checkout.totalprice_element")
                );
            priceOrderInfo =
                actionMethods.getAmount(
                    actionMethods.getValue("Checkout.totalprice_element")
                );
        } else {
            actionMethods.waitForElementToAppear(
                this.context.constants.getShortWaitSeconds(),
                "Checkout.merchandiseSubTotalPrice_element"
            );
            this.context.scenario.log(
                    actionMethods.getValue("Checkout.merchandiseSubTotalPrice_element")
                );
            priceOrderInfo =
                actionMethods.getAmount(
                    actionMethods.getValue("Checkout.merchandiseSubTotalPrice_element")
                );
        }
        Assert.assertTrue(
            "total price is not correct on order information page",
            this.context.POST_EVOUCHER_PRICE.equalsIgnoreCase(priceOrderInfo)
        );
    }

    @And("^.*enter E-voucher code in \"([^\"]*)\" using given file \"([^\"]*)\"$")
    public void enter_evocher_details(String locator, String FileName) throws Exception {
        String path = FilePath + FileName;
        List<Map<String, String>> testData = ExcelUtil.getData(path, store);
        String EVoucherCode = testData.get(0).get("EvoucherCode");
        logger.info("EVoucher code is: " + EVoucherCode);
        actionMethods.enterText(EVoucherCode, locator);
        context.scenario.log("Entered EVoucherCode : " + EVoucherCode);
    }
}
