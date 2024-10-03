package StepDefinition.WEB;

import Common.UTILS.ContextStore;
import Common.UTILS.ExcelUtilities;
import Common.UTILS.WebDriverConfig;
import io.cucumber.java.en.And;
import java.*;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

public class QuickBuySteps extends WebDriverConfig {

    private ContextStore context;
    String FilePath =
        System.getProperty("user.dir") +
        "//src//test//resources//TestData//" +
        getEnv().toUpperCase() +
        "//";

    String store = getStore();
    String env = getEnv();
    String region = getRegionName();

    public QuickBuySteps(ContextStore context) {
        this.context = context;
    }

    @And(
        "^.*enter quick paste order details information by using given file \"([^\"]*)\"$"
    )
    public void enter_quickpaste_order_details(String FileName) throws Exception {
        String path = FilePath + FileName;
        List<Map<String, String>> testData = ExcelUtil.getData(path, store);

        Workbook workbook = ExcelUtil.getWorkbook(path);
        Sheet sheet = workbook.getSheet(store);
        int rowCount = sheet.getLastRowNum();

        for (int rowNum = 0; rowNum < rowCount; rowNum++) {
            String orderCode = testData.get(rowNum).get("orderCode");
            String quantity = testData.get(rowNum).get("quantity");
            String lineNote = testData.get(rowNum).get("lineNote");
            String partNo = testData.get(rowNum).get("partNo");

            String quickPasteOrderinfo =
                orderCode + "," + quantity + "," + lineNote + "," + partNo + "\t\n";
            actionMethods.enterText(
                quickPasteOrderinfo,
                "QuickBuy.quickPasteArea_textbox"
            );
            actionMethods.enterToNextLine("QuickBuy.quickPasteArea_textbox");
            context.scenario.log("quick paste orderInformation: " + quickPasteOrderinfo);
        }
    }

    @And(
        "^.*fill quickbuy order details on QuickBuy Page by using given file.* \"([^\"]*)\"$"
    )
    public void enter_part_number(String FileName) throws Exception {
        String path = FilePath + FileName;
        List<Map<String, String>> testData = ExcelUtil.getData(path, store);

        Workbook workbook = ExcelUtil.getWorkbook(path);
        Sheet sheet = workbook.getSheet(store);
        int rowCount = sheet.getLastRowNum();

        for (int rowNum = 0; rowNum < rowCount; rowNum++) {
            String orderCode = testData.get(rowNum).get("orderCode");
            String quantity = testData.get(rowNum).get("quantity");
            String lineNote = testData.get(rowNum).get("lineNote");
            String partNo = testData.get(rowNum).get("partNo");

            int i = rowNum + 1;

            String orderCode_xpath =
                actionMethods.getLocatorString("QuickBuy.orderCodePartial_element") +
                i +
                "']";
            actionMethods
                .getDriver()
                .findElement(By.xpath(orderCode_xpath))
                .sendKeys(orderCode);

            String quantity_xpath =
                actionMethods.getLocatorString("QuickBuy.quantityPartial_element") +
                i +
                "']";
            actionMethods
                .getDriver()
                .findElement(By.xpath(quantity_xpath))
                .sendKeys(quantity);

            String lineNote_xpath =
                actionMethods.getLocatorString("QuickBuy.linNotePartial_element") +
                i +
                "']";
            actionMethods
                .getDriver()
                .findElement(By.xpath(lineNote_xpath))
                .sendKeys(lineNote);

            String partNo_xpath =
                actionMethods.getLocatorString("QuickBuy.partNoPartial_elements") +
                i +
                "']";
            actionMethods
                .getDriver()
                .findElement(By.xpath(partNo_xpath))
                .sendKeys(partNo);

            context.scenario.log(
                "quickBuy orderInformation: " +
                orderCode +
                "  " +
                quantity +
                "  " +
                lineNote +
                "  " +
                partNo
            );
        }
    }

