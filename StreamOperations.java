package java8newfeature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOperations {
	public static void main(String[] args) {
		//mapInStreams();
		//flatMapInStreams();
		filterInStreams();
		//limitInStreams();
		//skipInStreams();
		//reduceInStreams();
		//maxInStreams();
		//groupingByStreams();
		//partitioningByStreams();
		//streamPipeline();
	}
	
	public static void mapInStreams() {
		List<String> departmentList = new ArrayList<>();
		departmentList.add("Supply");
		departmentList.add("HR");
		departmentList.add("Sales");
		departmentList.add("Marketing");
		
		departmentList.stream().map(word -> word.toUpperCase()).forEach(System.out::println);
	}
	
	public static void flatMapInStreams() {
		String[] arrayOfWords = {"Eazy", "Bytes"};
		Stream<String> streamOfWords = Arrays.stream(arrayOfWords);
		Stream<String[]> streamOfLetters = streamOfWords.map(word -> word.split(""));
		streamOfLetters.flatMap(Arrays::stream).forEach(System.out::println);
		
		List<List<String>> list = Arrays.asList(Arrays.asList("Eazy"), Arrays.asList("Bytes"));
		System.out.println(list);
		list.stream().map(Collection::stream).forEach(System.out::println);
		list.stream().flatMap(Collection::stream).forEach(System.out::println);
	}
	
	public static void filterInStreams() {
		List<String> departmentList = new ArrayList<>();
		departmentList.add("Supply");
		departmentList.add("HR");
		departmentList.add("Sales");
		departmentList.add("Marketing");
		
		departmentList.stream().filter(word -> word.startsWith("S")).forEach(System.out::println);
	}
	
	public static void limitInStreams() {
		Stream.generate(new Random()::nextInt).
		limit(10).forEach(System.out::println);
	}
	
	public static void skipInStreams() {
		Stream.iterate(1, n -> n + 1).
		skip(0).limit(20).forEach(System.out::println);
	}
	
	public static void reduceInStreams() {
		System.out.println(
		Stream.iterate(1, n -> n + 1).
		skip(0).limit(20).reduce(0, Integer::sum));
	}
	
	public static void maxInStreams() {
		System.out.println(
		Stream.iterate(0, n -> n + 1).limit(20).max((a, b) -> a + b));
	}

	public static void groupingByStreams() {
		List<Product> productList = Arrays.asList(
				new Product("Apple", 1300), 
				new Product("Samsung", 1400), 
				new Product("Nokia", 800), 
				new Product("Mi", 450));
		
		Map<Integer, List<Product>> groupByPriceMap = productList.stream()
				.collect(Collectors.groupingBy(Product::getPrice));
		
		System.out.println("The list of products grouped by price is:" + groupByPriceMap);
	}
	
	public static void partitioningByStreams() {
		List<Product> productList = Arrays.asList(
				new Product("Apple", 1300), 
				new Product("Samsung", 1400), 
				new Product("Nokia", 800), 
				new Product("Mi", 450));
		
		Map<Boolean, List<Product>> costlyProducts = productList.stream()
				.collect(Collectors.partitioningBy(product -> product.getPrice() > 1000));
		
		System.out.println("The list of products partitioned by price is:" + costlyProducts);
	}
	
	private static void streamPipeline() {
		List<Integer> inputNums = new ArrayList<>();
		inputNums.add(5);
		inputNums.add(2);
		inputNums.add(11);
		inputNums.add(7);
		inputNums.add(4);
		inputNums.add(13);
		inputNums.add(9);
		
		List<Integer> newNums = inputNums.stream().filter(num -> num % 2 != 0)
				.map(num -> num*num).sorted().collect(Collectors.toList());
		
		newNums.forEach(System.out::println);
	}
}
