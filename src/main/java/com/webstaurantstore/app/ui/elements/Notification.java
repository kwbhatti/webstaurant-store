package com.webstaurantstore.app.ui.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.webstaurantstore.ui.Element;
import com.webstaurantstore.ui.Page;
import com.webstaurantstore.ui.Wait;
import com.webstaurantstore.ui.Wait.Condition;

/**
 * Notification that pops up for successful addition to cart
 * 
 * @author kbhatti
 *
 * @param <P> {@link Page} where the notification popped up
 */
public class Notification<P> extends Element<P> {

	/**
	 * 
	 * @param page {@link Page} where the notification popped up
	 */
	public Notification(Page<P> page) {
		super(page, "//*[@id = 'watnotif-wrapper']");
	}
	
	/**
	 * Clicks close button on the notification
	 * 
	 * @return {@link Page} where the notification popped up
	 */
	public Page<P> close() {
		WebElement closeButton = Wait.until(By.xpath(xpath + "//button[@aria-label = 'close']"), Condition.PRESENT);
		closeButton.click();
		return page;
	}

}
