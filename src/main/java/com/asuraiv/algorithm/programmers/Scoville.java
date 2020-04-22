package com.asuraiv.algorithm.programmers;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class Scoville {

	public int solution(int[] scoville, int k) {

		PriorityQueue<Integer> minHeap = new PriorityQueue<>(scoville.length);

		for (int curr : scoville) {
			if (curr >= k) {
				continue;
			}
			minHeap.add(curr);
		}

		int answer = 0;

		while (existUnderK(minHeap, k)) {

			int first = minHeap.poll();
			int second = minHeap.poll();

			int newVal = first + (second * 2);

			minHeap.add(newVal);

			answer++;
		}

		return answer;
	}

	private boolean existUnderK(PriorityQueue<Integer> minHeap, int k) {
		return minHeap.stream()
			.anyMatch(scoville -> scoville < k);
	}

	@Test
	public void test() {

		assertThat(solution(new int[] { 1, 2, 3, 9, 10, 12 }, 7), is(2));
	}
}
