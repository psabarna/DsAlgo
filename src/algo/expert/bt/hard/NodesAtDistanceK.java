package algo.expert.bt.hard;

import java.util.*;

public class NodesAtDistanceK {
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public static ArrayList<Integer> findNodesDistanceK(BinaryTree tree, int target, int k) {
        // Write your code here.
        Map<BinaryTree, BinaryTree> parents = new HashMap<>();
        findParents(tree, null, parents);

        BinaryTree targetNode = findTarget(tree, target);
        if(targetNode!=null) {
            return nodesAtDistanceK(targetNode, parents, k);
        }
        return  new ArrayList<>();
    }
    public static ArrayList<Integer> nodesAtDistanceK(BinaryTree target, Map<BinaryTree,BinaryTree> parentMap, int k){
        ArrayList<Integer> nodesAtKDistance =  new ArrayList<>();
        ArrayDeque<NodeDistance> queue = new ArrayDeque<>();
        queue.add(new NodeDistance(target,0));
        Set<BinaryTree> visited = new HashSet<>();
        while(queue.size()>0){
            NodeDistance node  = queue.pollFirst();
            if(node.node!=null && !visited.contains(node.node)) {

                if (node.distance == k) {
                    nodesAtKDistance.add(node.node.value);
                } else {
                    if(!visited.contains(node)) {
                        if (node.node.left != null && !visited.contains(node.node.left)) {
                            queue.add(new NodeDistance(node.node.left, node.distance + 1));
                        }
                        if (node.node.right != null && !visited.contains(node.node.right)) {
                            queue.add(new NodeDistance(node.node.right, node.distance + 1));
                        }
                        if (parentMap.getOrDefault(node.node, null) != null && !visited.contains(parentMap.get(node.node))) {
                            queue.add(new NodeDistance(parentMap.get(node.node), node.distance + 1));
                        }
                    }
                }
                visited.add(node.node);
            }
        }
        return nodesAtKDistance;
    }
    static class NodeDistance{
        BinaryTree node;
        int distance;

        public NodeDistance(BinaryTree node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
    public static BinaryTree findTarget(BinaryTree tree, int target){
            BinaryTree result =null;
            if(tree.value == target){
                 result = tree;
            }
            if(result == null && tree.left!=null) {
                 result =findTarget(tree.left, target);
            }
            if(result == null && tree.right!=null) {
               result =  findTarget(tree.right, target);
            }
        return  result;
    }

    public static void findParents(BinaryTree node, BinaryTree parent, Map<BinaryTree,BinaryTree> parents){
        if(node!=null){
            parents.put(node, parent);
            findParents(node.left, node, parents);
            findParents(node.right, node, parents);
        }
    }

    public static void main(String[] args) {
        /*BinaryTree root = new BinaryTree(1);
        root.right = new BinaryTree(3);
        root.left = new BinaryTree(2);
        root.left.left = new BinaryTree(4);
        root.left.right = new BinaryTree(5);
        root.right.right = new BinaryTree(6);
        root.right.right.left = new BinaryTree(7);
        root.right.right.right = new BinaryTree(8);*/

        BinaryTree root = new BinaryTree(1);

        root.left = new BinaryTree(2);
        root.left.left = new BinaryTree(3);
        root.left.left.left = new BinaryTree(4);
        root.left.left.left.left = new BinaryTree(5);

        int target = 2;
        int k = 3;
        List<Integer> kDistanceNodes = findNodesDistanceK(root, target, k);
        for(Integer n: kDistanceNodes){
            System.out.println(n);
        }
    }

}
