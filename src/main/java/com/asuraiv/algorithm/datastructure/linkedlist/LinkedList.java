package com.asuraiv.algorithm.datastructure.linkedlist;

public class LinkedList<T> {

	private Node head;
	private Node tail;

	public void add(T value) {

		if(this.head == null) {
			Node initialNode = new Node(value);
			this.head = initialNode;
			this.tail = initialNode;
			return;
		}

		appendToTail(value);
	}

	private void appendToTail(T value) {

		Node appendedNode = new Node(value);

		appendedNode.prev = this.tail;

		this.tail.next = appendedNode;
		this.tail = appendedNode;
	}

	/**
	 * Removes the first occurrence of the specified value from this list
	 * @param value
	 */
	public void remove(T value) {

		if(this.head.value.equals(value)) {
			this.head = head.next;
			return;
		}

		if(this.head.next == null) {
			// Don't remove anything
			return;
		}

		Node current = this.head;

		// find node for given value
		while(current.value != value) {
			current = current.next;
		}

		current.prev.next = current.next;
		current.next.prev = current.prev;
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
		Node prev;

		Node(T value) {
			this.value = value;
		}
	}
}
