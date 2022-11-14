package algo.expert.binarytree.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a binary tree, return sum of the depth of all nodes
 *
 */
public class NodeDepths {
    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static int nodeDepths(BinaryTree root) {
        // Write your code here.

        return nodeDepths(root,0,0);
    }

    public static int nodeDepths(BinaryTree node, int currentDepth, int totalDepth){
        if(node==null){
            return totalDepth;
        }
        totalDepth+=currentDepth;
        currentDepth+=1;
        totalDepth = nodeDepths(node.left, currentDepth, totalDepth);
        totalDepth =  nodeDepths(node.right, currentDepth, totalDepth);

        return totalDepth;
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
        System.out.println(nodeDepths(root));
    }

    
}

