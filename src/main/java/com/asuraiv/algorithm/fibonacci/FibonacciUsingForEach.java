package com.asuraiv.algorithm.fibonacci;

import org.junit.Test;
import org.junit.runner.JUnitCore;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FibonacciUsingForEach {

	private int fib(int n) {

		int[] f = new int[n + 1];

		f[0] = 0;
		f[1] = 1;

		int i = 2;

		while(i <= n) {

			f[i] = f[i - 1] + f[i - 2];

			if(i == n) {
				return f[i];
			}

			i++;
		}

		return -1;
	}

	@Test
	public void testFib() {

		int n = fib(6);

		assertThat(n, is(8));
	}

	public static void main(String[] args) {
		JUnitCore.main("FibonacciUsingForEach");
	}
}
