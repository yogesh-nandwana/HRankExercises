package com.na.stats;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class StatsUtil {

	public static List<Integer> quartiles(List<Integer> list) {
		List<Integer> quartiles = new ArrayList<Integer>();

		list.sort(null); // 1,2,3,5,6,7
		
		//System.out.println(list);

		int[] array2 = list.stream().mapToInt(x -> x).toArray();
		int median = (int) median(array2);
		
		List<Integer> secList = null,firstList = null;
		
		int firstQtr = 0,secQtr=0,startIndex=0;
		if (list.size() % 2 == 0) {
			
			firstList = list.subList(0, (list.size()/2));
			//System.out.println(firstList);
			firstQtr = (int) median(firstList.stream().mapToInt(x ->x).toArray());
			
			secList = list.subList((list.size()/2), list.size());
			//System.out.println(secList);
			secQtr = (int) median(secList.stream().mapToInt(x ->x).toArray());
		} else { // odd no. of nums in list // 1,2,3,4,5,6,7
			startIndex = (int) Math.ceil((list.size()/2));
			
			firstList = list.subList(0,startIndex);
			//System.out.println(firstList);
			firstQtr = (int) median(firstList.stream().mapToInt(x ->x).toArray());
			
			
			secList= list.subList(startIndex+1, (list.size()));
			//System.out.println(secList);
			secQtr = (int) median(secList.stream().mapToInt(x ->x).toArray());
		}
		
		quartiles.add(firstQtr);
		quartiles.add(median);
		quartiles.add(secQtr);
		
		return quartiles;
	}

	public static float median(int[] nums) {
		float median = -1;

		Arrays.sort(nums);

		int len = nums.length;
		int midIndex = len / 2;

		if (len % 2 == 0) {
			median = (nums[midIndex] + nums[midIndex - 1]) / 2f;
		} else {
			median = nums[midIndex];
		}

		return median;
	}

	public static int mode(int[] nums) {
		Map<Integer, Integer> map = new TreeMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.get(nums[i]) == null) {
				map.put(nums[i], 1);
			} else {
				map.put(nums[i], map.get(nums[i]) + 1);
			}
		}

		int maxVal = map.values().stream().mapToInt(v -> v).max().orElse(0);
		List<Integer> list = map.entrySet().stream().filter(e -> e.getValue() == maxVal).map(e -> e.getKey())
				.collect(Collectors.toList());
		list.sort(null);
		return list.get(0);
	}
	
	public static OptionalDouble mean(int[] nums) {
		return Arrays.stream(nums).average();
	}
	
	public static void weightedMean(List<Integer> nr, List<Integer> dr) {
		long totalDr = dr.stream().reduce(0, (a, b) -> a + b).longValue();
		
		long nrSum = 0;
		for(int i=0;i<nr.size();i++) {
			nrSum = nrSum + nr.get(i) * dr.get(i);
		}
		System.out.printf("%.1f", nrSum * 1.0f/totalDr);
	}

	public static int[] readIntsFromScreen() {
		Scanner scr = new Scanner(System.in);
		int count = scr.nextInt();
		int[] arr = new int[count];
		for (int i = 0; i < count; i++) {
			arr[i] = scr.nextInt();
		}
		scr.close();
		return arr;
	}
}