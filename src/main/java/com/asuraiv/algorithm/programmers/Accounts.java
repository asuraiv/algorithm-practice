package com.asuraiv.algorithm.greedy;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Accounts {

	int solution(int n, int[] accounts) {

		int count = 0;
		int total = 0;

		boolean flag = true;

		while(!isEmpty(accounts)) {

			int curr;

			if(flag) {
				curr = findMax(accounts);
				flag = false;
			} else {
				curr = findMin(accounts);
				flag = true;
			}

			int increment = total + curr;

			if(increment > n || increment == n) {
				count++;
				total = 0;
				continue;
			}

			total += curr;
		}

		return count + 1;
	}

	private boolean isEmpty(int[] accounts) {

		for (int account : accounts) {
			if (account != -1) {
				return false;
			}
		}

		return true;
	}

	private int findMax(int[] accounts) {

		int max = 0;
		int maxIdx = 0;

		for (int i = 0; i < accounts.length; i++) {

			int curr = accounts[i];

			if(curr != -1 && max < curr) {
				max = curr;
				maxIdx = i;
			}
		}

		accounts[maxIdx] = -1;

		return max;
	}

	private int findMin(int[] accounts) {

		int min = Integer.MAX_VALUE;
		int minIdx = 0;

		for (int i = 0; i < accounts.length; i++) {

			int curr = accounts[i];

			if(curr != -1 && min > curr) {
				min = curr;
				minIdx = i;
			}
		}

		accounts[minIdx] = -1;

		return min;
	}

	@Test
	public void test() {

		assertThat(solution(1000, new int[]{800, 400, 200, 500, 300, 700}), is(3));
	}
}
