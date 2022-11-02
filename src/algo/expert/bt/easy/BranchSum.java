package algo.expert.bt.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a binary tree, return list of its branch sums
 * Branch sum is the sum of nodes from root to leaf nodes
 *
 */
public class BranchSum {
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

    //O(n) time and O(n) space
    public static List<Integer> branchSums(BinaryTree root) {
        // Write your code here.
        List<Integer> bs = new ArrayList<Integer>();

        branchSums(root, 0, bs);
        return bs;
    }

    public static void branchSums(BinaryTree node, int parentSum, List<Integer> sums) {
        if(node.left==null && node.right==null){
            sums.add(parentSum+node.value);
        }else{
            if(node.left!=null)
                branchSums(node.left, parentSum + node.value, sums);
            if(node.right!=null)
                branchSums(node.right, parentSum + node.value, sums);
        }
    }

    public static void main(String[] args) {
        TestBinaryTree tree = new TestBinaryTree(1).insert(Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10));
        List<Integer> expected = new ArrayList<Integer>(Arrays.asList(15, 16, 18, 10, 11));
        List<Integer> actual = branchSums(tree);
        for (Integer sum: actual){
            System.out.println(sum);
        }
    }

    public static class TestBinaryTree extends BinaryTree {
        TestBinaryTree(int value) {
            super(value);
        }

        TestBinaryTree insert(List<Integer> values) {
            return insert(values, 0);
        }

        TestBinaryTree insert(List<Integer> values, int i) {
            if (i >= values.size()) return null;

            List<TestBinaryTree> queue = new ArrayList<TestBinaryTree>();
            queue.add(this);
            while (queue.size() > 0) {
                TestBinaryTree current = queue.get(0);
                queue.remove(0);
                if (current.left == null) {
                    current.left = new TestBinaryTree(values.get(i));
                    break;
                }
                queue.add((TestBinaryTree) current.left);
                if (current.right == null) {
                    current.right = new TestBinaryTree(values.get(i));
                    break;
                }
                queue.add((TestBinaryTree) current.right);
            }
            insert(values, i + 1);
            return this;
        }
    }


}
