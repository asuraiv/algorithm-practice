package com.asuraiv.algorithm.greedy;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ZeroOneKnapsack {

	int solution(int[] weights, int[] values, int limit) {

		int length = weights.length;

		double[] valuesPerWeights = new double[length];

		for (int i = 0; i < length; i++) {
			valuesPerWeights[i] = values[i] / weights[i];
		}

		int answer = 0;
		int totalWeight = 0;

		while (true) {

			int maxIdx = findMax(valuesPerWeights);

			if(limit < (totalWeight + weights[maxIdx])) {
				break;
			}

			answer += values[maxIdx];
			totalWeight += weights[maxIdx];

			valuesPerWeights[maxIdx] = -1.0;
		}

		return answer;
	}

	private int findMax(double[] valuesPerWeights) {

		double max = 0.0;
		int maxIdx = 0;

		for (int i = 0; i < valuesPerWeights.length; i++) {

			double curr = valuesPerWeights[i];
			if (max < curr) {
				max = curr;
				maxIdx = i;
			}
		}

		return maxIdx;
	}

	@Test
	public void test() {
		assertThat(solution(new int[] { 5, 10, 20 }, new int[] { 50, 60, 140 }, 30), is(190));
	}
}
