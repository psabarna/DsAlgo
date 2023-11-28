package algo.expert.binarytree.veryhard;

/*
Given a binary tree flatten it

https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
 */
public class FlattenBinaryTree {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    static class FlattenedTree{
        TreeNode head;
        TreeNode tail;
        public FlattenedTree(TreeNode head, TreeNode tail){
            this.head = head;
            this.tail = tail;
        }
    }
    public void flatten(TreeNode root) {
        helper(root);
    }
    public FlattenedTree helper(TreeNode node){
        if(node==null){
            return null;
        }


        TreeNode tail = node;
        TreeNode right = node.right;

        if(node.left!=null){
            FlattenedTree leftF =  helper(node.left);
            node.right = leftF.head;
            tail = leftF.tail;
        }
        if(right!=null){
            FlattenedTree rightF =  helper(right);
            tail.right = rightF.head;
            tail = rightF.tail;
        }
        node.left=null;
        return new FlattenedTree(node, tail);


    }

    public static void main(String[] args) {

    }
}
