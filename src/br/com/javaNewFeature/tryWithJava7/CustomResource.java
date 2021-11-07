package br.com.javaNewFeature.tryWithJava7;

public class CustomResource implements AutoCloseable {

	@Override
	public void close() {
		System.out.println(" From close method inside the customResource class");
	}
	
	public void readFromResource() {
		System.out.println(" Reading data... ");
	}
}
