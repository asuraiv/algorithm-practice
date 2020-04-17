package com.asuraiv.algorithm.programmers;

import org.junit.Test;

import java.util.*;

import com.asuraiv.algorithm.common.AssertUtils;

import java.util.stream.Collectors;

public class BestAlbum {

	private int[] solution(String[] genres, int[] plays) {

		Map<String, Integer> mapPerGenre = new HashMap<>();

		for (int i = 0; i < plays.length; i++) {
			mapPerGenre.put(genres[i], mapPerGenre.getOrDefault(genres[i], 0) + plays[i]);
		}

		mapPerGenre = mapPerGenre.entrySet().stream()
			.sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
			.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

		Map<String, List<Integer>> mapOfNumbers = new LinkedHashMap<>();

		for (String genre : mapPerGenre.keySet()) {

			List<Integer> numbers = new ArrayList<>();

			for (int i = 0; i < genres.length; i++) {

				String curr = genres[i];

				if (curr.equals(genre)) {
					numbers.add(i);
				}
			}

			Comparator<Integer> comparing = Comparator.comparing(number -> plays[number]);

			numbers.sort(comparing.reversed()
				.thenComparing(Comparator.naturalOrder())
			);

			mapOfNumbers.put(genre, numbers);
		}

		List<Integer> answerList = new ArrayList<>();

		for (String genre : mapOfNumbers.keySet()) {

			List<Integer> numbers = mapOfNumbers.get(genre);

			for (int i = 0; i < Math.min(2, numbers.size()); i++) {
				answerList.add(numbers.get(i));
			}
		}

		int[] answer = new int[answerList.size()];
		for (int i = 0; i < answerList.size(); i++) {
			answer[i] = answerList.get(i);
		}

		return answer;
	}

	@Test
	public void testCase1() {

		AssertUtils.assertArrayEqualWithOrder(
			solution(new String[] { "classic", "pop", "classic", "classic", "pop" }, new int[] { 500, 2500, 150, 800, 2500 }),
			new int[] { 1, 4, 3, 0 });
	}

	@Test
	public void testCase2() {

		AssertUtils.assertArrayEqualWithOrder(
			solution(new String[] { "classic", "pop", "classic", "pop", "classic", "classic" }, new int[] { 400, 600, 150, 2500, 500, 500 }),
			new int[] { 3, 1, 4, 5 });
	}

	@Test
	public void testCase3() {

		AssertUtils.assertArrayEqualWithOrder(
			solution(new String[] { "classic", "classic", "classic", "classic", "pop" }, new int[] { 100,100,100,100,1000 }),
			new int[] { 4, 0, 1 });
	}
}
