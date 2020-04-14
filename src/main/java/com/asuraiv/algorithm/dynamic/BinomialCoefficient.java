package com.asuraiv.algorithm.dynamic;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/*
	이항계수 문제
 */
public class BinomialCoefficient {

	public int bin(int n, int k) {

		int[][] B = new int[n + 1][k + 1];

		for (int i = 0; i <= n; i++) {

			for (int j = 0; j <= Math.min(i, k); j++) {

				if(i == 0 || j == 0) {
					B[i][j] = 1;
					continue;
				}

				B[i][j] = B[i - 1][j - 1] + B[i - 1][j];
			}
		}

		return B[n][k];
	}

	@Test
	public void test() {

		assertThat(bin(4, 2), is(6));
	}
}
