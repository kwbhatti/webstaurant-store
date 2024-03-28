package com.webstaurantstore.app.ui;

import com.webstaurantstore.app.ui.pages.LandingPage;
import com.webstaurantstore.core.ProjectProperties;
import com.webstaurantstore.ui.UI;

public class WebstaurantStoreUI extends UI {

	public WebstaurantStoreUI() {
		super(ProjectProperties.getWebstaurantStoreAppUrl());
	}
	
	public LandingPage goToLandingPage() {
		return new LandingPage();
	}
}
