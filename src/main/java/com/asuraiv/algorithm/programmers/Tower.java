package com.asuraiv.algorithm.programmers;

import com.asuraiv.algorithm.common.AssertUtils;
import org.junit.Test;

import java.util.*;

public class Tower {

	int[] solution(int[] heights) {

		int[] results = new int[heights.length]; // initialize all zero

		LinkedList<Integer> stack = new LinkedList<>();

		for (int i = 0; i < heights.length; i++) {

			int curr = heights[i];

			if (stack.isEmpty()) {
				stack.offer(curr);
				continue;
			}

			for (int j = stack.size() - 1; j > -1; j--) {
				Integer height = stack.get(j);
				if (height > curr) {
					results[i] = j + 1;
					break;
				}
			}

			stack.offer(curr);
		}

		return results;
	}

	@Test
	public void testCase1() {

		AssertUtils.assertArrayEqualWithOrder(solution(new int[] { 6, 9, 5, 7, 4 }), new int[] { 0, 0, 2, 2, 4 });
	}

	@Test
	public void testCase2() {

		AssertUtils.assertArrayEqualWithOrder(solution(new int[] { 3, 9, 9, 3, 5, 7, 2 }), new int[] { 0, 0, 0, 3, 3, 3, 6 });
	}
}
