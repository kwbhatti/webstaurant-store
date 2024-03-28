package com.webstaurantstore.app.ui.pages;

import org.openqa.selenium.By;

import com.webstaurantstore.app.ui.elements.EmptyCartAlert;
import com.webstaurantstore.ui.Wait;
import com.webstaurantstore.ui.Wait.Condition;

/**
 * Represents Cart Page
 * 
 * @author kbhatti
 *
 */
public class CartPage extends WebstaurantPage<CartPage> {

	static By emptyCartButton = By.xpath("//button[text() = 'Empty Cart']");
	
	@Override
	public CartPage getPage() {
		return this;
	}

	/**
	 * Clicks on 'Empty Cart' button and returns {@link EmptyCartAlert} since that is displayed next
	 * 
	 * @return {@link EmptyCartAlert} 
	 */
	public EmptyCartAlert<CartPage> clickEmptyCartButton() {
		Wait.until(emptyCartButton, Condition.CLICKABLE).click();
		return new EmptyCartAlert<CartPage>(this);
	}
	
	/**
	 * Clicks on 'Empty Cart' button and then clicks on 'Empty Cart' button again in the Empty Cart Alert
	 * 
	 * @return {@link CartPage}
	 */
	public CartPage emptyCart() {
		clickEmptyCartButton().emptyCart();
		return this;
	}
}
