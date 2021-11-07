package br.com.javaNewFeature.function;


import java.time.LocalDate;
import java.util.function.Supplier;

public class SupplierExample {
	public static void main(String[] args) {
		Supplier<Integer> getCurrDayOfMonth = () -> LocalDate.now().getDayOfMonth();
	
		System.out.println("Today's day of the month is: " + getCurrDayOfMonth.get());
		
		Supplier<String> getCurrDay = () -> LocalDate.now().getDayOfWeek().name();
		
		System.out.println("Today's day is: " + getCurrDay.get());
	}
}
