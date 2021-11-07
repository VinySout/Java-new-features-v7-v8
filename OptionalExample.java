package java8newfeature;

import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalExample {
	
	public static void main(String[] args) {
		withJava8();
	}

	public static void withJava8() {
		String[] str = new String[10];
		
		str[5] = "Eazy Byte 1";
		str[4] = "Eazy Byte 2";
		
		Optional<String> empty = Optional.empty();
		System.out.println(empty);
		
		Optional<String> value = Optional.of(str[5]);
		System.out.println(value.get());
		
		Optional<String> nullValue = Optional.ofNullable(str[4]);
		nullValue.ifPresent(System.out::println);
		System.out.println(nullValue.orElse("No Value").toLowerCase());
		
		Optional<String> nonEmptyString = Optional.of("Eazy Byte 3");
		Optional<String> emptyString = Optional.empty();
		
		System.out.println("Non-Empty Optional: " + nonEmptyString.map(String::toUpperCase));
		System.out.println("Empty Optional: " + emptyString.map(String::toUpperCase));
		
		Optional<Optional<String>> nonEmptyOptionalInput = Optional.of(Optional.of("Eazy Byte 4"));
		System.out.println("Optional value: " + nonEmptyOptionalInput);
		System.out.println("Optional.map: " + nonEmptyOptionalInput.map(input -> input.map(String::toUpperCase)));
		
		System.out.println("Optional.flatMap: " + nonEmptyOptionalInput.flatMap(input -> input.map(String::toUpperCase)));
		
		Optional<String> country = Optional.of("INDIA");
		Optional<String> emptyCountry = Optional.empty();
		
		System.out.println(country.filter(g -> g.equals("india")));
		System.out.println(country.filter(g -> g.equalsIgnoreCase("INDIA")));
		System.out.println(emptyCountry.filter(g -> g.equalsIgnoreCase("INDIA")));
		
		if(country.isPresent()) {
			System.out.println("Value available");
		}
		
		country.ifPresent(c -> System.out.println("In Countr Option, Value available is: " + c));
		emptyCountry.ifPresent(c -> System.out.println("In Countr Option, Value available is: " + c));
	
		System.out.println(country.orElse("No Countr data available"));
		System.out.println(emptyCountry.orElse("No Countr data available"));
		System.out.println(emptyCountry.orElseGet(() -> "No Countr data available"));
		System.out.println(emptyCountry.orElseThrow(NoSuchElementException::new));
		
	}
	
}
