package java8newfeature;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateExample {

	public static void main(String[] args) {
		Predicate<Integer> isEven = i -> i % 2 == 0;
		
		System.out.println(isEven.test(61));
		
		Predicate<Integer> isGreaterThan50 = i -> i > 50;
		
		System.out.println(isGreaterThan50.test(51));
		
		System.out.println(isGreaterThan50.and(isEven).test(60));
		
		System.out.println(isGreaterThan50.or(isEven).test(41));
		
		System.out.println(isGreaterThan50.negate().test(40));
		
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		List<Integer> collect = list.stream().filter(isEven.negate()).collect(Collectors.toList());
		
		System.out.println("List of even from the given list: " + collect);
		
		Predicate<String> checkquality = Predicate.isEqual("Eazy Byte");
		
		System.out.println("Is the input string is equal ? : " + checkquality.test("Eazy Byte"));
		
	}

}
