package br.com.javaNewFeature.safeVar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SafeVarExample {
	
	public static void main(String[] args) {
		sum(1);
		sum(1, 2);
		sum(1, 2, 3);
		
		SafeVarExample obj = new SafeVarExample();
		
		List<String> list1 = new ArrayList<>();
		List<String> list2 = new ArrayList<>();
		List<String> list3 = new ArrayList<>();
		
		list1.add("testing 1");
		list2.add("testing 2");
		list3.add("testing 3");
		
		obj.print(list1, list2, list3);
	}

	@SafeVarargs
	public final void print(List<String>... lists) {
		String firstElement = lists[0].get(0);
		System.out.println(firstElement);
	}

	private static void sum(int... i) {
		System.out.println(Arrays.toString(i));
	}
}
