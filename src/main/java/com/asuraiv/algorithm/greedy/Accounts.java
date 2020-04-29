package com.asuraiv.algorithm.greedy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Accounts {

	int solution(int limit, int[] bankbook) {

		List<Integer> list = new ArrayList<>();

		for (int val : bankbook) {
			list.add(val);
		}

		list.sort(Comparator.reverseOrder());

		int[] sorted = list.stream().mapToInt(v -> v).toArray();

		for (int i = 0; i < sorted.length; i++) {

			int val = sorted[i];

			if(val == -1) {
				continue;
			}

			int curr = val;

			for (int j = i + 1; j < sorted.length; j++) {

				int added = sorted[j];

				if(added == -1) {
					continue;
				}

				if(curr + added > limit) {
					continue;
				}

				curr += added;
				sorted[j] = -1;
			}
		}

		int answer = 0;

		for (int val : sorted) {
			if(val > 0) {
				answer++;
			}
		}

		return answer;
	}

	@Test
	public void test() {

		assertThat(solution(1000, new int[]{800, 400, 200, 500, 300, 700}), is(3));
	}

	@Test
	public void testCase2() {

		assertThat(solution(10, new int[]{1,2,3,3,3,8}), is(2));
	}

	@Test
	public void testCase3() {

		assertThat(solution(1, new int[]{0, 0, 0, 0, 0}), is(1));
	}
}
