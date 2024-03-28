package com.webstaurantstore.scenarios;

import java.io.IOException;
import java.time.Duration;

import org.testng.annotations.Test;

import com.webstaurantstore.app.ui.WebstaurantStoreUI;
import com.webstaurantstore.app.ui.elements.TableNavigation;
import com.webstaurantstore.app.ui.pages.SearchResultsPage;
import com.webstaurantstore.core.Log;
import com.webstaurantstore.core.Report;
import com.webstaurantstore.core.Suite;
import com.webstaurantstore.ui.Page;
import com.webstaurantstore.utils.SleepUtils;

public class Cart extends Suite {

	@Test
	private void search() throws IOException {
		Log.info("some message");
		Report.info("stainless work table");
		SearchResultsPage sr = new WebstaurantStoreUI().goToLandingPage().searchProduct("stainless work table");
		SleepUtils.sleepFor(Duration.ofSeconds(1));
		Page.logScreenshot();
		TableNavigation tn = sr.tableNavigation;
		int counter = 0;
		while (tn.isNextButtonVisible()) {
			System.out.println("counter " + counter);
			tn.clickNext();
			counter++;
		}
		SleepUtils.sleepFor(Duration.ofSeconds(3));
		Page.logScreenshot();
		
	}
}
