package StepDefinition.GENERIC;

import static org.junit.Assert.assertTrue;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Arrays;
import java.util.List;
import java.util.List;
import java.util.Map;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.Color;

public class CosmeticSteps extends WebDriverConfig {

	/*
	 * Need to revisit Assertion method for validation of CSS changes
	 */
	private ContextStore context;
	private static final Logger logger = LogManager.getLogger(CosmeticSteps.class);

	public CosmeticSteps(ContextStore context) {
		this.context = context;
	}

	/* <--Value to be passed in Order- colorName, colorValue, locator------> */
	@And("^.*verify text color of.* as \"([^\"]*)\"$")
	public void getTextColor(String Value) throws Exception {
		String[] textColor = Value.split(",");
		String color = textColor[0], colorValue = textColor[1], locator = textColor[2];
		String hexColor = uiMethods.getTextColor(color, colorValue, locator);
		Assert.assertTrue("color are not correct", colorValue.trim().equalsIgnoreCase(hexColor));
	}

	/* <--Value to be passed in Order- colorName, colorValue, locator------> */
	@And("^.*verify background color of.* as \"([^\"]*)\"$")
	public void verifyBackgroundColor(String Value) throws Exception {
		String[] textColor = Value.split(",");
		String color = textColor[0], colorValue = textColor[1], locator = textColor[2];
		String ColorOfContainer = uiMethods.verifyBackgroundColor(color, colorValue, locator);
		Assert.assertTrue("The color of the Background is not matching",
				ColorOfContainer.equalsIgnoreCase(colorValue.trim()));
	}

	/* <--Value to be passed in Order- colorName, colorValue, locator------> */
	@And("^.*verify border color of.* as \"([^\"]*)\"$")
	public void verifyBorderColor(String Value) throws Exception {
		String[] textColor = Value.split(",");
		String color = textColor[0], colorValue = textColor[1], locator = textColor[2];
		String ColorOfContainer = uiMethods.verifyBorderColor(color, colorValue, locator);
		Assert.assertTrue("The color of the border is not matching",
				ColorOfContainer.equalsIgnoreCase(colorValue.trim()));
	}

	@And("^.*verify text of.* is Bold \"([^\"]*)\"$")
	public void verifySentenceIsBOLD(String locator) throws Exception {
		Boolean isBold = uiMethods.verifySentenceIsBold(locator);
		Assert.assertTrue("word is not bold", isBold);
	}

	@And("^.*verify text of.* is Not Bold \"([^\"]*)\"$")
	public void verifySentenceIsNOTBOLD(String locator) throws Exception {
		Boolean isBold = uiMethods.verifySentenceIsNOTBold(locator);
		Assert.assertFalse("word is bold incorrectly", isBold);
	}

	// Important Method 1
	@And("^.*verify text \"([^\"]*)\" is visible for \"([^\"]*)\"$")
	public void verifyTextExistence(String text, String locator) throws Exception {
		Assert.assertTrue(uiMethods.verifyTextExistence(text, locator));
	}

	// Important Method 1
	@And("^.*verify text \"([^\"]*)\" is NOT visible for \"([^\"]*)\"$")
	public void verifyTextNONExistence(String text, String locator) throws Exception {
		Boolean value = uiMethods.verifyTextExistence(text, locator);
		Assert.assertFalse(value);
	}

	// Important Method 3
	@And("^.*verify element \"([^\"]*)\" is visible in DOM$")
	public void verifyElementAttachedInDom(String locator) throws Exception {
		Boolean value = uiMethods.verifyElementExistence(locator);
		Assert.assertTrue(value);
	}

	// Important Method 3
	@And("^.*verify element \"([^\"]*)\" is not visible in DOM$")
	public void verifyElementNOTAttachedInDom(String locator) throws Exception {
		Boolean value = uiMethods.verifyElementExistence(locator);
		Assert.assertFalse(value);
	}

	// Define the element to be searched in this format :
	// ("class=\"cadViewerTitle\"") in Obj class
	@And("^.*verify element \"([^\"]*)\" is visible in accordian element \"([^\"]*)\"$")
	public void elementIsPresentInElement(String loactorToSearch, String locator) throws Exception {
		Boolean value = uiMethods.verifyPresenceOfXpath(loactorToSearch, locator);
		Assert.assertTrue(value);
	}

