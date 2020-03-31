package com.asuraiv.algorithm.topcoder.basic;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/*
	SRM480, Div 2, Level 1
 */
public class Cryptography {

	public long encrypt(int[] numbers) {

		long max = 0L;

		for(int i = 0; i < numbers.length; i++) {

			int curr = numbers[i] + 1;

			for(int j = 0; j < numbers.length; j++) {

				if(i != j) {
					curr *= numbers[j];
				}
			}

			max = Math.max(max, curr);
		}

		return max;
	}

	@Test
	public void test() {

		int[] numbers = {1, 3, 2, 1, 1, 3};

		assertThat(encrypt(numbers), is(36L));
	}
}
