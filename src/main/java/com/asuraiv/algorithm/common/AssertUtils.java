package com.asuraiv.algorithm.common;

public class AssertUtils {

	public static void assertArrayEqualWithOrder(int[] expected, int[] actual) {

		if(expected.length != actual.length) {
			throw new RuntimeException("actual size is not same with expected.");
		}

		for(int i = 0; i < expected.length; i++) {

			int expectedValue = expected[i];
			int actualValue = actual[i];

			if(expectedValue != actualValue) {
				throw new RuntimeException("Array is not same.\nexpected: "
					+ expected.toString() + "\nactual: " + actual.toString() + "\n");
			}
		}
	}
}
