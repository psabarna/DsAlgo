package tree;

public class BSTDeleteNode {
//to be corrected


     public static class TreeNode {
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

    public static TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){
            return root;
        }
        if(root.val> key){
            root.left = deleteNode(root.left, key);
        }else if(root.val<key){
            root.right = deleteNode(root.right, key);
        }else{
            return getSuccessor(root);
        }
        return root;
    }
    public static TreeNode getSuccessor(TreeNode node){
        if(node.left ==null && node.right==null){
            return null;
        }else if(node.left==null){
            return node.right;
        }else if(node.right==null){
            return node.left;
        }else{
            TreeNode successor = node.right;

            if(successor.left==null){
                successor.left = node.left;
            }else{
                TreeNode parent = node;
                while(successor.left!=null){
                    parent = successor;
                    successor = successor.left;
                }
                parent.left = successor.right;
                successor.left = node.left;
                successor.right = node.right;
            }
            return successor;
        }
    }

    public static void main(String[] args) {
        TreeNode two = new TreeNode(2,null,null);
        TreeNode four = new TreeNode(4,null,null);
        TreeNode seven = new TreeNode(7,null,null);
        TreeNode six = new TreeNode(6,null,seven);
        TreeNode three = new TreeNode(3,two,four);
        TreeNode five = new TreeNode(5,three,six);
        deleteNode(five, 3);
        System.out.println(five.val);
    }

}
