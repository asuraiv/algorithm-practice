package com.asuraiv.algorithm.linkedlist;

public class LinkedList<T> {

	private Node head;

	public void add(T value) {

		if(this.head == null) {
			this.head = new Node(value);
			return;
		}

		Node tail = findTail();

		tail.next = new Node(value);
	}

	private Node findTail() {

		Node tail = this.head;

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

		if(this.head.value.equals(value)) {
			this.head = null;
			return;
		}

		if(this.head.next == null) {
			// Don't remove anything
			return;
		}

		Node current = this.head;
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

		if (this.head.next == null) {
			this.head = null;
			return;
		}

		this.head = this.head.next;
	}

	public void distinct(T value) {

		Node found = find(value);

		if(found == null) {
			return;
		}

		Node prev = found;
		Node curr = found.next;

		while(curr != null) {

			if(curr.value.equals(value)) {
				prev.next = curr.next;
				curr = curr.next;
				continue;
			}

			curr = curr.next;
		}
	}

	private Node findFromNode(Node from, T value) {

		if(from.value.equals(value)) {
			return from;
		}

		Node next = from.next;

		while(next != null) {
			if(next.value.equals(value)) {
				return next;
			}
			next = next.next;
		}

		return next;
	}

	private Node find(T value) {

		return findFromNode(this.head, value);
	}

	public void printAllValues() {

		if(head == null) {
			return;
		}

		System.out.print(this.head.value);

		Node next = this.head.next;

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
