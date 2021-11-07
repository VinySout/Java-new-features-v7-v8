package java8newfeature;

public class AnonymousVsLambda {
	
	int sum = 0;
	
	public void sum() {
		ArithmeticOperation sumOperation = (a, b) -> {
			int sum = 0;
			this.sum = a+b;
			System.out.printf("The value of sum inside lambda is: %s %n", sum);
			return this.sum;
		};
		System.out.printf("The sum of given 2 numbers is: %s %n", 
				sumOperation.performOperation(10, 20));
	}

	public static void main(String[] args) {
		AnonymousVsLambda lambda = new AnonymousVsLambda();
		lambda.sum();
		
		ArithmeticOperation op = new ArithmeticOperation() {
			@Override
			public int performOperation(int a, int b) {
				// TODO Auto-generated method stub
				return a + b;
			}
			
		};
		
		System.out.printf("the sum of two input integers without lambda is:  %s %n", 
				op.performOperation(10, 20));
		
		ArithmeticOperation sum = (a, b) -> a + b;
		ArithmeticOperation mult = (a, b) -> a * b;
		ArithmeticOperation sub = (a, b) -> a - b;
		
		System.out.printf("the sum of two input integers:  %s %n", 
				sum.performOperation(10, 20));
		System.out.printf("the multiply of two input integers:  %s %n", 
				mult.performOperation(10, 20));
		System.out.printf("the subtract of two input integers without lambda is:  %s %n", 
				sub.performOperation(10, 20));
	}

}
