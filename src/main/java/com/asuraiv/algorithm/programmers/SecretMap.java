package com.asuraiv.algorithm.programmers;

import org.junit.Test;

import java.util.*;

import static com.asuraiv.algorithm.common.AssertUtils.*;

public class SecretMap {

	public String[] solution(int n, int[] arr1, int[] arr2) {

		String format = "%0" + n + "d";

		String[] answer = new String[n];

		for(int i = 0; i < n; i++) {

			String row = "";

			String binStr1 = String.format(format, Integer.parseInt(Integer.toBinaryString(arr1[i])));
			String binStr2 = String.format(format, Integer.parseInt(Integer.toBinaryString(arr2[i])));

			for(int j = 0; j < binStr1.length(); j++) {

				int bin1 = (int)(binStr1.charAt(j) - 48);
				int bin2 = (int)(binStr2.charAt(j) - 48);

				if((bin1 | bin2) == 1) {
					row += "#";
				} else {
					row += " ";
				}
			}

			answer[i] = row;
		}

		return answer;
	}

	@Test
	public void test() {
		String[] result = solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28});
		System.out.println(result);
	}
}
