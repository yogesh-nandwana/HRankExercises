package com.na.test;

/**
 *
 * @author Nandwana
 */
public class TestExercise {
    
    public static void main(String[] args){
        //()->System.out.println("hello"); //how to make use of this lambda        
        oldWay();
        lambdaWay();
      
    }

    private static void oldWay() {
       new MyFunctional() {
            @Override
            public void function() {
                System.out.println("old way: without lambda");
            }
        }.function();
    }

    private static void lambdaWay() {
         MyFunctional myFunc = () -> System.out.println("new way: with lambda");
         myFunc.function();
    }
}

interface MyFunctional{
    void function();
}