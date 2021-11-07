package br.com.javaNewFeature.tryWithJava7;

import java.util.Objects;

import br.com.javaNewFeature.anonymousVsLambda.Product;

public class RequireNonNull {

	public static void main(String[] args) {
		Product product = null;
		processProductDetails(product);
	}

	private static void processProductDetails(Product product) {
		Objects.requireNonNull(product, "Product object can't be null");
		System.out.println(product.getNome());
		System.out.println(product.getPrice());
	}

}

