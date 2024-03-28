package com.webstaurantstore.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.webstaurantstore.ui.Page.Condition;

public abstract class Element<T> {

	
	protected Page<?> page = null;
	public By locator = null;
	
	public Element(Page<?> page, By locator, Condition... conditions) {
		this.page = page;
		this.locator = locator;
	}
	
	public abstract T getElement();
	
	public WebElement findElement(By locator, Condition... conditions) {
		return page.findElement(locator, conditions);
	}
	
	public T waitUntil(Condition... conditions) {
		page.waitUntil(locator, conditions);
		return getElement();
	}
	
	public void click(Condition... conditions) {
		page.click(locator, conditions);
	}
	
	public void sendKeys(String keysToSend, Condition... conditions) {
		page.sendKeys(locator, keysToSend, conditions);
	}
	
	public String getAttribute(String name, Condition... conditions) {
		return page.getAttribute(locator, name, conditions);
	}
	
	public String getText(Condition... conditions) {
		return page.getText(locator, conditions);
	}
	
	
}
