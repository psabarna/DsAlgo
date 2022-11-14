package algo.expert.binarytree.hard;

/**
 * Given a Binary Tree return Max Path Sum
 * A path Sum is the sum of values of a path.
 * Ex:          1
 *            /   \
 *           2     3
 *         /  \   /  \
 *        4   5  6    7
 *   Output: 18= 5+2+1+3+7
 *   Note: node value can be negative
 */

public class MaxPathSum {
    public static int maxPathSum(BinaryTree tree) {
        // Write your code here.
        return getNodePathInfo(tree).maxSumPath;
    }
    //O(n) time, O(log(n)) space
    public static NodeInfo getNodePathInfo(BinaryTree node){
        if(node==null){
            return new NodeInfo(0,Integer.MIN_VALUE);
        }
        NodeInfo leftInfo = getNodePathInfo(node.left);
        NodeInfo rightInfo = getNodePathInfo(node.right);

        int maxSumBranch = Math.max(leftInfo.maxSumBranch, rightInfo.maxSumBranch);
        maxSumBranch = Math.max(maxSumBranch+node.value, node.value );
        int maxSumAsRoot =Math.max(leftInfo.maxSumBranch+ node.value+ rightInfo.maxSumBranch, maxSumBranch);
        int maxPath = Math.max(maxSumAsRoot, Math.max(leftInfo.maxSumPath,rightInfo.maxSumPath));
        return new NodeInfo(maxSumBranch,maxPath);
    }

    static class NodeInfo {
        int maxSumBranch;
        int maxSumPath;

        public NodeInfo(int maxSumBranch, int maxSumPath) {
            this.maxSumBranch = maxSumBranch;
            this.maxSumPath = maxSumPath;
        }
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
        root.left.right = new BinaryTree(5);
        root.right = new BinaryTree(3);
        root.right.left = new BinaryTree(6);
        root.right.right = new BinaryTree(7);

        System.out.println(maxPathSum(root));
    }
}
