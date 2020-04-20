package com.asuraiv.algorithm.programmers;

import com.asuraiv.algorithm.common.AssertUtils;
import org.junit.Test;

import java.util.Arrays;

public class ExtractSequenceK {

	public int[] solution(int[] array, int[][] commands) {

		int[] answer = new int[commands.length];

		for (int i = 0; i < commands.length; i++) {

			int[] command = commands[i];

			for (int j = 0; j < command.length; j++) {

				int[] copied = Arrays.copyOfRange(array, command[0] - 1, command[1]);

				Arrays.sort(copied);

				answer[i] = copied[command[2] - 1];
			}
		}

		return answer;
	}

	@Test
	public void test() {

		AssertUtils.assertArrayEqualWithOrder(solution(new int[] { 1, 5, 2, 6, 3, 7, 4 }, new int[][] { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } }),
			new int[] { 5, 6, 3 });
	}
}
