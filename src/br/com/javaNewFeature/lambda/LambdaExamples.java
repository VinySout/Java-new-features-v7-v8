package br.com.javaNewFeature.lambda;


public class LambdaExamples {

	public static void main(String[] args) {
		voidMethodWithNoParams();
		voidMethodWithOneParam();
		voidMethodWithTwoParams();
	}
	
	private static void voidMethodWithNoParams() {
		VoidMethodWithNoParams method = () -> {
			System.out.println("Method with no return and input params");
			System.out.println("Method2 with no return and input params");
		};
		
		VoidMethodWithNoParams method1 = () -> 
			System.out.println("Ignoring {} since we have only 1 line");
		
		method.printHello();
		method1.printHello();
			
	}
	private static void voidMethodWithOneParam() {
		VoidMethodWithOneParam method = (input) -> {
			System.out.println(input);
		}; 
		
		VoidMethodWithOneParam method1 = (input) -> System.out.println(input);
		VoidMethodWithOneParam method2 = input -> System.out.println(input);
		
		method.printInput("Hello");
		method1.printInput("Opa!");
		method2.printInput("Welcome");
	}
	
	private static void voidMethodWithTwoParams() {
		VoidMethodWithTwoParams addition = (input, input1) -> {
			return (input + input1);
		}; 
		System.out.println(addition.printInputs(5, 10));
		
		VoidMethodWithTwoParams multiply = (input, input1) -> {
			return (input * input1); 
		};
		
		System.out.println(multiply.printInputs(5, 10)); 
		
		VoidMethodWithTwoParams division = (input, input1) -> input / input1;
		
		System.out.println(division.printInputs(50, 5)); 
	}

}
