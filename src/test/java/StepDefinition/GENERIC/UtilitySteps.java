package StepDefinition.GENERIC;

import Common.UTILS.ContextStore;
import Common.UTILS.ScreenshotUtil;
import Common.UTILS.WebDriverConfig;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.jayway.jsonpath.ReadContext;

public class UtilitySteps extends WebDriverConfig {

    WebDriver driver = getDriver();
    private static final Logger logger = LogManager.getLogger(UtilitySteps.class);

    private ContextStore context;

    public UtilitySteps(ContextStore context) {
        this.context = context;
    }

    @When("^I close browser$")
    public void closeBrowser() throws IOException {
        driver.close();
    }

    @When("^.*refresh browser.*$")
    public void refreshBrowser() throws IOException {
        driver.navigate().refresh();
    }

    @When("^I quit all browsers$")
    public void quitBrowser() throws IOException {
        driver.quit();
    }

    @When("^.*take screenshot.*$")
    public void takeScreenshot() throws IOException {
        context.scenario.attach(
            ScreenshotUtil.getByteScreenshot(),
            "image/png",
            "screenshot"
        );
    }

    @When("^.*navigate to \"(.*?)\" page$")
    public void navigateToPage(String valueToAppend) throws Throwable {
        String baseURL = getSiteBaseUrl();
        System.out.println("Base URL: " + baseURL);
        driver.get(baseURL + "/" + valueToAppend);
        System.out.println("Base URL after value append: " + baseURL + "/" + valueToAppend);
        this.context.scenario.log("Base URL after value append: " + baseURL + "/" + valueToAppend);
    }

    //updated version of "when I navigate to..."
    @When("^.*navigate to \"([^\"]*)\" page using details from json \"([^\"]*)\"$")
    public void navigateToPageUsingJson(String pageRef, String FileName) throws Exception {
	String FilePath = fileOperations.getEnvFolderPath();
    	String path = FilePath + FileName;
        ReadContext rx = JsonUtil.getJsonDocument(path);
        String valueToAppend = JsonUtil.getStringKeyValueFromStoreSpecificJson(rx, store, pageRef);
        if(valueToAppend==null){
		valueToAppend = JsonUtil.getStringKeyValueFromStoreSpecificJson(rx, getRegionName(), pageRef);
	}
	String baseURL = getSiteBaseUrl();
        System.out.println("Base URL: " + baseURL);
        driver.get(baseURL + "/" + valueToAppend);
        System.out.println("Base URL after value append: " + baseURL + "/" + valueToAppend);
        this.context.scenario.log("Base URL after value append: " + baseURL + "/" + valueToAppend);
    }

    @Then("^.*wait for \"(.*?)\" seconds$")
    public void waitForSeconds(Long sec) throws Throwable {
        Thread.sleep(sec * 1000);
    }

    @And("^.*wait \"(.*?)\" duration for \"(.*?)\" element to .*\"(.*?)\"$")
    public void waitForSeconds(String waitType, String locator, String criteria)
        throws Throwable {
        long sec = 0;
        if (waitType.equalsIgnoreCase("long")) {
            sec = this.context.constants.getLongWaitSeconds();
        } else if (waitType.equalsIgnoreCase("medium")) {
            sec = this.context.constants.getMediumWaitSeconds();
        } else {
            sec = this.context.constants.getShortWaitSeconds();
        }

        switch (criteria.toLowerCase()) {
            case "appear":
                actionMethods.waitForByElementToAppear(sec, locator);
                break;
            case "disappear":
                sec = this.context.constants.getShortWaitSeconds();
                actionMethods.waitForElementToDisappear(sec, locator);
                break;
        }
    }

    @And("^.*click.* \"([^\"]*)\" refreshed element$")
    public void clickOnRefreshedElement(String locator) throws Exception {
        actionMethods.waitForElemenToGetRefreshed(
            this.context.constants.getShortWaitSeconds(),
            locator
        );
        actionMethods.click(locator);
    }

    @And("^.*click.* \"([^\"]*)\"$")
    public void click(String locator) throws Exception {
        actionMethods.waitForElementToAppear(
            this.context.constants.getMediumWaitSeconds(),
            locator
        );
        actionMethods.click(locator);
    }

    @And("^.*click.* \"([^\"]*)\" without wait$")
    public void clickWithoutWait(String locator) throws Exception {
        actionMethods.click(locator);
    }

