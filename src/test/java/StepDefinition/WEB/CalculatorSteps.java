package StepDefinition.WEB;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import Common.UTILS.ContextStore;
import Common.UTILS.ScreenshotUtil;
import Common.UTILS.WebDriverConfig;
import io.cucumber.java.en.And;

public class CalculatorSteps extends WebDriverConfig {
	private static final Logger logger = LogManager.getLogger(ChangeCountrySteps.class);
	private ContextStore context;

	public CalculatorSteps(ContextStore context) {
		this.context = context;
	}

	int idx;
	JavascriptExecutor js = (JavascriptExecutor) driver;

	@And("^.*verifies \"([^\"]*)\" is present in the calculator and charts page$")
	public void verify_calculator_is_present(String calc) throws Exception {
		String calculator = storeText.getStoreText(calc);
		String calcChart_xpath = getLocatorString("CalculatorPage.calculatorContainer_element") + "//h3";
		List<WebElement> allCalculators = driver.findElements(By.xpath(calcChart_xpath));
		for (int i = 0; i < allCalculators.size(); i++) {
			if (allCalculators.get(i).getText().equalsIgnoreCase(calculator)) {
				idx = i+1;
				this.context.scenario.log(calculator + " is present in Calculator and Charts page");
		        js.executeScript("arguments[0].scrollIntoView(true);", allCalculators.get(i));
			}
		}
	}

	@And("^.*verifies \"([^\"]*)\" as short Description and \"([^\"]*)\" as button text and image with link \"([^\"]*)\"$")
	public void verify_calculator_details(String expShortDesc, String expButtonText, String link) throws Exception {
		String expectedShortDesc = storeText.getStoreText(expShortDesc);
		String expectedButtonText = storeText.getStoreText(expButtonText);
		String calcImg_link = getLocatorString("CalculatorPage.calculatorContainer_element") + "/div[" + idx + "]/a[1]";
		String calcDesc = getLocatorString("CalculatorPage.calculatorContainer_element") + "/div[" + idx + "]/p";
		String calcImg = getLocatorString("CalculatorPage.calculatorContainer_element") + "/div[" + idx
				+ "]/a[1]/picture/img";
		String calcBtn = getLocatorString("CalculatorPage.calculatorContainer_element") + "/div[" + idx + "]/a[2]";

		// validations
		String actualCalcImgLink = driver.findElement(By.xpath(calcImg_link)).getAttribute("href").trim();
		String shrtDesc = driver.findElement(By.xpath(calcDesc)).getText().trim();
		String actualCalcBtnText = driver.findElement(By.xpath(calcBtn)).getText().trim();
		String actualCalcBtnLink = driver.findElement(By.xpath(calcBtn)).getAttribute("href");
		this.context.softAssertions.assertThat(actualCalcImgLink)
				.as("Calculator link in Image")
				.overridingErrorMessage("Actual Image Link: "+ actualCalcImgLink +" expected to contain link: "+ link).contains(link);

		this.context.softAssertions.assertThat(driver.findElement(By.xpath(calcImg)).isDisplayed())
				.overridingErrorMessage("Calculator Image is not displaying").isEqualTo(true);

		this.context.softAssertions.assertThat(shrtDesc)
				.as("Calculator short description")
				.overridingErrorMessage("Calculator short description: "+shrtDesc+" is not as per expected description: "+expectedShortDesc)
				.isEqualTo(expectedShortDesc);

		this.context.softAssertions.assertThat(actualCalcBtnText)
				.as("Calculator button text")
				.overridingErrorMessage("Calculator button text: "+actualCalcBtnText+" is not matching with expected text: "+expectedButtonText)
				.isEqualTo(expectedButtonText);

		this.context.softAssertions.assertThat(actualCalcBtnLink)
				.as("Calculator link in Button")
				.overridingErrorMessage("Link in Button: "+actualCalcBtnLink+" is not pointing to the correct calculator link: "+link).contains(link);

		driver.findElement(By.xpath(calcBtn)).click();

		Thread.sleep(2000);
		this.context.softAssertions.assertThat(driver.getCurrentUrl().contains(link)).overridingErrorMessage(
				"Correct calculator page is not opening after clicking on the calculator button in calculator and charts page")
				.isEqualTo(true);

	}

	@And("^customer captures screenshot of the calculator section$")
	public void take_screenshot_of_calculator() throws Exception {
		driver.navigate().back();
		String calcDesc = getLocatorString("CalculatorPage.calculatorContainer_element") + "/div[" + idx
				+ "]/a[1]/picture/img";
		WebElement calcDescEL = driver.findElement(By.xpath(calcDesc));
		actionMethods.waitForElementToAppear(5, "CalculatorPage.calculatorContainer_element");
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", calcDescEL);
		context.scenario.attach(ScreenshotUtil.getByteScreenshot(), "image/png", "screenshot");
	}

