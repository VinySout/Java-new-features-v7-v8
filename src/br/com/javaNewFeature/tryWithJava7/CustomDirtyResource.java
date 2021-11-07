package br.com.javaNewFeature.tryWithJava7;

public class CustomDirtyResource implements AutoCloseable {

	@Override
	public void close() throws Exception {
		throw new NullPointerException("Oops.. It's bad to have a NullPointerException!");
	}
	public void readFromResource() {
		throw new RuntimeException("I'm sorry. I don't have data abailable right now due to network issue!");
	}

}
