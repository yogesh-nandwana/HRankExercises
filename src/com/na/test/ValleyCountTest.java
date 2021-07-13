package com.na.test;

public class ValleyCountTest {
	public static void main(String[] args) {
		String path = "UDDDUDUU";
		//String path = "DDUUDDUDUUUD";
		int valleys = countingValleys(path.length(),path);
		System.out.println(valleys);
	}
	
	public static int countingValleys(int steps, String path) {
		int valleyCount = 0,currentLevel = 0;
		char[] chars = path.toCharArray();
		for(char c:chars) {
			if(c == 'D') {
				--currentLevel; 
			}else if(c == 'U') {
				++currentLevel; 
			}
			
			if(currentLevel == 0 && c=='U') {
					valleyCount++;
			}
		}	
		return valleyCount;
	}
}