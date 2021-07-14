package com.na.stats;

import static com.na.stats.StatsUtil.*;
import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		System.out.println(quartiles(Arrays.asList(3, 7, 8, 5, 12, 14, 21, 13, 18)));

//		int[] nums = StatsUtil.readIntsFromScreen();
//		// int[] nums = new int[] {64630,11735, 14216, 99233, 14470, 4978, 73429, 38120, 51135, 67060};
//
//		OptionalDouble avg = mean(nums);
//		System.out.println(avg.orElse(0.00));
//
//		float median = median(nums);
//		System.out.println(median);
//
//		int mode = StatsUtil.mode(nums);
//		System.out.println(mode);
//
//		weightedMean(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6));
	}
}