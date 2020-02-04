package com.asuraiv.algorithm.search;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class SequentialSearch {

	private int search(int[] S, int x) {

		int n = S.length;

		for (int i = 0; i < n; i++) {
			if(S[i] == x) {
				return i;
			}
		}

		return -1;
	}

	@Test
	public void testSequentialSearch() {

		int[] S = new int[]{2, 3, 4, 1, 5, 6, 8, 7, 10, 8, 9};

		int index = search(S, 8);

		assertThat(index, is(6));
	}
}
