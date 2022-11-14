package algo.expert.binarytree.medium;


/**
 * Given a Binary Tree, invert the nodes. i. e swap between right and left for each node
 *       1
 *   2       3
 *  4  5   6    7
 *
 *  becomes
 *         1
 *     3       2
 *   7  6   5    4
 *
 */
public class InvertBT {

    public static void invertBinaryTree(BinaryTree tree) {
        // Write your code here.
        if(tree==null){
            return;
        }
        BinaryTree temp = tree.left;
        tree.left = tree.right;
        tree.right = temp;
        invertBinaryTree(tree.left);
        invertBinaryTree(tree.right);
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {

        var root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.left.left = new BinaryTree(4);
        root.left.left.left = new BinaryTree(8);
        root.left.left.right = new BinaryTree(9);
        root.left.right = new BinaryTree(5);
        root.right = new BinaryTree(3);
        root.right.left = new BinaryTree(6);
        root.right.right = new BinaryTree(7);
        invertBinaryTree(root);

        System.out.println(root.left.value+" "+root.right.value);

    }
}
