package algo.expert.binarytree.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a Binary Tree with each node having reference to its Parent, find the inorder successor of any given node
 *
 */
public class Successor {
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;
        public BinaryTree parent = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    //Brute Force, Traverse inorder, store in a list and then get the next node from list
    public static BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
        // Write your code here.
        List<BinaryTree> inOrder = new ArrayList<>();
        traverseInOrder(tree, inOrder);
        int idx = 0;
        while(idx< inOrder.size() && inOrder.get(idx)!= node){
            idx++;
        }
        if(idx<inOrder.size()-1){
            return inOrder.get(idx+1);
        }
        return null;
    }

    public static void traverseInOrder(BinaryTree tree, List<BinaryTree> inOrder){
        if(tree==null){
            return;
        }
        traverseInOrder(tree.left, inOrder);
        inOrder.add(tree);
        traverseInOrder(tree.right, inOrder);
    }

    //Try to use the parent pointer of node to resolve it without traversing every node
    public static BinaryTree findSuccessor1(BinaryTree tree, BinaryTree node) {
        if(node.right!=null){
            return getLeftMostNode(node.right);
        }else {
            return getImmediateRightParent(node, tree);
        }


    }

    public static BinaryTree getImmediateRightParent(BinaryTree bt, BinaryTree root){
        while(bt!=root){
            if(bt == bt.parent.left){
                return bt.parent;
            }
            bt = bt.parent;
        }
        return null;
    }
    public static BinaryTree getLeftMostNode(BinaryTree bt){
        while(bt.left!=null){
            bt = bt.left;
        }
        return bt;
    }



    public static void main(String[] args) {
        var root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.left.parent = root;
        root.left.left = new BinaryTree(4);
        root.left.left.parent = root.left;
        root.left.left.left = new BinaryTree(6);
        root.left.left.left.parent = root.left.left;

        root.left.right = new BinaryTree(5);
        root.left.right.parent = root.left;
        root.right = new BinaryTree(3);
        root.right.parent = root;
        
        BinaryTree node =  root.left.right;
        System.out.println(findSuccessor1(root, node).value);
    }
}
