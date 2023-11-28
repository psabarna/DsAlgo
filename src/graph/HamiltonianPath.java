package graph;

import java.util.ArrayList;
import java.util.List;

public class HamiltonianPath {

    public static void hamiltonian(ArrayList<Edge>[] graph, List<Integer> visited, String psf, int source, int start){
        visited.add(source);
        if(visited.size()== graph.length){
            boolean closingFound = false;
            for(Edge edge: graph[source]){
                if(edge.dest== start){
                    closingFound = true;
                }
            }
            psf+=closingFound? "*": ".";
            System.out.println(psf);
        }


        for(Edge edge: graph[source]) {
            if(!visited.contains(edge.dest)) {
                hamiltonian(graph, visited, psf + " " + edge.dest, edge.dest, start);
            }
        }

        visited.remove(visited.size()-1);
    }
    
    
    public static void main(String[] args) {
        ArrayList<Edge>[] arrayLists = loadGraph();
        List<Integer> visited = new ArrayList<>();
        for(int i =0; i< arrayLists.length; i++) {
            hamiltonian(arrayLists, visited, i+"", i, i);
        }
    }

    private static ArrayList<Edge>[] loadGraph(){

        int[][][] input = {{{0,1},{0,3}, {0,6}},
                {{1,0},{1,2}},
                {{2,1},{2,3}},
                {{3,0},{3,2},{3,4}},
                {{4,3},{4,5},{4,6}},
                {{5,4},{5,6}},
                {{6,5},{6,4}, {6,0}},
        };
        ArrayList<Edge>[] graph = new ArrayList[input.length];
        for(int i =0; i< input.length; i++){
            int[][] edges = input[i];
            ArrayList<Edge> edgeList = new ArrayList<>();
            for(int[] edge: edges) {
                edgeList.add(new Edge(edge[0], edge[1]));
            }
            graph[i] = edgeList;
        }
        return graph;
    }

    static class Edge{
        int src;
        int dest;


        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;

        }
    }
}
