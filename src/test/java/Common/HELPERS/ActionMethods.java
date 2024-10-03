package Common.HELPERS;
import static Common.CONSTANTS.GlobalConstants.FEEDBACKFORM_OBJS;

import Common.UTILS.WebDriverConfig;
import java.time.Duration;
import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionMethods extends WebDriverConfig {

    private static final Logger logger = LogManager.getLogger(ActionMethods.class);
    String mainWindow;
    String childWindow;

    public void enterText(String value, String locator) throws Exception {
        WebElement elementObj = getLocator(locator);
        elementObj.sendKeys(value.trim());
    }

    public void clearText(String locator) throws Exception {
        WebElement elementObj = getLocator(locator);
        elementObj.click();
        elementObj.clear();
    }

    public void click(String locator) throws Exception {
        WebElement elementObj = getLocator(locator);
        elementObj.click();
    }

    public void clickUsingJSExecutor(String locator) throws Exception {
        WebElement elementObj = getLocator(locator);
        ((JavascriptExecutor) getDriver()).executeScript(
                "arguments[0].click();",
                elementObj
            );
    }

    public String generateRandomNumberString(String stringToConvert) {
        Random rand = new Random();
        if (stringToConvert != null) {
            return stringToConvert.concat(
                (Integer.toString(rand.nextInt(Integer.MAX_VALUE)))
            );
        } else {
            return null;
        }
    }

    public String getValue(String locator) throws Exception {
        WebElement elementObj = getLocator(locator);
        logger.info("Visible text on the page is: " + elementObj.getText());
        return (elementObj.getText().trim());
    }

    public String getMultipleValuesInTag(String locator) throws Exception {
        WebElement elementObj = getLocator(locator);
        String textValue =
            (
                (
                    elementObj.getAttribute("innerHTML").replaceAll("\\<.*?\\>", "")
                ).replaceAll("\\s{2,}", "\n")
                    .trim()
            );
        logger.info("Multiple values in tag are: " + textValue.trim());
        return (textValue.trim());
    }

    public String getValueUsingAttribute(String locator, String attributeType)
        throws Exception {
        WebElement elementObj = getLocator(locator);
        String value = elementObj.getAttribute(attributeType);
        return value;
    }

    public void DrawBorderToElement(String locator) throws Exception {
        WebElement elementObj = getLocator(locator);
        ((JavascriptExecutor) getDriver()).executeScript(
                "arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
                elementObj
            );
    }

    public void selectValueByText(String name, String locator) throws Exception {
        WebElement elementObj = getLocator(locator);
        Select value = new Select(elementObj);
        value.selectByVisibleText(storeText.getStoreText(name));
    }

    public void selectValueByValue(String option, String locator) throws Exception {
        WebElement elementObj = getLocator(locator);
        Select value = new Select(elementObj);
        value.selectByValue(option);
    }

    public void selectValueByIndex(int index, String locator) throws Exception {
        WebElement elementObj = getLocator(locator);
        Select value = new Select(elementObj);
        value.selectByIndex(index);
    }

    public void clickAndHover(String locator) throws Exception {
        WebElement elementObj = getLocator(locator);
        Actions action = new Actions(driver);
        action.moveToElement(elementObj).click().build().perform();
    }

    public void hoverOnElement(String locator) throws Exception {
        WebElement elementObj = getLocator(locator);
        Actions action = new Actions(driver);
        action.moveToElement(elementObj).build().perform();
    }

    public void enterToNextLine(String locator) throws Exception {
        WebElement elementObj = getLocator(locator);
        elementObj.sendKeys(Keys.ENTER);
    }

    public void waitForElementToAppear(long sec, String locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(sec));
        try {
            wait.until(ExpectedConditions.visibilityOf(getLocator(locator)));
        } catch (Exception e) {
            logger.info("Visibility Of timed out: " + locator);
        }
    }

    public void waitForByElementToAppear(long sec, String locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(sec));
        try {
	        wait.until(ExpectedConditions.presenceOfElementLocated(getLocatorByObj(locator)));
        } catch (Exception e) {
            logger.info("Visibility Of By obj timed out: " + locator);
        }
    }

    public void waitForElementToDisappear(long sec, String locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(sec));
        try {
            wait.until(ExpectedConditions.invisibilityOf(getLocator(locator)));
        } catch (Exception e) {
            logger.info("Invisibility Of element timed out: " + locator);
        }
    }

    public void waitForAttributeToContain(
        long sec,
        String locator,
        String attribute,
        String value
    ) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(sec));
        try {
            wait.until(
                ExpectedConditions.attributeContains(
                    getLocator(locator),
                    attribute,
                    value
                )
            );
        } catch (Exception e) {
            logger.info("AttributeContains element timed out: " + locator);
        }
    }

    public void waitForURLContains(long sec, String keyword) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(sec));
        try {
            wait.until(ExpectedConditions.urlContains(keyword));
        } catch (Exception e) {
            logger.info("Visibility Of url contains timed out: " + keyword);
        }
    }

    public void waitForElemenToGetRefreshed(long sec, String locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(sec));
        try {
            wait.until(
                ExpectedConditions.refreshed(
                    ExpectedConditions.stalenessOf(getLocator(locator))
                )
            );
        } catch (Exception e) {
            logger.info("Visibility Of timed out:" + locator);
        }
    }

    public void scrollDownPage(double VerticalDown) {
        ((JavascriptExecutor) getDriver()).executeScript(
                "window.scrollBy(0," + VerticalDown + ")"
            );
    }

    public void scrollUpPage(double VerticalUp) {
        VerticalUp = -VerticalUp;
        String k = "scrollBy(0," + VerticalUp + ")";
        ((JavascriptExecutor) getDriver()).executeScript(
                "window.scrollBy(0," + VerticalUp + ")"
            );
    }

    public static long getEpochSeconds() {
        long unixTime = System.currentTimeMillis() / 1000L;
        return (unixTime);
    }

    public void switchToWindow() {
       mainWindow = getDriver().getWindowHandle();
        for (String handle : getDriver().getWindowHandles()) {
            if (!(handle.equals(mainWindow))) {
                getDriver().switchTo().window(handle);
                System.out.println("Switched to child window");
            }
        }
    }

    public void closeChildWindow() {
    	 for (String handle : getDriver().getWindowHandles()) {
             if (!(handle.equals(mainWindow))) {
                 getDriver().close();
             }
         }
    	 getDriver().switchTo().window(mainWindow);
    	 System.out.println("Successfully redirected to main window");
    }

    public String getAmount(String amount) {
        switch (getStore()) {
            case "de":
                if (
                    !getDriver().getCurrentUrl().contains("langId=74") &&
                    !getDriver().getCurrentUrl().contains("en-DE")
                ) {
                    amount = amount.replace(".", "^").replace(",", ".").replace("^", ",");
                }
                break;
            case "it":
                if (
                    !getDriver().getCurrentUrl().contains("langId=39") &&
                    !getDriver().getCurrentUrl().contains("en-IT")
                ) {
                    amount = amount.replace(".", "^").replace(",", ".").replace("^", ",");
                }
                break;
            case "fr":
                if (
                    !getDriver().getCurrentUrl().contains("langId=73") &&
                    !getDriver().getCurrentUrl().contains("en-FR")
                ) {
                    amount = amount.replace(".", "^").replace(",", ".").replace("^", ",");
                }
                break;
        }
        return amount.replaceAll("[^0-9.]", "");
    }

    public void clickOnOffset(int x, int y) throws Exception {
        Actions action = new Actions(driver);
        action.moveByOffset(x, y).click().perform();
    }

    public void navigateToPage(String valueToAppend) throws Throwable {
        String baseURL = driver.getCurrentUrl().split(".com")[0] + ".com";
        driver.get(baseURL + "/" + valueToAppend);
    }

    public void pressTabKey(String locator) throws Exception {
        WebElement elementObj = getLocator(locator);
        elementObj.sendKeys(Keys.TAB);
    }

    public void pressShiftTabKey(String locator) throws Exception {
        WebElement elementObj = getLocator(locator);
        elementObj.sendKeys(Keys.chord(Keys.SHIFT, Keys.TAB));
    }

    //input.sendKeys(Keys.chord(Keys.CONTROL, "a"));

    public int getCountOfElements(String locator) throws Exception {
        int count = getMutipleLocators(locator).size();
        return count;
    }

    public void switchToParentWindow() {
        String mainWindow = getDriver().getWindowHandle();
        for (String handle : getDriver().getWindowHandles()) {
            if (!(handle.equals(mainWindow))) {
                getDriver().switchTo().window(mainWindow);
                System.out.println("Switched to Parent window");
            }
        }
    }


    public void clickLinkText(String locator) throws Exception {
        WebElement elementObj = getDriver().findElement(By.linkText(locator));
        elementObj.click();

    }

    public void setLocalStorageToSkipFeedbackForms() {
        WebStorage webStorage = (WebStorage) new Augmenter().augment(driver);
        // using local storage
        LocalStorage localStorage = webStorage.getLocalStorage();

        for (String key : FEEDBACKFORM_OBJS.keySet()) {
            localStorage.setItem(key, FEEDBACKFORM_OBJS.get(key));
            System.out.println("local storage key & value: " + key + " " + localStorage.getItem(key));
        }
    }
    
    public String getFirstSelectedOption(String locator) throws Exception {
        WebElement elementObj = getLocator(locator);
        Select value = new Select(elementObj);
        WebElement ele = value.getFirstSelectedOption();
        String selectedOption = ele.getText();
        return selectedOption;
    }
    
    public void waitForPageLoad(long sec) {
        try {
            new WebDriverWait(getDriver(), Duration.ofSeconds(sec)).until(webDriver -> 
            ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        } catch (Exception e) {
            logger.error("Error!", e);
        }
    }
    
}
