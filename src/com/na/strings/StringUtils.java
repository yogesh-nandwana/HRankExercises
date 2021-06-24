package com.na.strings;

import java.util.*;
import java.util.stream.Collectors;

public final class StringUtils {
	private StringUtils() {
		new AssertionError("No com.na.strings.StringUtils instances for you!");
	}
	
	public static Set<String> substrings(final String str,final Set<String> substrList){
		
		assert Objects.nonNull(str):"Input string is null!";
		System.out.println("finding substrings for:"+str);
		for(int beginIndex=0;beginIndex<str.length()-1;beginIndex++) {
			List<String> substrs = new ArrayList<String>();
			for(int endIndex=str.length()-1;endIndex>beginIndex;endIndex--) {
				String substring = str.substring(beginIndex,endIndex);
				substrs.add(substring);
			}
			System.out.println("char:"+str.charAt(beginIndex)+",index:"+beginIndex+":"+substrs);
			substrList.addAll(substrs);
		}
		System.out.println("final substrings:"+substrList);
		return substrList; 
	}

	public static List<String> substringsWithMinLength(final String str,final int minLen){
		Set<String> substrings = substrings(str, new TreeSet<String>());
		return substrings.stream().filter(st->st.length()>=minLen).collect(Collectors.toList());
	}

	public static List<String> substringsWithFixedLength(final String str,final int fixedLen){
		Set<String> substrings = substrings(str, new TreeSet<String>());
		return substrings.stream().filter(st->st.length()==fixedLen).collect(Collectors.toList());
	}

	public static boolean isPalindrom(final String str) {
		assert Objects.nonNull(str):"Input string is null!";
		assert str.trim().length()>0:"Input string is empty!";
		boolean palindrom = true;
		char[] charArray = str.toCharArray();
		int beginIndex=0,endIndex = charArray.length-1;
		while(beginIndex<endIndex) {
			if(charArray[beginIndex]==charArray[endIndex]) {
				beginIndex++;
				endIndex--;
			}else {
				palindrom = false;
				break;
			}
		}
		return palindrom;
	}
}