package algo.expert.bt.veryhard;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.function.Function;

public class IterativeInOrderTraversal {
    public static void iterativeInOrderTraversal(
            BinaryTree tree, Function<BinaryTree, Void> callback) {
        BinaryTree prev =null;
        BinaryTree node = tree;
        while(node!=null){
            if(prev == node.parent){
                if(node.left!=null){
                    prev = node;
                    node = node.left;
                }else{
                    System.out.println(node.value);
                    prev = node;
                    node = node.right;
                }
            }
        }

        // Write your code here.
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
}
