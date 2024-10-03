package StepDefinition.WEB;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import io.cucumber.java.en.And;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;

public class CompareProductsSteps extends WebDriverConfig {

    private ContextStore context;
    String FilePath =
        System.getProperty("user.dir") +
        "//src//test//resources//TestData//" +
        getEnv().toUpperCase() +
        "//";

    public CompareProductsSteps(ContextStore context) {
        this.context = context;
    }

    @And(
        "^.* compare the saved details of \"([^\\\"]*)\" products from PLP table with compare product page"
    )
    public void compare_saved_OrderCode(int numOfProducts) throws Exception {
        for (int i = 2; i <= numOfProducts + 1; i++) {
            String orderCode_Xpath =
                actionMethods.getLocatorString("CompareProducts.orderCode_text") +
                "[" +
                i +
                "]" +
                "/a";
            String orderCode = actionMethods
                .getDriver()
                .findElement(By.xpath(orderCode_Xpath))
                .getText();
            Assert.assertTrue(
                "Order Code is missing",
                this.context.productDetails.get("ProductDetails").contains(orderCode)
            );

            String manuPartNo_xpath =
                actionMethods.getLocatorString(
                    "CompareProducts.manufacturerAndPartNumber_text"
                ) +
                "[" +
                i +
                "]" +
                "/a";
            String manuPartNo = actionMethods
                .getDriver()
                .findElement(By.xpath(manuPartNo_xpath))
                .getText();
            Assert.assertTrue(
                "Manufacturer Part Number is missing",
                this.context.productDetails.get("ProductDetails").contains(manuPartNo)
            );

            String manuName_xpath =
                actionMethods.getLocatorString(
                    "CompareProducts.manufacturerAndPartNumber_text"
                ) +
                "[" +
                i +
                "]";
            String manuName = actionMethods
                .getDriver()
                .findElement(By.xpath(manuName_xpath))
                .getAttribute("innerText");
            String Text = manuName.split("\n+")[0];
            Assert.assertTrue(
                "Manufacturer name is missing",
                this.context.productDetails.get("ProductDetails").contains(Text)
            );
        }
    }
}
