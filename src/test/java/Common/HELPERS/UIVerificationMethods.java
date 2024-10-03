package Common.HELPERS;

import Common.UTILS.WebDriverConfig;
import java.time.Duration;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UIVerificationMethods extends WebDriverConfig {

    private static final Logger logger = LogManager.getLogger(
        UIVerificationMethods.class
    );

    public String verifyBackgroundColor(
        String colorName,
        String colorValue,
        String locator
    ) throws Exception {
        String ColorOfContainer = null;
        WebElement elementObj = getLocator(locator);
        String containerCSSValue = elementObj.getCssValue("background-color");
        ColorOfContainer = Color.fromString(containerCSSValue).asHex();
        logger.info("Value of color obtained: " + ColorOfContainer);
        return ColorOfContainer.trim();
    }

    public String verifyBorderColor(String colorName, String colorValue, String locator)
        throws Exception {
        String ColorOfContainer = null;
        WebElement elementObj = getLocator(locator);
        String containerCSSValue = elementObj.getCssValue("border-color");
        logger.info("Value of CSS Border: " + containerCSSValue);
        ColorOfContainer = Color.fromString(containerCSSValue).asHex();
        logger.info("Value of color obtained: " + ColorOfContainer);
        return ColorOfContainer.trim();
    }

    public String getTextColor(String colorName, String colorValue, String locator)
        throws Exception {
        WebElement elementObj = getLocator(locator);
        String color = elementObj.getCssValue("color");
        String hexColor = Color.fromString(color).asHex();
        logger.info("Text color obtained: " + hexColor);
        return hexColor.trim();
    }

    public Boolean verifySentenceIsNOTBold(String locator) throws Exception {
        WebElement elementObj = getLocator(locator);
        String fontWeight = elementObj.getCssValue("font-weight");
        boolean isBold =
            "bold".equals(fontWeight) ||
            "bolder".equals(fontWeight) ||
            Integer.parseInt(fontWeight) >= 700;
        logger.info("Text is Bold" + isBold);
        return isBold;
    }

    public Boolean verifySentenceIsBold(String locator) throws Exception {
        WebElement elementObj = getLocator(locator);
        String fontWeight = elementObj.getCssValue("font-weight");
        boolean isBold =
            "bold".equals(fontWeight) ||
            "bolder".equals(fontWeight) ||
            Integer.parseInt(fontWeight) >= 700;
        logger.info("Text is Bold" + isBold);
        return isBold;
    }

    public String verifyFontSizeOfText(String locator, String ExpectedFontSize)
        throws Exception {
        WebElement elementObj = getLocator(locator);
        String ActualFontSize = elementObj.getCssValue("font-size");
        logger.info("Font Size of text is obtained: " + ActualFontSize.trim());
        return ActualFontSize.trim();
    }

    public String verifyAlignmentOfText(String locator, String expectedAlign)
        throws Exception {
        WebElement elementObj = getLocator(locator);
        String ActualAlignment = elementObj.getCssValue("text-align");
        logger.info("Alignment is obtained: " + ActualAlignment.trim());
        return ActualAlignment;
    }

    public Boolean verifyLinkIsPresent(String locator) throws Exception {
        boolean value = false;
        WebElement elementObj = getLocator(locator);
        String getHrefValue = elementObj.getAttribute("href");
        if (!getHrefValue.equalsIgnoreCase(null)) {
            logger.info("Link is present");
            value = true;
        }
        return value;
    }

    public void scrollToAnyWhere(String locator) throws Exception {
        WebElement elementObj = getLocator(locator);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", elementObj);
    }

    public Boolean ScrollAndVerifyText(String locator, String text) throws Exception {
        WebElement elementObj = getLocator(locator);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", elementObj);
        String ActualText = elementObj.getText();
        logger.info("Value obtained: " + ActualText);
        if (ActualText.equalsIgnoreCase(text.trim())) {
            return true;
        } else {
            return false;
        }
    }

    public String checkforScrollPresent() {
        String value = "";

        JavascriptExecutor javascript = (JavascriptExecutor) getDriver();
        // Check If horizontal scroll Is present or not.
        Boolean b1 = (Boolean) javascript.executeScript(
            "return document.documentElement.scrollWidth>document.documentElement.clientWidth;"
        );
        // Check If vertical scroll Is present or not.
        Boolean b2 = (Boolean) javascript.executeScript(
            "return document.documentElement.scrollHeight>document.documentElement.clientHeight;"
        );

        if (b1 == true && b2 == true) {
            logger.info("Horizontal and vertical Scrollbar is present on page.");
            value = "Both Vertical and Horizontal";
        } else if (b1 == false && b2 == true) {
            logger.info("Horizontal Scrollbar is not present on page.");
            logger.info("Vertical Scrollbar is present on page.");
            value = "Only Vertical";
        } else if (b1 == true && b2 == false) {
            logger.info("Horizontal Scrollbar is not present on page.");
            logger.info("Vertical Scrollbar not present on page.");
            value = "Only Horizontal";
        } else if (b1 == false && b2 == false) {
            logger.info("Horizontal and Vertical Scrollbar not present on page.");
            value = "No Horizontal No Vertical";
        }

        return value;
    }

    // Important Method 1
    public Boolean verifyTextExistence(String value_get, String locator)
        throws Exception {
        String value = storeText.getStoreText(value_get);
        String text = "[^" + value + "]";
        WebElement elementObj = getLocator(locator);
        String textValue =
            (
                (
                    (
                        (
                            elementObj
                                .getAttribute("innerHTML")
                                .replaceAll("\\<.*?\\>", "")
                        ).replaceAll("\\s{2,}", "\n")
                            .trim()
                    )
                ).replaceAll(text, "@")
            ).replaceAll("@", "");
        logger.info("Text exists on the page: " + textValue);
        if (textValue.contains(value.trim())) {
            return true;
        } else {
            return false;
        }
    }

    // Important Method 2 Example of passing xpath to be
    // searched:("class=\"cadViewerTitle\"")) {
    public boolean verifyPresenceOfXpath(String xpath, String locator) throws Exception {
        WebElement elementObj = getLocator(locator);
        String textValue = elementObj.getAttribute("innerHTML");
        if (textValue.contains(xpath)) {
            return true;
        } else {
            return false;
        }
    }

    // Important Method 3
    public Boolean verifyElementExistence(String locator) throws Exception {
        List<WebElement> elementObj = getMutipleLocators(locator);
        logger.info("Element exists on the page: " + elementObj.size());
        if (elementObj.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean isElementDisplayed(String locator) {
        actionMethods.waitForElementToAppear(15, locator);
        try {
            WebElement elementObj = getLocator(locator);
            return elementObj.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean isElementSelected(String locator) {
        actionMethods.waitForElementToAppear(15, locator);
        try {
            WebElement elementObj = getLocator(locator);
            return elementObj.isSelected();
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean verifyTextStartWithGivenWord(String locator, String ExpectedWord)
        throws Exception {
        WebElement elementObj = getLocator(locator);
        String ActualText = elementObj.getText();
        System.out.println("actual text is obtained...." + ActualText);
        if (ActualText.startsWith(ExpectedWord)) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean verifyTextEndsWithGivenWord(String locator, String ExpectedWord)
        throws Exception {
        WebElement elementObj = getLocator(locator);
        String ActualText = elementObj.getText();
        System.out.println("actual text is obtained...." + ActualText);
        if (ActualText.endsWith(ExpectedWord)) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean isElementEnabled(String locator) {
        actionMethods.waitForElementToAppear(15, locator);
        try {
            WebElement elementObj = getLocator(locator);
            return elementObj.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean isElementPresent(String locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        try {
            wait.until(ExpectedConditions.visibilityOf(getLocator(locator)));
            WebElement elementObj = getLocator(locator);
            return elementObj.isDisplayed();
        } catch (Exception e) {
            logger.info("Visibility Of timed out: " + locator);
            return false;
        }
    }
    
    public Boolean isElementClickable(String locator) throws Exception {
        actionMethods.waitForElementToAppear(15, locator);
            WebElement elementObj = getLocator(locator);
            if(!elementObj.getAttribute("class").contains("disabled")){
            return true;
            }else{
            	return false;	
            }
    }
    
}
