package StepDefinition.GENERIC;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks extends WebDriverConfig {

	ContextStore context;
	private static final Logger logger = LogManager.getLogger(Hooks.class);

	public Hooks(ContextStore context) {
		this.context = context;
	}

	@Before
	public void setUp(Scenario scenario) {
		this.context.scenario = scenario;
		logger.info("************************* Test Started *************************");
		String class_name = scenario.getId().toString();
		logger.info("Test feature name: "
				+ class_name.substring(class_name.lastIndexOf("/") + 1, class_name.lastIndexOf(":")));
		logger.info("Test method name: " + scenario.getName());
		logger.info("Test line number: " + scenario.getLine());
		this.context.softAssertions = new SoftAssertions();
		if (scenario.getSourceTagNames().contains("@enablePerfLogs")) {
			System.setProperty("chrome.enablePerfLogs", "true");
		}

		if (scenario.getSourceTagNames().contains("@api") && System.getProperty("os.name").contains("Windows")) {
			System.setProperty("pHost", "euproxy");
			System.setProperty("pPort", "8080");
		}

		// for reading run config properties
		prop = new Properties();
		try {
			fis = new FileInputStream(System.getProperty("user.dir") + "//runConfig.properties");
			prop.load(fis);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@AfterStep
	public void addScreenshot(Scenario scenario) {
		// validate if scenario has failed
		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "image");
		}
	}

	@After(order = 2)
	public void assertAllSoftAssertions() {
		this.context.softAssertions.assertAll();
	}

    @After(order = 1)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            logger.info("Test failed. Taking Screenshot");
            // Take a screenshot...
            final byte[] screenshot =
                ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            // embed it in the report.
            scenario.attach(screenshot, "image/png", "Screenshot added");
        }
        logger.info("************************* Test Completed *************************");
        if (null != driver) {
            getDriver().quit();
        }
    }
}
