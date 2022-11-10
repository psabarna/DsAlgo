package algo.expert.bst.medium;
//TODO
public class BSTConstruction {
    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public BST insert(int value) {
            // Write your code here.
            // Do not edit the return statement of this method.
            BST prev = null;
            BST currentNode = this;
            while(currentNode!=null){
                if(value>=currentNode.value){
                    prev = currentNode;
                    currentNode= currentNode.right;
                }else{
                    prev = currentNode;
                    currentNode = currentNode.left;
                }
            }
            if(value>= prev.value){
                prev.right = new BST(value);
            }else{
                prev.left = new BST(value);
            }

            return this;
        }

        public boolean contains(int value) {
            // Write your code here.
            if(this.value== value){
                return true;
            }
            if(value>this.value && this.right!=null){
                return this.right.contains(value);
            }
            if(value<this.value && this.left!=null){
                return this.left.contains(value);
            }
            return false;
        }

        public BST remove(int value) {
            // Write your code here.
            // Do not edit the return statement of this method.
            BST parent = null;
            BST nodeToRemove = null;
            BST currentNode = this;
            while(currentNode!=null && nodeToRemove==null){
                if(currentNode.value== value){
                    nodeToRemove = currentNode;
                    break;
                }
                parent = currentNode;
                currentNode = value> currentNode.value?currentNode.right: currentNode.left;
            }

            //Node found

            if(parent==null){
                //its root
            }else if(parent.left== nodeToRemove){
                //its in left subtree
            }else if(parent.right== nodeToRemove){
                //its in right
            }

            return this;
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

        root.insert(12);
        System.out.println(root.right.left.left.value == 12);
        System.out.println(root.contains(18));
    }
}
