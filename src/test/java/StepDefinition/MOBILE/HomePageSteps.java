package StepDefinition.MOBILE;

import static org.junit.Assert.assertTrue;

import java.util.List;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import io.cucumber.java.en.And;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.Assert;

public class HomePageSteps extends WebDriverConfig {

    private static final Logger logger = LogManager.getLogger(HomePageSteps.class);

    private ContextStore context;
    String FilePath =
        System.getProperty("user.dir") +
        "//src//test//resources//TestData//" +
        getEnv().toUpperCase() +
        "//";

    String store = getStore();
    String env = getEnv();
    String region = getRegionName();

    public HomePageSteps(ContextStore context) {
        this.context = context;
    }

    @And("^.*verify the \"([^\"]*)\" functionality.*$")
    public void verifyNoButtonFunctionality(String locator) throws Exception {
        if (uiMethods.isElementDisplayed(locator)) {
            actionMethods.click(locator);
//            Thread.sleep(2000);
            //Check that the geoLocationBanner is not present anymore
            Boolean value = uiMethods.isElementDisplayed(
                "Home.geoLocationbanner_element"
            );
            logger.info(
                "No button clicked succesfully and geoLocation banner disappers!"
            );
            Assert.assertFalse(value);
        }
    }

    @And("^.*I verify the \"([^\"]*)\" remember me functionality.*$")
    public void verifyRememberMefunctionality(String locator) throws Exception {
        actionMethods.click(locator);
        actionMethods.click("Home.geoLocationYes_button");
        Thread.sleep(2000);
        String url = driver.getCurrentUrl();
        assertTrue(url.contains("uk") && url.contains("?pf_custSiteRedirect=true"));
        logger.info("Redirected to UK store successfully");
    }

    @And("^.* click on \"([^\"]*)\" and verify its functionality.*$")
    public void changeCountryfunctionality(String locator) throws Exception {
        actionMethods.click(locator);
        Boolean value = uiMethods.isElementDisplayed("Home.countrySelector_element");
        logger.info("Country selector pop up appears !!");
        Assert.assertTrue(value);
        actionMethods.selectValueByText(
            "Germany (Deutsch, English) ",
            "Home.countrySelect_dropdown"
        );

        actionMethods.click("Home.selectCountyContinue_button");
        Thread.sleep(2000);
        String url = driver.getCurrentUrl();
        assertTrue(
            url.contains("de") &&
            url.contains("?langId=-3&setLangId=true&pf_custSiteRedirect=true")
        );
        logger.info("Redirected to DE store successfully!!");
    }

    @And(
        "^.*verify and click on element Engineering Glossary link if its present on page$"
    )
    public void verifyElementIsDispalyedAndClick() throws Exception {
        actionMethods.waitForElementToAppear(
            this.context.constants.getMediumWaitSeconds(),
            "Home.engineeringGlossary"
        );
        if (uiMethods.isElementDisplayed("Home.engineeringGlossary") == true) {
            actionMethods.click("Home.engineeringGlossary");
            Thread.sleep(2000);
            String act_Value = driver.getCurrentUrl();
            Assert.assertTrue(
                "string is not present in the URL ",
                act_Value.contains("engineering")
            );
        } else context.scenario.log("Element is not present on page");
    }
    
    @And ("^.*validates category innerlinks with updated tracking ID url for \"([^\"]*)\"$")
    public void validate_category_innerLink(String locator) throws Exception {
    	List<WebElement> categoryLinks = actionMethods.getMutipleLocators(locator);
    	int count = 0;
    	int i = 1;
    	this.context.scenario.log("Total Categories: "+categoryLinks.size());
    	for(WebElement categoryLink : categoryLinks) {
    		String value = categoryLink.toString().split("xpath:")[1].trim();
    		String xpath = "(" + value.substring(0, value.length() -1) + ")[" + i + "]/p";
    		String category = driver.findElement(By.xpath(xpath)).getText().trim();
    		categoryLink.click();
    		List<WebElement> subCategoryLinks = actionMethods.getMutipleLocators("Home.allSubCategory_link");
    		for(WebElement subCategoryLink : subCategoryLinks) {
    				String link = subCategoryLink.getAttribute("href").trim();
    				this.context.softAssertions.assertThat(link).overridingErrorMessage("FAILED!! %s link contains # for category %s", link, category).doesNotContain("#");
    				this.context.softAssertions.assertThat(link).overridingErrorMessage("FAILED!! %s link does not contain ?ICID for category %s", link, category).contains("?ICID");
    				count++;
    		}
    		String closeBtn = actionMethods.getLocatorString("Home.allSubCategory_link") + "/ancestor::ul/preceding-sibling::div//a";
    		driver.findElement(By.xpath(closeBtn)).click();
    		this.context.scenario.log("Succesfully validated "+count+" links under " +category+ " category");
    		i++;
    	}
    }
    
    @And ("^.*validates manufacturer list innerlinks with updated tracking ID url for \"([^\"]*)\"$")
    public void validate_manufacturer_list_innerlinks(String locator) throws Exception {
    	List<WebElement> mfrLinks = actionMethods.getMutipleLocators(locator);
    	int i = 1;
    	for(WebElement mfrLink : mfrLinks) {
    		String link = mfrLink.getAttribute("href").trim();
			this.context.softAssertions.assertThat(link).overridingErrorMessage("FAILED!! Manufacturer %s link %s link contains # ", i, link).doesNotContain("#");
			this.context.softAssertions.assertThat(link).overridingErrorMessage("FAILED!! Manufacturer %s link %s link does not contains ?ICID ", i, link).contains("?ICID");
			i++;
    	}
    	this.context.scenario.log("All "+mfrLinks.size()+ " Manufacturer links are successfully validated in the homepage");
    }
}
