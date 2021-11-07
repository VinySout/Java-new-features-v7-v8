package br.com.javaNewFeature.tryWithJava7;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CatchingMultipleExceptions {
	
	private final static Logger LOGGER = Logger.getLogger(SupressedExceptions.class.getName());
	
	public static void main(String[] args) {
		//beforeJava7();
		withJava7();
	}

	private static void beforeJava7() {
		int arr[] = { 1, 2, 3 };
		try {
			for (int i = 0; i < arr.length + 1; i++) {
				System.out.println(arr[i]);
			}
		} catch (NullPointerException e) {
			LOGGER.log(Level.SEVERE, e.toString());
		} catch (ArrayIndexOutOfBoundsException ex) {
			LOGGER.log(Level.SEVERE, ex.toString());
		}
	}

	private static void withJava7() {
		int arr[] = { 1, 2, 3 };
		try {
			for (int i = 0; i < arr.length + 1; i++) {
				System.out.println(arr[i]);
			}
		} catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
			LOGGER.log(Level.SEVERE, e.toString());
		}
	}
}
