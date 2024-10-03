package StepDefinition.WEB;

import Common.UTILS.ContextStore;
import Common.UTILS.ScreenshotUtil;
import Common.UTILS.WebDriverConfig;
import StepDefinition.GENERIC.BaseSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.PathNotFoundException;

public class PLPSteps extends WebDriverConfig {

    private ContextStore context;
    private static final Logger logger = LogManager.getLogger(PLPSteps.class);
    private String anyValue;
    String FilePath = System.getProperty("user.dir") +
            "//src//test//resources//TestData//" +
            getEnv().toUpperCase() +
            "//";

    public PLPSteps(ContextStore context) {
        this.context = context;
    }

    @And("^I save the value of First Order code from PLP table$")
    public void save_first_order_code() throws Exception {
        this.context.ORDER_CODE = actionMethods.getValue("PLP.firstPurchasableOrderCode_text");
        this.context.scenario.log(
                "Value of purchasable Ordercode/SKU obtained: " + this.context.ORDER_CODE);
    }

    @Then("^I switched on Rohs window and verify customer name in application and Rohs Certificate$")
    public void switche_on_rohs_Window_and_verify_customer_name() throws Exception {
        // uiMethods.scrollToAnyWhere("Header.userFirstName_text");
        String Firstname = actionMethods
                .getValue("Header.userFirstName_text")
                .toLowerCase();
        logger.info("User Name from Header: " + Firstname);
        actionMethods.switchToWindow();
        uiMethods.scrollToAnyWhere("PLP.rohsCustomerName_text");
        String customernameOnCertificate = actionMethods
                .getValue("PLP.rohsCustomerName_text")
                .toLowerCase();
        logger.info("Customer Name from RoHSCertificate: " + customernameOnCertificate);
        Assert.assertTrue(customernameOnCertificate.contains(Firstname));
    }

    @Given("^.*verify \"([^\"]*)\" products are listed in products table \"([^\"]*)\"$")
    public void verify_number_of_product_display(int size, String locators)
            throws Exception {
        List<WebElement> checkBoxes = actionMethods.getMutipleLocators(locators);
        int countCheckbox = checkBoxes.size();
        Assert.assertEquals(
                size + " Items are not available on page",
                size,
                countCheckbox);
    }

    @And("^.* select instock sub radio button \"([^\"]*)\" if available")
    public void click_instock_sub_radio_button(String locator) throws Exception {
        if (!getStore().equalsIgnoreCase("uk")) {
            actionMethods.waitForElemenToGetRefreshed(
                    this.context.constants.getShortWaitSeconds(),
                    locator);
            actionMethods.click(locator);
        }
    }

    @And("^.* save the details of \"([^\"]*)\" product from PLP table")
    public void save_product_details(int numOfProducts) throws Exception {
        List<String> productDetails_list = new ArrayList<>();

        for (int i = 1; i <= numOfProducts; i++) {
            String orderCode_Xpath = actionMethods.getLocatorString("PLP.productRowPartial_element") +
                    "[" +
                    i +
                    "]" +
                    "/td[3]/p";
            productDetails_list.add(
                    actionMethods.getDriver().findElement(By.xpath(orderCode_Xpath)).getText());

            String manuName_xpath = actionMethods.getLocatorString("PLP.manufacturerName_text") +
                    "[" +
                    i +
                    "]";
            productDetails_list.add(
                    actionMethods.getDriver().findElement(By.xpath(manuName_xpath)).getText());

            String manuPartNo_xpath = actionMethods.getLocatorString("PLP.allManufacturerPartNo_link") +
                    "[" +
                    i +
                    "]";
            productDetails_list.add(
                    actionMethods
                            .getDriver()
                            .findElement(By.xpath(manuPartNo_xpath))
                            .getText());
        }
        this.context.productDetails.put("ProductDetails", productDetails_list);
        this.context.scenario.log(
                "Product details  obtained: " +
                        this.context.productDetails.get("ProductDetails"));
    }

