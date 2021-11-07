package br.com.javaNewFeature.function;


import java.util.function.Function;
import java.util.function.UnaryOperator;

public class UnaryOperatorExample {
	
	public static void main(String[] args) {
		UnaryOperator<String> convertStrWithUnary = input -> input.toUpperCase();
		
		System.out.println("The uppercase value of given input with Unary operator is: "
				+ convertStrWithUnary.apply("Testando Texto testado!"));
		
		UnaryOperator<String> sameValue = UnaryOperator.identity();
		
		System.out.println("The value of given input is: " + sameValue.apply("Testando texto"));
		
		Function<Integer, Integer> multiplyOperation = a -> {
			System.out.println("Multiply by 2 Operation");
			return a * 2;
		};
		
		UnaryOperator<Integer> tripleOperation = a -> {
			System.out.println("Multiply by 3 Operation");
			return a * 3;
		};
		
		multiplyOperation = multiplyOperation.andThen(tripleOperation);
		
		System.out.println(multiplyOperation.apply(5));
		
		multiplyOperation = multiplyOperation.compose(tripleOperation);
		
		System.out.println(multiplyOperation.apply(5));
		
		multiplyOperation = multiplyOperation.andThen(tripleOperation);
		
		System.out.println(multiplyOperation.apply(5));
		
	}
}
