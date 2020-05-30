package com.na.test;

/**
 *
 * @author Nandwana
 */
public class MethodReferenceExample {
    
    public static void main(String[] args){
        Thread t1= new Thread(()->printMsg()); // thread instance with lambda expression
        t1.start();
        
        //megthod reference is alternative for lambda structure of type  ()->methodWithoutArg()
        
        Thread t2 = new Thread(MethodReferenceExample::printMsg);//thread isntance with method reference can be used as
                                                                //alternative to lambda without arg as above.
        t2.start();
    }
    
    
    public static void printMsg(){
    System.out.println("Inside printMsg");
}

}