    @And("^.* select first \"([^\"]*)\" checkbox from PLP table")
    public void select_checkbox(int numOfCheckbox) throws Exception {
        for (int i = 1; i <= numOfCheckbox; i++) {
            String orderCoder_Xpath = actionMethods.getLocatorString("PLP.allCompareCheck_checkbox") +
                    "[" +
                    i +
                    "]";
            actionMethods.getDriver().findElement(By.xpath(orderCoder_Xpath)).click();
        }
    }

    @Then("^.* verif.*product availability is \"([^\"]*)\" and get the.* for \"([^\"]*)\" part no and click on it$")
    public void product_availability(String availability, String partNo)
            throws Exception {
        String availability_value = storeText.getStoreText(availability);
        int totalProducts = actionMethods
                .getMutipleLocators("PLP.productRowPartial_element")
                .size();
        if (totalProducts > 0) {
            context.scenario.log("Entered in PLP Page");
            for (int i = 1; i <= totalProducts; i++) {
                String availability_Xpath = actionMethods.getLocatorString("PLP.productRowPartial_element") +
                        "[" +
                        i +
                        "]/td[5]/div/span[1]//p";
                System.out.println(
                        "value: " + driver.findElement(By.xpath(availability_Xpath)).getText());
                String availabilityType = driver
                        .findElement(By.xpath(availability_Xpath))
                        .getText();
                if (availabilityType.equalsIgnoreCase(availability_value)) {
                    String pdplink_xpath = actionMethods.getLocatorString("PLP.productRowPartial_element") +
                            "[" +
                            i +
                            "]/td[2]/a";
                    driver.findElement(By.xpath(pdplink_xpath)).click();
                    break;
                }
            }
        } else
            context.scenario.log("Entered in PDP Page");
    }

    @And("^.*click on random product link and navigate to PLP page$")
    public void randomProductLink_Click() throws Exception {
        for (int i = 0; i >= 0; i--) {
            Random r = new java.util.Random();
            List<WebElement> locator = actionMethods.getMutipleLocators(
                    "BrowseForProducts.allProducts_links");
            WebElement randomElement = locator.get(r.nextInt(locator.size()));
            randomElement.click();
            if (actionMethods.uiMethods.verifyElementExistence(
                    "PLP.firstManufacturerPartNo_link") == true) {
                this.context.scenario.log("In PLP Page");
            } else {
                actionMethods.uiMethods.scrollToAnyWhere(
                        "CategoryPage.showAllProducts_button");
                actionMethods.click("CategoryPage.showAllProducts_button");
                this.context.scenario.log("In PLP Page");
            }
        }
    }

    // Applicable only for EU Region (SD-2536)
    @And("^.*User Navigates to PLP of store \"([^\"]*)\" by searching \"([^\"]*)\"$")
    public void verifyAvnetLink(String store, String searchEle) throws Exception {
        String avnetLink = "//*[@class='avnetStocklink']";
        System.out.println(driver.getCurrentUrl() + searchEle);
        driver.get(driver.getCurrentUrl() + searchEle);

        List<WebElement> elementObj = driver.findElements(By.xpath(avnetLink));

        if (elementObj.size() <= 0) {
            this.context.scenario.log("Avnet Stock link has been removed form PLP");
        } else {
            Assert.fail();
        }
    }

