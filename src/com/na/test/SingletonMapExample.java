package com.na.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SingletonMapExample {

	public static void main(String[] args) {
		Map<String, String> singletonMap = Collections.singletonMap("key", "value");
		System.out.println(singletonMap);
		//singletonMap.put("k1", "v1"); //throws java.lang.UnsupportedOperationException, doesn't allow adding 
									  // after creation.
		
		 List<String> singletonList = Collections.singletonList("hi");
		System.out.println(singletonList);
		//singletonList.add("hello");//throws java.lang.UnsupportedOperationException, doesn't allow adding after creation
		
		Set<Object> singleton = Collections.singleton(new Object());
		System.out.println(singleton);
//		singleton.add(new Object());//throws java.lang.UnsupportedOperationException, doesn't allow adding after creation
	}

}
