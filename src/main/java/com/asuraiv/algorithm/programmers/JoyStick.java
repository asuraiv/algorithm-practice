package com.asuraiv.algorithm.programmers;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


/*
	Level 2 조이스틱
 */
public class JoyStick {

	int solution(String name) {

		int[] visited = new int[name.length()];

		for (int i = 0; i < name.length(); i++) {
			char c = name.charAt(i);
			visited[i] = c == 'A' ? -1 : 0;
		}

		int answer = 0;

		int currIdx = 0;

		while(true) {

			answer += moveCount(name.charAt(currIdx));

			visited[currIdx] = 1;

			if(allVisited(visited)) {
				break;
			}

			int rightIdx;
			int rightCount = 0;

			for (int i = currIdx + 1; ; i++) {

				rightCount++;

				if(i >= name.length()) {
					i = 0;
				}

				if(visited[i] == 0) {
					rightIdx = i;
					break;
				}
			}

			int leftIdx;
			int leftCount = 0;

			for (int i = currIdx - 1; ; i--) {

				leftCount++;

				if(i < 0) {
					i = name.length() - 1;
				}

				if(visited[i] == 0) {
					leftIdx = i;
					break;
				}
			}

			currIdx = rightCount <= leftCount ? rightIdx : leftIdx;

			answer += Math.min(rightCount, leftCount);

		}

		return answer;
	}

	private boolean allVisited(int[] visited) {

		for (int val : visited) {
			if(val == 0) {
				return false;
			}
		}

		return true;
	}

	private int moveCount(char curr) {

		if(curr > 'M') {
			return (91 - curr);
		}

		return (curr - 'A');
	}

	@Test
	public void testCase1() {

		assertThat(solution("JAZ"), is(11));
	}

	@Test
	public void testCase2() {

		assertThat(solution("BABB"), is(5));
	}

	@Test
	public void testCase3() {

		assertThat(solution("JEROEN"), is(56));
	}

	@Test
	public void testCase4() {

		assertThat(solution("JAN"), is(23));
	}

	@Test
	public void testCase5() {

		assertThat(solution("BBBAAB"), is(9));
	}
}
