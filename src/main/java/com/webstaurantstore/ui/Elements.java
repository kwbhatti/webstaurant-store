package com.webstaurantstore.ui;

import java.util.ArrayList;

import org.openqa.selenium.By;

public abstract class Elements<T> extends ArrayList<Element<T>> {

	private static final long serialVersionUID = 1611571501615936903L;
	
	protected Page<?> page = null;
	protected By locator = null;
	
	public Elements(Page<?> page, By locator) {
		this.page = page;
		this.locator = locator;
	}
	
	public abstract T getElement();
}
