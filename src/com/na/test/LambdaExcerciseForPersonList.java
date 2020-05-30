package com.na.test;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;

//1. sort list by last name
//2.Create a method that prints all elements in the list
//3.Create a method that prints all persons detal whose last name starts with "c"
public class LambdaExcerciseForPersonList {

    public static void main(String... args) {
        final List<Person> personsList = Arrays.asList(new Person("Mohan", "bagwaan", 34),
                new Person("Ram", "manohar", 35),
                new Person("Shyam", "sundar", 39),
                new Person("Dhanna", "lal", 19),
                new Person("Shukhram", "chandar", 69)
        );

        System.out.println("Going to sort persons list...");
        sortPersonByLastName(personsList);
       
        System.out.println("Going to print all persons");
       // printConditionally(personsList,p -> true);
        performConditionally(personsList, p->true,p->System.out.println(p));

        System.out.println("Going to print conditionally..");
        //printConditionally(personsList, p -> p.getLastName().startsWith("c"));
        performConditionally(personsList, p->p.getLastName().startsWith("c"),p->System.out.println(p.getLastName()));
    
}
//    interface Condition{
//        boolean test(Person p);
//    }

   
public static void performConditionally(List<Person> persons,Predicate<Person> predicate,Consumer<Person> c){
    for(Person p:persons){
        if(predicate.test(p)){
            c.accept(p);
        }
    }     
}

    public static void printConditionally(List<Person> persons,Predicate<Person> predicate){
        persons.stream().filter(p->predicate.test(p)).forEach(p->System.out.println(p));
    }
          //    public static void printConditionally(List<Person> persons, Condition c) {
//        persons.stream().filter(p->c.test(p)).forEach(p->System.out.println(p));     
//        persons.forEach(p -> {
//            if(p.getLastName().startsWith(startWith)){
//                System.out.println(p);
//            }            
//        });
    

  
    public static void sortPersonByLastName(List<Person> persons) {
        persons.sort((p1, p2) -> {
            return p1.getLastName().compareTo(p2.getLastName());
        }
        );
    }
    
//     public static void printPersons(List<Person> persons) {
//        persons.forEach(p -> System.out.println(p));
//    }
}

class Person {
    private final String firstName;
    private final String lastName;
    private final int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" + "firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.firstName);
        hash = 43 * hash + Objects.hashCode(this.lastName);
        hash = 43 * hash + this.age;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (this.age != other.age) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        return true;
    }
}