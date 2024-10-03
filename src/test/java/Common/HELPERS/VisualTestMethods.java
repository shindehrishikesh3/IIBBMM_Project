package Common.HELPERS;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.testautomationguru.ocular.Ocular;
import com.testautomationguru.ocular.comparator.OcularResult;
import com.testautomationguru.ocular.sample.SampleBuilder;
import com.testautomationguru.ocular.snapshot.SnapshotBuilder;

import Common.UTILS.WebDriverConfig;

public class VisualTestMethods extends WebDriverConfig {
	
	private static final Logger logger = LogManager.getLogger(VisualTestMethods.class);
	
	public OcularResult compareAll(String snapshot) {
        Path snapshotPath = Paths.get(snapshot + ".png");
        SampleBuilder builder = Ocular
            .snapshot()
            .from(snapshotPath)
            .sample()
            .using(driver);
        return builder.compare();
    }
    
    public OcularResult compareExceptElements(String snapshot, WebElement... elements) {
        Path snapshotPath = Paths.get(snapshot + ".png");
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

}
