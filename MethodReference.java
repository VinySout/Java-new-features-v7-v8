package br.com.java78;

import java.util.ArrayList;
import java.util.List;

public class MethodReference {

	public static void main(String[] args) {
		ArithmeticOperation operation = (a, b) -> {
			int sum = a + b;
			System.out.println("The sum of given input values using lambda is: " + sum);
			return sum;
		};
		
		operation.performOperation(10, 40);
		
		
		ArithmeticOperation methodRef = MethodReference::performAddition;
		
		MethodReference methodRef2 = new MethodReference();
		
		ArithmeticOperation instanceMethod = methodRef2::performInstanceAddition;
		
		
		methodRef.performOperation(10, 55);
		
		instanceMethod.performOperation(45, 65);
		
		//////////////////////////////////////////////////////////////////////////////
		
		List<String> departmentList = new ArrayList<>();
		
		departmentList.add("Supply");
		departmentList.add("HR");
		departmentList.add("Sales");
		departmentList.add("Marketing");
		//departmentList.forEach(s -> System.out.println(s));
		departmentList.forEach(System.out::println);
		
		//////////////////////////////////////////////////////////////////////////////
		
		ProductInterface productInterface = Product::new;
		Product prod = productInterface.getProduct("Apple Iphone", 1500);

		System.out.println(prod.name);
		System.out.println(prod.price);
	}
	
	public static int performAddition(int a, int b) {
		int sum = a + b;
		System.out.println("The sum of given input values using lambda is: " + sum);
		return sum;
	}
	
	public int performInstanceAddition(int a, int b) {
		int sum = a + b;
		System.out.println("The sum of given input values using lambda is: " + sum);
		return sum;
	}
}

