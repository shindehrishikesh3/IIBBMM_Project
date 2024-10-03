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
        "Common.UTILS",
    },
    plugin = {
        "pretty",
        "json:target/cucumber/reports.json",
        "junit:target/cucumber/reports.xml",
        "html:target/cucumber/report.html",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
    },
    monochrome = true,
    tags = "@test11",
    dryRun = false
)
public class Screenshot_After_Each_Step extends WebDriverConfig {

    @AfterClass
    public static void closeBrowser() {
        driver.quit();
    }
}
