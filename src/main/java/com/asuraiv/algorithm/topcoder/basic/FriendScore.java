package com.asuraiv.algorithm.topcoder.basic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/*
	SRM436, Div 2, Level 1
 */
public class FriendScore {

	public int highestScore(String[] friends) {

		List<Integer> results = new ArrayList<>();

		int n = friends.length;

		for (int i = 0; i < n; i++) {

			int count = 0;

			for (int j = 0; j < n; j++) {

				char curr = friends[i].charAt(j);

				if (curr == 'N') {
					continue;
				}

				count++;

				String target = friends[j];

				for (int k = 0; k < n; k++) {

					if (k != i && target.charAt(k) == 'Y') {
						count++;
					}
				}
			}

			results.add(count);
		}

		return Collections.max(results);
	}

	@Test
	public void testCase1() {

		String[] friends = {"NYNNN", "YNYNN", "NYNYN", "NNYNY", "NNNYN"};

		assertThat(highestScore(friends), is(4));
	}

	@Test
	public void testCase2() {

		String[] friends = {
			"NNNNYNNNNN",
			"NNNNYNYYNN",
			"NNNYYYNNNN",
			"NNYNNNNNNN",
			"YYYNNNNNNY",
			"NNYNNNNNYN",
			"NYNNNNNYNN",
			"NYNNNNYNNN",
			"NNNNNYNNNN",
			"NNNNYNNNNN"
		};

		assertThat(highestScore(friends), is(8));
	}
}
