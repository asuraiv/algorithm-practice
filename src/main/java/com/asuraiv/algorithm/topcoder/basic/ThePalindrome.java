package com.asuraiv.algorithm.topcoder.basic;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/*
	SRM428, Div 2, Level 1
 */
public class ThePalindrome {

	int find(String s) {

		int leftFoldedLength = getLengthOfPalindrome(s, true);
		int rightFoldedLength = getLengthOfPalindrome(s, false);

		return Math.min(leftFoldedLength, rightFoldedLength);
	}

	private int getLengthOfPalindrome(String s, boolean leftFold) {

		int length = s.length();

		int left = 0;
		int right = length - 1;

		int added = 0;

		while(left != right && left < right) {

			char leftChar = s.charAt(left);
			char rightChar = s.charAt(right);

			if(leftChar != rightChar) {
				if(leftFold) {
					left++;
				} else {
					right--;
				}
				added++;
				continue;
			}

			left++;
			right--;
		}

		if(added == 0) {
			return length;
		}

		return length + added;
	}

	@Test
	public void testCase1() {

		assertThat(find("abab"), is(5));
	}

	@Test
	public void testCase2() {

		assertThat(find("abacaba"), is(7));
	}

	@Test
	public void testCase3() {

		assertThat(find("abba"), is(4));
	}

	@Test
	public void testCase5() {

		assertThat(find("abdfhdyrbdbsdfghjkllkjhgfds"), is(38));
	}

	@Test
	public void testCase6() {

		assertThat(find("ccccab"), is(8));
	}
}
