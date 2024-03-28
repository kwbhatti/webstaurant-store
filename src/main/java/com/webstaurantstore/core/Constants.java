package com.webstaurantstore.core;

import com.chimpcentral.logger.LoggerOptions;
import com.webstaurantstore.utils.FilePaths;

public class Constants {

	private Constants() {}
	
	private static final String DEFAULT_ENV_STR = "PROD";
	private static final String DEFAULT_BROWSER_STR = "CHROME";
	
	private static final String ENV_STR = System.getProperty("env", DEFAULT_ENV_STR);
	public static final Env ENV = Env.valueOf(ENV_STR);

	public static final String USER_DIR = FilePaths.getUserDir();
	public static final String REPORT_FILE_PATH = new FilePaths.FilePath(USER_DIR).append("target").append("Report.html").get();
	public static final String PROPERTIES_DIR = new FilePaths.FilePath(USER_DIR).append("properties").get();
	public static final String PROJECT_PROPERTIES_PATH = new FilePaths.FilePath(PROPERTIES_DIR).append(ENV.propertiesFileName).get();
	public static final String SCREENSHOTS_DIR = new FilePaths.FilePath(USER_DIR).append("target").append("screenshots").get();
	
	private static final String BROWSER_STR = System.getProperty("browser", DEFAULT_BROWSER_STR);
	public static final Browser BROWSER = Browser.valueOf(BROWSER_STR);
	
	public static final LoggerOptions loggerOptions = new LoggerOptions()
			.setFilename("Logs.html")
			.setHeading("Webstaurant Store")
			.setGithubURL("https://github.com/kwbhatti/webstaurant-store")
			.setMailToAddress("khurram.waleed.bhatti@gmail.com");
}
