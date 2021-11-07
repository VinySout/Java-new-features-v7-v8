package java8newfeature;

public interface Vehicle {

	public int getSpeed();
	
	public void applyBreak();
	
	public default void autoPilot() {
		System.out.println("I'll help in driving with out manual support");
	}
	
	public static void airBarg() {
		System.out.println("Active");
	}
}
