package com.asuraiv.algorithm.programmers;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.asuraiv.algorithm.common.AssertUtils.*;

import org.junit.Test;

public class FailRates {

	public int[] solution(int N, int[] stages) {

		int players = stages.length;

		double[] failRates = new double[N + 1];

		failRates[0] = -1.0;

		for (int i = 1; i < N + 1 && players > 0; i++) {

			int failCount = 0;

			for (int j = 0; j < stages.length; j++) {

				int stage = stages[j];

				if (stage != -1 && stage == i) {
					failCount++;
					stages[j] = -1;
				}
			}

			failRates[i] = ((double) failCount / (double) players);

			players -= failCount;
		}

		Comparator<Integer> comparing = Comparator.comparing(stage -> failRates[stage]);
		Comparator<Integer> resultComparing = comparing.reversed().thenComparing(Comparator.naturalOrder());

		List<Integer> list = IntStream.rangeClosed(1, N)
			.boxed()
			.sorted(resultComparing)
			.collect(Collectors.toList());

		return list.stream().mapToInt(i -> i).toArray();
	}

	@Test
	public void test() {

		assertArrayEqualWithOrder(solution(5, new int[] { 2, 1, 2, 6, 2, 4, 3, 3 }), new int[] { 3, 4, 2, 1, 5 });
	}
}