    @And("^.*extract number value from text \"([^\"]*)\".*$")
    public void extractNumberFromText(String locator) throws Exception {
        String text = actionMethods.getValue(locator);
        String regex = "([0-9]+)";
        // Creating a pattern object
        Pattern pattern = Pattern.compile(regex);
        // Creating a Matcher object
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.print(matcher.group());
            anyValue = matcher.group();
        }
        logger.info("The value found is : " + anyValue);
        this.context.scenario.log(
                "The number found as of String is " + anyValue);
    }

    @And("^.*enter extracted number in \"([^\"]*)\" text box.*$")
    public void enterExtractedNumber(String locator) throws Exception {
        actionMethods.clearText(locator);
        actionMethods.enterText(anyValue, locator);
        this.context.scenario.log("Entered quantity " + anyValue);
    }

    @And("^.* verify text is equal to \"([^\"]*)\"$")
    public void verifyTextAreSame(String locator)
            throws Exception {
        String text = getLocator(locator).getAttribute("value");
        this.context.scenario.log("Expected value is " + anyValue + " and Actual value is " + text);
        Assert.assertEquals(text, anyValue);
    }

    @And("^validates only self referencing link in breadcrumb is displaying as text$")
    public void validate_breadcrumb() throws Exception {
        List<WebElement> locator = actionMethods.getMutipleLocators("Search.breadcrumbCount_list");
        int totalLinks = locator.size();
        String lastLink = actionMethods.getLocatorString("Search.breadcrumbCount_list") + "[" + totalLinks + "]/a";
        List<WebElement> link = driver.findElements(By.xpath(lastLink));
        System.out.println("Last link count: " + link.size());
        if (link.size() == 0) {
            this.context.scenario.log("Self referencing link in breadcrumb is displaying as text");
        } else {
            Assert.fail();
        }
        int totalBreadcrumbLinks = actionMethods.getMutipleLocators("Search.breadcrumbLinks_link").size();
        Assert.assertEquals(totalLinks-1, totalBreadcrumbLinks);
        this.context.scenario.log("***Other links except self referencing link in breadcrumb is displaying as links***");
    }

    @And("^I save the PLP category name in the PLP page$")
    public void save_category_header() throws Exception {
        String header = actionMethods.getLocatorString("PLP.header_text") + "/h1";
        this.context.CATEGORY_NAME = driver.findElement(By.xpath(header)).getText().trim();
        this.context.scenario.log(
                "Value of H1 in PLP page obtained: " + this.context.CATEGORY_NAME);
    }

    @Then("^.*validate.*PLP page header when.*\"([^\"]*)\" filter.*selected$")
    public void validate_pdp_header(String filterType) throws Exception {
        String header = actionMethods.getLocatorString("PLP.header_text") + "/h1";
        String actualHeader = driver.findElement(By.xpath(header)).getText().trim();
        if (filterType.equalsIgnoreCase("single valueable")) {
            String filterName = actionMethods.getValue("PLP.appliedFilterName_text").replace("=", "").trim();
            String expectedHeader = filterName + " " + this.context.CATEGORY_NAME;
            this.context.softAssertions.assertThat(actualHeader).isEqualTo(expectedHeader);
            context.scenario.attach(
                    ScreenshotUtil.getByteScreenshot(),
                    "image/png",
                    "screenshot");
            try {
                actionMethods.click("Filters.clearAllFilters_link");
                ContextStore.STUB_ENABLED = false;
            } catch (NoSuchElementException e) {
                this.context.scenario.log("****No Filter is available to test in this category****");
            }
        } else if (!ContextStore.STUB_ENABLED) {
            this.context.scenario
                    .log("****Skipping validation for " + filterType.toUpperCase() + " as filter is not available****");
        } else {
            this.context.softAssertions.assertThat(actualHeader).isEqualTo(this.context.CATEGORY_NAME);
            context.scenario.attach(
                    ScreenshotUtil.getByteScreenshot(),
                    "image/png",
                    "screenshot");
            try {
                actionMethods.click("Filters.clearAllFilters_link");
                ContextStore.STUB_ENABLED = false;
            } catch (NoSuchElementException e) {
                this.context.scenario.log("****No Filter is available to test in this category****");
            }
        }
    }

    @Then("^.*validate.*breadcrumb when.*filter is selected.*$")
    public void validate_breadcrumb_for_filter_applied() throws Exception {
        List<WebElement> breakcrumbs = actionMethods.getMutipleLocators("Search.breadcrumbCount_list");
        int lastBreadcrumbIndex = breakcrumbs.size();
        String lastBreadcrumb_xpath = actionMethods.getLocatorString("Search.breadcrumbCount_list") + "["
                + lastBreadcrumbIndex + "]";
        String lastBreadcrumbName = driver.findElement(By.xpath(lastBreadcrumb_xpath)).getText().replace("> ", "")
                .trim();
        if (driver.getCurrentUrl().contains("/w/")) {
            this.context.softAssertions.assertThat(lastBreadcrumbName).isEqualTo(this.context.CATEGORY_NAME);
            this.context.scenario
                    .log("****Search result page is worthless, hence breadcrumb name is same as category name****");
        } else {
            String expectedValue = driver.getTitle().split("\\|")[0].trim();
            this.context.softAssertions.assertThat(lastBreadcrumbName).isEqualTo(expectedValue);
        }
    }

    @Then("^validates applied filters are removed while clicking on previous breadcrumb link$")
    public void validate_filters_removed_when_clicked_on_prev_breadcrumb() throws Exception {
        List<WebElement> breakcrumbs = actionMethods.getMutipleLocators("Search.breadcrumbCount_list");
        int breadcrumbIndex = breakcrumbs.size() - 1;
        String breadcrumb_xpath = actionMethods.getLocatorString("Search.breadcrumbCount_list") + "[" + breadcrumbIndex
                + "]";

        if (uiMethods.isElementDisplayed("PLP.appliedFilter_element"))
            this.context.scenario.log("****Filters are applied before clicking on second last breadcrumb****");
        driver.findElement(By.xpath(breadcrumb_xpath)).click();
        actionMethods.waitForElementToDisappear(10, "PLP.appliedFilter_element");
        if (!uiMethods.isElementDisplayed("PLP.appliedFilter_element")
                && uiMethods.isElementDisplayed("PLP.header_text"))
            this.context.scenario.log("****Page is navigated to the category page and applied filters are removed****");
    }

    @And("^validates breadcrumb schema is updated as per applied filter$")
    public void validate_breadcrumb_schema() throws Exception {
        List<WebElement> breakcrumbs = actionMethods.getMutipleLocators("Search.breadcrumbCount_list");
        int breadcrumbIndex = breakcrumbs.size();
        String breadcrumb_xpath = actionMethods.getLocatorString("Search.breadcrumbCount_list") + "[" + breadcrumbIndex
                + "]";

        String newBreadcrumb = driver.findElement(By.xpath(breadcrumb_xpath)).getText().trim();
        List<String> breadcrumbItemList = new ArrayList<String>();

        JavascriptExecutor je = (JavascriptExecutor) driver;
        String schemaText = (String) je
                .executeScript("return document.querySelector('script[type=\"application/ld+json\"]').textContent");
        this.context.scenario.log("****Breadcrumb schema obtained after applying filters: " + schemaText + "****");
        DocumentContext jsonContext = JsonPath.parse(schemaText);
        int length = jsonContext.read("$.itemListElement.length()");
        for (int i = 0; i < length; i++) {
            try {
                breadcrumbItemList.add(jsonContext.read("$.itemListElement[" + i + "].item.name"));
            } catch (PathNotFoundException e) {
                break;
            }
        }
        if (driver.getCurrentUrl().contains("/w/")) {
            this.context.softAssertions.assertThat(breadcrumbItemList.contains(newBreadcrumb));
            this.context.scenario.log("****Current link is worthless hence no Filter name is added in the Schema****");
        } else {
            this.context.scenario
                    .log("****" + newBreadcrumb + ": present in schema list: " + breadcrumbItemList + "****");
            this.context.softAssertions.assertThat(breadcrumbItemList.contains(newBreadcrumb));
        }

    }

}
