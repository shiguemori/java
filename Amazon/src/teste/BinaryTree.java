package teste;

import java.util.*;

class BinaryTree {

	/*
	 * class Node int data; Node left; Node right;
	 */
	static int height(Node root) {
		if (root == null)
			return -1;

		int left = 1 + height(root.left);
		int right = 1 + height(root.right);
		return left > right ? left : right;
	}

	public static Node insert(Node root, int data) {
		if (root == null) {
			return new Node(data);
		} else {
			Node cur;
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

	public static void main(String[] args) {
		System.out.println("Begin");
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		Node root = null;
		while (t-- > 0) {
			int data = scan.nextInt();
			root = insert(root, data);
		}
		scan.close();
		int height = height(root);
		System.out.println(height);
	}
}