package graph;

import java.util.*;

public class MinimumHeightTree {
    //TODO::Optimal Approach

    //Bruteforce, calculate the height considering every node as root
    private static List<Integer> minHeightRoots(int vertices, int[][] edges){

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i =0; i<vertices; i++){
            graph.put(i, new ArrayList<>());
        }
        for(int[] edge: edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int minHeight = Integer.MAX_VALUE;
        List<Integer> nodes = new ArrayList<>();
        for(int i =0; i< vertices; i++){
           int height = findHeight(graph, i);
           if(height>minHeight){
               continue;
           }
            if(height<minHeight){
                nodes.clear();
                minHeight = height;
            }
            nodes.add(i);

        }
        return nodes;
    }

    private static int findHeight( Map<Integer, List<Integer>> graph, int index){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.size()];
        queue.add(index);
        int height =0;
        while(!queue.isEmpty()){
            int length = queue.size();
            height++;
            while(length>0){
                int vertex = queue.poll();
                visited[vertex] = true;
                for(int v: graph.get(vertex)){
                    if(!visited[v]){
                        queue.offer(v);
                    }
                }
                length--;
            }
        }
        return height;
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1}, {1,2}, {1,3}, {2,4}};
        System.out.println(minHeightRoots(5, edges));
    }
}
