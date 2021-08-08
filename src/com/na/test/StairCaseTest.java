package com.na.test;

public class StairCaseTest {
	public static void main(String[] args) {
		printStairCase(6);
	}
	
	public static void printStairCase(int n){
		for(int i=0;i<n;i++) {
			for(int j=0;j<=n;j++) {
				if(i+j>=n) {
					System.out.print("#");
				}else if(j>0) {
					System.out.print("%");
				}
			}
			System.out.println();
		}
	}
}