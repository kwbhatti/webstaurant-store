package com.webstaurantstore.app.ui.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.webstaurantstore.ui.Element;
import com.webstaurantstore.ui.Page;

/**
 * Represents a single product box container after searching for products
 * 
 * @author kbhatti
 *
 * @param <P> {@link Page} where the product box is displayed
 */
public class ProductBoxContainer<P> extends Element<P> {

	By itemDescriptionSpan = By.xpath(".//*[@data-testid = 'itemDescription']");
	By addToCartButton = By.xpath(".//*[@data-testid = 'itemAddCart']");
	
	/**
	 * 
	 * @param page {@link Page} where the product box is displayed
	 * @param element {@link WebElement} representation of product box
	 */
	public ProductBoxContainer(Page<P> page, WebElement element) {
		super(page, element);
	}
	
	/**
	 * @return Returns the item description of the product box
	 */
	public String getItemDescription() {
		return element.findElement(itemDescriptionSpan).getText();
	}
	
	/**
	 * Clicks 'Add to Cart' button for the product
	 */
	public void addToCart() {
		element.findElement(addToCartButton).click();
	}

}
