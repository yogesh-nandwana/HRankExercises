package com.na.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JumpingCloudsTest {
	public static void main(String[] args) {
		List<Integer> aList = Arrays.asList(0, 1, 0, 0, 0, 1, 0);
		
		List<Integer> indexesToJump = findIndexesToJump(aList);
		System.out.println(indexesToJump);
		
		int minJumps = findPossibleJumps(indexesToJump);
		System.out.println(minJumps);
	}

	private static int findPossibleJumps(List<Integer> indexList) {
		int jumpCount = 0;
		//[0, 2, 3, 4, 6]
		int startPos = 0;
		int endPos = indexList.size()-1;
		
		while(startPos<endPos) {
			int currentElement = indexList.get(startPos);
			
			if(indexList.contains(currentElement+2)) {
				jumpCount++;
				startPos = indexList.indexOf(currentElement+2);
			}else if(indexList.contains(currentElement+1)) {
				jumpCount++;
				startPos = indexList.indexOf(currentElement+1);
			}
		}
		return jumpCount;
	}

	private static List<Integer> findIndexesToJump(List<Integer> aList) {
		List<Integer> indexList = new ArrayList<Integer>();
		for(int i=0;i<aList.size();i++) {
			if(aList.get(i) == 0) {
				indexList.add(i);
			}
		}
		return indexList;
	}
}