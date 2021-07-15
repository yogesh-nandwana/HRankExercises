package com.na.test;

import java.util.Arrays;
//Sample input list: 110011000011; 
//question: re-arrange the elements of the list so that all 1's and 0's are together (using min. number of operations) ; 
//Sample output: 111111000000
public class BinaryArrayArrangement {
	public static void main(String[] args) {
		char[] str = "110011000011".toCharArray();
		int i = 0, j = str.length-1;
		while(i<j) {
			if(str[i] == '0') {
				char t = str[i];
				str[i] = str[j];
				str[j] = t;
				j--;
			}else {
				i++;
			}
		}
		System.out.println(Arrays.toString(str));
	}
}