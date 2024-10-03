package StepDefinition.WEB;

import Common.UTILS.ContextStore;
import Common.UTILS.ScreenshotUtil;
import Common.UTILS.WebDriverConfig;
import StepDefinition.GENERIC.BaseSteps;
import StepDefinition.GENERIC.UtilitySteps;
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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public class OrderHistoryAndTrackingSteps extends WebDriverConfig {

    private ContextStore context;
    String FilePath =
        System.getProperty("user.dir") +
        "//src//test//resources//TestData//" +
        getEnv().toUpperCase() +
        "//";

    String store = getStore();
    String env = getEnv();
    String region = getRegionName();

    public OrderHistoryAndTrackingSteps(ContextStore context) {
        this.context = context;
    }

    @SuppressWarnings("static-access")
    @And("^.*order history table is displayed.*$")
    public void VerifyOrderHistoryTableInMyAccount() throws Exception {
        long initialSeconds = actionMethods.getEpochSeconds();
        long currentSeconds = 0;
        UtilitySteps utilitySteps = new UtilitySteps(context);
        do {
            currentSeconds = actionMethods.getEpochSeconds();
            utilitySteps.refreshBrowser();
        } while (
            !(uiMethods.isElementDisplayed("OrderHistory.orderHistory_table")) ||
            ((currentSeconds - initialSeconds) >= 120)
        );
    }

    @And("^.*to order history and tracking page.*$")
    public void NavigateToOrderHistoryPage() throws Exception {
        actionMethods.hoverOnElement("Header.myAccount_dropdown");
        actionMethods.click("Header.orderHistory_list");
    }

    @And("Selects a order with {string} in order history and tracking page")
    public void SelectOrder(String orderConfirmationNumber) throws Exception {
        WebElement objPONumber = null;
        WebElement objOrderHistory = actionMethods.getLocator(
            "OrderHistory.orderHistory_table"
        );
        Actions objActions = new Actions(driver);
        objActions.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(1000);
        List<WebElement> objOrderHistory_rows = getDriver().findElements(By.xpath("//*[@class='orderStatus']//tbody/tr/td[3]"));
    	for (int iLoop=0;iLoop<objOrderHistory_rows.size();iLoop++) {
    		if (objOrderHistory_rows.get(iLoop).getText().equalsIgnoreCase(orderConfirmationNumber)) {
    			objPONumber = getDriver().findElement(By.xpath("//*[@class='orderStatus']//tbody/tr["+(iLoop+1)+"]/td[2]/a"));
    			objPONumber.click();
    			//Thread.sleep(10000);
    			break;
    		}
    	}
    }

    @And("Selects a order with {string} in orders and reports page")
    public void SelectOrder_iBuyUser(String orderConfirmationNumber) throws Exception {
        WebElement objPONumber = null;
        WebElement objOrderHistory = actionMethods.getLocator(
            "OrderHistory.orderHistory_table"
        );
        Actions objActions = new Actions(driver);
        objActions.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(1000);
        List<WebElement> objOrderHistory_rows = getDriver().findElements(By.xpath("//*[@class='orderStatus']//tbody/tr/td[1]"));
    	for (int iLoop=0;iLoop<objOrderHistory_rows.size();iLoop++) {
    		if (objOrderHistory_rows.get(iLoop).getText().equalsIgnoreCase(orderConfirmationNumber)) {
    			objPONumber = getDriver().findElement(By.xpath("//*[@class='orderStatus']//tbody/tr["+(iLoop+1)+"]/td[1]//a"));
    			objPONumber.click();
    			//Thread.sleep(10000);
    			break;
    		}
    	}
    }
    
    
    
	@And("^.*verify iBuy \"([^\"]*)\" and \"([^\"]*)\" fields  displayed in order Info$")
	public void verify_Dept_CostCode_ibuy(String dept, String costCode) throws Exception {

		if ((getRegionName().equalsIgnoreCase("newark"))) {
			String exp_CostCode = storeText.getStoreText(costCode);
			String locator;
			String elemText;
			String value;

			locator = "OrderHistory.CostCode_element";
			elemText = "OrderHistory.CostCode_text";
			Assert.assertTrue(locator+ " not displayed",uiMethods.isElementDisplayed(locator));
			String act_CostCode = getLocator(locator).getText();
			Assert.assertEquals("CostCode Custom field not displayed in order details",exp_CostCode, act_CostCode);
			this.context.scenario.log("Cost Code field displayed in order info");
			value = actionMethods.getValue(elemText);
			System.out.println("value of CostCode: " + value);
			Assert.assertFalse("CostCode value is missing", value.isEmpty());
			this.context.scenario.log("The value of CostCode present on page: " + value);
		}

		if (!(getRegionName().equalsIgnoreCase("newark"))) {
			List<String> expListItems = new ArrayList<>();
			expListItems.add(costCode);
			expListItems.add(dept);
			List<String> expTranslatedListItems = new ArrayList<>();
			List<String> actListItems = new ArrayList<>();
			String StoreValue = getStore().toLowerCase();

			System.out.println("ExpTransalatedList:");
			expListItems.forEach(d -> {
				expTranslatedListItems.add(storeText.getStoreText(d));
				System.out.println(storeText.getStoreText(d) + ",");
			});
			List<WebElement> actWebElementList = getMutipleLocators("OrderHistory.OrderInfo_elements");
			System.out.println("ActualPLPList:");
			actWebElementList.forEach(e -> {
				System.out.println("ActualTextDisplayed:" + e.getText() + ",");
				String temp = e.getText().trim();
				actListItems.add(temp);
				System.out.println(temp + ",");
			});
			Assert.assertTrue("List items does not match- Dept and CostCode not found",
					actListItems.containsAll(expTranslatedListItems));
			this.context.scenario.log("Department and Cost Code field displayed in order info");

			for (String K : expTranslatedListItems) {
				if (actListItems.contains(K)) {
					int m = actListItems.indexOf(K);
					int l=m+1;
					String elementText = "(//div[@class='orderInfo headCol']//p)[" + l + "]";
					WebElement elementObj = getDriver().findElement(By.xpath(elementText));
					String value = elementObj.getText().trim();
					Assert.assertFalse("Value for "+K+" is missing", value.isEmpty());
					this.context.scenario.log("The value for " + K + " present on page:" + value);
				}
			}
		}
	}

	@And("^.*verify iBuy \"([^\"]*)\" and \"([^\"]*)\" fields  displayed in order shipping details$")
	public void verify_LineNote_ProjCode_ibuy(String lineNote, String projCode) throws Exception {

		String exp_LineNote = storeText.getStoreText(lineNote);
		String exp_ProjCode = storeText.getStoreText(projCode);
		String locator;
		String elemText;
		String value;
		String locator1;
		String elemText1;
		String value1;

		locator = "OrderHistory.LineNote_element";
		elemText = "OrderHistory.LineNote_text";
		Assert.assertTrue(locator+" not displayed",uiMethods.isElementDisplayed(locator));
		String act_LineNote = getLocator(locator).getText();
		Assert.assertEquals("LineNote Custom field not displayed in order details",exp_LineNote, act_LineNote);
		this.context.scenario.log("Line Note field displayed in order details");
		value = actionMethods.getValue(elemText);
		System.out.println("value of LineNote: " + value);
		Assert.assertFalse("Line Note value is missing", value.isEmpty());
		this.context.scenario.log("The value of LineNote present on page: " + value);

		locator1 = "OrderHistory.ProjCode_element";
		elemText1 = "OrderHistory.ProjCode_text";
		Assert.assertTrue(locator1+" not displayed",uiMethods.isElementDisplayed(locator1));
		String act_ProjCode = getLocator(locator1).getText();
		Assert.assertEquals("ProjectCode Custom field not displayed in order details",exp_ProjCode, act_ProjCode);
		this.context.scenario.log("Project Code field displayed in order details");
		value1 = actionMethods.getValue(elemText1);
		System.out.println("value of Project Code: " + value1);
		Assert.assertFalse("Project Code value is missing", value1.isEmpty());
		this.context.scenario.log("The value of Project Code present on page: " + value1);

	}
    

    @And("Clicks on view invoice link for order with {string}")
    public void ClickViewInvoiceLink(String orderConfirmationNumber) throws InterruptedException {
    	WebElement objViewinvoice_link = null;
    	Actions objActions = new Actions(driver);
        objActions.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(1000);
        List<WebElement> objOrderHistory_rows = getDriver().findElements(By.xpath("//*[@class='orderStatus']//tbody/tr/td[3]"));
        for (int iLoop=0;iLoop<objOrderHistory_rows.size();iLoop++) {
    		if (objOrderHistory_rows.get(iLoop).getText().equalsIgnoreCase(orderConfirmationNumber)) {
    			objViewinvoice_link = getDriver().findElement(By.xpath("//*[@class='orderStatus']//tbody/tr["+(iLoop+1)+"]/td[10]/a"));
    			objViewinvoice_link.click();
    			break;
    		}
    	}
    }
    
    @Then("Verify that open order report downloaded succesfully")
    public void VerifyReportDownloaded() throws InterruptedException{
    	int iCountBefore, iCountAfter = 0;
    	String strDownloadFolderPath = null;
    	strDownloadFolderPath = fileOperations.getDownloadFolderPath();
    	iCountBefore = fileOperations.getCountOfFilesInDirectory(strDownloadFolderPath);
    	System.out.println(iCountBefore);
    	Thread.sleep(1000);
    	actionMethods.waitForElementToDisappear(30, "OrderHistory.downloadProgress_modal");
    	Thread.sleep(1000);
    	iCountAfter = fileOperations.getCountOfFilesInDirectory(strDownloadFolderPath);
    	System.out.println(iCountAfter);
    	Assert.assertTrue(
                "Open order report not downloaded",
                iCountAfter>iCountBefore);
    }
}
