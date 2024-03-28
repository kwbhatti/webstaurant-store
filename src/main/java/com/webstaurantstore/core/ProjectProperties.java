package com.webstaurantstore.core;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ProjectProperties {

	private Properties properties = new Properties();
	private static ProjectProperties instance = null;
	
	private ProjectProperties() {
		try (InputStream inputStream = new FileInputStream(Constants.PROJECT_PROPERTIES_PATH)) {
			properties.load(inputStream);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
	
	private static ProjectProperties getInstance() {
		if (instance != null) return instance;
		return new ProjectProperties();
	}
	
	public static String getProperty(String key) {
		return getInstance().properties.getProperty(key);
	}

	public static String getWebstaurantStoreAppUrl() {
		return getProperty("webstaurant-store.app.url");
	}
	
}
