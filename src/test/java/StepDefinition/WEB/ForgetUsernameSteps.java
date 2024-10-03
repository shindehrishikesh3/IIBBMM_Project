package StepDefinition.WEB;

import Common.UTILS.ContextStore;
import Common.UTILS.ScreenshotUtil;
import Common.UTILS.WebDriverConfig;
import StepDefinition.GENERIC.BaseSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public class ForgetUsernameSteps extends WebDriverConfig {

    private ContextStore context;
    String FilePath =
        System.getProperty("user.dir") +
        "//src//test//resources//TestData//" +
        getEnv().toUpperCase() +
        "//";
    String store = getStore();

    public ForgetUsernameSteps(ContextStore context) {
        this.context = context;
    }

    @And(
        "^.*check if MultipleUsername window is displayed and add username in.*\"([^\"]*)\"$"
    )
    public void multipleUsername(String locator) throws Exception {
        Boolean value = uiMethods.isElementDisplayed("ForgotUsername.enterUsename_text");
        if (value == true) {
            this.context.scenario.log("Multiple Username window is displayed");
            String path = FilePath + "Registration.xlsx";
            List<Map<String, String>> testData = ExcelUtil.getData(path, store);
            String Username = testData.get(0).get("ForgetUsername");
            actionMethods.enterText(Username, locator);
            actionMethods.click("ForgotUsername.continueUsername_button");
        } else {
            this.context.scenario.log("Multiple Username window not displayed");
        }
    }
}
