package desafios.diarios;

import java.util.*;

class Node2 {
	Node2 left, right;
	int data;

	Node2(int data) {
		this.data = data;
		left = right = null;
	}
}

class Day22 {

	public static int getHeight(Node2 root) {
		if (root == null)
			return -1;

		int left = 1 + getHeight(root.left);
		int right = 1 + getHeight(root.right);
		return left > right ? left : right;
	}

	public static Node2 insert(Node2 root, int data) {
		if (root == null) {
			return new Node2(data);
		} else {
			Node2 cur;
			if (data <= root.data) {
				cur = insert(root.left, data);
				root.left = cur;
			} else {
				cur = insert(root.right, data);
				root.right = cur;
			}
			return root;
		}
	}

	static Scanner sc = new Scanner(System.in);

	public static void main(String args[]) {
		int T = sc.nextInt();
		Node2 root = null;
		while (T-- > 0) {
			int data = sc.nextInt();
			root = insert(root, data);
		}
		int height = getHeight(root);
		System.out.println(height);
	}
}