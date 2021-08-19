package desafios.diarios;

import java.util.*;

class Node3 {
	Node3 left, right;
	int data;

	Node3(int data) {
		this.data = data;
		left = right = null;
	}
}

class Day23 {

	static int height(Node3 n) {
		if (n == null)
			return 0;

		if (n.left == null && n.right == null)
			return 1;

		int lheight = height(n.left);
		int rheight = height(n.right);

		return Math.max(lheight, rheight) + 1;
	}

	static void levelOrder(Node3 root) {
		int h = height(root);

		for (int i = 0; i <= h; i++) {
			printTreeLevelRec(root, i);
		}
	}

	static void printTreeLevelRec(Node3 node, int desired) {
		if (node == null)
			return;
		if (desired == 0)
			System.out.print(node.data + " ");

		printTreeLevelRec(node.left, desired - 1);
		printTreeLevelRec(node.right, desired - 1);
	}

	public static Node3 insert(Node3 root, int data) {
		if (root == null) {
			return new Node3(data);
		} else {
			Node3 cur;
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
		Node3 root = null;
		while (T-- > 0) {
			int data = sc.nextInt();
			root = insert(root, data);
		}
		levelOrder(root);
	}
}