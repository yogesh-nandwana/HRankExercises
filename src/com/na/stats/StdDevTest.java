package com.na.stats;

import java.util.Arrays;
import java.util.Scanner;

public class StdDevTest {
	public static void main(String[] args) {
		int[] arr =  readIntsFromScreen();
		//int[] arr  = new int[] {10,40,30,50,20};
		double avg = Arrays.stream(arr).average().orElse(0);
		double sum = Arrays.stream(arr).mapToDouble(a -> (avg - a)*(avg - a)).sum();
		double sqrt = Math.sqrt(sum / arr.length);
		System.out.printf("%.1f",sqrt);		
	}
	
	public static int[] readIntsFromScreen(){
		Scanner scr = new Scanner(System.in);
		int count =  scr.nextInt();
		int[] arr = new int[count];
		for(int i=0;i<count;i++) {
			arr[i]=scr.nextInt();
		}
		scr.close();
		return arr;
	}
}