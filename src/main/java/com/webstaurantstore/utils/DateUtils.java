package com.webstaurantstore.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * Utility for Date, Time, Calendar
 * 
 * @author kbhatti
 *
 */
public class DateUtils {

	public static long getCurrentUnixTimeStamp() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getTimeInMillis();
    }
}
