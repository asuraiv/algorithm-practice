package com.asuraiv.algorithm.fibonacci;

import org.junit.Test;
import org.junit.runner.JUnitCore;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RecursiveFibonacci {

	int fib(int n) {

		if (n <= 1) {
			return n;
		}

		return fib(n - 1) + fib(n - 2);
	}

	int fib(int n, int a, int b) {

		if (n == 0) {
			return a;
		}

		if (n == 1) {
			return b;
		}

		return fib(n - 1, b, a + b);
	}

	@Test
	public void testFib() {

		int n = fib(6, 0, 1);

		assertThat(n, is(8));
	}

	public static void main(String[] args) {

		JUnitCore.main("RecursiveFibonacci");
	}
}
