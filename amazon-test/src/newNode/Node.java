package newNode;

class Node {

	int data;
	int depth;
	Node left, right;

	/**
	 * @param data
	 * @param depth
	 */
	Node(int data, int depth) {
		this.data = data;
		this.depth = depth;
	}
}