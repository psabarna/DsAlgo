package graph;

import java.util.ArrayList;

public class SmallestWeightPath {
    static String smallestWeightPath = null;
    static int smallestWeight = Integer.MAX_VALUE;
    private static class Edge{
        int src;
        int dest;
        int weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static  void findSmallestPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, String psf, int wsf){
        visited[src] =true;
        if(src==dest){
            if(wsf<smallestWeight){
                smallestWeightPath = psf;
                smallestWeight = wsf;
            }
            //return;
        }
        for(Edge edge: graph[src]){
            if(!visited[edge.dest]) {
                findSmallestPath(graph, edge.dest, dest, visited, psf+edge.dest, wsf+edge.weight);

            }

        }
        visited[src] =false;
    }

    public static void main(String[] args) {
        ArrayList<Edge>[] graph = loadGraph();
        boolean[] visited = new boolean[graph.length];
        findSmallestPath(graph, 0, 6, visited, ""+0,0);
        System.out.println(smallestWeightPath+" with weight = " +smallestWeight);
    }
    private static ArrayList<Edge>[] loadGraph(){

        int[][][] input = {{{0,1,10},{0,3,40}},
                {{1,0,10},{1,2,10}},
                {{2,1,10},{2,3,10}},
                {{3,0,40},{3,2,10},{3,4,2}},
                {{4,3,2},{4,5,3},{4,6,8}},
                {{5,4,3},{5,6,3}},
                {{6,5,3},{6,4,8}},
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
