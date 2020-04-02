package com.asuraiv.algorithm.topcoder.basic;

import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/*
	SRM494, Div 2, Level 1
 */
public class InterestingParty {


	int bestInvitation(String[] first, String[] second) {

		Map<String, Integer> countMap = new HashMap<>();

		for(int i = 0; i < first.length; i++) {

			countMap.put(first[i], countMap.getOrDefault(first[i], 0) + 1);
			countMap.put(second[i], countMap.getOrDefault(second[i], 0) + 1);
		}

		return Collections.max(countMap.values());
	}

	@Test
	public void test() {

		String[] first = {"snakes", "programming", "cobra", "monty"};
		String[] second = {"python", "python", "anaconda", "python"};

		assertThat(bestInvitation(first, second), is(3));
	}
}
