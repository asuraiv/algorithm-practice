package com.asuraiv.algorithm.linkedlist;

public class LinkedList<T> {

	private Node head;

	public void add(T value) {

		if(head == null) {
			head = new Node(value);
			return;
		}

		Node tail = findTail();

		tail.next = new Node(value);
	}

	private Node findTail() {

		Node tail = head;

		while(tail.next != null) {
			tail = tail.next;
		}

		return tail;
	}

	/**
	 * Removes the first occurrence of the specified value from this list
	 * @param value
	 */
	public void remove(T value) {

		Node current = head;
		Node previous = null;

		while(current.value != value) {
			previous = current;
			current = current.next;
		}

		if(previous == null) {
			removeHead();
			return;
		}

		previous.next = current.next;
	}

	private void removeHead() {

		if (head.next == null) {
			head = null;
			return;
		}

		head = head.next;
	}

	public void printAllValues() {

		System.out.print(head.value);

		Node next = head.next;

		while(next != null) {

			System.out.print(" -> ");
			System.out.print(next.value);

			next = next.next;
		}

		System.out.println();
	}

	private class Node {

		T value;
		Node next;

		Node(T value) {
			this.value = value;
		}
	}
}
