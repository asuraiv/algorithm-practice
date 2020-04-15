package com.asuraiv.algorithm.programmers;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class NoCompletions {

	String solution(String[] participant, String[] completion) {

		Map<String, Integer> map = new HashMap<>();

		for (String person : completion) {
			map.put(person, map.getOrDefault(person, 0) + 1);
		}

		for(String part : participant) {

			Integer count = map.get(part);

			if(count == null || count == 0) {
				return part;
			}

			map.put(part, count - 1);
		}

		return "";
	}

	@Test
	public void testCase1() {
		assertThat(solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"}), is("mislav"));
	}

	@Test
	public void testCase2() {
		assertThat(solution(new String[]{"a", "b", "b", "c"}, new String[]{"a", "b", "b"}), is("c"));
	}
}
