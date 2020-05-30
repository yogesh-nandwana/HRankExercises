package com.na.test;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Nandwana
 */
public class ForEachLoopExample {
    public static void main(String... args){
        final List<Person> personsList = Arrays.asList(new Person("Mohan", "bagwaan", 34),
                new Person("Ram", "manohar", 35),
                new Person("Shyam", "sundar", 39),
                new Person("Dhanna", "lal", 19),
                new Person("Shukhram", "chandar", 69)
        );
        
         System.out.println("Using old for loop which uses external itrerator, executes sequentially");
        for(int i=0;i<personsList.size();i++){
            System.out.println(personsList.get(i));
        }
        
         System.out.println("Using for-in loop which uses external itrerator,  executes sequentially too");
        for(Person p: personsList){
            System.out.println(p);
        }
        
        System.out.println("Using lambda, uses parallelism on multicore cpus, order of print is not fixed");
        personsList.forEach(p->System.out.println(p));
        
        System.out.println("Using method reference uses parallelism on multicore cpus, order of print is not fixed");
        personsList.forEach(System.out::println);
    }
}
