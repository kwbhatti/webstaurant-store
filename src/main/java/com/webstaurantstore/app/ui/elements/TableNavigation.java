package com.webstaurantstore.app.ui.elements;

import org.openqa.selenium.By;

import com.webstaurantstore.ui.Element;
import com.webstaurantstore.ui.Page;
import com.webstaurantstore.ui.Wait;
import com.webstaurantstore.ui.Wait.Condition;

/**
 * Navigation at the bottom of the table
 * 
 * @author kbhatti
 *
 * @param <P> {@link Page} where the table navigation is located
 */
public class TableNavigation<P> extends Element<P> {

	By firstButton = By.xpath(xpath + "//li[contains(@class , 'rounded-l-md')]");
	By lastButton = By.xpath(xpath + "//li[contains(@class , 'rounded-r-md')]"); 
	
	/**
	 * 
	 * @param page {@link Page} where the table is located
	 * @param xpath {@link String} xpath of the table navigation
	 */
	public TableNavigation(Page<P> page, String xpath) {
		super(page, xpath);
	}

	/**
	 * Clicks the last button in the navigation
	 */
	public void clickLastButton() {
		Wait.until(lastButton, Condition.CLICKABLE).click();
	}
	
	/**
	 * Checks if the last button is the next button
	 * @return {@link Boolean} true if the last button is the next button
	 */
	public boolean isNextButtonVisible() {
		String lastButtonLinkAriaLabel = Wait.until(lastButton, Condition.VISIBLE)
											.findElement(By.xpath(".//a"))
											.getAttribute("aria-label");
		if (lastButtonLinkAriaLabel.contains("current page")) return false;
		return true;
	}
	
}
