package com.na.sorting;

import java.util.Arrays;

public class BubbleSortTest {

	public static void main(String[] args) {
		int[] ar = new int[] {11,2,4,1,0,-1};
		int i = 0;
		int  j = ar.length-1;
		int k = 0;
		while(k<j) {
			while(i<j) {
				if(ar[i] > ar[i+1]) {
					swap(i,i+1,ar);
				}
				i = i+1;			
			}
			System.out.println(Arrays.toString(ar));
			k = 0;
			i = 0;
			j = j-1;
		}
	
	}

	private static void swap(int i, int j, int[] ar) {
		int t = ar[i];
		ar[i] = ar[i+1];
		ar[i+1] = t;		
	}
}