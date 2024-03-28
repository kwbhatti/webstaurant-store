package com.webstaurantstore.ui;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.webstaurantstore.core.Constants;
import com.webstaurantstore.core.Log;
import com.webstaurantstore.core.Scenario;
import com.webstaurantstore.core.WebDriverManager;
import com.webstaurantstore.utils.DateUtils;
import com.webstaurantstore.utils.FilePaths;
import com.webstaurantstore.utils.FileUtils;

public abstract class Page<T> {

	protected WebDriver driver = null;
	protected WebDriverWait wait = null;
	
	protected Page() {
		this.driver = WebDriverManager.getDriver();
		this.wait = WebDriverManager.getDriverWait();
	}
	
	public static enum Condition {
		VISIBLE,
		PRESENT,
		CLICKABLE
	}
	
	public static enum CollectionCondition {
		VISIBLE
	}
	
	public abstract T getPage();
	
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
	
	public static synchronized void logScreenshot() throws IOException {
		logScreenshot(500);
	}
	
	public T waitUntil(By locator, Condition condition) {
		System.out.println("wait until with locaiton and condition");
		switch(condition) {
		case VISIBLE: wait.until(ExpectedConditions.visibilityOfElementLocated(locator)); break;
		case PRESENT: wait.until(ExpectedConditions.presenceOfElementLocated(locator)); break;
		case CLICKABLE: wait.until(ExpectedConditions.elementToBeClickable(locator)); break;
		default: throw new IllegalArgumentException("Provided condition is not valid");
		}
		return getPage();
	}
	
	public T waitUntil(By locator, CollectionCondition condition) {
		switch(condition) {
		case VISIBLE: wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator)); break;
		default: throw new IllegalArgumentException("Provided condition is not valid");
		}
		return getPage();
	}
	
	public T waitUntil(By locator, Condition... conditions) {
		Arrays.asList(conditions).forEach(e -> waitUntil(locator, e));
		return getPage();
	}
	
	public T waitUntil(By locator, CollectionCondition... conditions) {
		Arrays.asList(conditions).forEach(e -> waitUntil(locator, e));
		return getPage();
	}
	
	public WebElement findElement(By locator, Condition... conditions) {
		waitUntil(locator, conditions);
		return driver.findElement(locator);
	}
	

	
	public List<WebElement> findElemets(By locator, CollectionCondition... conditions) {
		waitUntil(locator, conditions);
		return driver.findElements(locator);
	}
	
	public void click(By locator, Condition... conditions) {
		waitUntil(locator, conditions);
		driver.findElement(locator).click();
	}
	
	public void sendKeys(By locator, String keysToSend, Condition... conditions) {
		waitUntil(locator, conditions);
		driver.findElement(locator).sendKeys(keysToSend);
	}
	
	public String getAttribute(By locator, String name, Condition... conditions) {
		waitUntil(locator, conditions);
		System.out.println("waiting for element located by " + locator.toString());
		return driver.findElement(locator).getAttribute(name);
	}
	
	public String getText(By locator, Condition... conditions) {
		waitUntil(locator, conditions);
		return driver.findElement(locator).getText();
	}
}