	// Define the element to be searched in this format :
	// ("class=\"cadViewerTitle\"") in Obj class
	@And("^.*verify element \"([^\"]*)\" is not visible in accordian element \"([^\"]*)\"$")
	public void elementIsNOTPresentInElement(String loactorToSearch, String locator) throws Exception {
		Boolean value = uiMethods.verifyPresenceOfXpath(loactorToSearch, locator);
		Assert.assertFalse(value);
	}

	@And("^.*link \"([^\"]*)\" is present.*$")
	public void verifyLinkIsPresent(String locator) throws Exception {
		Boolean value = uiMethods.verifyLinkIsPresent(locator);
		Assert.assertTrue(value);
	}

	@And("^.*text \"([^\"]*)\" is aligned as \"([^\"]*)\"$")
	public void verifyAlignmentOfText(String locator, String expectedAlignment) throws Exception {
		String ActualAlignment = uiMethods.verifyAlignmentOfText(locator, expectedAlignment);
		Assert.assertTrue("The Alignment of text matches the expected",
				ActualAlignment.trim().equalsIgnoreCase(expectedAlignment.trim()));
	}

	@And("^.*font size of text \"([^\"]*)\" as \"([^\"]*)\"$")
	public void verifyFontSizeOfText(String locator, String ExpectedFontSize) throws Exception {
		String ActualFontSize = uiMethods.verifyFontSizeOfText(locator, ExpectedFontSize);
		Assert.assertTrue("Font Size of text doesn't matches the expected",
				ActualFontSize.trim().equalsIgnoreCase(ExpectedFontSize.trim()));
	}

	@And("^.*verify if both Horizontal & Vertical scroll bar are present in a page$")
	public void V_HScroll() throws Exception {
		String value = uiMethods.checkforScrollPresent();
		Assert.assertTrue(value.equalsIgnoreCase("Both Vertical and Horizontal"));
	}

	@And("^.*verify if none of the Horizontal & Vertical scroll bar are present in a page$")
	public void No_V_HScroll() throws Exception {
		String value = uiMethods.checkforScrollPresent();
		Assert.assertTrue(value.equalsIgnoreCase("No Horizontal No Vertical"));
	}

	@And("^.*verify if only Horizontal bar is present in a page$")
	public void Only_HScroll() throws Exception {
		String value = uiMethods.checkforScrollPresent();
		Assert.assertTrue(value.equalsIgnoreCase("Only Horizontal"));
	}

	@And("^.*verify if only Vertical bar is present in a page$")
	public void Only_VScroll() throws Exception {
		String value = uiMethods.checkforScrollPresent();
		Assert.assertTrue(value.equalsIgnoreCase("Only Vertical"));
	}

	@And("^.*element \"([^\"]*)\" is present on page$")
	public void verifyElementIsDispalyed(String locator) throws Exception {
		logger.info("verify element is displayed:"+locator);
		actionMethods.waitForByElementToAppear(this.context.constants.getMediumWaitSeconds(), locator);
		Boolean value = uiMethods.isElementDisplayed(locator);
		Assert.assertTrue(value);		
	}

	@And("^.*verify absence of element \"([^\"]*)\"$")
	public void verifyAbsenceOfElement(String locator) throws Exception {
//		actionMethods.waitForElementToAppear(this.context.constants.getMediumWaitSeconds(), locator);
		Boolean value = uiMethods.isElementDisplayed(locator);
		Assert.assertFalse("Element is incorrectly present on page", value);
	}

	@And("^.*element \"([^\"]*)\" is present on page and display.*in report$")
	public void verifyElementIsPresentAndDisplayInReport(String locator)
			throws Exception {
		actionMethods.waitForElementToAppear(
				this.context.constants.getMediumWaitSeconds(),
				locator
				);
		Assert.assertTrue(uiMethods.isElementDisplayed(locator));
		String value = actionMethods.getValue(locator);
		Assert.assertFalse("Text is missing", value.isEmpty());
		this.context.scenario.log("The value of the element verified on page: " + value);
	}

