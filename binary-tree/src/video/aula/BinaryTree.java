package video.aula;

/**
 * @author Shiguemori
 */
public class BinaryTree {

    public int value;
    public BinaryTree left;
    public BinaryTree right;

    /**
     * Tree construction
     *
     * @param value
     * @param left
     * @param right
     */
    BinaryTree(int value, BinaryTree left, BinaryTree right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public BinaryTree insert(int valor) {
        return insert(this, valor);
    }

    /**
     * Fill the tree
     *
     * @param nodeBinaryTree
     * @param value
     * @return
     */
    public static BinaryTree insert(BinaryTree nodeBinaryTree, int value) {
        if (nodeBinaryTree == null) {
            return new BinaryTree(value, null, null);
        } else {
            BinaryTree newNode;
            if (value <= nodeBinaryTree.value) {
                newNode = insert(nodeBinaryTree.left, value);
                nodeBinaryTree.left = newNode;
            } else {
                newNode = insert(nodeBinaryTree.right, value);
                nodeBinaryTree.right = newNode;
            }
            return nodeBinaryTree;
        }
    }

    public void iterarNo() {
        int i = 0;
        int altura = this.height();
        for (i = 0; i <= altura; i++) {
            printRecursive(this, i);
        }
    }

    /**
     * Print the values in a recursive way
     *
     * @param nodeBinaryTree
     * @param target
     */
    public static void printRecursive(BinaryTree nodeBinaryTree, int target) {
        if (nodeBinaryTree == null)
            return;

        if (target == 0)
            System.out.print(nodeBinaryTree.value + " ");

        printRecursive(nodeBinaryTree.left, target - 1);
        printRecursive(nodeBinaryTree.right, target - 1);
    }

    /**
     * @return
     */
    public int height() {
        return this.height(this);
    }

    /**
     * @param nodeBinaryTree
     * @return
     */
    private int height(BinaryTree nodeBinaryTree) {
        if (nodeBinaryTree == null)
            return -1;

        if (nodeBinaryTree.left == null && nodeBinaryTree.right == null) {
            return 0;
        }

        int left = 1 + height(nodeBinaryTree.left);
        int right = 1 + height(nodeBinaryTree.right);

        return Math.max(left, right);
    }

    /**
     * @param nodeBinaryTree
     */
    public static void printPreOrder(BinaryTree nodeBinaryTree) {
        System.out.print(nodeBinaryTree.value + " ");
        if (nodeBinaryTree.left != null) {
            BinaryTree.printPreOrder(nodeBinaryTree.left);
        }
        if (nodeBinaryTree.right != null) {
            BinaryTree.printPreOrder(nodeBinaryTree.right);
        }
    }

    /**
     * Count nodes
     *
     * @param sum
     * @return
     */
    public int countNodes(int sum) {
        sum = sum + 1;
        if (this.hasLeft())
            sum = this.left.countNodes(sum);

        if (this.hasRight())
            sum = this.right.countNodes(sum);

        return sum;
    }

    /**
     * Search the value inside the tree
     *
     * @param target
     * @param found
     * @return
     */
    public boolean search(int target, boolean found) {

        if (this.value == target) {
            found = true;
        }

        if (found) {
            return true;
        }

        if (target <= this.value) {
            if (!this.hasLeft())
                return false;

            found = this.left.search(target, false);
        } else {

            if (!this.hasRight())
                return false;

            found = this.right.search(target, false);
        }
        return found;
    }

    /**
     * Verify if has left and right
     * @return
     */
    public boolean hasRightAndLeft() {
        if (this.hasLeft() && this.hasRight())
            return true;
        else
            return false;
    }

    /**
     * Verify if has right or left
     * @return
     */
    public boolean hasRightOrLeft() {
        if (this.hasLeft() || this.hasRight())
            return true;
        else
            return false;
    }

    /**
     * Verify if has right
     *
     * @return
     */
    public boolean hasRight() {
        if (this.right == null)
            return false;
        else
            return true;
    }

    /**
     * Verify if has left
     *
     * @return
     */
    public boolean hasLeft() {
        if (this.left == null)
            return false;
        else
            return true;
    }

    /**
     * Remove node
     *
     * @param value
     * @return
     */
    public BinaryTree nodeRemove(int value) {
        return this.nodeRemove(this, value);
    }

    /**
     * Remove node
     *
     * @param nodeBinaryTree
     * @param value
     * @return
     */
    public BinaryTree nodeRemove(BinaryTree nodeBinaryTree, int value) {
        if (nodeBinaryTree == null)
            return nodeBinaryTree;

        if (value > nodeBinaryTree.value) {
            nodeBinaryTree.right = nodeRemove(nodeBinaryTree.right, value);

        } else if (value < nodeBinaryTree.value) {
            nodeBinaryTree.left = nodeRemove(nodeBinaryTree.left, value);

        } else {
            if (nodeBinaryTree.left == null && nodeBinaryTree.right == null) {
                nodeBinaryTree = null;

            } else if (nodeBinaryTree.right != null) {
                nodeBinaryTree.value = sucessor(nodeBinaryTree);
                nodeBinaryTree.right = nodeRemove(nodeBinaryTree.right, nodeBinaryTree.value);
            } else {
                nodeBinaryTree.value = predecessor(nodeBinaryTree);
                nodeBinaryTree.left = nodeRemove(nodeBinaryTree.left, nodeBinaryTree.value);
            }
        }
        return nodeBinaryTree;
    }

    /**
     * @param nodeBinaryTree
     * @return
     */
    private int sucessor(BinaryTree nodeBinaryTree) {
        nodeBinaryTree = nodeBinaryTree.right;
        while (nodeBinaryTree.left != null) {
            nodeBinaryTree = nodeBinaryTree.left;
        }
        return nodeBinaryTree.value;
    }

    /**
     * @param nodeBinaryTree
     * @return
     */
    private int predecessor(BinaryTree nodeBinaryTree) {
        nodeBinaryTree = nodeBinaryTree.left;
        while (nodeBinaryTree.right != null) {
            nodeBinaryTree = nodeBinaryTree.right;
        }
        return nodeBinaryTree.value;
    }

}
