package com.webstaurantstore.ui;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.webstaurantstore.core.WebDriverManager;

/**
 * Manages Element waits
 * 
 * @author kbhatti
 *
 */
public class Wait {

	protected static FluentWait<WebDriver> wait = WebDriverManager.getDriverWait(); 
	protected static WebDriver driver = WebDriverManager.getDriver();
	
	/**
	 * TODO: Add more conditions
	 * 
	 * Expected conditions used by {@link WebElement#findElement(By)}
	 * 
	 * @author kbhatti
	 *
	 */
	public static enum Condition {
		VISIBLE,
		PRESENT,
		CLICKABLE
	}
	
	/**
	 * TODO: Add more conditions
	 * 
	 * Expected conditions used by {@link WebElement#findElements(By)}
	 * 
	 * @author kbhatti
	 *
	 */
	public static enum CollectionCondition {
		VISIBLE
	}
	
	private Wait() {}
	
	/**
	 * Waits for the element until the condition is satisfied
	 * 
	 * @param locator {@link By} 
	 * @param condition {@link Condition}
	 * @return {@link WebElement}
	 */
	private synchronized static WebElement until(By locator, Condition condition) {
		switch(condition) {
		case VISIBLE: wait.until(ExpectedConditions.visibilityOfElementLocated(locator)); break;
		case PRESENT: wait.until(ExpectedConditions.presenceOfElementLocated(locator)); break;
		case CLICKABLE: wait.until(ExpectedConditions.elementToBeClickable(locator)); break;
		default: throw new IllegalArgumentException("Provided condition is not valid");
		}
		return driver.findElement(locator);
	}

	/**
	 * Waits for the element until conditions are satisfied
	 * 
	 * @param locator {@link By}
	 * @param conditions {@link Condition}(s)
	 * @return {@link WebElement}
	 */
	public synchronized static WebElement until(By locator, Condition... conditions) {
		Arrays.asList(conditions).forEach(e -> until(locator, e));
		return driver.findElement(locator);
	}
	
	/**
	 * Waits for elements until condition is satisfied
	 * 
	 * @param locator {@link By}
	 * @param condition {@link CollectionCondition}
	 * @return {@link List} of {@link WebElement}
	 */
	private synchronized static List<WebElement> until(By locator, CollectionCondition condition) {
		switch(condition) {
		case VISIBLE: wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator)); break;
		default: throw new IllegalArgumentException("Provided condition is not valid");
		}
		return driver.findElements(locator);
	}
	
	/**
	 * Waits for elements until conditions are satisfied
	 * 
	 * @param locator {@link By}
	 * @param conditions {@link CollectionCondition}
	 * @return {@link List} of {@link WebElement}
	 */
	public synchronized static List<WebElement> until(By locator, CollectionCondition... conditions) {
		Arrays.asList(conditions).forEach(e -> until(locator, e));
		return driver.findElements(locator);
	}
}
