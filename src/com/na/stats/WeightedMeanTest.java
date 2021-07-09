package com.na.stats;

import java.util.Arrays;
import java.util.List;

public class WeightedMeanTest {
	public static void main(String[] args) {
		weightedMean(Arrays.asList(1,2,3), Arrays.asList(4,5,6));
	}

	public static void weightedMean(List<Integer> nr, List<Integer> dr) {
		long totalDr = dr.stream().reduce(0, (a, b) -> a + b).longValue();
		
		long nrSum = 0;
		for(int i=0;i<nr.size();i++) {
			nrSum = nrSum + nr.get(i) * dr.get(i);
		}
		System.out.printf("%.1f", nrSum * 1.0f/totalDr);
	}
}