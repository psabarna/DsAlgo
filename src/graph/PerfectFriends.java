package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
https://www.pepcoding.com/resources/online-java-foundation/graphs/perfect-friends-official/ojquestion
 */
public class PerfectFriends {
    static class Edge{
        int src;
        int dest;


        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;

        }
    }
    static class DisjointUnion{
        int[] parent ;
        public DisjointUnion(int size){
            parent = new int[size];
            for(int i =0; i<size; i++){
                parent[i] = i;
            }
        }
        public void union(int u, int v){
            int p1 = find(u);
            int p2 = find(v);
            if(p1!=p2){
                parent[v] = p1;
            }
        }
        public int find(int u){
            int x = u;
            while(parent[x]!=x){
                x= parent[x];
            }
            parent[u] = x;
            return x;
        }
    }
    public static List<List<Integer>> findConnectedComponents(ArrayList<Edge>[] graph){
        DisjointUnion union = new DisjointUnion(graph.length);
        for(int i = 0; i < graph.length; i ++){
            ArrayList<Edge> edges = graph[i];
            for(int j = 0; j<edges.size(); j++){
                union.union(edges.get(j).src, edges.get(j).dest);
            }
        }
        Map<Integer, List<Integer>> connections = new HashMap<>();
        for(int i =0; i< union.parent.length; i++){
            List<Integer> conn = connections.getOrDefault(union.parent[i], new ArrayList<>());
            conn.add(i);
            connections.put(union.parent[i], conn);
        }
        return new ArrayList<>(connections.values());
    }
    public static int perfectFriendPairCount(ArrayList<Edge>[] graph){
        List<List<Integer>> components = findConnectedComponents(graph);
        int friendPairCount = 0;
        for(int i = 0; i< components.size(); i++){
            for(int j = i+1; j< components.size(); j++){
                friendPairCount += (components.get(i).size() * components.get(j).size());
            }
        }
        return friendPairCount;
    }


    public static void main(String[] args) {
        ArrayList<Edge>[] graph = loadGraph();
        System.out.println(perfectFriendPairCount(graph));
    }
    
    private static ArrayList<Edge>[] loadGraph(){

        int[][][] input = {{{0,1},{0,3}},
                {{1,0},{1,2}},
                {{2,1},{2,3}},
                {{3,0},{3,2}},
                {{4,5},{4,6}},
                {{5,4},{5,6}},
                {{6,5},{6,4}},
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
}
