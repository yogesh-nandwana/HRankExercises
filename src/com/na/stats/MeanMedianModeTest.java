package com.na.stats;

import java.util.*;
import java.util.stream.Collectors;

public class MeanMedianModeTest {
	public static void main(String[] args) {
		int[] nums = readIntsFromScreen();
		//int[] nums = new int[] {64630,11735, 14216, 99233, 14470, 4978, 73429, 38120, 51135, 67060};
		
		 OptionalDouble avg = mean(nums);
		 System.out.println(avg.orElse(0.00));
		
		float median = median(nums);
		System.out.println(median);
		
		int mode = mode(nums);
		System.out.println(mode);
	}
	
	private static int mode(int[] nums) {
		Map<Integer,Integer> map = new TreeMap<>();
		for(int i=0;i<nums.length;i++) {
			if(map.get(nums[i])==null) {
				map.put(nums[i], 1);
			}else {
				map.put(nums[i],map.get(nums[i])+1);
			}
		}
		
		int maxVal = map.values().stream().mapToInt(v -> v).max().orElse(0);
		List<Integer> list = map.entrySet().stream().filter(e -> e.getValue() == maxVal).map(e -> e.getKey()).collect(Collectors.toList());
		list.sort(null);
		return list.get(0);		
	}
	
	private static float median(int[] nums) {
		float median = -1;
		
		Arrays.sort(nums);

		int len = nums.length;
		int midIndex = len/2;

		if(len%2==0) {
			median = (nums[midIndex]+nums[midIndex-1])/2f;
		}else {
			median = nums[midIndex];
		}
		
		return median;
	}
	
	private static OptionalDouble mean(int[] nums) {
		return Arrays.stream(nums).average();
	}

	public static int[] readIntsFromScreen(){
		Scanner scr = new Scanner(System.in);
		int count =  scr.nextInt();
		int[] arr = new int[count];
		for(int i=0;i<count;i++) {
			arr[i]=scr.nextInt();
		}
		scr.close();
		return arr;
	}
}