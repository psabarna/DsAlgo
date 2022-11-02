package algo.expert.bt.medium;

public class HeightBalancedTree {

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public static boolean heightBalancedBinaryTree(BinaryTree tree) {
        // Write your code here.
        return getHeightInfo(tree).balanced;
    }

    public static NodeInfo getHeightInfo(BinaryTree node) {
        // Write your code here.
        if(node==null){
            return new NodeInfo(true, 0);
        }
        NodeInfo leftInfo = getHeightInfo(node.left);
        NodeInfo rightInfo = getHeightInfo(node.right);
        int height = Math.max(leftInfo.height, rightInfo.height)+1;
        boolean balanced = leftInfo.balanced && rightInfo.balanced && Math.abs(leftInfo.height-rightInfo.height)<=1;
        return new NodeInfo(balanced, height);
    }

    static class NodeInfo{
        boolean balanced;
        int height;

        public NodeInfo(boolean balanced, int height) {
            this.balanced = balanced;
            this.height = height;
        }
    }

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.right = new BinaryTree(3);
        root.left.left = new BinaryTree(4);
        root.left.right = new BinaryTree(5);
        root.right.right = new BinaryTree(6);
        root.left.right.left = new BinaryTree(7);
        root.left.right.right = new BinaryTree(8);

        var actual = heightBalancedBinaryTree(root);
        System.out.println(actual);
    }
}