	@And("^.*element \"([^\"]*)\" is present on page except in \"([^\"]*)\" region/store.*$")
	public void verifyElementIsPresentExceptSite(String locator, String exceptList)
			throws Exception {

		String[] regionStoreArray = exceptList.toLowerCase().split(",");
		String region = getRegionName().toLowerCase();
		String store = getStore().toLowerCase();
		System.out.println("Except List: " + Arrays.asList(regionStoreArray));
		if (
				!Arrays.asList(regionStoreArray).contains(region) &&
				!Arrays.asList(regionStoreArray).contains(store)
				) {
			System.out.println("Region: " + region);
			System.out.println("Store: " + store);
			verifyElementIsPresentAndDisplayInReport(locator);
		} else {
			context.scenario.log("Not applicable for region/store list: " + exceptList);
		}
	}


	@Then("^.*verify below are displayed in .*\"([^\"]*)\" table.*$")
	public void verifyListContainsText(String locators, DataTable table) throws Exception {
		actionMethods.waitForElementToAppear(this.context.constants.getMediumWaitSeconds(), locators);
		List<String> expProdDesrList = table.asList(String.class);
		List<String> expProdDesrListTranslated = new ArrayList<String>();
		List<WebElement> actWebElementList = actionMethods.getMutipleLocators(locators);
		List<String> actProdDesrList = new ArrayList<String>();
		for (String element : expProdDesrList) {
			if (element.equalsIgnoreCase("Browser Search Tools") && store.equalsIgnoreCase("fr"))
				continue;
			if (!(element.equalsIgnoreCase("n/a") || element.equalsIgnoreCase("NA"))) {
				expProdDesrListTranslated.add(storeText.getStoreText(element));
			}

		}
		for (WebElement element : actWebElementList) {
			actProdDesrList.add(element.getText().replace(":", "").replace("：", "").trim());
		}
		context.scenario.log("actual list:" + actProdDesrList + "\n should atleast have \n expected elements:"
				+ expProdDesrListTranslated);
		Assert.assertTrue("Product description is wrong", actProdDesrList.containsAll(expProdDesrListTranslated));
	}

	@Then("^.*verify values in the \"([^\"]*)\" table are not empty$")
	public void verifyValuesInTableNonEmpty(String locators) throws Exception {
		List<WebElement> welist = actionMethods.getMutipleLocators(locators);
		for (WebElement element : welist) {
			Assert.assertTrue("Text is missing", !element.getText().isEmpty());
		}
	}

	/**
	 * Verify presence of elements only for the acceptedList of regions/stores
	 *
	 * @param locator
	 * @param acceptedList should be a comma separated list of regions/stores
	 * @throws Exception
	 */
	@Then("^.*verify element \"([^\"]*)\" is present on \"([^\"]*)\" region/store.*$")
	public void verifyElementOnlyDisplayedInspecificRegionStore(String locator, String acceptedList) throws Exception {
		String[] regionarray = acceptedList.toLowerCase().split(",");
		String region = getRegionName().toLowerCase();
		String store = getStore().toLowerCase();
		if (Arrays.asList(regionarray).contains(region) || Arrays.asList(regionarray).contains(store)) {
			Assert.assertTrue(uiMethods.isElementDisplayed(locator));
		} else {
			context.scenario.log(String.format("Not applicable for this region/store:%s/%s", region, store));
		}
	}

	/**
	 * Verify presence of element everywhere except in the given list of
	 * stores/regions
	 *
	 * @param locator
	 * @param exceptList should contain comma separated region or stores
	 * @throws Exception
	 */
	@Then("^.*verify element \"([^\"]*)\" is present except in \"([^\"]*)\" region/store.*$")
	public void verifyElementDisplayedExceptInSpecificRegionStore(String locator, String exceptList) throws Exception {
		String[] regionStoreArray = exceptList.toLowerCase().split(",");
		String region = getRegionName().toLowerCase();
		String store = getStore().toLowerCase();
		System.out.println("Except List: " + Arrays.asList(regionStoreArray));
		if (!Arrays.asList(regionStoreArray).contains(region) && !Arrays.asList(regionStoreArray).contains(store)) {
			System.out.println("Region: " + region);
			System.out.println("Store: " + store);
			actionMethods.waitForElementToAppear(this.context.constants.getMediumWaitSeconds(), locator);
			Assert.assertTrue(uiMethods.isElementDisplayed(locator));
		} else {
			context.scenario.log("Not applicable for region/store list:" + exceptList);
		}
	}

