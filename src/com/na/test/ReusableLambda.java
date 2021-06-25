package com.na.test;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class ReusableLambda {

  public static void main(String[] args) {
    final List<String> friends =  Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
     final List<String> editors =  Arrays.asList("Brian", "Jackie", "John", "Mike");
     final List<String> comrades =  Arrays.asList("Kate", "Ken", "Nick", "Paula", "Zach");
     
     System.out.println(String.format("friends count:%d",filterAndCount(friends, checkIfStartsWith("N"))));
     System.out.println(String.format("editors count:%d",filterAndCount(editors, checkIfStartsWith("B"))));
     
     
     System.out.println(String.format("comrades count:%d",filterAndCount(comrades, checkIfLenMoreThan(4))));
    
    Function<String, Predicate<String>> startsWithLetter = new Function<String, Predicate<String>>() {
      @Override
      public Predicate<String> apply(String t) {
        return name -> name.startsWith(t);
      }};
      
      System.out.println(String.format("friends wcount:%d",filterAndCount(friends, startsWithLetter.apply("N"))));
      
      
      Function<String, Predicate<String>> startsWithLetterNew = t -> name -> name.startsWith(t);
      
      
      System.out.println(String.format("friends wqcount:%d",filterAndCount(friends, startsWithLetterNew.apply("N"))));  
      
      pickName(friends,"J");
      pickName(friends,"S");
      
      final String steveOrLonger1 =
          friends.stream() 
             .reduce("Steve", (name1, name2) -> 
                name1.length() >= name2.length() ? name1 : name2);
      
      System.out.println("steveOrLonger:"+steveOrLonger1);
      
      final Optional<String> aLongName =
          friends.stream() 
             .reduce((name1, name2) -> 
                name1.length() >= name2.length() ? name1 : name2);
          aLongName.ifPresent(name ->
             System.out.println(
                String.format("A longest name: %s", name)));
          
          final String steveOrLonger2 =
              friends.stream() 
                 .reduce("Steve", (name1, name2) -> 
                    name1.length() >= name2.length() ? name1 : name2);
          
          System.out.println("steveOrLonger2:"+steveOrLonger2);
          
          System.out.println(String.join(", ", friends));
          
          StringJoiner sj = new StringJoiner(":").add("George").add("Sally").add("Fred");
          System.out.println(sj.toString());
          
          StringJoiner sj1 = new StringJoiner(",","(",")").add("George").add("Sally").add("Fred");
          System.out.println(sj1.toString());
          
          System.out.println(
              friends.stream() 
                 .map(String::toUpperCase) 
                 .collect(Collectors.joining(", ")));
  }
  
  public static void pickName(final List<String> names, final String startingLetter) {
    final Optional<String> foundName =  names.stream().filter(name -> name.startsWith(startingLetter)).findFirst();
    System.out.println(String.format("A name starting with %s: %s", startingLetter,
        foundName.orElse("No name found")));
    
    foundName.ifPresent(name -> System.out.printf("Hello %s", name));
  }
  
  
  public static Predicate<String> checkIfStartsWith( String letter) {
    return name -> name.startsWith(letter); //compiler figures out letter using lexical scoping, as letter is not passed in as arg to lambda
  }
  
  public static Predicate<String> checkIfLenMoreThan(final int len){
    return name -> name.length()>len;
  }
  
  public static long filterAndCount(Collection<String> coll,Predicate<String> test){
    return coll.stream().filter(test).count();
  }
}
