package br.com.javaNewFeature.anonymousVsLambda;


@FunctionalInterface
public interface ProductInterface {

	Product getProduct(String name, int price);
}
