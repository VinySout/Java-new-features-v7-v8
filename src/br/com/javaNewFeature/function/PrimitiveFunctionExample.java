package br.com.javaNewFeature.function;


import java.time.LocalDate;
import java.util.Arrays;
import java.util.Random;
import java.util.function.BooleanSupplier;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.DoublePredicate;
import java.util.function.DoubleSupplier;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.LongBinaryOperator;
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.function.LongPredicate;
import java.util.function.LongSupplier;
import java.util.function.LongToDoubleFunction;
import java.util.function.LongToIntFunction;
import java.util.function.LongUnaryOperator;
import java.util.function.ObjDoubleConsumer;
import java.util.function.ObjIntConsumer;
import java.util.function.ObjLongConsumer;
import java.util.function.ToDoubleBiFunction;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntBiFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongBiFunction;
import java.util.function.ToLongFunction;

public class PrimitiveFunctionExample {

	public static void main(String[] args) {
		problemWithNormalFunctionalInterfaces();
		predicatePrimitiveFunctions();
		functionPrimitiveFunctions();
		biFunctionPrimitiveFunctions();
		consumerPrimitiveFunctions();
		supplierPrimitiveFunctions();
		unaryPrimitiveFunctions();
		binaryPrimitiveFunctions();
	}

	private static void problemWithNormalFunctionalInterfaces() {
		Function<Integer, Integer> doubleTheValue = input -> input *2;
		
		int[] ipArray = {1,2,3,4,5,6,7,8,9,10};
		int[] opArray = new int[ipArray.length];
		
		for (int i = 0; i < ipArray.length; i++) {
			opArray[i] = doubleTheValue.apply(ipArray[i]);
		}
		
		System.out.println("The output Array is: " + Arrays.toString(ipArray));
		System.out.println("The output Array is: " + Arrays.toString(opArray));
		
	}

	private static void predicatePrimitiveFunctions() {
		IntPredicate checkInt = a -> a % 2 == 0;
		DoublePredicate checkDouble = a -> a % 2 == 0; 
		LongPredicate checkLong = a -> a % 2 == 0;
		
		System.out.println("Output from IntPredicate is: " + checkInt.test(10));
		System.out.println("Output from DoublePredicate is: " + checkDouble.test(10.0));
		System.out.println("Output from LongPredicate is: " + checkLong.test(1356479684));
		
	}

	private static void functionPrimitiveFunctions() {
		IntFunction<String> applyInt = a -> Integer.toString(a);
		DoubleFunction<String> applyDouble = a -> Double.toString(a);
		LongFunction<String> applyLong = a -> Long.toString(a);
		
		System.out.println("Output from IntFunction is: " + applyInt.apply(10));
		System.out.println("Output from DoubleFunction is: " + applyDouble.apply(10.5));
		System.out.println("Output from LongFunction is: " + applyLong.apply(1356479684));
		
		ToIntFunction<String> toInt = a -> Integer.parseInt(a);
		ToDoubleFunction<String> toDouble = a -> Double.parseDouble(a);
		ToLongFunction<String> toLong = a -> Long.parseLong(a);
		
		System.out.println("Output from ToIntFunction is: " + toInt.applyAsInt("20"));
		System.out.println("Output from ToDoubleFunction is: " + toDouble.applyAsDouble("10.5"));
		System.out.println("Output from ToLongFunction is: " + toLong.applyAsLong("1356479684"));
		
		IntToLongFunction intToLong = a -> (long) a;
		IntToDoubleFunction intToDouble = a -> (double) a;
		LongToIntFunction longToInt = a -> (int) a;
		LongToDoubleFunction longToDouble = a -> (double) a;
		DoubleToIntFunction doubleToInt = a -> (int) a;
		DoubleToLongFunction doubleToLong = a -> (long) a;
		
		System.out.println("Output from IntToLongFunction is: " + intToLong.applyAsLong(10));
		System.out.println("Output from IntToDoubleFunction is: " + intToDouble.applyAsDouble(10));
		System.out.println("Output from LongToIntFunction is: " + longToInt.applyAsInt(10344));
		System.out.println("Output from LongToDoubleFunction is: " + longToDouble.applyAsDouble(10344));
		System.out.println("Output from DoubleToIntFunction is: " + doubleToInt.applyAsInt(10.10));
		System.out.println("Output from DoubleToLongFunction is: " + doubleToLong.applyAsLong(10344.65));
	}

