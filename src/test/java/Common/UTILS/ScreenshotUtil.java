package Common.UTILS;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;

public class ScreenshotUtil extends WebDriverConfig {

    public static byte[] getByteScreenshot() throws IOException {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        byte[] fileContent = FileUtils.readFileToByteArray(src);
        return fileContent;
    }

    //To capture full page screenshot, this works only with firefox
    public static byte[] getFullPageScreenshot()
        throws IOException, InterruptedException {
        Actions objActions = new Actions(driver);
        for (int iLoop = 0; iLoop < 10; iLoop++) {
            objActions.sendKeys(Keys.PAGE_DOWN).build().perform();
            Thread.sleep(500);
        }
        byte[] imageBytes =
            ((FirefoxDriver) driver).getFullPageScreenshotAs(OutputType.BYTES);
        return imageBytes;
    }

    /**
     * convert png image to byte format
     * @param imagePath
     * @return
     * @throws IOException
     */
    public byte[] pngToByte (String imagePath) throws IOException {
		 // open image
		 File imgPath = new File(imagePath);
		 BufferedImage bufferedImage = ImageIO.read(imgPath);
	     ByteArrayOutputStream bos = new ByteArrayOutputStream();
	     ImageIO.write(bufferedImage, "png", bos );
	     byte [] data = bos.toByteArray();

		 return data;
	}

	/**
	 *
	 * @param type - Possible values - viewport, full
	 * @param path
	 * @throws IOException
	 */
	// Shutterbug to capture page screenshot
	public void saveScreenshotShutterBug(String type, String path) throws IOException {
		switch(type.toLowerCase()){
			case "viewport":
			ImageIO.write(Shutterbug.shootPage(driver, Capture.VIEWPORT).getImage(), "PNG", new File(path));
			break;

			case "full":
			ImageIO.write(Shutterbug.shootPage(driver, Capture.FULL_SCROLL).getImage(), "PNG", new File(path));
			break;
		}
	}

	public byte[] getByteFullScreenshot() throws IOException {
		return Shutterbug.shootPage(driver, Capture.FULL_SCROLL).getBytes();
	    }


}
