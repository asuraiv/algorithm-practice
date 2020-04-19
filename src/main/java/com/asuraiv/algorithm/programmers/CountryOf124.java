package com.asuraiv.algorithm.programmers;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CountryOf124 {

	public String solution(int n) {

		int[] digits = {1, 2, 4};

		String answer = "";

		int r = n;

		while(r > 3) {

			if(r % 3 == 0) {
				answer = 4 + answer;
				r = (r / 3) - 1;
				continue;
			}

			answer = digits[(r % 3) - 1] + answer;

			r = r / 3;
		}

		answer = digits[r - 1] + answer;

		return answer;
	}

	@Test
	public void test() {

		assertThat(solution(15), is("114"));
	}
}
