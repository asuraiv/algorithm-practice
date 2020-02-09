package com.asuraiv.algorithm.search;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BinarySearch {

	private int search(int[] S, int x) {

		return binarySearch(S, 0, S.length - 1, x);
	}

	private int binarySearch(int[] S, int low, int high, int x) {

		int middle = (low + high) / 2;

		int candidate = S[middle];

		if(candidate == x) {
			return middle;
		}

		if(candidate < x) {
			low = middle + 1;
		} else {
			high = middle - 1;
		}

		return binarySearch(S, low, high, x);
	}

	private int searchUsingForEach(int[] S, int x) {

		int low = 1;
		int high = S.length;
		int middle = -1;

		while(low <= high) {

			middle = (low + high) / 2;

			if(x == S[middle]) {
				break;
			} else if(x < S[middle]) {
				high = middle - 1;
			} else {
				low = middle + 1;
			}
		}

		return middle;
	}

	@Test
	public void testBinarySearch() {

		int[] S = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

		int index = search(S, 8);

		assertThat(index, is(7));
	}

	@Test
	public void testBinarySearchUsingForEach() {

		int[] S = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

		int index = searchUsingForEach(S, 8);

		assertThat(index, is(7));
	}
}