    /**
     *
     * @param locator element locator string
     * @param acceptedList Accepted values for region, europe, newark, apac. For store e.g. uk, de etc
     * @throws Exception
     */
    @And ("^.*click.* \"([^\"]*)\" only in \"([^\"]*)\" store/region$")
    public void clickElementOnlyInSpecificRegionStore(
        String locator,
        String acceptedList
    ) throws Exception {
        String[] regionarray = acceptedList.toLowerCase().split(",");
        String region = getRegionName().toLowerCase();
        String store = getStore().toLowerCase();
        if (
            Arrays.asList(regionarray).contains(region) ||
            Arrays.asList(regionarray).contains(store)
        ) {
        	uiMethods.scrollToAnyWhere(locator);
        	Thread.sleep(2000);
            actionMethods.click(locator);
        } else {
            context.scenario.log(
                String.format("Not applicable for this region/store:%s/%s", region, store)
            );
        }
    }
    
    @And ("^.*click.*\"([^\"]*)\" on any one.*$")
    public void clickRandomElement(String locator) throws Exception {
    	List<WebElement> ele = actionMethods.getMutipleLocators(locator);
    	Random r = new java.util.Random();
		ele.get(r.nextInt(ele.size())).click();
		
    }

    @And("^.*navigates to url \"([^\"]*)\"$")
    public void navigateToUrl(String url) {
        driver.get(url);
    }

    @And("^.*navigates back in the browser$")
    public void navigateBack() {
        driver.navigate().back();
    }

    @And("^.*click.* \"([^\"]*)\" using js$")
    public void clickUsingJs(String locator) throws Exception {
        actionMethods.waitForElementToAppear(
            this.context.constants.getMediumWaitSeconds(),
            locator
        );
        actionMethods.clickUsingJSExecutor(locator);
		logger.info("Clicked using js  : "+locator);
    }

    @And("^.*clears text from textbox \"([^\"]*)\"$")
    public void clearText(String locator) throws Exception {
        WebElement elementObj = getLocator(locator);
        elementObj.click();
        elementObj.clear();
    }

    // Method to enter single text in single text box
	@And("^.*enter.* value \"([^\"]*)\" in textbox \"([^\"]*)\"$")
	public void enterText(String value, String locator) throws Exception {
		String store = getStore().toLowerCase();
		if (uiMethods.isElementPresent(locator)) {
			actionMethods.enterText(value, locator);
		} else {
			context.scenario.log(String.format("Not applicable for %s store as element got changed", store));
		}
	}

    // Method to enter two values in single step
    @And(
        "^.*enter.* values \"([^\"]*)\" and \"([^\"]*)\" in textbox \"([^\"]*)\" and \"([^\"]*)\" respectively.$"
    )
    public void enterTwoText(
        String value1,
        String value2,
        String locator1,
        String locator2
    ) throws Exception {
        actionMethods.enterText(value1, locator1);
        actionMethods.enterText(value2, locator2);
    }

    @And("^.*scroll till \"([^\"]*)\"$")
    public void scrollToAnyWhere(String locator) throws Exception {
        uiMethods.scrollToAnyWhere(locator);
    }

    @And("^.*scroll to \"([^\"]*)\" and verify text \"([^\"]*)\" is present$")
    public void scrollAndVerifyText(String locator, String text) throws Exception {
        Boolean ActualText = uiMethods.ScrollAndVerifyText(locator, text);
        Assert.assertTrue(ActualText.equals(true));
    }

    @And("^.*select by visible text.* \"([^\"]*)\" from dropdown \"([^\"]*)\"$")
    public void selectValueByText(String name, String locator) throws Exception {
        actionMethods.selectValueByText(name, locator);
    }

    @And("^.*select by option.* \"([^\"]*)\" from dropdown \"([^\"]*)\"$")
    public void selectValueByValue(String option, String locator) throws Exception {
        actionMethods.selectValueByValue(option, locator);
    }

    @And("^.*select by index.* \"([^\"]*)\" from dropdown \"([^\"]*)\"$")
    public void selectValueByIndex(int index, String locator) throws Exception {
        actionMethods.selectValueByIndex(index, locator);
    }

    @And("^.*hover on element.* \"([^\"]*)\"$")
    public void clickAndHover(String locator) throws Exception {
        //        actionMethods.clickAndHover(locator);
        actionMethods.hoverOnElement(locator);
    }

    @And("^.*scroll down the page by pixels \"([^\"]*)\"$")
    public void scrollDownPage(double value) throws Exception {
        actionMethods.scrollDownPage(value);
    }

    @And("^.*scroll up the page by pixels \"([^\"]*)\"$")
    public void scrollUpPage(double value) throws Exception {
        actionMethods.scrollUpPage(value);
    }

    @And("^.*switch to .*window$")
    public void switchToWindow() {
        actionMethods.switchToWindow();
    }

    @And ("^.*closed.*child window.*back to parent window$")
    public void backToParentwindow() {
    	actionMethods.closeChildWindow();
    }

