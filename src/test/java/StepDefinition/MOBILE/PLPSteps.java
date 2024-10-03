package StepDefinition.MOBILE;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PLPSteps extends WebDriverConfig {

    private ContextStore context;
    String FilePath =
        System.getProperty("user.dir") +
        "//src//test//resources//TestData//" +
        getEnv().toUpperCase() +
        "//";
    String store = getStore();
    String env = getEnv();
    String region = getRegionName();

    public PLPSteps(ContextStore context) {
        this.context = context;
    }

    @And("^I verify dropdown list items in mobile \"([^\"]*)\" PLP page$")
    public void verify_list_options_PLP(String key) throws Exception {
        List<String> expListItems = new ArrayList<>();
        List<String> expTranslatedListItems = new ArrayList<>();
        List<String> actListItems = new ArrayList<>();
        String StoreValue = getStore().toLowerCase();
        switch (key.toLowerCase()) {
            case "plp sortby":
                // Mobile PLP
                expListItems = this.context.constants.getPLPSortListItems();
                System.out.println("ExpTransalatedList:");
                expListItems.forEach(d -> {
                    expTranslatedListItems.add(storeText.getStoreText(d));
                    System.out.println(storeText.getStoreText(d) + ",");
                });
                List<WebElement> actWebElementList = getMutipleLocators(
                    "PLP.sortByOptions_list"
                );
                System.out.println("ActualPLPList:");
                actWebElementList.forEach(e -> {
                    System.out.println("ActualTextDisplayed:" + e.getText() + ",");
                    String temp = e.getText().trim();
                    String actText = temp.replaceAll("\\s", "");
                    actListItems.add(actText);
                    System.out.println(actText + ",");
                });
                this.context.scenario.log(
                        "Actual list:" +
                        actListItems +
                        "Expected translated list:" +
                        expTranslatedListItems
                    );
                Assert.assertEquals(
                    "List items does not match",
                    expTranslatedListItems,
                    actListItems
                );
                break;
            default:
                this.context.scenario.log(key + "case not found");
        }
    }

    @And("^.*get the PLP Products found count before applying filters$")
    public void preFilterCount() throws Exception {
        actionMethods.waitForElementToAppear(
            this.context.constants.getShortWaitSeconds(),
            "Search.productsHeader_text"
        );
        this.context.scenario.log(actionMethods.getValue("Search.productsHeader_text"));
        this.context.PRE_FILTER_COUNT =
            actionMethods.getValue("Filters.filtersCount_text").replaceAll("[,'. ]", "");
    }

    @And("^.*verify the PLP Products found count after applying filters$")
    public void postFilterCount() throws Exception {
        actionMethods.waitForElementToAppear(
            this.context.constants.getShortWaitSeconds(),
            "Search.productsHeader_text"
        );
        this.context.scenario.log(actionMethods.getValue("Search.productsHeader_text"));
        this.context.POST_FILTER_COUNT =
            actionMethods.getValue("Filters.filtersCount_text").replaceAll("[,'. ]", "");
        if (store != "us") {
            Assert.assertTrue(
                "Filter is not selected",
                Integer.parseInt(this.context.POST_FILTER_COUNT) <
                Integer.parseInt(this.context.PRE_FILTER_COUNT)
            );
        }
    }

    @And("^I save the value of First Order code from PLP Page$")
    public void save_first_order_code() throws Exception {
        this.context.ORDER_CODE =
            actionMethods.getValue("PLP.firstPurchasableOrderCode_text");
        this.context.scenario.log(
                "Value of purchasable Ordercode/SKU obtained: " + this.context.ORDER_CODE
            );
    }

    @Then(
        "^.* verif.*product availability is \"([^\"]*)\" and get the.* for \"([^\"]*)\" part no and click on it in mobile$"
    )
    public void product_availability(String availability, String partNo)
        throws Exception {
        String availability_value = storeText.getStoreText(availability);
        List<WebElement> allProducts = actionMethods.getMutipleLocators(
            "PLP.productlist_element"
        );
        int totalProducts = allProducts.size();
        if (totalProducts > 0) {
            context.scenario.log("Entered in PLP Page");
            for (WebElement product : allProducts) {
                String availabilityType = actionMethods.getValue(
                    "PLP.availabilityType_text"
                );
                if (availabilityType.equalsIgnoreCase(availability_value)) {
                    actionMethods.getLocator("PLP.descriptionPage_link").click();
                    break;
                }
            }
        } else context.scenario.log("Entered in PDP Page");
    }

    @And ("^validates in mobile only self referencing link in breadcrumb is displaying as text$")
    public void validate_breadcrumb() throws Exception{
        List<WebElement> locator = actionMethods.getMutipleLocators("PLP.breadcrumb_link");
		if(locator.size() == 1){
            this.context.scenario.log("Other link except Self referencing link in breadcrumb is displaying as link in mobile");
        }else{
            Assert.fail();
        }
        String firstLink = actionMethods.getValue("PLP.breadcrumb_link").toLowerCase();
        String productName = actionMethods.getValue("PLP.category_text").toLowerCase();
        String wholeContent = actionMethods.getValue("PLP.body_element").toLowerCase();
        String expectedValue = firstLink + " < " + productName;
        System.out.println("Expected Value is :"+expectedValue);
        System.out.println("Whole content is :"+wholeContent);
        if(wholeContent.contains(expectedValue)){
            this.context.scenario.log("Self referencing link in breadcrumb is displaying as text in mobile");
        }else{
            Assert.fail(); 
        }
    }

    @Then ("^select.*from \"([^\"]*)\" which is having atleast \"([^\"]*)\" product$")
    public void click_random_manufacture_filter(String loc, int count) throws Exception{
        List<WebElement> locator = actionMethods.getMutipleLocators(loc);
        for (int i = 0; i < locator.size(); i++) {
            String productCount_str = locator.get(i).getText().trim().replaceAll("[^0-9]", "").replaceAll(" ", "");
            System.out.println("productstring: " + productCount_str);
            int productCount = Integer.parseInt(productCount_str);
            if (productCount > count) {
                System.out.println("productcount stored: " + productCount);
                int j = i + 1;
                String value = "(" + actionMethods.getLocatorString(loc) + ")[" + j + "]/parent::label";
                driver.findElement(By.xpath(value)).click();
                break;
            }
        }
    }

    @Then (".*unchecked the previosly selected filter.*\"([^\"]*)\"$")
    public void uncheck_filters(String loc) throws Exception{
        int totalFilters = actionMethods.getMutipleLocators(loc).size();
        if(totalFilters > 1){
            List<WebElement> filters = actionMethods.getMutipleLocators(loc);
            for(WebElement filter : filters){
                filter.click();
            }
        }else if(totalFilters == 0){
            this.context.scenario.log("No Filters are previously selected to uncheck");
        }else{
            actionMethods.getLocator(loc).click();
        }
    }
}
