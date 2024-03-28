package com.webstaurantstore.utils;

import java.time.Duration;

/**
 * Utility for sleep
 * 
 * @author kbhatti
 *
 */
public class SleepUtils {

	private SleepUtils() {}
	
	public static void sleepFor(Duration duration) {
		try {
			Thread.sleep(duration.toMillis());
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

}