	// Method to verify the exact text on page(for text in mutiple tags)
	@And("^.*verify the message \"([^\"]*)\" is present in multiple tags using innertext in page \"([^\"]*)\"$")
	public void verifyTextUsingInnerText(String value, String locator) throws Exception {
		String exp_Value = storeText.getStoreText(value);
		String act_Value = actionMethods.getMultipleValuesInTag(locator);
		logger.info("Actual text obtained from the page: " + act_Value);
		Assert.assertTrue("Partial text matching is failing", act_Value.contains(exp_Value));
	}

	// Method to verify the exact text on page(it will handle the equivalent
	// translated text for non-english store)
	@And("^.*verify text.* \"([^\"]*)\" in page \"([^\"]*)\"$")
	public void verifyText(String value, String locator) throws Exception {
		String exp_Value = storeText.getStoreText(value);
		String act_Value = actionMethods.getValue(locator);
		logger.info("Actual text obtained from the page: " + act_Value);
		Assert.assertEquals(exp_Value, act_Value);
	}

	// Method to verify the partial text on page(it will handle the equivalent
	// translated text for non-english store)
	@And("^.*verify.*contains.* \"([^\"]*)\" .*in.* \"([^\"]*)\"$")
	public void verifyPartialText(String value, String locator) throws Exception {
		actionMethods.waitForByElementToAppear(this.context.constants.getShortWaitSeconds(), locator);
		WebElement elementObj = getLocator(locator);
		String exp_Value = storeText.getStoreText(value);
		actionMethods.waitForAttributeToContain(this.context.constants.getShortWaitSeconds(), locator, "innerText",
				exp_Value);
		String act_Value = elementObj.getText();
		logger.info("Actual text obtained from the page: " + act_Value);
		Assert.assertTrue("Partial string is not present in the expected message", act_Value.contains(exp_Value));
	}

	@And("^.*element \"([^\"]*)\" is selected on page$")
	public void verifyElementIsSelected(String locator) throws Exception {
		actionMethods.waitForElementToAppear(this.context.constants.getMediumWaitSeconds(), locator);
		Boolean value = uiMethods.isElementSelected(locator);
		Assert.assertTrue(value);
	}

	// Method to verify the exact text(with Attribute) on page(it will handle
	// the equivalent translated text for non-English store
	// also handles checking values of other parts of same elements

	@And("^.*verify text.* \"([^\"]*)\" in page \"([^\"]*)\" with attribute \"([^\"]*)\"$")
	public void verifyTextwithAttribute(String ExpectedText, String locator, String attribute) throws Exception {
		String exp_Value = storeText.getStoreText(ExpectedText);
		logger.info("Expected value: " + exp_Value);
		String act_Value = actionMethods.getValueUsingAttribute(locator, attribute);
		logger.info("Actual text obtained from the page: " + act_Value);
		Assert.assertEquals(exp_Value, act_Value);
	}

	@And("^verify url parameter value as \"([^\"]*)\"$")
	public void verifyCurrentUrlContainsString(String text) throws Exception {
		String exp_Value = storeText.getStoreText(text);
		String actualvalue = driver.getCurrentUrl();
		String baseurl = getSiteBaseUrl();
		Assert.assertEquals(actualvalue, baseurl.concat(exp_Value));
	}

	@And("^.*verif.*current url contains \"([^\"]*)\".*$")
	public void verify_current_url_contains_string(String value) throws Exception {
		String text = storeText.getStoreText(value);
		String act_Value = driver.getCurrentUrl();
		logger.info("Value of the current URL: " + act_Value);
		Assert.assertTrue("string is not present in the URL ", act_Value.contains(text));
	}

