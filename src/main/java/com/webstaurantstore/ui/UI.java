package com.webstaurantstore.ui;

import com.webstaurantstore.core.WebDriverManager;

public abstract class UI {

	public UI(String url) {
		WebDriverManager.getDriver().manage().window().maximize();
		WebDriverManager.getDriver().get(url);
	}
}
