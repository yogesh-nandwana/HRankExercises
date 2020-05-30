package com.na.test;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Nandwana
 */
public class StreamsTest1 {
    public static void main(String... args){
        final List<Person> personsList = Arrays.asList(new Person("Mohan", "bagwaan", 34),
                new Person("Ram", "manohar", 35),
                new Person("Shyam", "sundar", 39),
                new Person("Dhanna", "lal", 19),
                new Person("Shukhram", "chandar", 69)
        );
     
        personsList.stream() //Sequential stram with collection as its source
         .filter(p->p.getLastName().startsWith("lal")) //intermediate operation
        .forEach(p->System.out.println(p)); //terminal operation
        
        
        long count = personsList.parallelStream()
                .filter(p->p.getFirstName().startsWith("M"))
                .count();
        
        System.out.println("count:"+count);
    }
}