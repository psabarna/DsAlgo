package graph;

import java.util.ArrayList;
import java.util.List;

public class PathUsingDFS {
    static class Edge{
        int src;
        int dest;
        int weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static  boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited){
        visited[src] =true;
        if(src==dest){
            return true;
        }
        for(Edge edge: graph[src]){
            if(!visited[edge.dest]) {
                boolean hasPath = hasPath(graph, edge.dest, dest, visited);
                if (hasPath) {
                    return true;
                }
            }

        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Edge>[] graph = loadGraph();
        boolean[] visited = new boolean[graph.length];
        System.out.println(hasPath(graph, 0, 6, visited));
    }
    private static ArrayList<Edge>[] loadGraph(){

        int[][][] input = {{{0,1,10},{0,3,10}},
                {{1,0,10},{1,2,10}},
                {{2,1,10},{2,3,10}},
                {{3,0,10},{3,2,10},{3,4,10}},
                {{4,3,10},{4,5,10},{4,6,10}},
                {{5,4,10},{5,6,10}},
                {{6,5,10},{6,4,10}},
        };
        ArrayList<Edge>[] graph = new ArrayList[input.length];
        for(int i =0; i< input.length; i++){
            int[][] edges = input[i];
            ArrayList<Edge> edgeList = new ArrayList<>();
            for(int[] edge: edges) {
                edgeList.add(new Edge(edge[0], edge[1], edge[2]));
            }
            graph[i] = edgeList;
        }
        return graph;
    }
}
