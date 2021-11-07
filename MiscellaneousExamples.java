package java8newfeature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;
import java.util.Map.Entry;
import java.util.Objects;

public class MiscellaneousExamples {

	public static void main(String[] args) {
		listReplaceAll();
		//listSort();
		//spliterator();
		//forEachRemaining();
		//forEach();
		mapEnhancements();
		stringJoin();
		arrayMethods();
		numberMethods();
		mathMethods();
		objectsNullCheck();
		booleanMethods();
	}

	private static void listReplaceAll() {
		List<String> departmentList = new ArrayList<>();
		
		departmentList.add("Supply");
		departmentList.add("HR");
		departmentList.add("Sales");
		departmentList.add("Marketing");
		departmentList.add("Insurance");
		departmentList.add("Security");
		departmentList.add("Finance");
		System.out.println("Before List: " + departmentList);
		System.out.println("-------------------------------------------------");
		
		departmentList.replaceAll(element -> element.toUpperCase());
		System.out.println("After List: " + departmentList);
		System.out.println("-------------------------------------------------");
		
		listSort(departmentList);
	}

	private static void listSort(List<String> departmentList) {
		departmentList.sort(Comparator.naturalOrder());
		System.out.println("After sort: " + departmentList);
		System.out.println("-------------------------------------------------");
		
		spliterator(departmentList);
	}

	private static void spliterator(List<String> departmentList) {
		List<String> newList = new ArrayList<>();
		Spliterator<String> splitr  = departmentList.spliterator();
		while (splitr.tryAdvance(value -> newList.add(value.toUpperCase())));
		
		Spliterator<String> newSplitr = newList.spliterator();
		
		while (newSplitr.tryAdvance(System.out::println));
		System.out.println("-------------------------------------------------");
		
		forEachRemaining(departmentList);
	}

	private static void forEachRemaining(List<String> departmentList) {
		departmentList.iterator().forEachRemaining(System.out::println);
		System.out.println("-------------------------------------------------");
		forEach(departmentList);
	}

	private static void forEach(List<String> departmentList) {
		departmentList.forEach(System.out::println);	
		System.out.println("-------------------------------------------------");
	}

	private static void mapEnhancements() {
		Map<String, String> map = new HashMap<>();
		map.put("India", "Delhi");
		map.put("USA", "Washington");
		map.put("Japan", "Tokyo");
		map.put("China", "Beijing");
		map.put("Germany", "Berlin");
		map.put("England", "London");
		
		map.forEach((country, capital) -> {
			System.out.println("the capital of " + country + " is: " + capital);
		});
		System.out.println("-------------------------------------------");
		map.entrySet().stream().sorted(Entry.comparingByKey()).forEachOrdered(System.out::println);
		System.out.println("-------------------------------------------");
		map.entrySet().stream().sorted(Entry.comparingByValue()).forEachOrdered(System.out::println);
		System.out.println(map.getOrDefault("Russia", "No Data present"));
		System.out.println("-------------------------------------------");
		
		map.computeIfAbsent("Spain", name -> "Madrid");
		map.computeIfPresent("USA", (k,v) -> "Washington DC");
		map.compute("India", (key, val) -> "New "  + val);
		map.remove("England", "London");
		map.replaceAll((country, capital) -> capital.toUpperCase());
		map.replace("India", "Delhi");
		map.entrySet().stream().sorted(Entry.comparingByValue()).forEachOrdered(System.out::println);;
		System.out.println("-------------------------------------------");
	}

	private static void stringJoin() {
		String departments = String.join(", ", "Supply", "HR", "Sales");
		System.out.println(departments);
		System.out.println("-------------------------------------------");
	}

	private static void arrayMethods() {
		int[] array = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		Arrays.setAll(array, ele -> {
			return array[ele] = array[ele] * 2;
		});
		System.out.println(Arrays.toString(array));
		
		int[] unsortedArr = {3,78,7,91,20,1,8,54};
		Arrays.parallelSort(unsortedArr);
		System.out.println(Arrays.toString(unsortedArr));
		
		Arrays.parallelPrefix(array, (first, second) -> {
			return first + second;
		});
		
		System.out.println(Arrays.toString(array));
	}

	private static void numberMethods() {
		int sum = Integer.sum(234, 456);
		int max = Integer.max(234, 456);
		int min = Integer.min(234, 456);
		
		System.out.println(sum);
		System.out.println(max);
		System.out.println(min);
	}

	private static void mathMethods() {
		long sum = Math.addExact(1234, 45678);
		long sub = Math.subtractExact(1234, 45678);
		long mul = Math.multiplyExact(1234, 45678);
		long inc = Math.incrementExact(45678);
		long dec = Math.decrementExact(45678);
		long neg = Math.negateExact(1234);
		System.out.println(sum);
		System.out.println(sub);
		System.out.println(mul);
		System.out.println(inc);
		System.out.println(dec);
		System.out.println(neg);
	}

	private static void objectsNullCheck() {
		List<String> departmentList = new ArrayList<>();
		departmentList.add("Supply");
		departmentList.add("HR");
		departmentList.add("Sales");
		departmentList.add("Marketing");
		departmentList.add("Insurance");
		departmentList.add("Security");
		departmentList.add("Finance");
		departmentList.add(null);
		
		long nullCount = departmentList.stream().filter(Objects::isNull).count();
		long nonNullCount = departmentList.stream().filter(Objects::nonNull).count();
		
		System.out.println("Total null Values in the list are: " + nullCount);
		System.out.println("Total non-null Values in the list are: " + nonNullCount);
	}

	private static void booleanMethods() {
		boolean checkAnd = Boolean.logicalAnd(10 > 5, "Eazy".equals("Eazy"));
		boolean checkOr = Boolean.logicalOr(10 > 5, "Eazy".equals("Eazy Byte"));
		boolean checkXor = Boolean.logicalXor(false, true);
		
		System.out.println(checkAnd);
		System.out.println(checkOr);
		System.out.println(checkXor);
		
		
	}
	
	
}
