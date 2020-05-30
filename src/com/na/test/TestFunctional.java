package com.na.test;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

@FunctionalInterface
interface Foo {
	String method(String str);

	default void sayHi() {
		System.out.println("hi");
	}
}

class UseFoo {
	String addFoo(String str, Function<String, String> foo) {
		return foo.apply(str);
	}
}

public class TestFunctional {
	public static void main(String[] args) {

		// Objects.requireNonNull(obj);

		Function<String, String> foo = str -> str + " from foo ";

		Foo fooInterface = str -> str + " using Foo...";

		Runnable r = () -> System.out.println("hi");

		Runnable s = Thread::new;

		UseFoo useFoo = new UseFoo();
		System.out.println(useFoo.addFoo("hi", foo));

		String[] strArray = { "a", "b", "c", "d" };

		Stream<String> stream = Arrays.stream(strArray);

		boolean anyMatch = Stream.of("a", "b", "c").anyMatch(x -> x.equals("ca"));
		System.out.println(anyMatch);

		Stream<String> filterdStream = stream.filter(t -> !t.equals("d"));
		filterdStream.forEach(t -> System.out.println(t));

		// List<String> collect = filterdStream.collect(Collectors.toList());
		// collect.forEach(s1->System.out.println(s1));
	}
}