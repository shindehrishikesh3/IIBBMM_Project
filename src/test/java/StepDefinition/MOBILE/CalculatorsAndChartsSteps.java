package StepDefinition.MOBILE;

import Common.UTILS.ContextStore;
import Common.UTILS.ScreenshotUtil;
import Common.UTILS.WebDriverConfig;
import io.cucumber.java.en.And;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class CalculatorsAndChartsSteps extends WebDriverConfig {

	private ContextStore context;
	String FilePath = System.getProperty("user.dir") + "//src//test//resources//TestData//" + getEnv().toUpperCase()
			+ "//";

	int idx;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	List<String> expectedCalculators = new ArrayList<String>();
	List<String> calculatorURLs = new ArrayList<String>();
	List<String> expectedCalculatorTitles = new ArrayList<String>();

	public CalculatorsAndChartsSteps(ContextStore context) {
		this.context = context;
	}

	@And("^.*verify GoogleBot Hreflang for \"([^\"]*)\" of \"([^\"]*)\" attribute on the link \"([^\"]*)\"$")
	public void validate_GoogleBot_hreflang(String store, String name, String Url) throws Throwable {
		String path = FilePath + "Mob_SSP_963_GoogleBotTestBaseUrls" + ".xlsx";
		List<Map<String, String>> testData = ExcelUtil.getData(path, store);

		String baseurl = null;
		baseurl = testData.get(0).get("URL").trim();

		String loc = "/html/head/link[@hreflang]";
		System.out.println(baseurl + Url);
		driver.get(baseurl + Url);

		WebElement hreflang = actionMethods.getDriver().findElement(By.xpath(loc));
		List<WebElement> elementObj = driver.findElements(By.xpath(loc));

		if (elementObj.size() > 0) {
			this.context.scenario.log("HrefLang is within header tag");
		} else {
			Assert.fail();
		}
	}

	@And("^verifies \"([^\"]*)\" is present in the calculator and charts page in mobile$")
	public void verify_calculator_is_present(String calc) throws Exception {
		String calculator = storeText.getStoreText(calc);
		String calcChart_xpath = getLocatorString("CalcuatorsAndCharts.calculatorContainer_element") + "//h3";
		List<WebElement> allCalculators = driver.findElements(By.xpath(calcChart_xpath));
		for (int i = 0; i < allCalculators.size(); i++) {
			if (allCalculators.get(i).getText().equalsIgnoreCase(calculator)) {
				idx = i + 1;
				this.context.scenario.log(calculator + " is present in Calculator and Charts page");
				js.executeScript("arguments[0].scrollIntoView(true);", allCalculators.get(i));
			}
		}
	}

	@And("^.*verifies \"([^\"]*)\" as short Description and \"([^\"]*)\" as button text and image with link \"([^\"]*)\" in mobile$")
	public void verify_calculator_details(String expShortDesc, String expButtonText, String link) throws Exception {
		String expectedShortDesc = storeText.getStoreText(expShortDesc);
		String expectedButtonText = storeText.getStoreText(expButtonText);
		String calcImg_link = getLocatorString("CalcuatorsAndCharts.calculatorContainer_element") + "/div[" + idx
				+ "]/a[1]";
		String calcDesc = getLocatorString("CalcuatorsAndCharts.calculatorContainer_element") + "/div[" + idx + "]/p";
		String calcImg = getLocatorString("CalcuatorsAndCharts.calculatorContainer_element") + "/div[" + idx
				+ "]/a[1]/picture/img";
		String calcBtn = getLocatorString("CalcuatorsAndCharts.calculatorContainer_element") + "/div[" + idx + "]/a[2]";

		// validations
		String actualCalcImgLink = driver.findElement(By.xpath(calcImg_link)).getAttribute("href").trim();
		String shrtDesc = driver.findElement(By.xpath(calcDesc)).getText().trim();
		String actualCalcBtnText = driver.findElement(By.xpath(calcBtn)).getText().trim();
		String actualCalcBtnLink = driver.findElement(By.xpath(calcBtn)).getAttribute("href");
		this.context.softAssertions.assertThat(actualCalcImgLink).as("Calculator link in Image")
				.overridingErrorMessage(
						"Actual Image Link: " + actualCalcImgLink + " expected to contain link: " + link)
				.contains(link);

		this.context.softAssertions.assertThat(driver.findElement(By.xpath(calcImg)).isDisplayed())
				.overridingErrorMessage("Calculator Image is not displaying").isEqualTo(true);

		this.context.softAssertions.assertThat(shrtDesc).as("Calculator short description")
				.overridingErrorMessage("Calculator short description: " + shrtDesc
						+ " is not as per expected description: " + expectedShortDesc)
				.isEqualTo(expectedShortDesc);

		this.context.softAssertions.assertThat(actualCalcBtnText).as("Calculator button text")
				.overridingErrorMessage("Calculator button text: " + actualCalcBtnText
						+ " is not matching with expected text: " + expectedButtonText)
				.isEqualTo(expectedButtonText);

		this.context.softAssertions
				.assertThat(actualCalcBtnLink).as("Calculator link in Button").overridingErrorMessage("Link in Button: "
						+ actualCalcBtnLink + " is not pointing to the correct calculator link: " + link)
				.contains(link);

		driver.findElement(By.xpath(calcBtn)).click();

		Thread.sleep(2000);
		this.context.softAssertions.assertThat(driver.getCurrentUrl().contains(link)).overridingErrorMessage(
				"Correct calculator page is not opening after clicking on the calculator button in calculator and charts page")
				.isEqualTo(true);

	}

	@And("^customer captures screenshot of the calculator section in mobile$")
	public void take_screenshot_of_calculator() throws Exception {
		driver.navigate().back();
		String calcDesc = getLocatorString("CalcuatorsAndCharts.calculatorContainer_element") + "/div[" + idx
				+ "]/a[1]/picture/img";
		WebElement calcDescEL = driver.findElement(By.xpath(calcDesc));
		actionMethods.waitForElementToAppear(5, "CalcuatorsAndCharts.calculatorContainer_element");
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView(true);", calcDescEL);
		context.scenario.attach(ScreenshotUtil.getByteScreenshot(), "image/png", "screenshot");
	}

	@And("^customer verifies Parallel Resistor Calculator inputs in mobile$")
	public void parallel_resistor_calc() throws Exception {
		boolean resistorsPresent = true;
		this.context.softAssertions.assertThat(driver.getTitle().trim())
				.overridingErrorMessage("Title: " + driver.getTitle().trim()
						+ " is not displaying as expected: Parallel Resistance Calculator | Farnell UK")
				.isEqualTo("Parallel Resistance Calculator | Farnell UK");
		List<WebElement> defaultResistors = getMutipleLocators("CalcuatorsAndCharts.PRdefaultResistor_input");
		this.context.softAssertions.assertThat(defaultResistors.size()).overridingErrorMessage(
				"Expected Default Resistors are %d but displaying %d", 2, defaultResistors.size()).isEqualTo(2);
		context.scenario.attach(ScreenshotUtil.getByteScreenshot(), "image/png", "screenshot");

		this.context.softAssertions.assertThat(actionMethods.getValue("CalcuatorsAndCharts.addResistor_button").trim())
				.as("Add Resistor text").overridingErrorMessage("Add Resistor text is displaying incorrectly")
				.isEqualTo("Add Resistor");

		this.context.softAssertions
				.assertThat(actionMethods.getValue("CalcuatorsAndCharts.removeResistor_button").trim())
				.as("Remove Resistor text").overridingErrorMessage("Remove Resistor text is displaying incorrectly")
				.isEqualTo("Remove Resistor");

//		this.context.softAssertions.assertThat(isRemoveDisabled).as("Remove Resistor Button is disabled by default")
//		.overridingErrorMessage("Remove Resistor button is not disabled by default").isEqualTo("true");

		for (int i = 1; i <= 8; i++) {
			actionMethods.click("CalcuatorsAndCharts.addResistor_button");
			Thread.sleep(1000);
		}
		context.scenario.attach(ScreenshotUtil.getByteScreenshot(), "image/png", "screenshot");

		// validation of total Resistor input fields with units
		for (int i = 1; i <= 10; i++) {
			if (!driver.findElement(By.id("resistor" + i)).isDisplayed()) {
				resistorsPresent = false;
				break;
			} else {
				boolean unitDisplayed = PRUnitvalidation("//*[@id='resistor" + i + "Unit']");
				this.context.softAssertions.assertThat(unitDisplayed).as("Unit displayed in Dropdown")
						.overridingErrorMessage("Units are not displaying properly for resistor " + i).isEqualTo(true);
			}
		}

		String isAddDisabled = actionMethods.getValueUsingAttribute("CalcuatorsAndCharts.addResistor_button",
				"disabled");

		this.context.softAssertions.assertThat(isAddDisabled).as("Add Resistor Button is disabled")
				.overridingErrorMessage("Add Resistor button is not disabled after adding 10 resistor field")
				.isEqualTo("true");

		this.context.softAssertions.assertThat(resistorsPresent)
				.overridingErrorMessage("All resistor fields are not added properly").isEqualTo(true);

		for (int i = 1; i <= 8; i++) {
			actionMethods.click("CalcuatorsAndCharts.removeResistor_button");
			Thread.sleep(1000);
		}

		String resIp = getLocatorString("CalcuatorsAndCharts.parallelResistance_input") + "/div/div[@class='hide']";
		int hiddenResistors = driver.findElements(By.xpath(resIp)).size();

		this.context.softAssertions.assertThat(hiddenResistors)
				.as("Resistors getting removed after clicking on remove resistor button")
				.overridingErrorMessage("Expected hidden: " + hiddenResistors + "Resistors are not removed")
				.isGreaterThan(0);

		// output field validation
		String actualOutputText = actionMethods.getValue("CalcuatorsAndCharts.PRoutput_text");
		this.context.softAssertions.assertThat(actualOutputText).as("Parallel resistor calculator output field text")
				.overridingErrorMessage("Parallel resistor calculator output field text: " + actualOutputText
						+ " is not displaying properly")
				.isEqualTo("Total Parallel Resistance");

		boolean unitDisplayed = PRUnitvalidation("//*[@id='totalParallelResistanceUnit']");
		this.context.softAssertions.assertThat(unitDisplayed).as("Unit displayed in Dropdown")
				.overridingErrorMessage("Units are not displaying properly for output").isEqualTo(true);
	}

	public boolean PRUnitvalidation(String loc) {
		boolean result = false;
		String firstUnit = driver.findElement(By.xpath(loc + "/option[1]")).getText().trim();
		String secondUnit = driver.findElement(By.xpath(loc + "/option[2]")).getText().trim();
		String thirdUnit = driver.findElement(By.xpath(loc + "/option[3]")).getText().trim();

		if (firstUnit.equals("Ω") && secondUnit.equals("kΩ") && thirdUnit.equals("MΩ"))
			result = true;
		return result;
	}

	@And ("^I verify all calculators are displaying$")
	public void verify_all_calculators_displaying() throws Exception{
		String FileName = "CalculatorsAndConversionTools.xlsx";
		String path = FilePath + FileName;
		List<Map<String, String>> testData = ExcelUtil.getData(path, getStore());
		List<String> actualCalculators = new ArrayList<String>();
		for(int i = 0 ; i < testData.size()-1 ; i++){
			expectedCalculators.add(testData.get(i).get("Calculators"));
			expectedCalculatorTitles.add(testData.get(i).get("Titles"));
		}
		if(!store.equalsIgnoreCase("cn")){
			List<WebElement> allCalcs = getMutipleLocators(
					"CalcuatorsAndCharts.calcAndConversionTools_list");
			for(WebElement calc : allCalcs){
				System.out.println(calc.getText().trim());
				actualCalculators.add(calc.getText().trim());
			}			
		}else{
			List<WebElement> allCalcs = getMutipleLocators(
					"CalcuatorsAndCharts.cnCalcAndConversionTools_list");
			for(WebElement calc : allCalcs){
				actualCalculators.add(calc.getText().trim());
			}					
		}
		Assert.assertEquals(expectedCalculators, actualCalculators);
		this.context.scenario.log("All "+actualCalculators.size()+" caluculators are present");
	}

	@And ("^I store urls of all the calculators$")
	public void store_calculator_urls() throws Exception{	
		List<WebElement> calcBtns;
		if(!store.equalsIgnoreCase("cn")){
			calcBtns = getMutipleLocators(
				"CalcuatorsAndCharts.calculator_button");
		}else{
			calcBtns = getMutipleLocators(
				"CalcuatorsAndCharts.cnCalculator_link");
		}
		for(WebElement btn : calcBtns){
			calculatorURLs.add(btn.getAttribute("href").trim());
		}
	}

	@And ("^I verify all the calculators are opening properly$")
	public void validate_calculator_page() throws Exception{
		for(int i = 0 ; i < calculatorURLs.size() ; i++){
			String title = null;
			System.out.println("URL: "+calculatorURLs.get(i));
			if(System.getProperty("pHost") != null){
				Document doc = Jsoup.connect(calculatorURLs.get(i)).proxy(getProxyHost(), getProxyPort()).get();
				title = doc.title();
			}else{
				Document doc = Jsoup.connect(calculatorURLs.get(i)).get();
				title = doc.title();
			}
			System.out.println("Actual Title: "+title);
			System.out.println("Expected Title: "+expectedCalculatorTitles.get(i));
			this.context.softAssertions.assertThat(title).overridingErrorMessage("Validation failed for %s, Expected title is %s --- but displaying as %s",expectedCalculators.get(i),expectedCalculatorTitles.get(i),title).isEqualTo(expectedCalculatorTitles.get(i));
		}
	}

}
