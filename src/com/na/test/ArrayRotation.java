package com.na.test;
import java.io.*;
import java.util.*;

class Result {

	//5 2
	//1 2 3 4 5
	//3 4 5 1 2
    public static List<Integer> rotLeft(List<Integer> a, int d) {
     int size = a.size();
     List<Integer> l = new ArrayList<Integer>();
     for(int i=0;i<size;i++) {
    	 l.add(0);
     }
     for(int i=0;i<size;i++){
         int idx = (i-d);
         idx = idx<0?(idx+size):idx;
        l.set(idx,a.get(i));
     }
     return l;
    }
}

public class ArrayRotation {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int d = Integer.parseInt(firstMultipleInput[1]);

        String[] aTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> a = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aTemp[i]);
            a.add(aItem);
        }

        List<Integer> result = Result.rotLeft(a, d);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
