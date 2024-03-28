package com.webstaurantstore.core;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

/**
 * Manages Extent Report
 * 
 * @author kbhatti
 *
 */
public class Report {
		
	protected Report() {}
	
	protected static ExtentReports createReport(String reporterFilePath, String reportName) {
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(reporterFilePath);
		reporter.config().setDocumentTitle(reportName);
		reporter.config().setReportName(reportName);
		ExtentReports report = new ExtentReports();
		report.attachReporter(reporter);
		report.flush();
		return report;
	}
	
	public static ExtentReports getReport() {
		return Suite.report;
	}

	public static ExtentTest createTest(String testName) {
		return getReport().createTest(testName);
	}
	
	public static ExtentTest getTest() {
		return Suite.scenarios.get().test;
	}
	
	public static ExtentTest createNode(String name) {
		return getTest().createNode(name);
	}
	
	public static void info(String message) {
		getTest().info(message);
	}
	
	public static void info(Markup markup) {
		getTest().info(markup);
	}
	
	public static void pass(ExtentTest test, String message) {
		test.pass(message);
	}
	
	public static void pass(String message) {
		getTest().pass(message);
	}
	
	public static void fail( String message) {
		getTest().fail(message);
	}
		
	public static void warn(String message) {
		getTest().warning(message);
	}
	
	public static void skip(String message) {
		getTest().skip(message);
	}
	
	public static void skip(Throwable throwable) {
		Log.exception(throwable);
		getTest().skip("An exception was thrown: " + throwable.getMessage());
	}
	
}
