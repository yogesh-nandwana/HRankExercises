package com.na.strings;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.*;

import org.junit.jupiter.api.Test;

class StringUtilsTest {
	@Test
	void testSubstrings() {
		Set<String> substrings = StringUtils.substrings("aabcdcb", new TreeSet<String>());
		assertThat(substrings, hasItems("a", "aa", "aab", "aabc", "aabcd", "aabcdc", "ab", "abc", "abcd", "abcdc", "b", "bc", "bcd", "bcdc","c", "cd", "cdc", "d","dc"));
	}

	@Test
	void testSubstringsWithMinLength() {
		List<String> substringsWithMinLength = StringUtils.substringsWithMinLength("aabcdcb", 3);
		assertThat(substringsWithMinLength,hasItems("aab","aabc","aabcd","aabcdc","abc","abcd","abcdc","abcdc","bcd","bcdc","cdc"));
	}

	@Test
	void testSubstringsWithFixedLength() {
		List<String> substringsWithMinLength = StringUtils.substringsWithFixedLength("aabcdcb", 3);
		assertThat(substringsWithMinLength,hasItems("aab","abc","bcd","cdc"));
	}

	@Test
	void testIsPalindromFailure() {
		assertThat(StringUtils.isPalindrom("aabcdcb"),is(false));
	}

	@Test
	void testIsPalindromSuccess() {
		assertThat(StringUtils.isPalindrom("bcdcb"),is(true));
	}
}