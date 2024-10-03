package StepDefinition.MOBILE;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import com.fasterxml.jackson.databind.deser.std.StringArrayDeserializer;
import io.cucumber.java.en.And;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class OrderHistorySteps extends WebDriverConfig {

    private ContextStore context;
    String FilePath =
        System.getProperty("user.dir") +
        "//src//test//resources//TestData//" +
        getEnv().toUpperCase() +
        "//";

    public OrderHistorySteps(ContextStore context) {
        this.context = context;
    }

    @SuppressWarnings("static-access")
    @And("^.*recent order history table in mobile app is displayed.*$")
    public void verify_recent_order_table_in_my_account() throws Exception {
        long initialSeconds = actionMethods.getEpochSeconds();
        long currentSeconds = 0;
        do {
            currentSeconds = actionMethods.getEpochSeconds();
        } while (
            !(
                uiMethods.isElementDisplayed(
                    "OrderHistory.recentOrderHistoryTable_element"
                )
            ) ||
            ((currentSeconds - initialSeconds) >= 120)
        );
    }

    @And("^.*save.*order code.*\"([^\"]*)\"$")
    public void save_order_code(String loc) throws Exception {
        this.context.ORDER_CODE = actionMethods.getValue(loc);
        this.context.scenario.log(
                "Value of Ordercode obtained: " + this.context.ORDER_CODE
            );
    }

    @And(
        "^I verify whether same product from order history is reordered added to basket$"
    )
    public void verify_reordered_product() throws Exception {
        String ordercodes_xpath =
            "//*[@class='outlined-section basket-entry']/div[3]/div[1]/a";
        List<WebElement> ordercodes = driver.findElements(By.xpath(ordercodes_xpath));
        int total_ordercodes = ordercodes.size();
        System.out.println("Expected OrderCode: " + this.context.ORDER_CODE);
        if (ordercodes.size() > 1) {
            for (int i = 0; i < total_ordercodes; i++) {
                System.out.println("Current OrderCode: " + ordercodes.get(i).getText());
                if (ordercodes.get(i).getText().contains(this.context.ORDER_CODE)) {
                    Assert.assertTrue(true);
                }
            }
        } else {
            String actual_ordercode = driver
                .findElement(By.xpath(ordercodes_xpath))
                .getText()
                .trim();
            Assert.assertEquals(this.context.ORDER_CODE, actual_ordercode);
        }
    }

    @And("^.*checks if the order is shipped or not and save the order code$")
    public void save_order_code() throws Exception {
        try {
            this.context.ORDER_CODE =
                actionMethods.getValue("OrderHistory.orderCode_text");
            this.context.scenario.log(
                    "Value of Ordercode obtained: " + this.context.ORDER_CODE
                );
        } catch (Exception e) {
            if (e.getMessage() != null) {
                this.context.ORDER_CODE =
                    actionMethods.getValue("OrderHistory.shippedOrderCode_text");
                this.context.scenario.log(
                        "Value of Ordercode obtained: " + this.context.ORDER_CODE
                    );
            } else System.out.println(e.getMessage());
        }
    }
}
