package StepDefinition.WEB;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import StepDefinition.GENERIC.UtilitySteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BOMSteps extends WebDriverConfig {

	String FilePath = System.getProperty("user.dir") + "//src//test//resources//TestData//" + getEnv().toUpperCase()
			+ "//";

	String store = getStore();
	String env = getEnv();
	String region = getRegionName();
	String MatchProductCount;
	String selectedProductName = null;
	String PackageType = "";

	private ContextStore context;

	public BOMSteps(ContextStore context) {
		this.context = context;
	}

	@And("^.*delete if any BOM file present on page.* \"([^\"]*)\"$")
	public void deleteIfFileExist(String locator) throws Exception {
		actionMethods.waitForElementToAppear(this.context.constants.getMediumWaitSeconds(), locator);
		if (uiMethods.isElementDisplayed(locator)) {
			actionMethods.click(locator);
			actionMethods.click("BOMUploadPage.deleteYes_button");
		} else
			this.context.scenario.log("BOM file is not present ");
	}

	// By default, this will look for a file on the file system, at the location
	// provided.
	@And("^.*upload the file \"([^\"]*)\" into the element \"([^\"]*)\"$")
	public void fileToUpload(String FileName, String loactor) throws Exception {
		String path = FilePath + FileName;
		actionMethods.enterText(path, loactor);
	}

	@And("^.*rename the existing BOM file$")
	public void renameBOMFile() throws Exception {
		String UpdatedName = actionMethods.generateRandomNumberString("BOM_");
		context.scenario.log("Updated Name : " + UpdatedName);
		actionMethods.click("BOMUploadPage.edit_icon");
		Thread.sleep(1000);
		actionMethods.clearText("BOMUploadPage.editFileName_text");
		actionMethods.enterText(UpdatedName, "BOMUploadPage.editFileName_text");
	}

	@And("^.*update quote name if pop-up displayed$")
	public void renameQuote() throws Exception {
		String UpdatedQuoteName = actionMethods.generateRandomNumberString("BOM_");
		context.scenario.log("Updated Quote Name : " + UpdatedQuoteName);
		actionMethods.waitForElementToAppear(this.context.constants.getMediumWaitSeconds(),
				"BOMUploadPage.editQuotename_text");
		if (uiMethods.isElementDisplayed("BOMUploadPage.editQuotename_text")) {
			actionMethods.click("BOMUploadPage.editQuoteName_icon");
			Thread.sleep(1000);
			actionMethods.clearText("BOMUploadPage.editQuoteName_text");
			actionMethods.enterText(UpdatedQuoteName, "BOMUploadPage.editQuoteName_text");
			actionMethods.click("BOMUploadPage.saveQuoteName_button");
		}
	}

	@And("^.*enter an Order Code and Quantity and click Add a part button")
	public void AddProductToBOM() throws Exception {
		actionMethods.enterText(this.context.constants.getOrderCode(), "BOMUploadPage.ordercode_text");
		actionMethods.enterText("1", "BOMUploadPage.quantity_text");
		actionMethods.click("BOMUploadPage.addPart_button");
	}

	@Then("Verify the sorting of products on See alternavtives modal")
	public void VerifyAlternativesSorting() throws Exception {
		boolean bExact = true;
		boolean bUpgrade = true;
		boolean bSuggested = true;
		List<WebElement> lstAlternatives = null;
		List<WebElement> lstExactMatch = null;
		List<WebElement> lstUpgradeMatch = null;
		List<WebElement> lstSuggestedMatch = null;
		int iSuggestedStart = 0;

		lstAlternatives = actionMethods.getMutipleLocators("BOMUploadPage.allAlternatives_link");
		lstExactMatch = actionMethods.getMutipleLocators("BOMUploadPage.exactAlternative_link");
		lstUpgradeMatch = actionMethods.getMutipleLocators("BOMUploadPage.upgradeAlternative_link");
		lstSuggestedMatch = actionMethods.getMutipleLocators("BOMUploadPage.suggestedAlternative_link");

		for (int iLoop = 0; iLoop < lstExactMatch.size(); iLoop++) {
			if (!(lstAlternatives.get(iLoop).getText().contains("Exact"))) {
				bExact = false;
			}
		}

		for (int iLoop = lstExactMatch.size(); iLoop < lstUpgradeMatch.size(); iLoop++) {
			if (!(lstAlternatives.get(iLoop).getText().contains("Upgrade"))) {
				bUpgrade = false;
			}
		}

		if (lstUpgradeMatch.size() == 0) {
			iSuggestedStart = lstExactMatch.size() - 1;
		} else {
			iSuggestedStart = lstUpgradeMatch.size() - 1;
		}
		for (int iLoop = iSuggestedStart; iLoop < lstSuggestedMatch.size(); iLoop++) {
			if (!(lstAlternatives.get(iLoop).getText().contains("Suggested"))) {
				bSuggested = false;
			}
		}

		if (bExact == false || bUpgrade == false || bSuggested == false) {
			this.context.scenario.log("Sorting of alternative product is not as expected");
		}
	}

	@And("^.*verify \"([^\"]*)\" is enabled in BOM page")
	public void elementIsEnbaledInBOM(String locator) throws Exception {
		WebElement elementObj = getLocator(locator);
		String text = elementObj.getAttribute("class");
		Assert.assertTrue(!text.contains("disable"));
	}

	@And("^.*click \"([^\"]*)\" checkbox")
	public void selectcheckboxIfNotSelected(String locator) throws Exception {
		WebElement elementObj = getLocator(locator);
		if (!elementObj.isSelected()) {
			elementObj.click();
		}
	}

	@And("^.*select by index from packaging dropdown \"([^\"]*)\" without select tag$")
	public void selectPackagingtype(String locator) throws Exception {
		actionMethods.clickAndHover(locator);

	}

	@And("^.*save the value of the product count.* \"([^\"]*)\"$")
	public void saveMatchCount(String locator) throws Exception {
		actionMethods.waitForElementToAppear(this.context.constants.getMediumWaitSeconds(), locator);
		MatchProductCount = actionMethods.getValue(locator);
	}

	@And("^.*compare product count before and after delete product.* \"([^\"]*)\"$")
	public void compareBeforeAfterMatchCount(String locator) throws Exception {
		actionMethods.waitForElementToAppear(this.context.constants.getMediumWaitSeconds(), locator);
		String MatchProductAfter = actionMethods.getValue(locator);
		Assert.assertTrue("Count of product not reduced !!",
				Integer.parseInt(MatchProductCount) > Integer.parseInt(MatchProductAfter));
	}

	// By default, this will look for a file on the file system, at the location
	// provided.
	@And("^I choose worksheet to read store specific data$")
	public void selectWorksheet() throws Exception {
		if (store.equalsIgnoreCase("uk")) {
			actionMethods.selectValueByText("uk", "BOMUploadPage.worksheet_dropdown");
		} else if (store.equalsIgnoreCase("sg")) {
			actionMethods.selectValueByText("sg", "BOMUploadPage.worksheet_dropdown");
		} else if (store.equalsIgnoreCase("us")){
			actionMethods.selectValueByText("us", "BOMUploadPage.worksheet_dropdown");
		}  else if (store.equalsIgnoreCase("ch")) {
			actionMethods.selectValueByText("ch", "BOMUploadPage.worksheet_dropdown");
		}  else if (store.equalsIgnoreCase("de")) {
			actionMethods.selectValueByText("de", "BOMUploadPage.worksheet_dropdown");
		} else {
			this.context.scenario.log("Test data is missing for : "+store);
		}
		Thread.sleep(3000);
		actionMethods.selectValueByValue("Part Number", "BOMUploadPage.editColumnOne_dropdown");
		actionMethods.selectValueByValue("Quantity", "BOMUploadPage.editColumnTwo_dropdown");
		actionMethods.selectValueByValue("Description", "BOMUploadPage.editColumnThree_dropdown");

		actionMethods.waitForElementToAppear(this.context.constants.getMediumWaitSeconds(),
				"BOMUploadPage.done_button");
		actionMethods.click("BOMUploadPage.done_button");
	}

	@And("^.*select in-stock multiple matches from the table and compare the count$")
	public void CompareCountOfMultipleMatchesBeforeAndAfter() throws Exception {
		int countOfMultipleMatchBefore = actionMethods.getCountOfElements("BOMUploadPage.multipleMatch_rows");

		// click on the view all button to see the multiple options and select in-stock
		// products
		String ViewAllResults = storeText.getStoreText("View All Results");
		List<WebElement> viewAllProductsButton = getDriver()
				.findElements(By.xpath("//a[contains(text(),'" + ViewAllResults + "')]"));
		List<WebElement> productsList = null;
		String productNameLocator = null;
		boolean bFlag = false;
		for (int iLoop = 1; iLoop <= viewAllProductsButton.size(); iLoop++) {
			clickOnViewAllResultsButtonMultipleMatch(iLoop);

			uiMethods.isElementPresent("BOMUploadPage.viewAllProducts_button"); // to verify PLP page displayed
			productsList = getDriver().findElements(By.xpath("//*[@class='viewAllProdsTable']//tbody/tr"));
			for (int jLoop = 1; jLoop <= productsList.size(); jLoop++) {
				try {
					getDriver().findElement(
							By.xpath("//*[@class='viewAllProdsTable']//tbody/tr[" + jLoop + "]/td[3]/div/strong"));
					getDriver().findElement(By.xpath("//tr[" + jLoop + "]//a[@id='searchSelect']")).click();
					productNameLocator = "//*[@class='viewAllProdsTable']//tbody/tr[" + jLoop + "]/td[1]/a";

					selectedProductName = getDriver().findElement(By.xpath(productNameLocator)).getAttribute("title");

					bFlag = true;
					
					break;
				} catch (Exception e) {
					this.context.scenario.log("Exception handled!!");
				}
			}

		}
		Thread.sleep(2000);
		int countOfMultipleMatchAfter = actionMethods.getCountOfElements("BOMUploadPage.multipleMatch_rows");
		Assert.assertTrue("In stock product not selected, count of multiple matches is not reduced",
				countOfMultipleMatchAfter < countOfMultipleMatchBefore);
	}

	public void clickOnViewAllResultsButtonMultipleMatch(int index) throws Exception {
		String ViewAllResults = storeText.getStoreText("View All Results");
		String viewResults_loc = "(//a[contains(text(),'" + ViewAllResults + "')])[" + index + "]";

		actionMethods.scrollDownPage(400);
		Thread.sleep(2000);
		try {
			getDriver().findElement(By.xpath(viewResults_loc)).click();
		} catch (Exception e) {
			this.context.scenario.log("Exception handled!!");
			getDriver().findElement(By.xpath(("//a[contains(text(),'View All Results')]"))).click();
		}

	}

	@And("^.*verify.* \"([^\"]*)\" products present on BOM view page$")
	public void verifyTypeOfProduct(String typeOfProduct) throws Exception {

		List<WebElement> inStock = actionMethods.getMutipleLocators("BOMUploadPage.instockProduct_icon");
		List<WebElement> backOrder = actionMethods.getMutipleLocators("BOMUploadPage.backOrderProduct_icon");
		List<WebElement> noMatch = actionMethods.getMutipleLocators("BOMUploadPage.noMatchProduct_icon");
		List<WebElement> multipleMatches = actionMethods
				.getMutipleLocators("BOMUploadPage.multipleMatchesProduct_icon");

		if (typeOfProduct.equalsIgnoreCase("In-stock")) {
			this.context.scenario.log("Number of instock products : " + inStock.size());
			Assert.assertTrue("Number of matched lines products count is different", Integer.parseInt(actionMethods
					.getValue("BOMUploadPage.matchedLinesCircle_element")) == (inStock.size() + backOrder.size()));
		}
		if (typeOfProduct.equalsIgnoreCase("Backorder")) {
			this.context.scenario.log("Number of backOrder products : " + backOrder.size());
			Assert.assertTrue("Number of matched lines products count is different", Integer.parseInt(actionMethods
					.getValue("BOMUploadPage.matchedLinesCircle_element")) == (inStock.size() + backOrder.size()));
		}
		if (typeOfProduct.equalsIgnoreCase("No-Match")) {
			this.context.scenario.log("Number of noMatch products : " + noMatch.size());
			Assert.assertTrue("Number of No-Match products count is different",
					Integer.parseInt(actionMethods.getValue("BOMUploadPage.noMatchCircle_element")) == noMatch.size());
		}
		if (typeOfProduct.equalsIgnoreCase("Multi-Match")) {
			this.context.scenario.log("Number of multipleMatches products : " + multipleMatches.size());
			Assert.assertTrue("Number of multiple Matches products count is different", Integer.parseInt(
					actionMethods.getValue("BOMUploadPage.multiMatchCircle_element")) == multipleMatches.size());
		}
	}

	@And("^.*verify the number of.* \"([^\"]*)\" qualifier present in page \"([^\"]*)\"$")
	public void verifyQualifier(String qualifier, String locator) throws Exception {
		int numberOfQualifier = 0;
		String qualifiers_xpath = "";
		String qualifiers_text = "";
		String partNumber_text = "";
		String matchedMPN_text = "";
		String exp_Value = storeText.getStoreText(qualifier);
		List<WebElement> qualifiers = actionMethods.getMutipleLocators(locator);
		for (int i = 1; i < qualifiers.size(); i++) {
			qualifiers_xpath = actionMethods.getLocatorString("BOMUploadPage.qualifiersPartial_element") + i
					+ "']/td[5]";
			qualifiers_text = driver.findElement(By.xpath(qualifiers_xpath)).getText().trim();

			if (qualifiers_text.equalsIgnoreCase(exp_Value)) {
				partNumber_text = driver.findElement(By.xpath(qualifiers_xpath + "//preceding-sibling::td[2]/p"))
						.getText().trim();
				partNumber_text = partNumber_text.replace(".", "-");
				if (qualifier.equalsIgnoreCase("Suggested")) {
					matchedMPN_text = driver
							.findElement(By.xpath(qualifiers_xpath + "//preceding-sibling::td[1]//span")).getText()
							.trim();
					Assert.assertFalse("Part number & MNP is same", partNumber_text.equals(matchedMPN_text));
				} else if (qualifier.equalsIgnoreCase("Direct")) {

					matchedMPN_text = driver.findElement(By.xpath(qualifiers_xpath + "//preceding-sibling::td[1]//a"))
							.getAttribute("href");
					Assert.assertTrue("Part number & Matched MPN is different",
							matchedMPN_text.toLowerCase().contains(partNumber_text.toLowerCase()));
				}
				numberOfQualifier++;
			}
		}
		this.context.scenario.log("Number of " + qualifier + " qalifiers : " + numberOfQualifier);
	}

	@And("^.*select \"([^\"]*)\" packaging type for multiple packaging products.*$")
	public void verifyMultiPackagingType(String packageOption) throws Exception {

		String packageTypeOptions_xpath;
		String packageOptions_text;
		String PackageType;
		String exp_Value = storeText.getStoreText(packageOption);
		List<WebElement> multiPackageProducts = actionMethods.getMutipleLocators("BOMUploadPage.multiPackage_dropdown");
		List<WebElement> packageTypeOptions = actionMethods.getMutipleLocators("BOMUploadPage.packageType_element");

		if (multiPackageProducts.size() > 0) {
			actionMethods.clickUsingJSExecutor("BOMUploadPage.multiPackage_dropdown");
			for (int i = 1; i <= packageTypeOptions.size(); i++) {
				packageTypeOptions_xpath = actionMethods.getLocatorString("BOMUploadPage.packageType_element") + "[" + i
						+ "]/a/span[1]";
				packageOptions_text = driver.findElement(By.xpath(packageTypeOptions_xpath)).getAttribute("innerHTML")
						.trim();
				if (packageOptions_text.contains(exp_Value)) {
					actionMethods.scrollDownPage(15000);
					driver.findElement(By.xpath(packageTypeOptions_xpath)).click();
				}
			}
		}
		PackageType = actionMethods.getValue("BOMUploadPage.multiPackage_dropdown");
		context.scenario.log("Selected Packaging Type is : " + PackageType);
	}

	@And("^.*verify selected packaging type is present on Basket Page.*$")
	public void verifyPackagingTypeOnBasketPage() throws Exception {
		if (PackageType.equalsIgnoreCase("Full Reel")) {
			uiMethods.isElementDisplayed("ShoppingCart.packTypeReel_icon");
		} else if (PackageType.equalsIgnoreCase("Re-Reel")) {
			uiMethods.isElementDisplayed("ShoppingCart.packTypeRereel_icon");
		} else if (PackageType.equalsIgnoreCase("Cut Tape")) {
			uiMethods.isElementDisplayed("ShoppingCart.packTypeCutTape_icon");
		}
	}

	@And("^.*verify Number of Matched lines products on BOM view page is available on basket page \\\"([^\\\"]*)\\\"$")
	public void verify_BOM_Added_Product(String locator) throws Exception {
		actionMethods.waitForByElementToAppear(this.context.constants.getShortWaitSeconds(), locator);
		String	errorMsg_text=null;
		int count =0;
		String exp_Value = storeText.getStoreText(MatchProductCount);
		String act_Value = actionMethods.getValueUsingAttribute(locator, "innerText");
		List<WebElement> errorMsg = actionMethods.getMutipleLocators("BOMUploadPage.errorMsg_text");
		if(!(act_Value.contains(exp_Value))){
			for (int i = 1; i <= errorMsg.size(); i++) {
				errorMsg_text= driver.findElement(By.xpath(actionMethods.getLocatorString("BOMUploadPage.errorMsg_text") + "[" + i+ "]/p")).getText().trim();
				if((errorMsg_text.contains("no longer")) || (errorMsg_text.contains("No price"))){
					count++;
				}
			}
			Assert.assertTrue("All Macthed lines products on BOM view page is not available on basket page",
					act_Value.contains(Integer.toString(Integer.parseInt(exp_Value)- count)));
		}else {
		Assert.assertTrue("All Macthed lines products on BOM view page is not available on basket page",
				act_Value.contains(exp_Value));
		}
	}
	

	@And("^.*upload the BOM file \\\"([^\\\"]*)\\\" if no file is present on BOM page*$")
	public void upload_BOM_if_not_present(String fileName) throws Exception {
		if (!uiMethods.isElementDisplayed("BOMUploadPage.view_button")) {
			fileToUpload(fileName, "BOMUploadPage.uploadFile_text");
			Thread.sleep(10000);
			if (uiMethods.isElementDisplayed("BOMUploadPage.worksheet_dropdown")) {
				selectWorksheet();
				actionMethods.waitForElementToAppear(this.context.constants.getShortWaitSeconds(),
						"BOMUploadPage.edit_icon");
				driver.navigate().back();
			}
		}
	}

	@And("^.*verify that BOM File downloaded succesfully \"([^\"]*)\"$")
	public void VerifyBOMDownloaded(String locator) throws Exception {
		int iCountBefore, iCountAfter = 0;
		String strDownloadFolderPath = null;
		strDownloadFolderPath = fileOperations.getDownloadFolderPath();
		iCountBefore = fileOperations.getCountOfFilesInDirectory(strDownloadFolderPath);
		System.out.println(iCountBefore);
		Thread.sleep(1000);
		actionMethods.click(locator);
		Thread.sleep(1000);
		iCountAfter = fileOperations.getCountOfFilesInDirectory(strDownloadFolderPath);
		System.out.println(iCountAfter);
		Assert.assertTrue("file not downloaded", iCountAfter > iCountBefore);
	}

	@And("^I save the value of First Manufacturer Part No from Alternatives table$")
	public void save_first_alt_part_number() throws Exception {
		this.context.ORDER_CODE = actionMethods.getValue("BOMUploadPage.alternativesManuPartNo_text");
		this.context.scenario.log("Value of purchasable Ordercode/SKU obtained: " + this.context.ORDER_CODE);
	}

	@And("^I verify First product is added to BOM from Alternatives table$")
	public void verify_alternative_product_added() throws Exception {
		String AlternativePartNo = this.context.ORDER_CODE;
		String AltManuPartNo_xpath = actionMethods.getLocatorString("BOMUploadPage.alternativeManuPartNo_element")
				+ AlternativePartNo.toLowerCase() + "')]";
		Assert.assertTrue(driver.findElement(By.xpath(AltManuPartNo_xpath)).isDisplayed());
	}

	@And("^.*verify href url of BOM matched product on BOM result page")
	    public void verify_not_an_RLProduct() throws Exception {
		String columnInBomTable = "";
		String viewAllResultsbtn_loc = "";
		WebElement ViewResultCTA =null;
		boolean isViewResultCTAPresent = false;
		List<WebElement> rowsInBOMTable = actionMethods.getMutipleLocators("BOMUploadPage.Bomtable_element");
		int noOfRowsInBOMTable = rowsInBOMTable.size();
		for (int i = 1; i <= noOfRowsInBOMTable; i++) {
		columnInBomTable = actionMethods.getLocatorString("BOMUploadPage.Bomtable_element") + "[" + i + "]/td[6]";
		System.out.println("In Column: " + columnInBomTable);
		
		viewAllResultsbtn_loc = actionMethods.getLocatorString("BOMUploadPage.Bomtable_element") + "[" + i + "]/td[6]//*[@class='right btn btnSecondary allResult']";
		System.out.println("viewAllResultsbtn_loc: " + viewAllResultsbtn_loc);
			try {

				 ViewResultCTA = driver.findElement(By.xpath(viewAllResultsbtn_loc));
				isViewResultCTAPresent = ViewResultCTA.isDisplayed();
				context.scenario.log("Is ViewResultCTA Visible: " + isViewResultCTAPresent);
				} catch (Exception e) {
				System.out.println(e.getStackTrace());
				System.out.println("There is no Viewresultcta");
				}
				if (isViewResultCTAPresent) { 
				ViewResultCTA.click();
				Thread.sleep(10000);
				List<WebElement> Bompartno = actionMethods.getMutipleLocators("BOMUploadPage.BomMpartno_link");
					 actionMethods.clickUsingJSExecutor("BOMUplaodPage.Resultclose_icon");
			}
			else {
				
				System.out.println("Entered the Positive scenario");
				String matchedmpn = actionMethods.getLocatorString("BOMUploadPage.Bomtable_element") +"["+ i +"]/td[4]/a[@class='skulink mfPartNo']";
				WebElement ViewNonRLlink = driver.findElement(By.xpath(matchedmpn));
				if(ViewNonRLlink.isDisplayed()) {
					String Rereelhrefvalue = ViewNonRLlink.getAttribute("href");
					if(Rereelhrefvalue.split("/dp/")[1].contains("RL")||Rereelhrefvalue.split("/dp/")[0].contains("multicomp")) {
						Assert.assertFalse("There are rereel or multicomp products in the MatchedMPN column ", false);
					}else {
						System.out.println("Entered the logging part");
						context.scenario.log("There are no rereel or multicomp products in the MatchedMPN column and nonrereel or non multicomp product is resolved");
					}
				}
			}
		}
		
	}
	
	@And("^.*clicks on view all results matching with \\\"([^\\\"]*)\\\" part number")
	public void findIndexMatchingPartNumber(String partNumber) throws Exception {
		List<WebElement> lstPartNumber = null;
		int iPartNumberCount = 0;
		String ViewAllResults = storeText.getStoreText("View All Results");
		String viewResults_loc = null;
		WebElement parent_element = null;
		String[] splittedText = null;
		
		lstPartNumber = actionMethods.getMutipleLocators("BOMUploadPage.partNumberMultipleMatch_column");
		iPartNumberCount = lstPartNumber.size();
		for (int iLoop=0;iLoop<iPartNumberCount;iLoop++) {
			if (lstPartNumber.get(iLoop).getText().equalsIgnoreCase(partNumber)) {
				parent_element = lstPartNumber.get(iLoop).findElement(By.xpath("./.."));
				splittedText = parent_element.getAttribute("id").split("_");
				viewResults_loc = "//*[@id='bomFileRow_"+splittedText[1]+"']//a[contains(text(),'" + ViewAllResults + "')]";
				getDriver().findElement(By.xpath(viewResults_loc)).click();
				break;
			}
		}
		
	}

	@And("^.*verify the line note option.* \"([^\"]*)\" present in edit dropdown on BOM match modal")
    public void verify_line_note_option(String optionValue) throws Exception {
		boolean optionFound = false;
		String exp_Value = storeText.getStoreText(optionValue);
		List<WebElement> objEle = actionMethods.getMutipleLocators("BOMUploadPage.editManualMatch_dropdown");
		Select select = new Select(objEle.get(0));
		List<WebElement> dropdownOptions = select.getOptions();
		for(int iLoop=0; iLoop<dropdownOptions.size(); iLoop++) {
		    if(dropdownOptions.get(iLoop).getText().equalsIgnoreCase(exp_Value)) {
		    	optionFound=true;
		        break;
		    }
		}
		Assert.assertTrue("Verifying the option value in dropdown",optionFound);
	}
}

