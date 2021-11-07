package br.com.javaNewFeature.tryWithJava7;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SupressedExceptions {
	private final static Logger LOGGER = Logger.getLogger(SupressedExceptions.class.getName());

	public static void main(String[] args) {
		try {
			beforeJava7();
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
		}
		
		try {
			withJava7();
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
			final Throwable[] suppressedExceptions = e.getSuppressed();
			final int numSuppressed = suppressedExceptions.length;
			if(numSuppressed > 0) {
				for (final Throwable exception : suppressedExceptions) {
					LOGGER.log(Level.SEVERE, exception.getMessage());
				}
			}
		}
	}

	private static void beforeJava7() throws Exception {
		CustomDirtyResource cr = null;
		try {
			cr = new CustomDirtyResource();
			cr.readFromResource();
		} catch (Exception e) {
			cr.close();
		}
	}

	private static void withJava7() throws Exception {
		try (CustomDirtyResource cr = new CustomDirtyResource();){
			cr.readFromResource();
		}
	}
}