	private static void biFunctionPrimitiveFunctions() {
		ToIntBiFunction<String, String> toIntBiFunc = (input1, input2) -> {
			return (Integer.parseInt(input1) + Integer.parseInt(input2));
		};
		
		System.out.println("Output from ToIntBiFunction is:" + toIntBiFunc.applyAsInt("10", "20"));
		
		ToLongBiFunction<String, String> toLongBiFunc = (input1, input2) -> {
			return (Long.parseLong(input1) + Long.parseLong(input2));
		};
		
		System.out.println("Output from ToLongBiFunction is:" + toLongBiFunc.applyAsLong("101989", "658981"));
		
		ToDoubleBiFunction<String, String> toDoubleBiFunc = (input1, input2) -> {
			return (Double.parseDouble(input1) + Double.parseDouble(input2));
		};
		
		System.out.println("Output from ToDoubleBiFunction is:" + toDoubleBiFunc.applyAsDouble("10.89", "65.81"));
	}

	private static void consumerPrimitiveFunctions() {
		IntConsumer intCons = a -> System.out.println("Output from IntConsumer is: " + a);
		intCons.accept(10);
		
		LongConsumer longCons = a -> System.out.println("Output from LongConsumer is: " + a);
		longCons.accept(658965874);
		
		DoubleConsumer doubleCons = a -> System.out.println("Output from DoubleConsumer is: " + a);
		doubleCons.accept(10.2);
		
		ObjIntConsumer<String> objInt = (input, a) -> System.out.println("Output from ObjIntConsumer is: " + input + " " + a);
		objInt.accept("ten", 10);
		
		ObjLongConsumer<String> objLong = (input, a) -> System.out.println("Output from ObjLongConsumer is: " + input + " " + a);
		objLong.accept("one hundred thousand", 100000);
		
		ObjDoubleConsumer<String> objDouble = (input, a) -> System.out.println("Output from ObjDoubleConsumer is: " + input + " " + a);
		objDouble.accept("ten", 10.5);
	}

	private static void supplierPrimitiveFunctions() {
		IntSupplier intSupp = () -> {
			Random rand = new Random();
			return rand.nextInt(1000);
		};
		
		System.out.println("output from IntSupplier is: " + intSupp.getAsInt());
		
		LongSupplier longSupp = () -> {
			Random rand = new Random();
			return rand.nextLong();
		};
		
		System.out.println("output from LongSupplier is: " + longSupp.getAsLong());
		
		DoubleSupplier doubleSupp = () -> {
			Random rand = new Random();
			return rand.nextDouble();
		};
		
		System.out.println("output from DoubleSupplier is: " + doubleSupp.getAsDouble());
		
		BooleanSupplier booleanSupp = () -> LocalDate.now().isLeapYear();
		System.out.println("output from BooleanSupplier is: " + booleanSupp.getAsBoolean());
		
		
	}

	private static void unaryPrimitiveFunctions() {
		IntUnaryOperator intUnary = a -> a * 2;
		System.out.println("output from IntUnaryOperator is: " + intUnary.applyAsInt(24));
		
		LongUnaryOperator longUnary = a -> a * 2;
		System.out.println("output from LongUnaryOperator is: " + longUnary.applyAsLong(246545));
		
		DoubleUnaryOperator doubleUnary = a -> a * 2;
		System.out.println("output from DoubleUnaryOperator is: " + doubleUnary.applyAsDouble(24.56));
	}

	private static void binaryPrimitiveFunctions() {
		IntBinaryOperator intBinary = (a,b) -> a+b;
		System.out.println("output from IntBinaryOperator is: " + intBinary.applyAsInt(24, 26));
		
		LongBinaryOperator longBinary = (a,b) -> a+b;
		System.out.println("output from LongBinaryOperator is: " + longBinary.applyAsLong(2423423, 2654546));
		
		DoubleBinaryOperator doubleBinary = (a,b) -> a+b;
		System.out.println("output from DoubleBinaryOperator is: " + doubleBinary.applyAsDouble(24.23, 26.46));
		
	}

}
