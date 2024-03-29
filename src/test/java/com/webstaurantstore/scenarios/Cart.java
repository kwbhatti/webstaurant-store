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
import com.webstaurantstore.core.Report;
import com.webstaurantstore.core.Suite;
import com.webstaurantstore.ui.Page;


/**
 * To Execute the test:
 * 		a) either install Eclipse TestNG plugin or use IntelliJ
 * 		b) or run from command line
 * 			mvn clean install
 * 			available options
 * 				1. groups = Will work if test is tagged with group
 * 				2. env = <DEV|QA|PROD> (by default uses PROD)
 * 				3. browser = <CHROME|IE|FIREFOX> (be default uses CHROME)
 * 
 * Report is generated in ./target/Report.html
 * Log is generated in ./target/Logs.html
 * 
 * @author kbhatti
 *
 */
public class Cart extends Suite {

	/**
	 * NOTE: Added Page.logScreenshot() just for the purpose of displaying each page and is not needed
	 * 
	 * @throws IOException
	 */
	@Test
	private void search() throws IOException {
		SoftAssert softAssert = new SoftAssert();
		Report.info("Opening Webstaurant Store UI and searching for product");
		SearchResultsPage searchResultsPage = new WebstaurantStoreUI().openLandingPage().searchProduct("stainless work table");
		Page.logScreenshot();
		TableNavigation<SearchResultsPage> tableNavigation = searchResultsPage.getTableNavigation();
		List<ProductBoxContainer<SearchResultsPage>> productBoxContainers = null;
		Report.info("Checking if all results on each page has the word table in description");
		while (tableNavigation.isNextButtonVisible()) {
			productBoxContainers = searchResultsPage.getProductBoxContainers();
			productBoxContainers.forEach(e -> softAssert.assertTrue(e.getItemDescription().contains("Table")));
			tableNavigation.clickLastButton();
		}
		Report.info("Adding the last product on the last page to cart");
		searchResultsPage.getProductBoxContainer(productBoxContainers.size() -1).addToCart();
		searchResultsPage.getNotification().close();
		Page.logScreenshot();
		Report.info("Opening Cart Page");
		CartPage cartPage = searchResultsPage.clickCartButton();
		Report.info("Emptying cart");
		cartPage.emptyCart();
		Page.logScreenshot();
		softAssert.assertAll();
	}
}
