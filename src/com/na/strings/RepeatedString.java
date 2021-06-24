package com.na.strings;

import static org.junit.Assert.assertTrue;

//count letter a's occurances in a repeated(indefinitely) string of size n
// s = "abcac", n=10, return occurances = 4
public class RepeatedString {

	public static void main(String[] args) {
		long count = repeatedString("abcac",10);
		assertTrue("count:"+count,count==4);
		
		count = repeatedString("aba", 10);
		assertTrue("count:"+count,count==7);
		
		count = repeatedString("a", 1000000000000L);
		assertTrue("count:"+count,count==1000000000000L);
	}
	
	/*
     * Complete the 'repeatedString' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. LONG_INTEGER n
     */
    public static long repeatedString(String s, long n) {
    	if(s.length()==1) {
    		return n;
    	}
        while(s.length()<n){
            s = s.concat(s);  
        } //concat until result string is of size n
        if(s.length()>n){ // if resultant string size > n
            s = s.substring(0, (int)n); // extract desired string of size n    
        }        
        //now count a's occurances in s
        long count = 0;
        char[] charArray = s.toCharArray();
        for(int i=0;i<charArray.length;i++) {
        	if(charArray[i]=='a') {
        		count++;
        	}
        }
        return count;
    }
}