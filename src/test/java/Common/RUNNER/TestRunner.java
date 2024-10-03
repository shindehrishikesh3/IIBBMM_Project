package Common.RUNNER;

import Common.UTILS.WebDriverConfig;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = { "src/test/resources/Features" },
    glue = {
        "StepDefinition.GENERIC",
        "StepDefinition.WEB",
        "StepDefinition.MOBILE",
        "StepDefinition.API",
        "StepDefinition.Analytics",
    },
    plugin = {
        "pretty",
        "json:target/cucumber/reports.json",
        "junit:target/cucumber/reports.xml",
        "html:target/cucumber/report.html",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
    },
    monochrome = true,

    tags = "@websmoketest and @guestcheckoutUsingCC",

    dryRun = false
)
public class TestRunner extends WebDriverConfig {

    @AfterClass
    public static void closeBrowser() {}
}
