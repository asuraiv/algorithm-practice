package com.asuraiv.algorithm.sort;

import org.junit.Test;
import static com.asuraiv.algorithm.common.AssertUtils.*;

public class BubbleSort {

	private int[] sort(int[] S) {

		int n = S.length;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - 1; j++) {
				if(S[j] > S[j + 1]) {
					// swap
					int temp = S[j];
					S[j] = S[j + 1];
					S[j + 1] = temp;
				}
			}
		}

		return S;
	}

	@Test
	public void testBubbleSort() {

		int[] S = {2, 1, 3, 4, 6, 7, 5, 9, 10, 8};

		int[] actual = sort(S);

		int[] expected = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		assertArrayEqualWithOrder(expected, actual);
	}
}