	@And("^.*verify current url doesnot contain \"([^\"]*)\".*$")
	public void verify_current_url_doesnotcontain_string(String text) throws Exception {
		String act_Value = driver.getCurrentUrl();
		logger.info("Value of the current URL: " + act_Value);
		Assert.assertFalse("Paramter is present in the URL ", act_Value.contains(text));
	}

	@And("^.*verify text.* \"([^\"]*)\" in page \"([^\"]*)\" from file \"([^\"]*)\"$")
	public void verifyTextFromExcelFile(String KeyName, String locator, String FileName) throws Exception {
		String path = System.getProperty("user.dir") + "//src//test//resources//TestData//" + getEnv().toUpperCase()
				+ "//" + FileName;
		List<Map<String, String>> testData = ExcelUtil.getData(path, getStore());
		String exp_Value = testData.get(0).get(KeyName);
		String act_Value = actionMethods.getValue(locator).replaceAll("[,'. ]", "");
		System.out.println("Actual value obtained from WebSite: " + act_Value);
		Assert.assertEquals(exp_Value, act_Value);
		context.scenario.log("Text verified on page:" + act_Value);
	}

	@Then("^.*verify text.* in page \"([^\"]*)\" is present from file \"([^\"]*)\" except in \"([^\"]*)\" region/store.*$")
	public void verifyTextFromExcelFileSpecificRegionStore(String locator, String FileName, String exceptList)
			throws Exception {
		String exp_Value = "";
		String path = System.getProperty("user.dir") + "//src//test//resources//TestData//" + FileName + ".xlsx";
		List<Map<String, String>> testData = ExcelUtil.getData(path, getStore());
		String[] regionStoreArray = exceptList.toLowerCase().split(",");
		String region = getRegionName().toLowerCase();
		String store = getStore().toLowerCase();
		if (!Arrays.asList(regionStoreArray).contains(region) && !Arrays.asList(regionStoreArray).contains(store)) {
			actionMethods.waitForElementToAppear(this.context.constants.getMediumWaitSeconds(), locator);
			for (int i = 0; i < testData.size(); i++) {
				if (testData.get(i).get("KeyName").equals(locator.trim())) {
					exp_Value = testData.get(i).get("KeyValue").trim();
				}
			}
			String act_Value = actionMethods.getValue(locator);
			System.out.println("Actual value obtained from WebSite: " + act_Value);
			Assert.assertEquals(exp_Value, act_Value);
			context.scenario.log("Text verified on page:" + act_Value);
		} else {
			context.scenario.log("Not applicable for region/store list:" + exceptList);
		}
	}

	@And("^.* verify.*\"([^\"]*)\" is equal to \"([^\"]*)\"$")
	public void verifyTextForTwoElementsOnWeb(String locator1, String locator2) throws Exception {
		String text1 = getLocator(locator1).getText();
		String text2 = getLocator(locator2).getText();
		Assert.assertTrue(text1.equals(text2));
	}

	@And ("^.* verify that text in \"([^\"]*)\" contains the text in \"([^\"]*)\"$")
	public void verifyTextContains(String locator1, String locator2) throws Exception {
		String text1 = getLocator(locator1).getText();
		String text2 = getLocator(locator2).getText();
		Assert.assertTrue(text1.contains(text2));
	}


	@And("^.*verify color of elements text in \"([^\"]*)\" list as \"([^\"]*)\"$")
	public void getTextColorOfElementsInList(String locator, String Value) throws Exception {
		boolean flag = false;
		String firstColor = "", secondColor = "";
		String[] textColor = Value.split(",");
		String color = textColor[0], colorValue = textColor[1];
		String[] multipleColorValues = colorValue.split("&&");
		if (multipleColorValues.length == 2) {
			firstColor = multipleColorValues[0];
			secondColor = multipleColorValues[1];
		} else {
			firstColor = colorValue;
		}

		List<WebElement> elementsInList = getMutipleLocators(locator);
		for (WebElement e : elementsInList) {
			String color_css = e.getCssValue("color");
			String hexColor = Color.fromString(color_css).asHex();
			flag = (firstColor.equalsIgnoreCase(hexColor) || secondColor.equalsIgnoreCase(hexColor));
			Assert.assertTrue("color are not correct", flag);
		}
	}

