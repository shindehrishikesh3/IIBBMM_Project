package VisualTest;

import com.testautomationguru.ocular.Ocular;
import com.testautomationguru.ocular.comparator.OcularResult;
import com.testautomationguru.ocular.sample.SampleBuilder;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

public class VisualValidation {

    private static final String BaseImage_SNAPSHOTS =
        "src/test/resources/VisualTest/BaseImage";
    private static final String Compare_RESULTS = "src/test/resources/VisualTest/Results";
    private static final String URL = "https://ie.farnell.com";
    private static final String FIRST_TEST = "FirstTest";
    private static final String LOGO = "storeLogosEu";
    private static final Logger logger = LogManager.getLogger(VisualValidation.class);
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        Path ocularSnapshotsPath = Paths.get(".", BaseImage_SNAPSHOTS);
        File ocularSnapshotsDir = new File(ocularSnapshotsPath.toString());
        if (!ocularSnapshotsDir.exists()) {
            ocularSnapshotsDir.mkdirs();
        }
        Path ocularResultsPath = Paths.get(".", Compare_RESULTS);
        File ocularResultsDir = new File(ocularResultsPath.toString());
        if (!ocularResultsDir.exists()) {
            ocularResultsDir.mkdirs();
        }

        Ocular
            .config()
            .resultPath(ocularResultsPath)
            .snapshotPath(ocularSnapshotsPath)
            .globalSimilarity(50)
            .saveSnapshot(true);
    }

    @Before
    public void setupDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito", "--disable-dev-shm-usage");
        options.setCapability(
            CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,
            UnexpectedAlertBehaviour.DISMISS
        );

        System.setProperty(
            "webdriver.chrome.driver",
            System.getProperty("user.dir") + "\\drivers\\chromedriver.exe"
        );
        driver = new ChromeDriver(options);
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1400, 1000));
    }

    public OcularResult compare(String snapshotName, WebElement... elements) {
        Path snapshotPath = Paths.get(snapshotName + ".png");
        SampleBuilder builder = Ocular
            .snapshot()
            .from(snapshotPath)
            .sample()
            .using(driver);
        for (WebElement element : elements) {
            if (null != element) {
                builder = builder.excluding(element);
            }
        }
        return builder.compare();
    }

    @Test
    public void runFirstTest() {
        driver.get(URL);
        String snapshotName = FIRST_TEST;
        WebElement logo = driver.findElement(By.id(LOGO));
        OcularResult result = compare(snapshotName, logo);
        logger.info(snapshotName + " " + result);
        Assert.assertTrue(result.isEqualsImages());
    }

    @After
    public void cleanUp() {
        driver.close();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
    }
}
