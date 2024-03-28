package com.webstaurantstore.core;

import java.time.Duration;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Manages the {@link WebDriver} instance
 * 
 * @author kbhatti
 *
 */
public class WebDriverManager {

	/**
	 * Returns the {@link WebDriver} instance 
	 * 
	 * @return {@link WebDriver}
	 */
	public static WebDriver getDriver() {
		return Suite.scenarios.get().driver;
	}
	
	/**
	 * Returns the {@link WebDriverWait} instance 
	 * 
	 * @return {@link WebDriverWait}
	 */
	public static FluentWait<WebDriver> getDriverWait() {
		return new WebDriverWait(getDriver(), Duration.ofSeconds(10), Duration.ofMillis(250))
				.ignoring(StaleElementReferenceException.class);
	}
}