	@And("^.*get number of products present in page .* \"([^\"]*)\"  .*$")
	public void numbOfProducts(String locator) throws Exception {
		int countOfProducts = actionMethods.getCountOfElements(locator);
		logger.info("Number of products in the page: " + countOfProducts);
		this.context.scenario.log("No. of products found in page with the locator: " + countOfProducts);
	}

	@And("^.*verify count of elements present as \"([^\"]*)\" in page \"([^\"]*)\"$")
	public void verifyCountOfElements(int expectedCount, String locator) throws Exception {
		int actualCountOfElements = actionMethods.getCountOfElements(locator);
		logger.info("Actual products in the page: " + actualCountOfElements);
		Assert.assertEquals(expectedCount, actualCountOfElements);
	}

	@And("^.*element \"([^\"]*)\" is selected on page in \"([^\"]*)\" region/store$")
	public void verifyElementIsSelectedInSpecificRegion(String locator, String region) throws Exception {
		String regionArray[] = region.toLowerCase().split(",");
		String regionName = getRegionName().toLowerCase();
		String store = getStore().toLowerCase();
		if (Arrays.asList(regionArray).contains(regionName) || Arrays.asList(regionArray).contains(store)) {
			actionMethods.waitForElementToAppear(this.context.constants.getMediumWaitSeconds(), locator);
			Boolean value = uiMethods.isElementSelected(locator);
			Assert.assertTrue(value);
		}

	}

	@And("^.*verify element \"([^\"]*)\" is not Clickable$")
	public void verifyElementNOTActive(String locator) throws Exception {
		Boolean value = uiMethods.isElementClickable(locator);
		Assert.assertFalse(value);
	}

	@And("^.*verify element \"([^\"]*)\" is Clickable$")
	public void verifyElementActive(String locator) throws Exception {
		Boolean value = uiMethods.isElementClickable(locator);
		Assert.assertTrue(value);
	}
	@And("^.*element \"([^\"]*)\" is enabled.*$")
	public void verifyElementIsEnabled(String locator) throws Exception {
		actionMethods.waitForElementToAppear(
				this.context.constants.getMediumWaitSeconds(),
				locator
				);
		Boolean value = uiMethods.isElementEnabled(locator);
		Assert.assertTrue(value);
	}

	@And("^.*element \"([^\"]*)\" is disabled.*$")
	public void verifyElementIsNotEnabled(String locator) throws Exception {
		actionMethods.waitForElementToAppear(
				this.context.constants.getMediumWaitSeconds(),
				locator
				);
		Boolean value = uiMethods.isElementEnabled(locator);
		Assert.assertFalse(value);
	}

	@And(".*verify text color of.* as \"([^\"]*)\" for \"([^\"]*)\" region/store$")
	public void getTextColorForSpecificStores(String Value, String region) throws Exception {
		String regionArray[] = region.toLowerCase().split(",");
		String regionName = getRegionName().toLowerCase();
		String store = getStore().toLowerCase();
		if (Arrays.asList(regionArray).contains(regionName) || Arrays.asList(regionArray).contains(store)) {
			String[] textColor = Value.split(",");
			String color = textColor[0], colorValue = textColor[1], locator = textColor[2];
			String hexColor = uiMethods.getTextColor(color, colorValue, locator);
			Assert.assertTrue("color are not correct", colorValue.trim().equalsIgnoreCase(hexColor));
		}
	}

	@And("^.*verify text of.* is Bold \"([^\"]*)\" for \"([^\"]*)\" region/store$")
	public void verifySentenceIsBOLDinSpecificStores(String locator, String region) throws Exception {
		String regionArray[] = region.toLowerCase().split(",");
		String regionName = getRegionName().toLowerCase();
		String store = getStore().toLowerCase();
		if (Arrays.asList(regionArray).contains(regionName) || Arrays.asList(regionArray).contains(store)) {
			Boolean isBold = uiMethods.verifySentenceIsBold(locator);
			Assert.assertTrue("word is not bold", isBold);
		}
	}

