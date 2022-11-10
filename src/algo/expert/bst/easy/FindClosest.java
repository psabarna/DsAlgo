package algo.expert.bst.easy;

/**
 * Given a BST and a target value, find node which is closest to the target.
 */
public class FindClosest {
    public static int findClosestValueInBst(BST tree, int target) {
        // Write your code here.
        if(tree==null){
            return Integer.MIN_VALUE;
        }
        int diffFromRoot = Math.abs(tree.value-target);
        int childClosest ;
        if(target>=tree.value){
            childClosest = findClosestValueInBst(tree.right, target);
        }else{
            childClosest = findClosestValueInBst(tree.left, target);
        }
        int diffFromChild = Math.abs(childClosest-target);
        if(diffFromRoot<=diffFromChild){
            return tree.value;
        }else{
            return childClosest;
        }

    }



    public static int findClosestValueInBst(BST tree, int target, int closest) {
        // Write your code here.
        if(tree==null){
            return closest;
        }
        if(Math.abs(target- tree.value)<Math.abs(target-closest)){
            closest = tree.value;
        }
        if(target>=tree.value){
            return findClosestValueInBst(tree.right, target, closest);
        }else{
            return findClosestValueInBst(tree.left, target, closest);
        }


    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        var root = new BST(10);
        root.left = new BST(5);
        root.left.left = new BST(2);
        root.left.left.left = new BST(1);
        root.left.right = new BST(5);
        root.right = new BST(15);
        root.right.left = new BST(13);
        root.right.left.right = new BST(14);
        root.right.right = new BST(22);

        System.out.println(findClosestValueInBst(root, 12));

        System.out.println(findClosestValueInBst(root, 12, 10));
    }
}

