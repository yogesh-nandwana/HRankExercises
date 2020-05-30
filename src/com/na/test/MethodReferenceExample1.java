package com.na.test;

import java.util.Arrays;
import java.util.List;

import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 *
 * @author Nandwana
 */
public class MethodReferenceExample1 {

    public static void main(String... args) {
        final List<Person> personsList = Arrays.asList(new Person("Mohan", "bagwaan", 34),
                new Person("Ram", "manohar", 35),
                new Person("Shyam", "sundar", 39),
                new Person("Dhanna", "lal", 19),
                new Person("Shukhram", "chandar", 69)
        );

        System.out.println("Going to print all persons");
        //performConditionally(personsList, p -> true, p -> System.out.println(p));
        
        //we can replace consumer lambda with method reference as below
        //for lamda structure of type p->method(p)
        //for example in below case p->accept(p)
        performConditionally(personsList, p -> true,System.out::println);

    }

    public static void performConditionally(List<Person> persons, Predicate<Person> predicate, Consumer<Person> c) {
        for (Person p : persons) {
            if (predicate.test(p)) {
                c.accept(p);
            }
        }
    }
}