	@And("^customer verifies Parallel Resistor Calculator inputs$")
	public void parallel_resistor_calc() throws Exception {
		boolean resistorsPresent = true;
		this.context.softAssertions.assertThat(driver.getTitle().trim()).overridingErrorMessage(
				"Title: "+driver.getTitle().trim()+" is not displaying as expected: Parallel Resistance Calculator | Farnell UK").isEqualTo("Parallel Resistance Calculator | Farnell UK");
		List<WebElement> defaultResistors = getMutipleLocators("CalculatorPage.PRdefaultResistor_input");
		this.context.softAssertions.assertThat(defaultResistors.size()).overridingErrorMessage(
				"Expected Default Resistors are %d but displaying %d", 2, defaultResistors.size()).isEqualTo(2);
		context.scenario.attach(ScreenshotUtil.getByteScreenshot(), "image/png", "screenshot");
		
		this.context.softAssertions.assertThat(actionMethods.getValue("CalculatorPage.addResistor_button").trim()).as("Add Resistor text")
		.overridingErrorMessage("Add Resistor text is displaying incorrectly").isEqualTo("Add Resistor");
		
		this.context.softAssertions.assertThat(actionMethods.getValue("CalculatorPage.removeResistor_button").trim()).as("Remove Resistor text")
		.overridingErrorMessage("Remove Resistor text is displaying incorrectly").isEqualTo("Remove Resistor");
		
//		this.context.softAssertions.assertThat(isRemoveDisabled).as("Remove Resistor Button is disabled by default")
//		.overridingErrorMessage("Remove Resistor button is not disabled by default").isEqualTo("true");
		
		for (int i = 1; i <= 8; i++) {
			actionMethods.click("CalculatorPage.addResistor_button");
			Thread.sleep(1000);
		}
		context.scenario.attach(ScreenshotUtil.getByteScreenshot(), "image/png", "screenshot");

		// validation of total Resistor input fields with units
		for (int i = 1; i <= 10; i++) {
			if (!driver.findElement(By.id("resistor" + i)).isDisplayed()) {
				resistorsPresent = false;
				break;
			}else {
				boolean unitDisplayed = PRUnitvalidation("//*[@id='resistor"+i+"Unit']");
				this.context.softAssertions.assertThat(unitDisplayed).as("Unit displayed in Dropdown")
				.overridingErrorMessage("Units are not displaying properly for resistor " + i).isEqualTo(true);
			}
		}
		
		String isAddDisabled = actionMethods.getValueUsingAttribute("CalculatorPage.addResistor_button", "disabled");
		
		this.context.softAssertions.assertThat(isAddDisabled).as("Add Resistor Button is disabled")
		.overridingErrorMessage("Add Resistor button is not disabled after adding 10 resistor field").isEqualTo("true");

		this.context.softAssertions.assertThat(resistorsPresent)
				.overridingErrorMessage("All resistor fields are not added properly").isEqualTo(true);
		
		for (int i = 1; i <= 8; i++) {
			actionMethods.click("CalculatorPage.removeResistor_button");
			Thread.sleep(1000);
		}
		
		String resIp = getLocatorString("CalculatorPage.parallelResistance_input") + "/div/div[@class='hide']";
		int hiddenResistors = driver.findElements(By.xpath(resIp)).size();
		
		this.context.softAssertions.assertThat(hiddenResistors).as("Resistors getting removed after clicking on remove resistor button")
		.overridingErrorMessage("Expected hidden: " +hiddenResistors+ "Resistors are not removed").isGreaterThan(0);
		
		// output field validation
		String actualOutputText = actionMethods.getValue("CalculatorPage.PRoutput_text");
		this.context.softAssertions.assertThat(actualOutputText).as("Parallel resistor calculator output field text")
		.overridingErrorMessage("Parallel resistor calculator output field text: "+actualOutputText+" is not displaying properly").isEqualTo("Total Parallel Resistance");

		boolean unitDisplayed = PRUnitvalidation("//*[@id='totalParallelResistanceUnit']");
		this.context.softAssertions.assertThat(unitDisplayed).as("Unit displayed in Dropdown")
		.overridingErrorMessage("Units are not displaying properly for output").isEqualTo(true);
	}
	
	public boolean PRUnitvalidation(String loc) {
		boolean result = false;
		String firstUnit = driver.findElement(By.xpath(loc+"/option[1]")).getText().trim();
		String secondUnit = driver.findElement(By.xpath(loc+"/option[2]")).getText().trim();
		String thirdUnit = driver.findElement(By.xpath(loc+"/option[3]")).getText().trim();
		
		if(firstUnit.equals("Ω") && secondUnit.equals("kΩ") && thirdUnit.equals("MΩ"))
			result = true;
		return result;
	}

}
