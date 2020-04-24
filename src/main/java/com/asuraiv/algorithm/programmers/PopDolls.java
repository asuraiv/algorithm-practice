package com.asuraiv.algorithm.programmers;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import java.util.Stack;

public class PopDolls {

	public int solution(int[][] board, int[] moves) {

		int answer = 0;

		Stack<Integer> stack = new Stack<>();

		int moveIdx = 0;

		while(moveIdx < moves.length) {

			int idx = moves[moveIdx] - 1;

			int poped = 0;

			for(int i = 0; i < board.length; i++) {

				int curr = board[i][idx];

				if(curr != 0) {
					poped = curr;
					board[i][idx] = 0;
					break;
				}
			}

			if(poped == 0) {
				moveIdx++;
				continue;
			}

			if(!stack.isEmpty()) {

				int peeked = stack.peek();

				if(!stack.isEmpty() && peeked == poped) {
					stack.pop();
					answer += 2;
					moveIdx++;
					continue;
				}
			}

			stack.push(poped);

			moveIdx++;
		}

		return answer;
	}

	@Test
	public void test() {

		assertThat(solution(new int[][] {
			{ 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 }, { 3, 5, 1, 3, 1 } },
			new int[] { 1, 5, 3, 5, 1, 2, 1, 4 }), is(4));
	}
}
