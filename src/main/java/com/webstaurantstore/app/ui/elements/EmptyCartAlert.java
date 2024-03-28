package com.webstaurantstore.app.ui.elements;

import org.openqa.selenium.By;

import com.webstaurantstore.ui.Element;
import com.webstaurantstore.ui.Page;
import com.webstaurantstore.ui.Wait;
import com.webstaurantstore.ui.Wait.Condition;

/**
 * Represents the Empty Cart Alert that pops up when empty cart button is clicked
 * @author kbhatti
 *
 * @param <P> Page where the Alert popped up
 */
public class EmptyCartAlert<P> extends Element<P> {

	/**
	 * 
	 * @param page {@link Page} where the Alert popped up
	 */
	public EmptyCartAlert(Page<P> page) {
		super(page, "//*[@role = 'alertdialog']");
	}

	/**
	 * Clicks 'Empty Cart' button to empty cart
	 * 
	 * @return {@link Page} where the alert popped up
	 */
	public Page<P> emptyCart() {
		Wait.until(By.xpath(xpath + "//button[contains(text() , 'Empty')]"), Condition.CLICKABLE).click();
		return page;
	}
	
}
