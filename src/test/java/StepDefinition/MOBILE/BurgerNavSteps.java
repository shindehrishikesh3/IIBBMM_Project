package StepDefinition.MOBILE;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import io.cucumber.java.en.And;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class BurgerNavSteps extends WebDriverConfig {

    private ContextStore context;

    public BurgerNavSteps(ContextStore context) {
        this.context = context;
    }

    @And("^.*verify.* elements \"([^\"]*)\" with .* aligned as \"([^\"]*)\"$")
    public void verifyListofElements_Alignment(String locators, String expectedAlignment)
        throws Exception {
        List<WebElement> categoryList = actionMethods.getMutipleLocators(locators);
        for (int i = 1; i <= categoryList.size(); i++) {
            String category_Xpath =
                actionMethods.getLocatorString(locators) + "[" + i + "]";
            String ActualAlignment;
            try {
                ActualAlignment =
                    driver
                        .findElement(By.xpath(category_Xpath))
                        .getCssValue("text-align");
            } catch (NoSuchElementException e) {
                // TODO Auto-generated catch block
                String loc =
                    "(" + actionMethods.getLocatorString(locators) + ")" + "[14]";
                ActualAlignment =
                    driver.findElement(By.xpath(loc)).getCssValue("text-align");
                category_Xpath = loc;
            }

            //*[@class='category level-1-category panel panel-primary']/ul[2]/li/a
            Assert.assertTrue(
                "The Alignment of text does not  matches the expected",
                ActualAlignment.trim().equalsIgnoreCase(expectedAlignment.trim())
            );
            String value = null;
            try {
                value =
                    actionMethods
                        .getDriver()
                        .findElement(By.xpath(category_Xpath + "/a"))
                        .getText();
            } catch (NoSuchElementException e) {
                // TODO: handle exception
                	value =
                    actionMethods
                        .getDriver()
                        .findElement(By.xpath(category_Xpath + "/section/div/a"))
                        .getText();
            	
            }

            if (
                (!value.contains(storeText.getStoreText("View All Products"))) &&
                (!value.contains(storeText.getStoreText("Manufacturers")))
            ) {
                String classValue;
                if (value.equalsIgnoreCase("Resources")) {
                    classValue =
                        driver
                            .findElement(By.xpath(category_Xpath + "/section/div/a"))
                            .getAttribute("class");
                } else {
                	try {                		
                		classValue =
                				driver
                				.findElement(By.xpath(category_Xpath + "/a"))
                				.getAttribute("class");
                	}catch(NoSuchElementException e) {
                		classValue =
                				driver
                				.findElement(By.xpath(category_Xpath + "/section/div/a"))
                				.getAttribute("class");
                	}
                }
                if (classValue.equalsIgnoreCase("arrowRightArrow")) {
                    this.context.scenario.log(
                            "The Category " +
                            value +
                            " is aligned left as expected with RightArrow"
                        );
                } else {
                    Assert.fail();
                }
            } else {
                this.context.scenario.log(
                        "The Category " +
                        value +
                        " is aligned left as expected without RightArrow"
                    );
            }
        }
    }

    @And("^user verify.* elements Sub Menu \"([^\"]*)\" with .* aligned as \"([^\"]*)\"$")
    public void verifyListofElements_Alignment_SubMenu(
        String locators,
        String expectedAlignment
    ) throws Exception {
        List<WebElement> categoryList = actionMethods.getMutipleLocators(locators);
        for (int i = 1; i <= categoryList.size(); i++) {
            String category_Xpath =
                actionMethods.getLocatorString(locators) + "[" + i + "]";
            String ActualAlignment;

            ActualAlignment =
                driver.findElement(By.xpath(category_Xpath)).getCssValue("text-align");

            Assert.assertTrue(
                "The Alignment of text does not  matches the expected",
                ActualAlignment.trim().equalsIgnoreCase(expectedAlignment.trim())
            );
            String value;
            value =
                actionMethods
                    .getDriver()
                    .findElement(By.xpath(category_Xpath + "/li/a"))
                    .getText();

            String classValue;
            classValue =
                driver
                    .findElement(By.xpath(category_Xpath + "/li/a"))
                    .getAttribute("class");
            if (classValue.equalsIgnoreCase("arrowRightArrow")) {
                this.context.scenario.log(
                        "The Sub Category " +
                        value +
                        " is aligned left as expected with RightArrow"
                    );
            } else {
                this.context.scenario.log(
                        "The Sub Category " +
                        value +
                        " is aligned left as expected without RightArrow"
                    );
                Assert.fail();
            }
        }
    }

    @And("^user display .* list \"([^\"]*)\" in the report$")
    public void displayCategoryList(String locators) throws Exception {
        this.context.scenario.log("List of Categories: ");
        List<WebElement> categoryList = actionMethods.getMutipleLocators(locators);
        for (WebElement element : categoryList) {
            this.context.scenario.log(element.getText());
        }
    }
}
