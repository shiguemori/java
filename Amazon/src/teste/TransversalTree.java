package teste;

import java.util.*;

/**
 * @author Shiguemori
 *
 */
class TransversalTree {

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
		levelOrder(root);
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

	public static int height(Node n) {
		if (n == null)
			return 0;

		if (n.left == null && n.right == null)
			return 1;

		int lheight = height(n.left);
		int rheight = height(n.right);

		return Math.max(lheight, rheight) + 1;
	}
	
	public static void levelOrder(Node root) {
		int h = height(root);

		for (int i = 0; i <= h; i++) {
			printTreeLevelRec(root, i);
		}
	}

	public static void printTreeLevelRec(Node node, int desired) {
		if (node == null)
			return;
		if (desired == 0)
			System.out.print(node.data + " ");

		printTreeLevelRec(node.left, desired - 1);
		printTreeLevelRec(node.right, desired - 1);
	}
}
