package com.asuraiv.algorithm.programmers;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/*
	Level 2 쇠막대기
 */
public class IronBars {

	public int solution(String arrangement) {

		int answer = 0;

		Stack<Character> stack = new Stack<>();

		int barCnt = 0;
		char prev = ' ';

		for (int i = 0; i < arrangement.length(); i++) {
			char c = arrangement.charAt(i);
			switch (c) {
				case ')':
					barCnt--;
					if (prev == '(') {
						answer += barCnt;
						break;
					}
					answer++;
					break;
				default:
					stack.push(c);
					barCnt++;

			}
			prev = c;
		}

		return answer;
	}

	@Test
	public void test() {

		assertThat(solution("()(((()())(())()))(())"), is(17));
	}
}
