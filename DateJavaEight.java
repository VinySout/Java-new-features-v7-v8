package br.com.java78;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;

public class DateJavaEight {

	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
		LocalDate date = LocalDate.of(1939, 6, 16);
		int year = date.getYear();
		Month month = date.getMonth();
		int day = date.getDayOfMonth();
		DayOfWeek dow = date.getDayOfWeek();
		int len = date.lengthOfMonth();
		boolean leap = date.isLeapYear();
		
		int year1 = date.get(ChronoField.YEAR);
		int month1 = date.get(ChronoField.MONTH_OF_YEAR);
		int day1 = date.get(ChronoField.DAY_OF_MONTH);
		
		LocalDate parseDate = LocalDate.parse("2000-06-16");
		
		System.out.println("Done");
	}

}
