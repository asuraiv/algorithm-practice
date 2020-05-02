package com.asuraiv.algorithm.programmers;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GymSuit {

	int solution(int n, int[] lost, int[] reserve) {

		int lostIdx = 0;
		int reserveIdx = 0;

		int[] all = new int[n + 1];

		for(int i = 1; i < all.length; i++) {

			all[i] = 1;

			if(lostIdx < lost.length && i == lost[lostIdx]) {
				all[i] -= 1;
				lostIdx++;
			}

			if(reserveIdx < reserve.length && i == reserve[reserveIdx]) {
				all[i] += 1;
				reserveIdx++;
			}
		}

		for(int i = 0; i < reserve.length; i++) {

			int curr = reserve[i];

			int prev = curr - 1;
			int next = curr + 1;

			if(all[curr] < 2) {
				continue;
			}

			if(prev > 0 && all[prev] == 0) {
				all[prev] = 1;
				continue;
			}

			if(next <= reserve.length && all[next] == 0) {
				all[next] = 1;
			}
		}

		int answer = 0;

		for(int haveCloth : all) {
			if(haveCloth > 0) {
				answer++;
			}
		}

		return answer;
	}

	@Test
	public void tesCase1() {

		assertThat(solution(5, new int[]{2, 4}, new int[]{1, 3, 5}), is(5));
	}

	@Test
	public void tesCase2() {

		assertThat(solution(7, new int[]{2,3,4}, new int[]{1,2,3,6}), is(6));
	}
}
