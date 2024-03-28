package com.webstaurantstore.core;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverManager {

	public static WebDriver getDriver() {
		return Suite.scenarios.get().driver;
	}
	
	public static WebDriverWait getDriverWait() {
		return new WebDriverWait(getDriver(), Duration.ofSeconds(10), Duration.ofMillis(250));
	}
}