    @And("^.*wait \"([^\"]*)\" seconds for .*new window$")
    public void waitForNewWindow(int timeoutSeconds) {
        boolean flag = false;
        int counter = 0;
        while (!flag) {
            try {
                Set<String> winId = driver.getWindowHandles();
                if (winId.size() > 1) {
                    flag = true;
                    break;
                }
                Thread.sleep(1000);
                counter++;
                if (counter > timeoutSeconds) {
                    break;
                }
            } catch (Exception e) {
                logger.info("Timed out new window wait. " + e.getMessage());
                this.context.scenario.log("New window did not open");
            }
        }
    }

    @And("^.*switch to \"([^\"]*)\" frame$")
    public void switchToFrame(String locator) throws Exception {
        WebElement Frame = actionMethods.getLocator(locator);
        actionMethods.getDriver().switchTo().frame(Frame);
    }

    @And("^.*switch to default frame$")
    public void switchToDefault() throws Exception {
        actionMethods.getDriver().switchTo().defaultContent();
    }

    @And("^I press the tab key in \"([^\"]*)\"$")
    public void pressTabKey(String locator) throws Exception {
        actionMethods.pressTabKey(locator);
    }

    @And("^I press shift and tab in \"([^\"]*)\"$")
    public void pressShiftTabKey(String locator) throws Exception {
        actionMethods.pressShiftTabKey(locator);
    }

    @And("^I move to \"([^\"]*)\" OnOffset and click.$")
    public void click_On_cordinates(String Locator) throws Exception {
        Point point = getLocator(Locator).getLocation();
        int xcord = point.getX();
        System.out.println(
            "Position of the webelement from left side is " + xcord + " pixels"
        );
        int ycord = point.getY();
        actionMethods.clickOnOffset(xcord, ycord);
        System.out.println(
            "Position of the webelement from right side is " + ycord + " pixels"
        );
    }

    @And("^.*switch back to parent window$")
    public void switchToParentWindow() {
        actionMethods.switchToParentWindow();
    }

    @And("^.*click.* \"([^\"]*)\" for \"([^\"]*)\" region/store$")
	public void click(String locator, String region) throws Exception {
		String regionArray[] = region.toLowerCase().split(",");
		String regionName = getRegionName().toLowerCase();
		String store = getStore().toLowerCase();
		if (Arrays.asList(regionArray).contains(regionName) || Arrays.asList(regionArray).contains(store)) {
			actionMethods.waitForElementToAppear(this.context.constants.getMediumWaitSeconds(), locator);
			actionMethods.click(locator);
		}
	}

	@And("^.*select by visible text.* \"([^\"]*)\" from dropdown \"([^\"]*)\" for \"([^\"]*)\" region/store$")
	public void selectValueByText(String name, String locator, String region) throws Exception {
		String regionArray[] = region.toLowerCase().split(",");
		String regionName = getRegionName().toLowerCase();
		String store = getStore().toLowerCase();
		if (Arrays.asList(regionArray).contains(regionName) || Arrays.asList(regionArray).contains(store)) {
			actionMethods.selectValueByText(name, locator);
		}

	}

	@And("^.*enter.* value \"([^\"]*)\" in textbox \"([^\"]*)\" for \"([^\"]*)\" region/store$")
	public void enterText(String value, String locator,String region) throws Exception {
		String regionArray[] = region.toLowerCase().split(",");
		String regionName = getRegionName().toLowerCase();
		String store = getStore().toLowerCase();
		if (Arrays.asList(regionArray).contains(regionName) || Arrays.asList(regionArray).contains(store)) {
			actionMethods.enterText(value, locator);
		}

	}
		@When("^.*navigate to \"(.*?)\" page for \"([^\"]*)\"$")
    public void navigateToPageFromBaseURL(String valueToAppend, String Store) throws Throwable {

    	if (store.equalsIgnoreCase("cpc")) {
    		if (valueToAppend.equalsIgnoreCase("c/crystals-oscillators/crystals")) {
    			valueToAppend = "/c/electronic-electrical-components/crystals-oscillators/crystals";
    		} else {
    			this.context.scenario.log("unexpected page and store combination");
    		}
    	}
    	if (Store.equalsIgnoreCase("en-TW")) {
    		if (valueToAppend.equalsIgnoreCase("c/passive-components/capacitors")) {
    			valueToAppend = "/c/semiconductors-discretes/diodes";
    		} else {
    			this.context.scenario.log("unexpected page and store combination");
    		}
    	}
    	String baseURL = envConfig.getProperty(Store);
        System.out.println("Base URL: " + baseURL);
        driver.get(baseURL + "/" + valueToAppend);
        System.out.println(
            "Base URL after value append: " + baseURL + "/" + valueToAppend
        );

	}

	@And("^.*append link \"([^\"]*)\" to current URL")
	public void navigateToDerivedUrl(String derivedUrl) {
		String CurrentURL = driver.getCurrentUrl();
		String URL = CurrentURL + derivedUrl;
		driver.get(CurrentURL + derivedUrl);
		this.context.scenario.log("URL after value append: " + URL);

	}

}
