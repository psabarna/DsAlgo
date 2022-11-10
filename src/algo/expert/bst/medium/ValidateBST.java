package algo.expert.bst.medium;

/**
 * Check if a given tree is valid BST.
 */
public class ValidateBST {
    public static boolean validateBst(BST tree) {
        // Write your code here.
        if(tree==null){
            return true;
        }
        boolean isNodeValid =  (tree.left==null || tree.left.value< tree.value) && (tree.right==null || tree.right.value>= tree.value);

        return isNodeValid && validateBst(tree.left) && validateBst(tree.right);
    }

    public static boolean validateBst(BST tree, int min, int max) {
        // Write your code here.
        if(tree==null){
            return true;
        }

        boolean isNodeValid = tree.value>=min && tree.value<max;
        return isNodeValid && validateBst(tree.left, min, tree.value) && validateBst(tree.right, tree.value, max);
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        var root = new BST(10);
        root.left = new BST(5);
        root.left.left = new BST(2);
        root.left.left.left = new BST(1);
        root.left.right = new BST(5);
        root.right = new BST(15);
        root.right.left = new BST(13);
        root.right.left.right = new BST(14);
        root.right.right = new BST(22);
        System.out.println(validateBst(root));
    }
}
