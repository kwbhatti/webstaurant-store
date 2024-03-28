package com.webstaurantstore.app.ui;

import com.webstaurantstore.app.ui.pages.LandingPage;
import com.webstaurantstore.core.ProjectProperties;
import com.webstaurantstore.ui.UI;

/**TODO: Create navigator class to manage navigation to different pages*/

/**
 * Manages opening a new {@link WebstaurantStoreUI}
 * @author kbhatti
 *
 */
public class WebstaurantStoreUI extends UI {

	public WebstaurantStoreUI() {
		super(ProjectProperties.getWebstaurantStoreAppUrl());
	}
	
	/**
	 * Opens Landing Page (does not perform any action since it is already open
	 * returns the instance of the {@link LandingPage} class
	 * 
	 * @return {@link LandingPage}
	 */
	public LandingPage openLandingPage() {
		return new LandingPage();
	}
}
