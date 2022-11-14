package algo.expert.binarytree.veryhard;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

import java.util.Stack;
import java.util.function.Function;

import java.util.Stack;

/**
 *Given a Binary Tree where each node has reference to its left, right and parent, traverse it inorder iteratively
 */

public class IterativeInOrderTraversal {

    //O(n) time O(1) Space
    public static void iterativeInOrderTraversal(
            BinaryTree tree) {
        BinaryTree prev =null;
        BinaryTree node = tree;
        while(node!=null){
            BinaryTree nextNode = null;
            if(prev == node.parent){
                if(node.left!=null){
                    nextNode = node.left;
                }else{
                    System.out.println(node.value);
                    if(node.right!=null) {
                        nextNode = node.right;
                    }else{
                        nextNode =  node.parent;
                    }
                }
            }else if(prev == node.left){
                System.out.println(node.value);
                if(node.right!=null) {
                    nextNode = node.right;
                }else{
                    nextNode =  node.parent;
                }
            }else if(prev == node.right){
                nextNode =  node.parent;
            }
            prev = node;
            node = nextNode;
        }
    }

    //using Stack
    public static void iterativeInOrderTraversal1(BinaryTree tree){
        Stack<BinaryTree> stack = new Stack<>();
        while(tree!=null && !stack.empty()){
            if(tree!=null){
                stack.push(tree);
                tree = tree.left;
            }else{
                BinaryTree node = stack.pop();
                System.out.println(node.value);
                tree = node.right;
            }
        }

    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;
        public BinaryTree parent;

        public BinaryTree(int value) {
            this.value = value;
        }

        public BinaryTree(int value, BinaryTree parent) {
            this.value = value;
            this.parent = parent;
        }
    }

    public static void main(String[] args) {
        var root = new BinaryTree(1);
        root.left = new BinaryTree(2, root);
        root.left.left = new BinaryTree(4, root.left);
        root.left.left.right = new BinaryTree(9, root.left.left);
        root.right = new BinaryTree(3, root);
        root.right.left = new BinaryTree(6, root.right);
        root.right.right = new BinaryTree(7, root.right);
        iterativeInOrderTraversal1(root);
    }

    /*public static void main(String[] args) {
        BinaryTree root = new BinaryTree(5, null);
        root.left= new BinaryTree(3, root);
        root.right= new BinaryTree(7, root);

        root.left.left= new BinaryTree(1, root.left);
        root.left.left.right= new BinaryTree(2, root.left.left);
        root.left.right= new BinaryTree(4, root.left);

        root.right.left = new BinaryTree(6, root.right);
        root.right.right = new BinaryTree(8, root.right);

        iterativeInOrderTraversal(root, null);
    }*/
}
