package com.asuraiv.algorithm.programmers;

import com.asuraiv.algorithm.common.AssertUtils;
import org.junit.Test;

import java.util.*;

/*
	Level 1 모의고사
 */
public class MathTest {

	int[] solution(int[] answers) {

		int[][] persons = {
			{ 1, 2, 3, 4, 5 },
			{ 2, 1, 2, 3, 2, 4, 2, 5 },
			{ 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 }
		};

		int[] scores = new int[persons.length];

		for (int i = 0; i < persons.length; i++) {

			int[] curr = persons[i];

			for (int j = 0, personIdx = 0; j < answers.length; j++, personIdx++) {

				if (curr.length <= personIdx) {
					personIdx = 0;
				}

				if (curr[personIdx] == answers[j]) {
					scores[i] += 1;
				}
			}
		}

		List<Integer> top = new ArrayList<>();

		for (int i = 0; i < scores.length; i++) {

			int score = scores[i];

			if(top.isEmpty()) {
				top.add(i);
				continue;
			}

			if(scores[top.get(0)] < score) {
				top.clear();
				top.add(i);
				continue;
			}

			if(scores[top.get(0)] == score) {
				top.add(i);
			}
		}

		top.sort(Comparator.naturalOrder());

		int[] answer = new int[top.size()];

		for (int i = 0; i < top.size(); i++) {
			answer[i] = top.get(i) + 1;
		}

		return answer;
	}

	@Test
	public void testCase1() {
		AssertUtils.assertArrayEqualWithOrder(solution(new int[] { 1, 2, 3, 4, 5 }), new int[] { 1 });
	}

	@Test
	public void testCase2() {
		AssertUtils.assertArrayEqualWithOrder(solution(new int[] { 1, 3, 2, 4, 2 }), new int[] { 1, 2, 3 });
	}
}
