package com.asuraiv.algorithm.datastructure.linkedlist;

public class DistinctTest {

	public static void main(String[] args) {

		// test add
		LinkedList<Integer> list = new LinkedList<Integer>() {
			{
				{
					add(0);
					add(1);
					add(2);
					add(2);
					add(3);
					add(4);
					add(5);
				}
			}
		};

		list.distinct(2);

		list.printAllValues();
	}
}
