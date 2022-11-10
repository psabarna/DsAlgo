package algo.expert.bst.medium;

import java.util.Arrays;
import java.util.List;

public class MinHeightBST {

    public static BST minHeightBst(List<Integer> array) {
        if(array==null || array.size()==0){
            return null;
        }
        if(array.size()==1){
            return new BST(array.get(0));
        }
        int mid = (array.size()/2);
        BST root = new BST(array.get(mid));
        root.left = minHeightBst(array.subList(0, mid));
        root.right = minHeightBst(array.subList(mid+1, array.size()) );
        return root;
    }

    public static BST minHeightBst(List<Integer> array, int minIdx, int maxIdx) {
        if(maxIdx-minIdx>=0){
            int mid = (minIdx+maxIdx)/2;
            BST root = new BST(array.get(mid));
            root.left = minHeightBst(array,minIdx, mid-1);
            root.right = minHeightBst(array, mid+1, maxIdx);
            return root;
        }
       return null;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        public void insert(int value) {
            if (value < this.value) {
                if (left == null) {
                    left = new BST(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    right = new BST(value);
                } else {
                    right.insert(value);
                }
            }
        }
    }

    public static void main(String[] args) {

        List<Integer> array = Arrays.asList(1, 2, 5, 7, 10, 13, 14, 15, 22);
        var tree = minHeightBst(array, 0, array.size()-1);
        System.out.println(tree.value);

    }
}
