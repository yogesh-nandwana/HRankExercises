package com.na.test;

import java.util.Arrays;

public class PairMatchTest {
	public static void main(String[] args) {
		int[] ar = {1,2,1,2,1,3,2};
		//int[] ar = {10, 20, 20, 10, 10, 30, 50, 10, 20};
		Arrays.sort(ar);
		System.out.println(Arrays.toString(ar));      
		int i=0,j=1,count=0;
		while(i<ar.length && j<ar.length-1) {
			if(ar[i]==ar[j]) {
				System.out.printf("Pair matched at:(%d,%d)\n",i,j);
				count++;
				i=i+2;
				j=i+1;
			}else {
				i++;
				j++;
			}
		}
		System.out.println("count:"+count);
	}
}