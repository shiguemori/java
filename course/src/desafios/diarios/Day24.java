package desafios.diarios;

import java.util.*;

class Node4 {
	int data;
	Node4 next;

	Node4(int d) {
		data = d;
		next = null;
	}
}

class Day24 {

	public static Node4 removeDuplicates(Node4 head) {
		if (head == null || head.next == null) {
			return head;
		}
		if (head.data == head.next.data) {
			head.next = head.next.next;
			removeDuplicates(head);
		} else {
			removeDuplicates(head.next);
		}
		return head;
	}

	public static Node4 insert(Node4 head, int data) {
		Node4 p = new Node4(data);
		if (head == null)
			head = p;
		else if (head.next == null)
			head.next = p;
		else {
			Node4 start = head;
			while (start.next != null)
				start = start.next;
			start.next = p;

		}
		return head;
	}

	public static void display(Node4 head) {
		Node4 start = head;
		while (start != null) {
			System.out.print(start.data + " ");
			start = start.next;
		}
	}

	static Scanner sc = new Scanner(System.in);

	public static void main(String args[]) {
		Node4 head = null;
		int T = sc.nextInt();
		while (T-- > 0) {
			int ele = sc.nextInt();
			head = insert(head, ele);
		}
		head = removeDuplicates(head);
		display(head);

	}
}