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
import java.util.Set;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.Select;

public class FiltersSteps extends WebDriverConfig {

        private ContextStore context;
        String FilePath = System.getProperty("user.dir") +
                        "//src//test//resources//TestData//" +
                        getEnv().toUpperCase() +
                        "//";

        public FiltersSteps(ContextStore context) {
                this.context = context;
        }

        @And("^.*get the Products found count before applying filters$")
        public void preFilterCount() throws Exception {
                actionMethods.waitForElementToAppear(
                                this.context.constants.getShortWaitSeconds(),
                                "Search.productsHeader_text");
                this.context.scenario.log(actionMethods.getValue("Search.productsHeader_text"));
                this.context.PRE_FILTER_COUNT = actionMethods.getValue("Filters.filtersCount_text").replaceAll("[,'. ]",
                                "");
        }

        @And("^.*verify the Products found count after applying filters$")
        public void postFilterCount() throws Exception {
                actionMethods.waitForElementToAppear(
                                this.context.constants.getShortWaitSeconds(),
                                "Search.productsHeader_text");
                this.context.scenario.log(actionMethods.getValue("Search.productsHeader_text"));
                this.context.POST_FILTER_COUNT = actionMethods.getValue("Filters.filtersCount_text")
                                .replaceAll("[,'. ]", "");
                Assert.assertTrue(
                                "Filter is not selected",
                                Integer.parseInt(this.context.POST_FILTER_COUNT) != Integer
                                                .parseInt(this.context.PRE_FILTER_COUNT));
                context.scenario.attach(
                                ScreenshotUtil.getByteScreenshot(),
                                "image/png",
                                "post-filter");
        }

        @And("^.*verify the Products found count after clearing all the filters$")
        public void matchFilterCount() throws Exception {
                actionMethods.waitForElementToAppear(
                                this.context.constants.getShortWaitSeconds(),
                                "Search.productsHeader_text");
                this.context.scenario.log(actionMethods.getValue("Search.productsHeader_text"));
                this.context.POST_FILTER_COUNT = actionMethods.getValue("Filters.filtersCount_text")
                                .replaceAll("[,'. ]", "");
                Assert.assertTrue(
                                "Clear all filters is not giving right product count",
                                Integer.parseInt(this.context.POST_FILTER_COUNT) >= Integer
                                                .parseInt(this.context.PRE_FILTER_COUNT));
                context.scenario.attach(
                                ScreenshotUtil.getByteScreenshot(),
                                "image/png",
                                "post-filter");
        }

        // Below 2 methods will moved to generic methods prior discussions -- Divya
        @And("^.*get the products found count.*$")
        public void getProductCount() throws Exception {
                actionMethods.waitForElementToAppear(
                                this.context.constants.getShortWaitSeconds(),
                                "Search.productsHeader_text");
                this.context.scenario.log(actionMethods.getValue("Search.productsHeader_text"));
                this.context.ProductCount = actionMethods.getValue("Search.productsHeader_text").replaceAll("[,'. ]",
                                "");
        }

        @And("^.*verify the product count equal.*$")
        public void verfiyProductCountIsEqual() throws Exception {
                this.context.ProductCountInitial = this.context.ProductCount;
                actionMethods.waitForElementToAppear(
                                this.context.constants.getShortWaitSeconds(),
                                "Search.productsHeader_text");
                this.context.ProductCountLater = actionMethods.getValue("Search.productsHeader_text")
                                .replaceAll("[,'. ]", "");
                this.context.scenario.log(
                                "Initial Product Count :" + this.context.ProductCountInitial);
                this.context.scenario.log(
                                "Final Product Count :" + this.context.ProductCountLater);

                Assert.assertTrue(
                                "Product count is not matched",
                                this.context.ProductCountLater.equals(this.context.ProductCountInitial));
        }

        @And("^.*select any valuable filter having minimum \"([^\"]*)\" products$")
        public void select_valuable_filter(int count) throws Exception {
                try {
                        int idx = 0;
                        boolean flag = false;
                        uiMethods.scrollToAnyWhere("Filters.filterManufacturer_section");
                        Thread.sleep(2000);
                        List<WebElement> locators = actionMethods
                                        .getMutipleLocators("Filters.filterManufacturerOptions_element");

                        for (int i = 0; i < locators.size(); i++) {
                                try {
                                        String productCount_str = locators.get(i).getText().trim().split("\\(")[1]
                                                        .replaceAll(
                                                                        "[^0-9]",
                                                                        "");
                                        int productCount = Integer.parseInt(productCount_str);
                                        if (productCount > count) {
                                                idx = i;
                                                flag = true;
                                                ContextStore.STUB_ENABLED = true;
                                                break;
                                        }
                                } catch (ArrayIndexOutOfBoundsException e) {
                                        continue;
                                } catch (NumberFormatException e) {
                                        continue;
                                }
                        }
                        if (flag) {
                                actionMethods.selectValueByIndex(idx, "Filters.filterManufacturer_section");
                                actionMethods.waitForByElementToAppear(
                                                this.context.constants.getMediumWaitSeconds(),
                                                "Filters.showResult_button");
                                Thread.sleep(8000);
                                actionMethods.click("Filters.showResult_button");
                        } else
                                select_parametric_filter("valuable", count, "Filters.parmetricFilters_element");

                } catch (NoSuchElementException e) {
                        select_parametric_filter("valuable", count, "Filters.parmetricFilters_element");
                }
        }

