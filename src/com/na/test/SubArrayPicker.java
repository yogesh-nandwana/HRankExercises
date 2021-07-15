package com.na.test;

public class SubArrayPicker {

	public static void main(String[] args) {
		int[][] arr = {
				{-9, -9, -9, 1, 1, 1},
				{0, -9,  0,  4, 3, 2},
				{-9, -9 ,-9, 1, 2, 3},
				{0,  0,  8,  6, 6, 0},
				{0,  0,  0, -2, 0, 0},
				{0,  0,  1,  2, 4, 0}
		};

		int maxSum = 0;
		int rowCnt = arr.length;
		int colCnt = arr[0].length;
		int inputSize = 3, midRow = Math.round(inputSize/2);
		
		//System.out.println("rows:"+rowCnt+",cols:"+colCnt",midRow:"+midRow);
		int[][] subArray = null;
		int rowsToAccess = rowCnt/2, colsToAccess = colCnt/2;
		//System.out.println("rowsToAccess:"+rowsToAccess+",colsToAccess:"+colsToAccess);
		for(int i=0;i<=rowsToAccess;i++) {
			subArray = new int[inputSize][inputSize];
			for(int j=0;j<=colsToAccess;j++) {
				for(int r=0;r<inputSize;r++) {
					for(int c=0;c<inputSize;c++) {
						if(r == midRow) {
							if(r == c) {
								subArray[r][c] = arr[i+r][j+c];	
							}								
						}else {
							subArray[r][c] = arr[i+r][j+c];	
						}
					}
				}
				//print2DArray(subArray);
				int sum = sumIt(subArray);
				//System.out.println("sum:"+sum);
				maxSum = (sum > maxSum)?sum:maxSum;
			}			
		}
		System.out.println("maxSum:"+maxSum);
	}
	
	public static int sumIt(int[][] a) {
		int sum = 0;
		for (int i = 0; i <a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				sum = sum + a[i][j];
			}
		}
		return sum;
	}

	public static void print2DArray(int[][] a) {
		for (int i = 0; i <a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.println(a[i][j]);
			}
		}
		System.out.println("------------");
	}
}