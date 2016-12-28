package com.calculators;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Util {
	public static int getNumMonthsTillMaturity(int year, int month, int day) {
		LocalDateTime now = LocalDateTime.now();
		Calendar firstDate = new GregorianCalendar(year, month, day);
		Calendar secondDate = new GregorianCalendar(now.getYear(), now.getMonthValue(), now.getDayOfMonth());
		
		int months  = (firstDate.get(Calendar.YEAR) - secondDate.get(Calendar.YEAR)) * 12 +
			       (firstDate.get(Calendar.MONTH)- secondDate.get(Calendar.MONTH)) + 
			       (firstDate.get(Calendar.DAY_OF_MONTH) >= secondDate.get(Calendar.DAY_OF_MONTH)? 0: -1); 
		return months;
	}
}
