package com.webstaurantstore.scenarios;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.webstaurantstore.app.ui.WebstaurantStoreUI;
import com.webstaurantstore.app.ui.elements.ProductBoxContainer;
import com.webstaurantstore.app.ui.elements.TableNavigation;
import com.webstaurantstore.app.ui.pages.CartPage;
import com.webstaurantstore.app.ui.pages.SearchResultsPage;
import com.webstaurantstore.core.Suite;
import com.webstaurantstore.ui.Page;

public class Cart extends Suite {

	@Test
	private void search() throws IOException {
		SoftAssert softAssert = new SoftAssert();
		SearchResultsPage searchResultsPage = new WebstaurantStoreUI().openLandingPage().searchProduct("stainless work table");
		Page.logScreenshot();
		TableNavigation<SearchResultsPage> tableNavigation = searchResultsPage.getTableNavigation();
		List<ProductBoxContainer<SearchResultsPage>> productBoxContainers = null;
		while (tableNavigation.isNextButtonVisible()) {
			productBoxContainers = searchResultsPage.getProductBoxContainers();
			productBoxContainers.forEach(e -> softAssert.assertTrue(e.getItemDescription().contains("Table")));
			tableNavigation.clickLastButton();
		}
		searchResultsPage.getProductBoxContainer(productBoxContainers.size() -1).addToCart();
		searchResultsPage.getNotification().close();
		Page.logScreenshot();
		CartPage cartPage = searchResultsPage.clickCartButton();
		cartPage.emptyCart();
		Page.logScreenshot();
		softAssert.assertAll();
	}
}