        @And("^.*select any non valuable filter having minimum \"([^\"]*)\" products$")
        public void select_non_valuable_parametric_filter(int count) throws Exception {
                try {
                        select_parametric_filter("worthless", count, "Filters.parmetricFilters_element");
                } catch (NoSuchElementException e) {
                        select_packaging_filter(count);
                }
        }

        @And("^.*select any parametric valuable filter having minimum \"([^\"]*)\" products$")
        public void select_valuable_parametric_filter(int count) throws Exception {
                select_parametric_filter("valuable", count, "Filters.parmetricFilters_element");
        }

        @And ("^.*clears filter if clear link available$")
        public void clear_filter() throws Exception{
                try{
                        actionMethods.click("Filters.clearAllFilters_link");
                }catch(NoSuchElementException e){
                        this.context.scenario.log("No Filter applied to clear");
                }catch(ElementNotInteractableException e){
                        actionMethods.click("Filters.clearFilterCross_link");
                }
        }

        public void select_parametric_filter(String filterType, int count, String loc) throws Exception {
                List<WebElement> allParametricFilters = actionMethods.getMutipleLocators(loc);
                String allParametricFilters_xpath = actionMethods.getLocatorString(loc);
                int j = 0;
                boolean flag = false;
                JavascriptExecutor js = (JavascriptExecutor) getDriver();
                for (int i = 0; i < allParametricFilters.size(); i++) {
                        j = i + 1;
                        String filter_xpath = "(" + allParametricFilters_xpath + ")[" + j + "]";
                        WebElement ele = driver.findElement(By.xpath(filter_xpath));
                        String option_xpath = filter_xpath + "/option";
                        List<WebElement> options = driver.findElements(By.xpath(option_xpath));
                        js.executeScript("arguments[0].scrollIntoView(true);", ele);
                        Thread.sleep(2000);
                        for (int k = 0; k < options.size(); k++) {
                                String productCount_str = "";
                                int productCount;
                                try {
                                        productCount_str = options.get(k).getText().trim().split("\\(")[1]
                                                        .replaceAll("[^0-9]", "");
                                } catch (NumberFormatException e) {
                                        continue;
                                } catch (ArrayIndexOutOfBoundsException e) {
                                        this.context.scenario.log(
                                                        "****Unable to select any filter as No Filter present which is having product count more than 1****");
                                        break;
                                }
                                try {
                                        productCount = Integer.parseInt(productCount_str);
                                } catch (NumberFormatException e) {
                                        continue;
                                }
                                if (productCount >= count) {
                                        Select select = new Select(driver.findElement(By.xpath(filter_xpath)));
                                        select.selectByIndex(k);
                                        Thread.sleep(2000);
                                        String url = actionMethods.getValueUsingAttribute("Filters.showResult_button",
                                                        "href");
                                        if (filterType.equalsIgnoreCase("valuable") && !url.contains("/w/")) {
                                                actionMethods.click("Filters.showResult_button");
                                                flag = true;
                                                ContextStore.STUB_ENABLED = true;
                                                break;
                                        } else if (filterType.equalsIgnoreCase("worthless") && url.contains("/w/")) {
                                                actionMethods.click("Filters.showResult_button");
                                                flag = true;
                                                ContextStore.STUB_ENABLED = true;
                                                break;
                                        } else {
                                                actionMethods.click("Filters.clearAllFilters_link");
                                                Thread.sleep(5000);
                                                break;
                                        }
                                }

                        }
                        if (flag)
                                break;
                }
        }

        public void select_packaging_filter(int count) throws Exception {
                uiMethods.scrollToAnyWhere("Filters.packagingFilters_section");
                Thread.sleep(2000);
                List<WebElement> allPackagingFilters = actionMethods
                                .getMutipleLocators("Filters.packagingFilterOptions_element");
                for (int i = 0; i < allPackagingFilters.size(); i++) {
                        int j = i + 1;
                        String filter_str = actionMethods.getLocatorString("allPackagingFilters") + "[" + j + "]";
                        WebElement filter = driver.findElement(By.xpath(filter_str));
                        if (filter.getAttribute("disabled").equalsIgnoreCase("disabled"))
                                continue;
                        else {
                                String productCount_str = "";
                                try {
                                        productCount_str = filter.getText().trim().split("\\(")[1]
                                                        .replaceAll("[^0-9]", "");
                                } catch (NumberFormatException e) {
                                        continue;
                                }
                                int productCount = Integer.parseInt(productCount_str);
                                if (productCount >= count) {
                                        actionMethods.selectValueByIndex(i, "Filters.packagingFilters_section");
                                        ContextStore.STUB_ENABLED = true;
                                        break;
                                }
                        }
                }
        }

}
