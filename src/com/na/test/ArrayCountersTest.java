package com.na.test;

import java.util.Arrays;
import java.util.List;

public class ArrayCountersTest {
	public static void main(String[] args) {
		List<Long> list = Arrays.asList(2l,1l,3l);
		List<Long> list1 = arrayChallenge(list);
		System.out.println(list1);
	}
		
	public static List<Long> arrayChallenge(List<Long> arr) {
        Long[] cntArray = new Long[arr.size()];
        for(int i=0; i<arr.size();i++){
            long cnt = 0;
            if(i>0){
                int j = i;
                while(j>=0){
                    long diff = arr.get(i) - arr.get(j);
                    if(diff>0){
                        cnt = cnt + Math.abs(diff);
                    }else if(diff<0){
                        cnt = cnt - Math.abs(diff);
                    }
                    j--;                    
                }
                cntArray[i] = cnt;
            }else{ //first element
                cntArray[0] = 0l;
            }            
        }
        return Arrays.asList(cntArray);
    }
}