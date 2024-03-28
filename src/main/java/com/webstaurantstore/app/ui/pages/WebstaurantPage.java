package com.webstaurantstore.app.ui.pages;

import org.openqa.selenium.By;

import com.webstaurantstore.ui.Page;
import com.webstaurantstore.ui.Wait;
import com.webstaurantstore.ui.Wait.Condition;

/**
 * Represents Generic Webstaurant page and all the pages must implement this class
 * 
 * @author kbhatti
 *
 * @param <T> Implementation class of this class
 */
public abstract class WebstaurantPage<T> extends Page<T> {

	static By searchTextbox = By.xpath("(//input[@id = 'searchval'])[1]");
	static By searchButton = By.xpath("(//button[@value = 'Search'])[1]");
	
	static By cartButton = By.xpath("//a[@data-testid = 'cart-button']");
	
	/**
	 * Searches for a product
	 * 
	 * @param product {@link String} product to search
	 * @return {@link SearchResultsPage} 
	 */
	public SearchResultsPage searchProduct(String product) {
		Wait.until(searchTextbox, Condition.PRESENT).sendKeys(product);
		Wait.until(searchButton, Condition.CLICKABLE).click();
		return new SearchResultsPage();
	}
	
	/**
	 * Clicks cart button
	 * 
	 * @return {@link CartPage}
	 */
	public CartPage clickCartButton() {
		Wait.until(cartButton, Condition.CLICKABLE).click();
		return new CartPage();
	}
}
