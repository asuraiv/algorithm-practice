package com.asuraiv.algorithm.stringandarray;

public class ReplaceBlank {

	public static void main(String[] args) {

		int length = 13;
		String input = "Mr John Smith    ";
		String output = "";

		for(int i = 0; i < length; i++) {

			char curr = input.charAt(i);

			if(curr == ' ') {
				output += "%20";
				continue;
			}

			output += curr;
		}

		System.out.println(output); // Output: Mr%20John%20Smith
	}
}
