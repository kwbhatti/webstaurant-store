package com.webstaurantstore.core;

/**
 * Execution Environment
 * 
 * @author kbhatti
 *
 */
public enum Env {

	DEV ("Development", "dev.properties"),
	QA ("Testing", "qa.properties"),
	PROD ("Production", "prod.properties")
	;
	
	String name;
	String propertiesFileName;
	
	private Env(String name, String propertiesFileName) {
		this.name = name;
		this.propertiesFileName = propertiesFileName;
	}
}
