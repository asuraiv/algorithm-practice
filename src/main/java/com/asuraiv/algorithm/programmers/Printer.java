package com.asuraiv.algorithm.programmers;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import java.util.*;

public class Printer {

	public int solution(int[] priorities, int location) {

		int answer = 0;

		int length = priorities.length;

		LinkedList<Integer> queue = new LinkedList<>();

		for (int i = 0; i < length; i++) {
			queue.offer(i);
		}

		while (!queue.isEmpty()) {

			int i = queue.pollFirst();
			int priority = priorities[i];

			boolean shouldPushLast = false;

			for (int j = 0; j < queue.size(); j++) {

				if (priorities[queue.get(j)] > priority) {
					shouldPushLast = true;
					queue.offerLast(i);
					break;
				}
			}

			if (shouldPushLast) {
				continue;
			}

			answer++;

			if (i == location) {
				break;
			}
		}

		return answer;
	}

	@Test
	public void testCase1() {
		assertThat(solution(new int[] { 1, 1, 9, 1, 1, 1 }, 0), is(5));
	}

	@Test
	public void testCase2() {
		assertThat(solution(new int[] { 1, 2, 3 }, 0), is(3));
	}
}
