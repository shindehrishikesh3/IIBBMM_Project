package Common.UTILS;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import java.io.IOException;

public class TakeScreenshot extends WebDriverConfig {

    @AfterStep
    public void as(Scenario scenario) throws IOException {
        scenario.attach(ScreenshotUtil.getByteScreenshot(), "image/png", "test");
    }
}
