package com.webstaurantstore.app.ui.elements;

import org.openqa.selenium.By;

import com.webstaurantstore.ui.Element;
import com.webstaurantstore.ui.Page;
import com.webstaurantstore.ui.Page.Condition;

public class TableNavigation extends Element<TableNavigation> {

	static String xpath = "//nav[@aria-label = 'pagination']";
	By firstButton = null;
	By lastButton = null;
	
	public TableNavigation(Page<?> page) {
		super(page, By.xpath(xpath));
		this.firstButton = By.xpath(xpath + "//li[contains(@class , 'rounded-l-md')]");
		this.lastButton = By.xpath(xpath + "//li[contains(@class , 'rounded-r-md')]"); 
}

	@Override
	public TableNavigation getElement() {
		return this;
	}

	public void clickNext() {
		findElement(lastButton, Condition.CLICKABLE).click();
	}
	
	public boolean isNextButtonVisible() {
		String lastButtonLinkAriaLabel = findElement(lastButton, Condition.VISIBLE).findElement(By.xpath(".//a")).getAttribute("aria-label");
		if (lastButtonLinkAriaLabel.contains("current page")) return false;
		return true;
	}
	
}
