package com.webstaurantstore.ui;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import com.webstaurantstore.core.Constants;
import com.webstaurantstore.core.Log;
import com.webstaurantstore.core.Scenario;
import com.webstaurantstore.core.WebDriverManager;
import com.webstaurantstore.utils.DateUtils;
import com.webstaurantstore.utils.FilePaths;
import com.webstaurantstore.utils.FileUtils;

/**
 * Represents any web page
 * 
 * @author kbhatti
 *
 * @param <T>
 */
public abstract class Page<T> {

	protected WebDriver driver = WebDriverManager.getDriver();
	protected FluentWait<WebDriver> wait = WebDriverManager.getDriverWait();
	
	public abstract T getPage();
	
	/**
	 * Takes screenshot and adds to the log file
	 * 
	 * @param widthInPixels {@link Integer} width of the image (auto corrects to max 700 pixel)
	 * @throws IOException
	 */
	public static synchronized void logScreenshot(int widthInPixels) throws IOException {
		String screenshotDir = Constants.SCREENSHOTS_DIR;
		FileUtils.createDir(new File(screenshotDir));
		String screenshotFilename = DateUtils.getCurrentUnixTimeStamp() + ".png";
		String screenshotFilepath = new FilePaths.FilePath(screenshotDir).append(screenshotFilename).get();
		TakesScreenshot takesScreenshot = (TakesScreenshot) Scenario.getDriver();
		File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.createCopy(file, new File(screenshotFilepath));
		Log.image(screenshotFilepath, widthInPixels);
	}
	
	/**
	 * Logs screenshot
	 * 
	 * @throws IOException
	 */
	public static synchronized void logScreenshot() throws IOException {
		logScreenshot(500);
	}
}
