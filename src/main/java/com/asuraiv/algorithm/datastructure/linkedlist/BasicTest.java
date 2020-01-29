package com.asuraiv.algorithm.datastructure.linkedlist;

public class BasicTest {

	public static void main(String[] args) {

		// test add
		LinkedList<Integer> list = new LinkedList<Integer>() {
			{
				{
					add(0);
					add(1);
					add(2);
					add(3);
					add(3);
					add(3);
					add(4);
					add(5);
				}
			}
		};

		list.printAllValues(); // #1

		// test remove
		list.remove(3);

		list.printAllValues(); // #2

		list.remove(3);

		list.printAllValues(); // #3

		list = new LinkedList<Integer>() {
			{
				{
					add(0);
				}
			}
		};

		list.remove(0);

		list.printAllValues(); // #4

		/*
			Output:

			#1: 0 -> 1 -> 2 -> 3 -> 3 -> 3 -> 4 -> 5
			#2: 0 -> 1 -> 2 -> 3 -> 3 -> 4 -> 5
			#3: 0 -> 1 -> 2 -> 3 -> 4 -> 5
			#4:
		 */
	}
}
