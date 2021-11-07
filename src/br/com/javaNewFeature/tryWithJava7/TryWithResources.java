package br.com.javaNewFeature.tryWithJava7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResources {

	public static void main(String[] args) throws IOException {
		beforeJava7();
		System.out.println("-----------------------------------------------");
		withJava7();
		System.out.println("-----------------------------------------------");
		withCustomResInJava7();
	}

	private static void beforeJava7() throws IOException {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("C:/teste/testing.txt"));
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
			}
		} finally {
			br.close();
		}
	}
	
	private static void withJava7() throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader("C:/teste/testing.txt"));) {
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
			}
		}
	}
	
	public static void withCustomResInJava7() {
		try (CustomResource cr = new CustomResource();){
			cr.readFromResource();
		}
	}
}
