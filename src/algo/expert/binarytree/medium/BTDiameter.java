package algo.expert.binarytree.medium;

/**
 * Given a Binary Tree, find the diameter of Tree
 * The diameter is defined by the longest path, even if it does not pass through the root
 * Path is a collection of connected nodes, length of path is the edges between them.
 */
public class BTDiameter {

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
    static class TreeInfo{
        int height;
        int maxDiam;

        public TreeInfo(int height, int maxDiam) {
            this.height = height;
            this.maxDiam = maxDiam;
        }
    }

    public static int binaryTreeDiameter(BinaryTree tree) {
        // Write your code here.
        return treeInfo(tree).maxDiam;
    }

    public static TreeInfo treeInfo(BinaryTree node) {
        // Write your code here.
        if(node==null){
            return new TreeInfo(0,0);
        }
        TreeInfo leftInfo = treeInfo(node.left);
        TreeInfo rightInfo = treeInfo(node.right);
        int maxDiam = Math.max(leftInfo.maxDiam, rightInfo.maxDiam);
        if(leftInfo.height+rightInfo.height>maxDiam){
            maxDiam = leftInfo.height+rightInfo.height;
        }
        int height = Math.max(leftInfo.height, rightInfo.height)+1;
        return new TreeInfo(height, maxDiam);
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

        System.out.println(binaryTreeDiameter(root));

    }

}
