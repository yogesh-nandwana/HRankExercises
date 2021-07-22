package com.na.test;

import java.util.Arrays;

public class PairMatchTest {
	public static void main(String[] args) {
		int[] ar = {1,2,1,2,1,3,2};
		Arrays.sort(ar);
		System.out.println(Arrays.toString(ar));      
		int i=0,j=1,count=0;
		while(i<ar.length && j<ar.length-1) {
			if(ar[i]==ar[j]) {
				System.out.printf("Pair matched at:(%d,%d)\n",i,j);
				count++;
				i=i+2;
				j=i+2;
			}else {
				i++;
			}
		}
		System.out.println("count:"+count);
	}
}