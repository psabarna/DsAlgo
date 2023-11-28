package tree;

public class LCAInABST {

  

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      if(root==null){
        return null;
      }
      if(p.val>root.val && q.val>root.val){
        return lowestCommonAncestor(root.right, p, q);
      }else if(p.val<root.val && q.val<root.val){
        return lowestCommonAncestor(root.left, p, q);
      }else{
        return root;
      }

    }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(6);
    root.left = new TreeNode(2);
    root.right = new TreeNode(8);

    root.left.left = new TreeNode(0);
    root.left.right = new TreeNode(4);
    root.left.right.left = new TreeNode(3);
    root.left.right.right = new TreeNode(5);

    root.right.left = new TreeNode(7);
    root.right.right = new TreeNode(9);

    System.out.println(lowestCommonAncestor(root, root.left.right.left , root.left.right.right).val);

  }

}
