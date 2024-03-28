package com.webstaurantstore.ui;

import com.webstaurantstore.core.WebDriverManager;

/**
 * Manages Opening an app
 * 
 * @author kbhatti
 *
 */
public abstract class UI {

	/**
	 * 
	 * @param url {@link String} URL of the website
	 */
	public UI(String url) {
		WebDriverManager.getDriver().manage().window().maximize();
		WebDriverManager.getDriver().get(url);
	}
}
