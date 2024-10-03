package StepDefinition.WEB;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import io.cucumber.java.en.And;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HeaderSteps extends WebDriverConfig {

    private ContextStore context;
    String FilePath =
        System.getProperty("user.dir") +
        "//src//test//resources//TestData//" +
        getEnv().toUpperCase() +
        "//";

    public HeaderSteps(ContextStore context) {
        this.context = context;
    }

    @And("^I verify dropdown list items in \"([^\"]*)\".*$")
    public void verify_list_options(String key) throws Exception {
        List<String> expListItems = new ArrayList<>();
        List<String> expTranslatedListItems = new ArrayList<>();
        List<String> actListItems = new ArrayList<>();

        switch (key.toLowerCase()) {
            case "my account":
                expListItems = this.context.constants.getMyAccountlistItems();
                expListItems.forEach(d -> {
                    expTranslatedListItems.add(storeText.getStoreText(d));
                });
                List<WebElement> actWebElementsList = getMutipleLocators(
                    "Header.myAccount_list"
                );
                actWebElementsList.forEach(e -> {
                    actListItems.add(e.getText().trim());
                    this.context.scenario.log(e.getText() + ", ");
                });
                this.context.scenario.log("Actual list:" + actListItems);
                this.context.scenario.log(
                        "Expected translated list:" + expTranslatedListItems
                    );
                Assert.assertTrue(
                    "List items does not match",
                    actListItems.containsAll(expTranslatedListItems)
                );
                break;
            case "search categories list":
                break;
        }
    }

    @And("^I verify presence of login and register links for guest users$")
    public void verify_login_registerlink() throws Exception {
        if (getUserType().equalsIgnoreCase("guest")) {
            uiMethods.verifyLinkIsPresent("Register.register_link");
            uiMethods.verifyLinkIsPresent("Header.login_link");
        } else {
            this.context.scenario.log("NA for user type:" + getUserType());
        }
    }
    
    @And ("^verifies overlay with all elements \"([^\"]*)\" and links \"([^\"]*)\" are displaying while hovering on All products links$")
    public void verify_nested_category_overlay(String AllProductsXpath, String L0CategoryXpath) throws Exception {
    	int totalL0Products = actionMethods.getMutipleLocators(AllProductsXpath).size();
    	List<WebElement> L0Categories = actionMethods.getMutipleLocators(L0CategoryXpath);
    	this.context.softAssertions.assertThat(totalL0Products).describedAs("Verifying whether all L0 categories and other links are displaying").isEqualTo(this.context.constants.getMeganavTotalProducts());
    	for(WebElement L0Category : L0Categories) {
    		int i = 1;
			String L1CategoryXpath = actionMethods.getLocatorString(AllProductsXpath) + "[" + i + "]/a/following-sibling::div//a";
			Actions action = new Actions(driver);
            action.moveToElement(L0Category).build().perform();
            Thread.sleep(1000);
            int totalL1Products = driver.findElements(By.xpath(L1CategoryXpath)).size();
            this.context.softAssertions.assertThat(totalL1Products).describedAs("Verifying whether all L1 categories are displaying while hovering on L0 category: "+i).isGreaterThan(0);
    		i++;
    	}
    }
    
    @And ("^verifies overlay is displaying while hovering on \"([^\"]*)\".*$")
    public void verify_overlay_on_hover(String locator) throws Exception {
    	int totalLinks = actionMethods.getMutipleLocators(locator).size();
    	this.context.softAssertions.assertThat(totalLinks).isGreaterThan(0);
    }
}
