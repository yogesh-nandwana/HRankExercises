//input format: 
//1(no of test cases)
//8(no of elements in queue)
// 1 2 5 3 7 8 6 4
//------------------------	
//	1 2 3 5 4 6 7 8
//	1 2 5 3 4 6 7 8
//	1 2 5 3 4 7 6 8
//	1 2 5 3 7 4 6 8
//	1 2 5 3 7 4 8 6
//	1 2 5 3 7 8 4 6
//	1 2 5 3 7 8 6 4

package com.na.test;

import java.io.*;
import java.util.*;

class Test {
	public static void minimumBribes(List<Integer> list) {
		Integer[] q = new Integer[list.size()];
		q =  list.toArray(q);
		String str = minimumBribes(q,2);
		System.out.println(str);
	}
	private static String minimumBribes(Integer[] q,int perPersonAllowedBribes) {
		int cnt = 0;
		for(int i=0;i<q.length;i++) {
			int diff = q[i] - (i+1);
			if(diff>0) { // if Standee is either at right position or ahead 
				System.out.printf("Standee:%d has bribed %d times.\n",q[i],diff);
				if(diff > perPersonAllowedBribes) {
					return "Too chaotic";
				}
			}
			for(int j=0;j<i;j++) {
				if(q[j]>q[i]) {
					cnt++;
				}
			}
		}
		return String.valueOf(cnt);
	}
}

public class ChaoticQueueTest {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(bufferedReader.readLine().trim());

		for (int tItr = 0; tItr < t; tItr++) {
			int n = Integer.parseInt(bufferedReader.readLine().trim());
			String[] qTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
			List<Integer> q = new ArrayList<>();

			for (int i = 0; i < n; i++) {
				int qItem = Integer.parseInt(qTemp[i]);
				q.add(qItem);
			}
			Test.minimumBribes(q);
		}
		bufferedReader.close();
	}
}