package com.na.sorting;

import java.util.Arrays;

public class MinSwaps {
	public static void main(String[] args) {
		//int[] ar = {7,1,3,2,4,5,6};
		//int[] ar = {4, 3, 1, 2};
		//int[] ar = {2, 3, 4, 1, 5};
		int[] ar = {1, 3, 5, 2, 4, 6, 7};
		int start = 0;
		int swapCount = 0;
		
		while(start<ar.length-1) {
			int minNumIndex = findMinNumIndex(start,ar);
			if(start!=minNumIndex) {
				swap(start,minNumIndex,ar);
				swapCount++;
			}			
			start++;
			//after swap we know lowest no is at left most position
		}
		//System.out.println(Arrays.toString(ar));
		//System.out.println(swapCount);
	}

	private static void swap(int i, int minNumIndex, int[] ar) {
		int t = ar[minNumIndex];
		ar[minNumIndex] = ar[i];
		ar[i] = t;
		//System.out.printf(" swap(%d,%d)\t arr:%s\n",i,minNumIndex,Arrays.toString(ar));
	}

	private static int findMinNumIndex(int start, int[] ar) {
		int idx = start;
		int temp = ar[start];
		for(int k=start;k<ar.length;k++) {
			if(ar[k]<temp) {
				idx=k;
				temp = ar[k];
			}
		}
		//System.out.printf("min idx:%d" ,idx);
		return idx;
	}
}