package com.webstaurantstore.app.ui.elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import com.webstaurantstore.ui.Element;
import com.webstaurantstore.ui.Page;
import com.webstaurantstore.ui.Page.Condition;

public class ProductBoxContainer extends Element<ProductBoxContainer> {

	static String xpath = "//*[contains(@class , 'product-box-container')]";
	By itemDescriptionSpan = null;
	By addToCartButton = null;
	
	public ProductBoxContainer(Page<?> page) {
		super(page, By.xpath(xpath));
		this.itemDescriptionSpan = By.xpath(xpath + "//*[@data-testid = 'itemDescription']");
		this.addToCartButton = By.xpath(xpath + "//*[@data-testid = 'itemAddCart']");
	}

	@Override
	public ProductBoxContainer getElement() {
		return this;
	}
	
	public String getItemDescription() {
		return findElement(itemDescriptionSpan, Condition.PRESENT).getText();
	}
	
	public void addToCart() {
		findElement(addToCartButton, Condition.PRESENT).click();
	}

	
}
