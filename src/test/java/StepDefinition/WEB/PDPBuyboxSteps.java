package StepDefinition.WEB;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PDPBuyboxSteps extends WebDriverConfig {

    private ContextStore context;
    String FilePath =
        System.getProperty("user.dir") +
        "//src//test//resources//TestData//" +
        getEnv().toUpperCase() +
        "//";

    String store = getStore();
    String env = getEnv();
    String region = getRegionName();

    public PDPBuyboxSteps(ContextStore context) {
        this.context = context;
    }

    @Then("^.*verify cutoff time tooltip is present on \"([^\"]*)\" region website.*$")
    public void verify_cutoff_time_tooltip_specific(String regions) throws Exception {
        String[] regionarray = regions.split(",");
        String region = getRegionName();
        if (Arrays.asList(regionarray).contains(region)) {
            actionMethods.click("PDPBuyBox.cutOffTimeTooltip_icon");
            Assert.assertTrue(
                uiMethods.isElementDisplayed("PDPBuyBox.tooltipContent_text")
            );
            Assert.assertTrue(
                "Cut off time tooltip text is missing",
                !actionMethods.getValue("PDPBuyBox.tooltipContent_text").isEmpty()
            );
        } else {
            context.scenario.log("Not applicable for this region:" + region);
        }
    }

    @Then("^.*verify total price for entered quantity$")
    public void verify_total_price_in_buy_box() throws Exception {
        String actualTotalPriceLabel;
        String actualTotalPriceValue;

        if (
            getRegionName().equalsIgnoreCase("APAC") && !getStore().equalsIgnoreCase("cn")
        ) {
            Assert.assertTrue(
                "Total price text missing",
                uiMethods.isElementDisplayed("PDPBuyBox.totalPriceLabelIncVAT_text")
            );
            Assert.assertTrue(
                "Total price value missing",
                uiMethods.isElementDisplayed("PDPBuyBox.totalPriceIncVAT_text")
            );
            actualTotalPriceLabel =
                actionMethods.getValue("PDPBuyBox.totalPriceLabelIncVAT_text");
            actualTotalPriceValue =
                actionMethods.getValue("PDPBuyBox.totalPriceIncVAT_text");
        } else {
            Assert.assertTrue(
                "Total price text missing",
                uiMethods.isElementDisplayed("PDPBuyBox.totalPriceLabelExcVAT_text")
            );
            Assert.assertTrue(
                "Total price value missing",
                uiMethods.isElementDisplayed("PDPBuyBox.totalPriceExcVAT_text")
            );
            actualTotalPriceLabel =
                actionMethods.getValue("PDPBuyBox.totalPriceLabelExcVAT_text");
            actualTotalPriceValue =
                actionMethods.getValue("PDPBuyBox.totalPriceExcVAT_text");
        }
        this.context.scenario.log("Actual total price label " + actualTotalPriceLabel);
        this.context.scenario.log("actualTotalPriceValue:" + actualTotalPriceValue);
    }

    @Then("^.*verif.* MPN is displayed after the Manufacturername on.* container$")
    public void verify_manufacturer_name_for_NLM_products() throws Exception {
        String actualMfgName = actionMethods.getValue(
            "PDPBuyBox.nlmManufacturerName_text"
        );
        int totalSubstituteProducts = actionMethods
            .getMutipleLocators("PDP.alternativeProducts_list")
            .size();
        for (int i = 1; i <= totalSubstituteProducts; i++) {
            String partno_xpath =
                actionMethods.getLocatorString("PDP.alternativeProducts_list") +
                "[" +
                i +
                "]" +
                "//a[@class='skulink mfrnum']";
            String partNo = driver.findElement(By.xpath(partno_xpath)).getText().trim();
            String mfgName_xpath =
                actionMethods.getLocatorString("PDP.alternativeProducts_list") +
                "[" +
                i +
                "]" +
                "/div[@class='manu cell']/div/h3/a/p[1]";
            String mfgName = driver.findElement(By.xpath(mfgName_xpath)).getText().trim();
            String expectedMfgName = mfgName + "-" + partNo;
            if (actualMfgName.equalsIgnoreCase(expectedMfgName)) {
                Assert.assertTrue(true);
                this.context.scenario.log("Name displayed as: " + actualMfgName);
                this.context.scenario.log(
                        "MPN link is included on suggested alternative or exact alternative section"
                    );
            }
        }
    }

    @Then("Verify Was and Now prices on PDP buybox$")
    public void VerifyPricesOnPDPBuybox() {
        try {
            uiMethods.isElementDisplayed("PDPBuyBox.currentPrice_label");
            String PRE_PROMOTION_PRICE_PDP = actionMethods
                .getValue("PDPBuyBox.currentPrice_label")
                .replaceAll("[^0-9,]", "")
                .replace(',', '.')
                .replaceAll("\\s", "")
                .toString()
                .trim();
            this.context.scenario.log("buy now price" + PRE_PROMOTION_PRICE_PDP);

            uiMethods.isElementDisplayed("PDPBuyBox.wasPrice_label");
            String POST_PROMOTION_PRICE_PDP = actionMethods
                .getValue("PDPBuyBox.wasPrice_label")
                .replaceAll("[^0-9,]", "")
                .replace(',', '.')
                .replaceAll("\\s", "")
                .toString()
                .trim();
            this.context.scenario.log("was now price" + POST_PROMOTION_PRICE_PDP);

            Assert.assertTrue(
                "Promotion is not applied",
                Float.parseFloat(PRE_PROMOTION_PRICE_PDP) <=
                Float.parseFloat(POST_PROMOTION_PRICE_PDP)
            );
        } catch (Exception E) {
            Assert.assertFalse(
                "No Promotional Price is available for the product entered",
                true
            );
        }
    }
   
}
