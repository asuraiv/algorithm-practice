package com.asuraiv.algorithm.greedy;

import org.junit.Test;

import java.util.Comparator;
import java.util.LinkedList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Accounts {

	int solution(int limit, int[] bankbook) {

		LinkedList<Integer> list = new LinkedList<>();

		for (int val : bankbook) {
			list.add(val);
		}

		list.sort(Comparator.reverseOrder());

		int answer = bankbook.length;

		int[] sorted = list.stream().mapToInt(v -> v).toArray();

		for (int i = 0; i < sorted.length; i++) {

			int val = sorted[i];

			if(val == -1) {
				continue;
			}

			int curr = val;
			answer--;

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

		return answer;
	}

	@Test
	public void test() {

		assertThat(solution(1000, new int[]{800, 400, 200, 500, 300, 700}), is(3));
	}
}
