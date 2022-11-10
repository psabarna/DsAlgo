package algo.expert.bst.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a BST find kth largest element
 */
public class FindKthLargest {

    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    public static int findKthLargestValueInBst(BST tree, int k) {
        List<Integer> reverseInOrder = new ArrayList<>();
        findKthLargestValueInBst(tree, k, reverseInOrder);
        if(reverseInOrder.size()>=k){
            return reverseInOrder.get(k-1);
        }
        return -1;
    }
    public static void findKthLargestValueInBst(BST tree, int k, List<Integer> reverseInOrder) {
        if(reverseInOrder.size()>=k){
            return;
        }
        if(tree!=null){
            findKthLargestValueInBst(tree.right, k, reverseInOrder);
            reverseInOrder.add(tree.value);
            findKthLargestValueInBst(tree.left, k, reverseInOrder);
        }
    }

    public static void main(String[] args) {
        BST root = new BST(15);
        root.left = new BST(5);
        root.left.left = new BST(2);
        root.left.left.left = new BST(1);
        root.left.left.right = new BST(3);
        root.left.right = new BST(5);
        root.right = new BST(20);
        root.right.left = new BST(17);
        root.right.right = new BST(22);
        int k = 3;
        int expected = 17;
        var actual = findKthLargestValueInBst(root, k);
        System.out.println(expected == actual);
    }
}
