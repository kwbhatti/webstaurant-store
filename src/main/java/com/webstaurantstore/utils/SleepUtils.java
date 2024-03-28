package com.webstaurantstore.utils;

import java.time.Duration;

public class SleepUtils {

	private SleepUtils() {}
	
	public static void sleepFor(Duration duration) {
		try {
			Thread.sleep(duration.toMillis());
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	public static int getRatio(Duration sleep, Duration timeout) {
		return (int) (timeout.toMillis() / sleep.toMillis());
	}
}
