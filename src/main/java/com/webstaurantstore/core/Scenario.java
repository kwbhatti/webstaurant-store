package com.webstaurantstore.core;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.chimpcentral.logger.Log;

public class Scenario {

	String name = null;
	ExtentTest test = null;
	Log log = null;
	WebDriver driver = null;
	
	public static String getName() {
		return Suite.scenarios.get().name;
	}
	
	public static ExtentTest getTest() {
		return Suite.scenarios.get().test;
	}
	
	public static Log getLog() {
		return Suite.scenarios.get().log;
	}
	
	public static WebDriver getDriver() {
		return Suite.scenarios.get().driver;
	}
}
