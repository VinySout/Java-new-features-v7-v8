package br.com.javaNewFeature.tryWithJava7;

import java.util.logging.Level;
import java.util.logging.Logger;

@SuppressWarnings("serial")
public class RethrowExceptions {
	
	private final static Logger LOGGER = Logger.getLogger(RethrowExceptions.class.getName());
	
	public static void main(String[] args) throws Exception {
		//beforeJava7("First");
		//withJava7("First");
		//withJava7ReflectiveOperation();
		withJava7ReflectiveOperation2();
	}

	private static void beforeJava7(String exName) throws Exception {
		try {
			if (exName.equals("First")) 
				throw new FistExceptions();
			else 
				 throw new SecondExceptions();
		} catch (Exception e) {
			 throw e;
		}
	}

	private static void withJava7(String exName) throws FistExceptions, SecondExceptions {
		try {
			if (exName.equals("First")) 
				throw new FistExceptions();
			else 
				 throw new SecondExceptions();
		} catch (Exception e) {
			 throw e;
		}
	}
	
	public static void withJava7ReflectiveOperation() {
		try {
			Class.forName("br.com.javaNewFeature.tryWithJava7.RethrowExceptions").getMethod("withJava7ReflectiveOperation").invoke(null, new Object[] {});
		} catch (ReflectiveOperationException e) {
			LOGGER.log(Level.SEVERE, e.toString());
		}
	}
	
	public static void withJava7ReflectiveOperation2() {
		try {
			Class.forName("br.com.javaNewFeature.tryWithJava7.RethrowExceptions").getMethod("testing").invoke(null, new Object[] {});
		} catch (ReflectiveOperationException e) {
			LOGGER.log(Level.SEVERE, e.toString());
		}
	}
	
	public static void testing () {
		System.out.println("Testing...!");
	}
	
	static class FistExceptions extends Exception {

	}
	
	static class SecondExceptions extends Exception {

	}

}


