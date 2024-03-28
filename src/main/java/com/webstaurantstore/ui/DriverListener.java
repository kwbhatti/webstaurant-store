package com.webstaurantstore.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

import com.webstaurantstore.core.Log;

import java.lang.reflect.Method;

/**
 * Helps log information to the log file
 * 
 * @author kbhatti
 *
 */
public class DriverListener implements WebDriverListener {

	private void logStep(String step) {
		Log.info("UI Step: " + step);
	}
	
	@Override
	public void beforeGet(WebDriver driver, String url) {
		logStep("get: " + url);
	}

	@Override
	public void beforeExecuteScript(WebDriver driver, String script, Object[] args) {
		logStep("js: " + script);
	}
	
	@Override
	public void beforeClick(WebElement element) {
		logStep("click: " + element);
	}
	
	@Override
	public void beforeSubmit(WebElement element) {
		logStep("submit: " + element);
	}
	
	@Override
	public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
		logStep("sendKeys: " + element);
	}
	
	@Override
	public void beforeClear(WebElement element) {
		logStep("clear: " + element);
	}
	
	@Override
	public void beforeAnyNavigationCall(WebDriver.Navigation navigation, Method method, Object[] args) {
		if (method.getName().equals("to")) return;
		logStep("navigate: " + method.getName());
	}
	
	@Override
	public void beforeTo(WebDriver.Navigation navigation, String url) {
		logStep("navigate to: " + url);
	}

}
