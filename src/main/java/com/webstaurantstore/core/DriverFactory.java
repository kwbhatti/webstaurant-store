package com.webstaurantstore.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

import com.webstaurantstore.ui.DriverListener;

public class DriverFactory {

	public DriverFactory() {}
	
	private static ChromeDriver getChromeDriver() {
		return new ChromeDriver();
	}
	
	private static FirefoxDriver getFirefoxDriver() {
		return new FirefoxDriver();
	}
	
	private static InternetExplorerDriver getInternetExplorerDriver() {
		return new InternetExplorerDriver();
	}
	
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
