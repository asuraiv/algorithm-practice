package com.asuraiv.algorithm.topcoder.basic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/*
	SRM150, Div 2, Level 2
 */
public class InterestingDigits {

	int[] digits(int base) {

		List<Integer> digits = new ArrayList<>();

		for(int i = 2; i < base; i++) {

			if((base - 1) % i == 0) {
				digits.add(i);
			}
		}

		int[] results = new int[digits.size()];

		for (int i = 0; i < digits.size(); i++) {
			results[i] = digits.get(i);
		}

		return results;
	}

	@Test
	public void test() {

		int base = 10;

		int[] results = digits(base);

		assertThat(results[0], is(3));
		assertThat(results[1], is(9));
	}
}
