package com.asuraiv.algorithm.topcoder.basic;

import org.junit.Test;

public class KiwiJuiceEasy {

	public int[] thePouring(int[] capacities, int[] bottles, int[] fromId, int[] toId) {

		for(int i = 0; i < fromId.length; i++) {

			int fromIdx = fromId[i];
			int toIdx = toId[i];

			int from = bottles[fromIdx];
			int to = bottles[toIdx];

			bottles[toIdx] = Math.min(capacities[toIdx], from + to);
			bottles[fromIdx] = Math.max(0, (from + to) - capacities[toIdx]);
		}

		return bottles;
	}

	@Test
	public void test() {

		int[] capacities = {14, 35, 86, 58, 25, 62};
		int[] bottles = {6, 34, 27, 38, 9, 60};
		int[] fromId = {1, 2, 4, 5, 3, 3, 1, 0};
		int[] toId = {0, 1, 2, 4, 2, 5, 3, 1};

		int[] results = thePouring(capacities, bottles, fromId, toId);

		for (int val : results) {

			System.out.print(val + " ");
		}
	}
}
