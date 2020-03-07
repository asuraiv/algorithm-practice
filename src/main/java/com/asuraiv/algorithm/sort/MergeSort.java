package com.asuraiv.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

import static com.asuraiv.algorithm.common.AssertUtils.assertArrayEqualWithOrder;

public class MergeSort {

	private void mergeSort(int n, int[] S) {

		if (n > 1) {

			int h = n / 2;
			int m = n - h;

			int[] U = Arrays.copyOfRange(S, 0, h);
			int[] V = Arrays.copyOfRange(S, m, n);

			mergeSort(h, U);
			mergeSort(m, V);

			merge(h, m, U, V, S);
		}
	}

	private void merge(int h, int m, int[] U, int[] V, int[] S) {

		int i = 0;
		int j = 0;
		int k = 0;

		while(i < h && j < m) {

			if(U[i] < V[j]) {
				S[k] = U[i];
				i++;
			} else {
				S[k] = V[j];
				j++;
			}
			k++;
		}

		if(i > h) {
			for(; k < (h + m) && j < m; k++, j++) {
				S[k] = V[j];
			}
		} else {
			for(; k < (h + m) && i < h; k++, i++) {
				S[k] = U[i];
			}
		}
	}

	@Test
	public void testMergeSort() {

		int[] S = {27, 10, 12, 20, 25, 13, 15, 22};

		mergeSort(S.length, S);

		int[] expected = {10, 12, 13, 15, 20, 22, 25, 27};

		assertArrayEqualWithOrder(expected, S);
	}
}
