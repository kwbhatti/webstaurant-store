package com.webstaurantstore.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

import com.webstaurantstore.ui.DriverListener;

/**
 * Responsible to instantiating the {@link WebDriver}
 * 
 * @author kbhatti
 *
 */
public class DriverFactory {

	public DriverFactory() {}
	
	/**
	 * TODO: other code needed for a Chrome driver
	 * 
	 * @return {@link ChromeDriver}
	 */
	private static ChromeDriver getChromeDriver() {
		return new ChromeDriver();
	}
	
	/**
	 * TODO: other code needed for Firefox driver
	 * 
	 * @return {@link FirefoxDriver}
	 */
	private static FirefoxDriver getFirefoxDriver() {
		return new FirefoxDriver();
	}
	
	/**
	 * TODO: other code needed for Internet Explorer driver
	 * 
	 * @return {@link InternetExplorerDriver}
	 */
	private static InternetExplorerDriver getInternetExplorerDriver() {
		return new InternetExplorerDriver();
	}
	
	/**
	 * Gets the driver based on the parameter
	 * Adds {@link DriverListener} to the driver for logging
	 * 
	 * @param browser {@link Browser}
	 * @return {@link WebDriver}
	 */
	public static WebDriver getDriver(Browser browser) {
		WebDriver driver = null;
		switch (browser) {
		case CHROME: driver = getChromeDriver(); break;
		case FIREFOX: driver = getFirefoxDriver(); break;
		case IE: driver = getInternetExplorerDriver(); break;
		default: throw new IllegalArgumentException("No driver is available for " + browser.toString());
		}
		driver = new EventFiringDecorator<>(new DriverListener()).decorate(driver);
		return driver;
	}
}
