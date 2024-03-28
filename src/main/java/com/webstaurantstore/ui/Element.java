package com.webstaurantstore.ui;

import org.openqa.selenium.WebElement;

/**
 * Represents any Element
 * 
 * @author kbhatti
 *
 * @param <P> {@link Page} the element is on
 */
public abstract class Element<P> {
	
	protected Page<P> page = null;
	protected String xpath = null;
	protected WebElement element = null;
	
	/**
	 * 
	 * @param page {@link Page} element is on
	 */
	public Element(Page<P> page) {
		this.page = page;
	}
	
	/**
	 * 
	 * @param page {@link Page} element is on
	 * @param xpath {@link String} xpath of the element
	 */
	public Element(Page<P> page, String xpath) {
		this(page);
		this.xpath = xpath;
	}

	/**
	 * 
	 * @param page {@link Page} element is on
	 * @param element {@link WebElement} 
	 */
	public Element(Page<P> page, WebElement element) {
		this(page);
		this.element = element;
	}
	
}
