package com.webstaurantstore.core;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.chimpcentral.logger.Logger;
import com.webstaurantstore.ui.Page;

/**
 * Base class for all the tests
 * 
 * @author kbhatti
 *
 */
public class Suite {

	private static String suiteName = null;
	
	static Logger suiteLog = null;
	static ExtentReports report = null;
	
	/** Helps manage parallel execution*/
	static ThreadLocal<Scenario> scenarios = new ThreadLocal<>();
	
	private static String capitalizeFirstLetter(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}
	
	/**
	 * Runs once before suite
	 * 	- Sets the {@link #suiteName}
	 *  - creates {@link #suiteLog}
	 *  - creates {@link #report}
	 *  
	 * @param context {@link ITestContext}
	 */
	@BeforeSuite (alwaysRun = true)
	protected void beforeSuite(ITestContext context) {
		ISuite suite = context.getSuite();
		suiteName = suite.getName();
		suiteLog = Log.createSuiteLog(Constants.loggerOptions, Suite.suiteName);
		suiteLog.info("Start Suite Execution");
		report = Report.createReport(Constants.REPORT_FILE_PATH, suiteName);
		suiteLog.info("Report created at " + Constants.REPORT_FILE_PATH);
	}
	
	/**
	 * Runs once before each method(test)
	 * 	- sets the test name based on its class name and method name
	 * 	- sets the {@link Scenario} for the test
	 * 	- creates {@link Log} for the test
	 * 	- creates {@link ExtentTest} for the test
	 *  - initialized {@link WebDriver} for the test
	 *  
	 * @param method {@link Method}
	 */
	@BeforeMethod (alwaysRun = true)
	protected void beforeMethod(Method method) {
		Class<?> clazz = method.getDeclaringClass();
		String className = clazz.getSimpleName();
		String testMethodName = method.getName();
		String testName = capitalizeFirstLetter(className) + ": " + capitalizeFirstLetter(testMethodName);
		scenarios.set(new Scenario());
		scenarios.get().name = testName;
		scenarios.get().log = Log.createLog(suiteLog, testName);
		scenarios.get().test = Report.createTest(testName);
		scenarios.get().driver = DriverFactory.getDriver(Constants.BROWSER);
	}
	
	/**
	 * Runs once after each method(test)
	 * 	- logs if the test throws any exception
	 * 	TODO: skip test if an exception is thrown
	 * 	- takes screenshot of the page if the test gets skipped or fails
	 * 	- flushes the report
	 * 	- terminates {@link WebDriver}
	 * 
	 * @param result {@link ITestResult}
	 * @throws IOException
	 */
	@AfterMethod (alwaysRun = true)
	protected void afterMethod(ITestResult result) throws IOException {
		Throwable throwable = result.getThrowable();
		if (throwable != null) Log.exception(throwable);
		if (result.getStatus() == ITestResult.SKIP || result.getStatus() == ITestResult.FAILURE) Page.logScreenshot();
		report.flush();
		scenarios.get().driver.quit();
		scenarios.remove();
		
	}
	
	/**
	 * Runs once after the whole suite
	 */
	@AfterSuite (alwaysRun = true)
	protected void afterSuite() {
		suiteLog.info("End Suite Execution");
	}
}