	@And("^.*verify background color of.* as \"([^\"]*)\" for \"([^\"]*)\" region/store$")
	public void verifyBackgroundColorinSpecificStores(String Value, String region) throws Exception {
		String regionArray[] = region.toLowerCase().split(",");
		String regionName = getRegionName().toLowerCase();
		String store = getStore().toLowerCase();
		if (Arrays.asList(regionArray).contains(regionName) || Arrays.asList(regionArray).contains(store)) {
			String[] textColor = Value.split(",");
			String color = textColor[0], colorValue = textColor[1], locator = textColor[2];
			String ColorOfContainer = uiMethods.verifyBackgroundColor(color, colorValue, locator);
			Assert.assertTrue("The color of the Background is not matching",
					ColorOfContainer.equalsIgnoreCase(colorValue.trim()));
		}
	}

	@Then("^.*verify values in the \"([^\"]*)\" table are not empty for \"([^\"]*)\" region/store$")
	public void verifyValuesInTableNonEmptyForSpecificStore(String locators, String region) throws Exception {
		String regionArray[] = region.toLowerCase().split(",");
		String regionName = getRegionName().toLowerCase();
		String store = getStore().toLowerCase();
		if (Arrays.asList(regionArray).contains(regionName) || Arrays.asList(regionArray).contains(store)) {
			List<WebElement> welist = actionMethods.getMutipleLocators(locators);
			for (WebElement element : welist) {
				if(!element.getAttribute("class").equalsIgnoreCase("engLangOnly"))
					Assert.assertTrue("Text is missing", !element.getText().isEmpty());
			}
		}
	}

	@And ("^I verify below are displayed for \"([^\"]*)\" region or store in \"([^\"]*)\" table$")
	public void verifyListContainsText(String region,String locators, DataTable table) throws Exception {
		String regionArray[] = region.toLowerCase().split(",");
		String regionName = getRegionName().toLowerCase();
		String store = getStore().toLowerCase();
		if (Arrays.asList(regionArray).contains(regionName) || Arrays.asList(regionArray).contains(store)) {
		
			actionMethods.waitForElementToAppear(this.context.constants.getMediumWaitSeconds(), locators);
			List<String> expProdDesrList = table.asList(String.class);
			List<String> expProdDesrListTranslated = new ArrayList<String>();
			List<WebElement> actWebElementList = actionMethods.getMutipleLocators(locators);
			List<String> actProdDesrList = new ArrayList<String>();
			for (String element : expProdDesrList) {
				if (element.equalsIgnoreCase("Browser Search Tools") && store.equalsIgnoreCase("fr"))
					continue;
				if (!(element.equalsIgnoreCase("n/a") || element.equalsIgnoreCase("NA"))) {
					expProdDesrListTranslated.add(storeText.getStoreText(element));
				}
	
			}
			for (WebElement element : actWebElementList) {
				actProdDesrList.add(element.getText().replace(":", "").replace("：", "").trim());
			}
			context.scenario.log("actual list:" + actProdDesrList + "\n should atleast have \n expected elements:"
					+ expProdDesrListTranslated);
			Assert.assertTrue("Product description is wrong", actProdDesrList.containsAll(expProdDesrListTranslated));
		}
	}
	
	@And ("^.*verify text .*\"([^\"]*)\" in page \"([^\"]*)\" for \"([^\"]*)\" region/store")
	public void verifyTextInSpecificRegionOrStore(String value, String locator, String region) throws Exception {
		String regionArray[] = region.toLowerCase().split(",");
		String regionName = getRegionName().toLowerCase();
		String store = getStore().toLowerCase();
		if (Arrays.asList(regionArray).contains(regionName) || Arrays.asList(regionArray).contains(store)) {			
			String exp_Value = storeText.getStoreText(value);
			String act_Value = actionMethods.getValue(locator);
			logger.info("Actual text obtained from the page: " + act_Value);
			Assert.assertEquals(exp_Value, act_Value);
		}
		
	}
}
