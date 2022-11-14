package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import javax.swing.tree.TreeNode;

public class BTLevelOrderTraversal {
//using recursion
  public static List<List<Integer>> levelOrder1(TreeNode root) {
    List<List<Integer>> levelList = new ArrayList<>();
    if(root==null){
      return levelList;
    }

    Queue<TreeNode> parentQueue = new ArrayDeque<>();
    parentQueue.add(root);

    while(!parentQueue.isEmpty() ){
      List<Integer> levelNodes = new ArrayList<>();
      Queue<TreeNode> childQueue = new ArrayDeque<>();
      int queueLength = parentQueue.size();
      for(int i =0; i<queueLength ; i++){
        TreeNode node = parentQueue.poll();
        levelNodes.add(node.val);
        if(node.left!=null){
          childQueue.add(node.left);
        }
        if(node.right!=null){
          childQueue.add(node.right);
        }
      }
      levelList.add(levelNodes);
      parentQueue = childQueue;
    }
    return levelList;

  }
  public static List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> levelList = new ArrayList<>();
    if(root==null){
      return levelList;
    }

    Queue<TreeNode> parentQueue = new ArrayDeque<>();
    parentQueue.add(root);
    levelOrder(parentQueue, levelList);
    return levelList;

  }

  public static void levelOrder(Queue<TreeNode> parentQueue,List<List<Integer>> levelList) {
    List<Integer> levelNodes = new ArrayList<>();
    Queue<TreeNode> childQueue = new ArrayDeque<>();
    while(!parentQueue.isEmpty()){
      TreeNode node = parentQueue.poll();
      levelNodes.add(node.val);
      if(node.left!=null){
        childQueue.add(node.left);
      }
      if(node.right!=null){
        childQueue.add(node.right);
      }
    }
    levelList.add(levelNodes);
    if(!childQueue.isEmpty()) {
      levelOrder(childQueue, levelList);
    }

  }
  public static void main(String[] args) {
    TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20));
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);
    final List<List<Integer>> lists = levelOrder1(root);
    for(List<Integer> level : lists){
      for (Integer node : level){
        System.out.print(node +" ");
      }
      System.out.println();
    }

  }

  static class TreeNode {
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
}
