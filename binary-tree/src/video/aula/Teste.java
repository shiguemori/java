package video.aula;

import java.util.Random;
import java.util.Scanner;

/**
 * 
 * @author Shiguemori
 *
 */
public class Teste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		runBinaryTree();
	}

	public static void runBinaryTree() {

		System.out.println("Begin Binary Tree");

		Scanner scan = new Scanner(System.in);
		BinaryTree nodeBinaryTree = null;
		for (int i = 0; i < 10; i++) {
			Random rand = new Random();
			nodeBinaryTree = BinaryTree.insert(nodeBinaryTree, rand.nextInt(300));
		}

		System.out.println("Print pre order");
		BinaryTree.printPreOrder(nodeBinaryTree);

		System.out.println("\nHeight");
		System.out.println(nodeBinaryTree.height());

		System.out.println("Print transversal");
		nodeBinaryTree.iterarNo();
		
		System.out.println("\nQuantity of nodes is :" + nodeBinaryTree.countNodes(0));

		System.out.println("Search");
		int t = scan.nextInt();
		boolean resultadoBusca = nodeBinaryTree.search(t, false);
		System.out.println(resultadoBusca ? "Founded" : "Not found");

		System.out.println("Remove");
		t = scan.nextInt();
		nodeBinaryTree.nodeRemove(t);

		System.out.println("Print transversal");
		nodeBinaryTree.iterarNo();
		System.out.println("\nEnd Binary Tree");
		scan.close();
	}

}
