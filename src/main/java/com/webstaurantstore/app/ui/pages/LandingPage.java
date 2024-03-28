package com.webstaurantstore.app.ui.pages;

import org.openqa.selenium.By;

import com.webstaurantstore.ui.Page;

public class LandingPage extends Page<LandingPage> {

	static By searchTextbox = By.xpath("(//input[@id = 'searchval'])[1]");
	static By searchButton = By.xpath("(//button[@value = 'Search'])[1]");
	
	@Override
	public LandingPage getPage() {
		return this;
	}

	public SearchResultsPage searchProduct(String product) {
		sendKeys(searchTextbox, product, Condition.PRESENT);
		click(searchButton, Condition.CLICKABLE);
		return new SearchResultsPage();
	}
	
}
