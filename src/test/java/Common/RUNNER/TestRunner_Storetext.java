package Common.RUNNER;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import StepDefinition.GENERIC.UtilitySteps;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = { "src/test/resources/Features" },
    glue = { "StepDefinition.GENERIC", "StepDefinition.WEB", "StepDefinition.MOBILE" },
    plugin = {
        "pretty",
        "json:target/cucumber/reports.json",
        "junit:target/cucumber/reports.xml",
        "html:target/cucumber/report.html",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
    },
    monochrome = true,
    tags = "@storetext",
    dryRun = false
)
public class TestRunner_Storetext extends WebDriverConfig {

    @BeforeClass
    public static void createOutputFolder() throws Exception {
        fileOperations.createOutputFolder();
    }

    @AfterClass
    public static void closeBrowser() {}
}
