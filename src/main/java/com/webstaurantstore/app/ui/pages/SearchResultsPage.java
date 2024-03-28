package com.webstaurantstore.app.ui.pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.webstaurantstore.app.ui.elements.Notification;
import com.webstaurantstore.app.ui.elements.ProductBoxContainer;
import com.webstaurantstore.app.ui.elements.TableNavigation;
import com.webstaurantstore.ui.Wait;
import com.webstaurantstore.ui.Wait.CollectionCondition;
import com.webstaurantstore.ui.Wait.Condition;

/**
 * Represents Search Results Page
 * 
 * @author kbhatti
 *
 */
public class SearchResultsPage extends WebstaurantPage<SearchResultsPage> {

	static String productBoxContainerXpath = "//*[contains(@class , 'product-box-container')]";
	
 	public SearchResultsPage() {
	}
	
	@Override
	public SearchResultsPage getPage() {
		return this;
	}
	
	/**
	 * Returns table navigation
	 * 
	 * @return {@link TableNavigation}
	 */
	public TableNavigation<SearchResultsPage> getTableNavigation() {
		return new TableNavigation<>(this, "//nav[@aria-label = 'pagination']");
	}
	
	/**
	 * Returns all the product box containers on the page
	 * 
	 * @return {@link List} of {@link ProductBoxContainer}
	 */
	public List<ProductBoxContainer<SearchResultsPage>> getProductBoxContainers() {
		List<WebElement> elements = Wait.until(By.xpath(productBoxContainerXpath), CollectionCondition.VISIBLE);		
		return elements.stream().map(e -> new ProductBoxContainer<SearchResultsPage>(this, e)).collect(Collectors.toList());
	}
	
	/**
	 * Returns a single product box container by its index
	 * 
	 * @param index {@link Integer} index of the product box on page
	 * @return {@link ProductBoxContainer}
	 */
	public ProductBoxContainer<SearchResultsPage> getProductBoxContainer(int index) {
		index++;
		WebElement productBoxContainer = Wait.until(By.xpath(productBoxContainerXpath + "[" + index + "]"), Condition.VISIBLE);
		return new ProductBoxContainer<>(this, productBoxContainer);
	}
	
	/**
	 * Returns the notification
	 * 
	 * @return {@link Notification}
	 */
	public Notification<SearchResultsPage> getNotification() {
		return new Notification<>(this);
	}

}
