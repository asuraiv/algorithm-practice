package com.asuraiv.algorithm.programmers;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StringCompression {

	public int solution(String s) {

		int answer = s.length();

		for (int i = 1; i <= s.length(); i++) {

			String curr = "";
			String prev = "";

			int count = 0;

			int size = i;
			int endIdx = 0;

			for (int j = 0; size <= s.length(); j += i, size = j + i) {

				String cutted = s.substring(j, size);

				if ("".equals(prev)) {
					prev = cutted;
					count++;
					endIdx = size;
					continue;
				}

				if (prev.equals(cutted)) {
					count++;
					endIdx = size;
					continue;
				}

				if (count < 2) {
					curr += prev;
				} else {
					curr += (count + prev);
				}

				prev = cutted;
				count = 1;
				endIdx = j;
			}

			if (count < 2) {
				if ("".equals(curr)) {
					curr = s;
				} else {
					curr += prev;
					endIdx += prev.length();
					curr += s.substring(Math.min(endIdx, s.length()));
				}
			} else {
				curr += (count + prev);
				curr += s.substring(Math.min(endIdx, s.length()));
			}

			if (answer > curr.length()) {
				answer = curr.length();
			}
		}

		return answer;
	}

	@Test
	public void testCase1() {
		assertThat(solution("ababcdcdababcdcd"), is(9));
	}

	@Test
	public void testCase2() {
		assertThat(solution("abcabcabcabcdededededede"), is(14));
	}

	@Test
	public void testCase3() {
		assertThat(solution("aabbaccc"), is(7));
	}

	@Test
	public void testCase4() {
		assertThat(solution("abcabcdede"), is(8));
	}

	@Test
	public void testCase5() {
		assertThat(solution("xababcdcdababcdcd"), is(17));
	}
}
