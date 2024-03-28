package com.webstaurantstore.app.ui.pages;

import com.webstaurantstore.app.ui.elements.ProductBoxContainers;
import com.webstaurantstore.app.ui.elements.TableNavigation;
import com.webstaurantstore.ui.Page;

public class SearchResultsPage extends Page<SearchResultsPage> {

	public TableNavigation tableNavigation = null;
	public ProductBoxContainers productBoxContainers = null;
	
 	public SearchResultsPage() {
		this.tableNavigation = new TableNavigation(this);
		this.productBoxContainers = new ProductBoxContainers(this);
	}
	
	@Override
	public SearchResultsPage getPage() {
		return this;
	}
	
	

}
