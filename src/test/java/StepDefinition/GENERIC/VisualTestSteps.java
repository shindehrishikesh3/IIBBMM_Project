package StepDefinition.GENERIC;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.Assume;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.testautomationguru.ocular.Ocular;
import com.testautomationguru.ocular.comparator.OcularResult;
import Common.UTILS.ContextStore;
import Common.UTILS.ScreenshotUtil;
import Common.UTILS.WebDriverConfig;
import io.cucumber.java.en.And;

public class VisualTestSteps extends WebDriverConfig {

	private ContextStore context;
	Path snapshotsPath;
	Path resultsPath;
	OcularResult result;
	Boolean isBICaptured=false;

	public VisualTestSteps(ContextStore context) {
        this.context = context;
    }

	public void captureScreenshot() throws IOException, InterruptedException {
        context.scenario.attach(
            ScreenshotUtil.getFullPageScreenshot(),
            "image/png",
            "screenshot"
        );
    }

	@And("^create folder structure for base & resultant images")
	public void createFolder() {
		snapshotsPath = Paths.get(fileOperations.getBaseImagePath() + "//" + getEnv().toUpperCase() + "//"
				+ getRegionName().toUpperCase() + "//" + getAppType().toLowerCase()+ "//" + getStore().toLowerCase());
		File ocularSnapshotsDir = new File(snapshotsPath.toString());
		if (!ocularSnapshotsDir.exists()) {
			ocularSnapshotsDir.mkdirs();
		}
		resultsPath = Paths
				.get(fileOperations.getCompareImageResultsPath() + "//" + getEnv().toUpperCase() + "//"
						+ getRegionName().toUpperCase() + "//" + getAppType().toLowerCase()+ "//" + getStore().toLowerCase());
		File ocularResultsDir = new File(resultsPath.toString());
		if (!ocularResultsDir.exists()) {
			ocularResultsDir.mkdirs();
		}
	}

	@And ("^.*similarity as \"([^\"]*)\" percent and save baseline images property to \"([^\"]*)\"$")
	public void set_ocular_params(int cutoff, boolean saveSnap) {
        Ocular
            .config()
            .resultPath(resultsPath)
            .snapshotPath(snapshotsPath)
            .globalSimilarity(cutoff)
            .saveSnapshot(saveSnap);
	}

	@And ("^.*validate.*whole page matches visually with the expected \"([^\"]*)\".*$")
	public void compare_whole_page(String expectedImage) throws Exception {
//		ocularResultsPath = Paths.get(System.getProperty("user.dir"), Compare_RESULTS);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		int contentHeight = ((Number) js.executeScript("return window.innerHeight")).intValue();
		System.out.println("contentHeight: " +contentHeight);
		int bodyHeight = ((Number) js.executeScript("return document.body.scrollHeight")).intValue();
		System.out.println("bodyHeight" +bodyHeight);
		int range = Math.abs(bodyHeight/contentHeight) + 1;
		System.out.println("range: "+range);
		for( int i = 1; i <= range; i++) {
			String img = expectedImage + i;
			result = visualMethods.compareAll(snapshotsPath.toString() + "//" +img);
	    	context.scenario.log(img + " " + result);
	    	actionMethods.scrollDownPage(550);
	    	Thread.sleep(2000);
	    	byte[] screenshot = screenshotUtil.pngToByte(resultsPath.toString()+"//"+img+ ".png");
	    	context.scenario.attach(screenshot, "image/png", "Screenshot added");
			context.softAssertions.assertThat(result.isEqualsImages()).isEqualTo(true);
		}
	}

	@And ("^.*validate.*whole page matches visually with the expected \"([^\"]*)\" except elements \"([^\"]*)\"$")
	public void compare_except(String expectedImage, String locator) throws Exception {
		WebElement element = getLocator(locator);
		OcularResult result = visualMethods.compareExceptElements(expectedImage, element);
    	context.scenario.log(expectedImage + " " + result);
	}

	//------------------------Shutterbug methods---------------------
	@And("^.*visually compare \"([^\"]*)\" .*with the baseline \"([^\"]*)\"$")
	public void configureImageCompare(String type, String imageName) throws IOException {
		String exp = snapshotsPath + "\\" + imageName + "_" + type + ".png";
		String act =resultsPath + "\\" + imageName + "_" + type;
		boolean result = false;
		// To save baseimages if there are no existing images
		if (!Files.exists(Paths.get(exp))) {
			screenshotUtil.saveScreenshotShutterBug(type, exp);
			this.context.scenario.log("JUST CAPTURED BASE IMAGES");
			isBICaptured = true;
			return;
		}

		if (type.equalsIgnoreCase("viewport")) {
			result = Shutterbug.shootPage(driver, Capture.VIEWPORT).equalsWithDiff(exp, act, 0.01);
			this.context.softAssertions.assertThat(result)
					.overridingErrorMessage("%s Image Mismatched - %s", imageName, type)
					.isEqualTo(true);
			context.scenario.attach(ScreenshotUtil.getByteScreenshot(), "image/png", "viewport");

		} else {
			result = Shutterbug.shootPage(driver, Capture.FULL_SCROLL).equalsWithDiff(exp, act, 0.01);
			this.context.softAssertions.assertThat(result)
					.overridingErrorMessage("%s Image Mismatched - %s", imageName, type)
					.isEqualTo(true);
			context.scenario.attach(screenshotUtil.getByteFullScreenshot(), "image/png", "Fullpage");
		}
		if (!result) {
			byte[] screenshotDiff = screenshotUtil.pngToByte(act + ".png");
			context.scenario.attach(screenshotDiff, "image/png", imageName + "_" + type);
		}

	}

	@And("skip if baseline image captured")
	public void skipTest(){
		if(isBICaptured){
		Assume.assumeTrue("NOT AN ACTUAL TEST, JUST CAPTURED BASE IMAGES", false);
		}
	}
}
