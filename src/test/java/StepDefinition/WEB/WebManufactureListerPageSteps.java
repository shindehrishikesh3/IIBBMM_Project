package StepDefinition.WEB;

import Common.HELPERS.UIVerificationMethods;
import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import io.cucumber.java.en.Then;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebManufactureListerPageSteps extends WebDriverConfig {

    private ContextStore context;
    private static final Logger logger = LogManager.getLogger(HomeSteps.class);

    public WebManufactureListerPageSteps(ContextStore context) {
        this.context = context;
    }

    @Then("^I verify manufacture page display in Ascending order$")
    public void verifyManufacturerListDisplayInAssendingOrder() throws Exception {
        ArrayList<String> ActualList = new ArrayList<String>();
        String actualCharacter = "";
        List<WebElement> list = actionMethods.getMutipleLocators(
            "ManufacturePage.menuSectionAll_link"
        );
        for (int i = 1; i < list.size(); i++) {
            actualCharacter =
                actionMethods.getLocatorString("ManufacturePage.menuSectionAll_link") +
                " [" +
                i +
                "]/a ";
            ActualList.add(
                actionMethods.getDriver().findElement(By.xpath(actualCharacter)).getText()
            );
        }

        ArrayList<String> ExpectedList = new ArrayList<String>();

        // COPY actual list to another list
        ExpectedList.addAll(ActualList);
        System.out.println("Actual list order is..." + ActualList);
        Collections.sort(ExpectedList);

        Assert.assertEquals(
            "Manufacturer list are sorted in assending order",
            ExpectedList,
            ActualList
        );
    }

    @Then("I verify '#' is moved to Bottom Of Page$")
    public void verifyHashIsMovedToBottomOfManufacturerPage() throws Exception {
        List<WebElement> list = actionMethods.getMutipleLocators(
            "ManufacturePage.menuSectionAll_link"
        );
        int SizeofElements = list.size();
        String locator = "ManufacturePage.menuSectionAll_link";

        String LocatorforFirstElement =
            actionMethods.getLocatorString(locator) + "[" + 1 + "]";
        String FirstCharacter = actionMethods
            .getDriver()
            .findElement(By.xpath(LocatorforFirstElement))
            .getText();

        Assert.assertEquals("A is not present at top ", "A", FirstCharacter);
        String LocatorforLastElement =
            actionMethods.getLocatorString(locator) + "[" + SizeofElements + "]";
        String LastCharacter = actionMethods
            .getDriver()
            .findElement(By.xpath(LocatorforLastElement))
            .getText();
        Assert.assertEquals("# is not present at Bottom", "#", LastCharacter);
    }

    @Then(
        "I Verify current  Url  is contain brand name after clicking on any brand from manufacturer page$"
    )
    public void verifyProperUrlShouldOpen() throws Exception {
        String Text = actionMethods.getValue("ManufacturePage.BOSCHManufacturer_link");
        System.out.println("linktext is display" + Text);
        actionMethods.clickUsingJSExecutor("ManufacturePage.BOSCHManufacturer_link");
        String currentURL = getDriver().getCurrentUrl();
        System.out.println("URL is " + currentURL);
        Assert.assertTrue("LinkText not match", currentURL.contains(Text.toLowerCase()));
    }
}
