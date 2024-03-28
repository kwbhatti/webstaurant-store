package com.webstaurantstore.core;

import com.chimpcentral.logger.Logger;
import com.chimpcentral.logger.LoggerOptions;

public class Log {

	Log() {}
		
	static Logger createSuiteLog(LoggerOptions options, String heading) {
		options.setSubHeading(heading);
		return new Logger(options);
	}
	
	static synchronized com.chimpcentral.logger.Log createLog(Logger logger, String name) {
		return logger.createLog(name);
	}
	
	public static com.chimpcentral.logger.Log getLog() {
		return Suite.scenarios.get().log;
	}
	
	public static <T> void info(T message) {
		if (getLog() != null) getLog().info(message);
	}

	public static <T> void warn(T message) {
		if (getLog() != null) getLog().warn(message);
	}
	
	public static void exception(Throwable exception) {
		if (getLog() != null) getLog().exception(exception);
	}
	
	public static <T> void toNode(String name, T logMessage) {
		if (getLog() != null) getLog().toNode(name, logMessage);
	}
	
	public static void image(String screenshotPath) {
		if (getLog() != null) getLog().image(screenshotPath);
	}
	
	public static void image(String screenshotPath, int widthInPixels) {
		if (getLog() != null) getLog().image(screenshotPath, widthInPixels);
	}

}