    @And(
        "^.*verify items added to Shopping BasketPage by using quickbuy from file \"([^\"]*)\"$"
    )
    public void verify_item__added_to_shopping_basket_page(String filename)
        throws Exception {
        String path = FilePath + filename;
        List<Map<String, String>> testData = ExcelUtil.getData(path, store);

        Workbook workbook = ExcelUtil.getWorkbook(path);
        Sheet sheet = workbook.getSheet(store);
        int rowCount = sheet.getLastRowNum();
        int i = 0;
        for (int rowNum = 0; rowNum < rowCount; rowNum++) {
            String orderCode = testData.get(rowNum).get("orderCode");
            String quantity = testData.get(rowNum).get("quantity");
            String lineNote = testData.get(rowNum).get("lineNote");
            String partNo = testData.get(rowNum).get("partNo");

            if (region.equalsIgnoreCase("newark")) {
                i = rowCount - rowNum;
            } else {
                i = rowNum + 1;
            }
            String orderCodeOnCart_xpath =
                actionMethods.getLocatorString("ShoppingCart.productCodeOnCart_list") +
                "[" +
                i +
                "]" +
                "/li[2]/span";
            String orderCodeOnCart = actionMethods
                .getDriver()
                .findElement(By.xpath(orderCodeOnCart_xpath))
                .getText();
            Assert.assertTrue(
                "Ordercode is not matched",
                orderCode.equalsIgnoreCase(orderCodeOnCart)
            );

            String quantityOnCart_xpath =
                actionMethods.getLocatorString(
                    "ShoppingCart.quantityOnCartPartial_element"
                ) +
                i +
                "']";
            String quantityOnCart = actionMethods
                .getDriver()
                .findElement(By.xpath(quantityOnCart_xpath))
                .getAttribute("value");
            Assert.assertTrue(
                "quantity Note is not matched",
                quantity.equalsIgnoreCase(quantityOnCart)
            );

            String lineNoteOnCart_xpath =
                actionMethods.getLocatorString(
                    "ShoppingCart.lineNoteOnCartPartial_element"
                ) +
                i +
                "']";
            String lineNoteOnCart = actionMethods
                .getDriver()
                .findElement(By.xpath(lineNoteOnCart_xpath))
                .getAttribute("value");
            Assert.assertTrue(
                "line Note is not matched",
                lineNote.equalsIgnoreCase(lineNoteOnCart)
            );

            String partNoOnCart_xpath =
                actionMethods.getLocatorString(
                    "ShoppingCart.partNumberOnCartPartial_element"
                ) +
                i +
                "']";
            String partNoOnCart = actionMethods
                .getDriver()
                .findElement(By.xpath(partNoOnCart_xpath))
                .getAttribute("value");
            Assert.assertTrue(
                "Part Number is matched",
                partNo.equalsIgnoreCase(partNoOnCart)
            );
        }
    }
    
    @And("^.*fill the form with different product code using given file \"([^\"]*)\"$")
    public void fillQuickBuyForm(String FileName) throws Exception {
        String path = FilePath + FileName;
        List<Map<String, String>> testData = ExcelUtil.getData(path, getStore());
        String NoLongerStocked = testData.get(0).get("NoLongerStocked");
        String NoLongerManufactured = testData.get(0).get("NoLongerManufactured");
        String AvailableForBackOrder = testData.get(0).get("AvailableForBackOrder");
        String NotCurrentlyInStock = testData.get(0).get("NotCurrentlyInStock");
        String MultipleMatch = testData.get(0).get("MultipleMatch");
        String CutTape = testData.get(0).get("CutTape");
        String NoResult = testData.get(0).get("NoResult");
        String Valid = testData.get(0).get("Valid");
        
        if(!region.equalsIgnoreCase("APAC")) {
        Boolean basketValue = uiMethods.isElementEnabled("QuickBuy.addToAllBasketDisabled_button");
        Assert.assertTrue(basketValue);
        actionMethods.enterText(NoLongerManufactured, "QuickBuy.firstrow_textbox");
        Thread.sleep(5000);
        }
        actionMethods.enterText(Valid, "QuickBuy.secondrow_textbox");
        Thread.sleep(3000);
        Boolean basketValue1 = uiMethods.isElementEnabled("QuickBuy.addToAllBasket_button");
        Assert.assertTrue(basketValue1);
        
        actionMethods.enterText(MultipleMatch, "QuickBuy.thirdrow_textbox");
        Thread.sleep(3000);
        
        
        int numOfRowsInMultipleMatch = actionMethods.getCountOfElements("QuickBuy.multipleMatchItems");
        
        Assert.assertEquals(5, numOfRowsInMultipleMatch);
        
        actionMethods.scrollDownPage(200);
        actionMethods.click("QuickBuy.multipleMatchItems");
        
        actionMethods.enterText(NoResult, "QuickBuy.fourthrow_textbox");
        actionMethods.waitForElementToAppear(this.context.constants.getMediumWaitSeconds(),"QuickBuy.invalidMessage_text");
        Boolean basketValue3 = uiMethods.isElementPresent("QuickBuy.invalidMessage_text");
        Thread.sleep(2000);
        Assert.assertTrue(basketValue3);
        
        actionMethods.enterText(Valid, "QuickBuy.fifthrow_textbox");
        Thread.sleep(3000);
        actionMethods.click("QuickBuy.delete_icon");
        actionMethods.click("QuickBuy.deletePopup_button");
    }
    
    @And("^.*check the limit for the addition of rows by adding rows \"([^\"]*)\"$")
    		public void CheckLimitToAddRows(String locator) throws Exception  {	
    	    for( int i = 1; i <= 44; i++) {
    	      actionMethods.click(locator);
    	      Thread.sleep(2000);
    	    }
    	    actionMethods.scrollDownPage(2000);
           Boolean value = uiMethods.isElementPresent("QuickBuy.addRowDisabled_button");
           Assert.assertTrue(value);
    }
    
}
