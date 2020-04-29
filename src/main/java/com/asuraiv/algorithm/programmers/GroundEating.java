package com.asuraiv.algorithm.programmers;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GroundEating {

	int solution(int[][] land) {

		int r = land.length;
		int[][] dp = new int[r][4];

		for (int i = 0; i < 4; ++i) {
			dp[0][i] = land[0][i];
		}

		for (int i = 1; i < r; ++i) {

			for (int j = 0; j < 4; ++j) {

				for (int k = 0; k < 4; ++k) {

					if (j != k) {
						dp[i][j] = Math.max(dp[i][j], land[i][j] + dp[i - 1][k]);
					}
				}
			}
		}

		int ans = 0;

		for (int i = 0; i < 4; ++i) {
			ans = Math.max(ans, dp[r - 1][i]);
		}

		return ans;
	}

	@Test
	public void testCase1() {
		assertThat(solution(new int[][] { { 1, 2, 3, 5 }, { 5, 6, 7, 8 }, { 4, 3, 2, 1 } }), is(16));
	}
}
