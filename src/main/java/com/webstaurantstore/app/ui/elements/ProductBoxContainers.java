package com.webstaurantstore.app.ui.elements;

import org.openqa.selenium.By;

import com.webstaurantstore.ui.Elements;
import com.webstaurantstore.ui.Page;

public class ProductBoxContainers extends Elements<ProductBoxContainer> {

	private static final long serialVersionUID = -1055562807896193573L;

	public ProductBoxContainers(Page<?> page) {
		super(page, By.xpath("//*[contains(@class , 'product-box-container')]"));
	}

	@Override
	public ProductBoxContainer getElement() {
		return new ProductBoxContainer(page);
	}

	
	
}
