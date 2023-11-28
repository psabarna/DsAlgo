package graph;

import java.util.*;

public class ConnectedComponents {
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

    //Using disjoint union
    public static int countComponents(ArrayList<Edge>[] graph){
        DisjointUnion union = new DisjointUnion(graph.length);
        for(int i = 0; i < graph.length; i ++){
            ArrayList<Edge> edges = graph[i];
            for(int j = 0; j<edges.size(); j++){
                union.union(edges.get(j).src, edges.get(j).dest);
            }
        }
        return (int)Arrays.stream(union.parent).distinct().count();

    }
    public static int countComponentsUsingDFS(ArrayList<Edge>[] graph){
        int count = 0;
        boolean[] visited =  new boolean[graph.length];
        for(int i =0; i< graph.length; i++){
            if(!visited[i]){
                count++;
                dfs(graph, visited, i);

            }
        }
        return count;
    }

    //Using disjoint union
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

    public static List<List<Integer>> findConnectedComponentsUsingDFS(ArrayList<Edge>[] graph){
        List<List<Integer>> components = new ArrayList<>();
        boolean[] visited =  new boolean[graph.length];
        for(int i =0; i< graph.length; i++){
            if(!visited[i]){
                List<Integer> component =  new ArrayList<>();
                dfs(graph, visited, component, i);
                components.add(component);
            }
        }
        return components;
    }
    //using dfs
    public static void dfs(ArrayList<Edge>[] graph, boolean[] visited, List<Integer> component, int src){
        if(!visited[src]) {
            visited[src] = true;
            component.add(src);
            for (Edge edge : graph[src]) {
                dfs(graph, visited, component,edge.dest);
            }
        }
    }

    public static void dfs(ArrayList<Edge>[] graph, boolean[] visited, int src){
        if(!visited[src]) {
            visited[src] = true;

            for (Edge edge : graph[src]) {
                dfs(graph, visited,edge.dest);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Edge>[] graph = loadGraph();
        boolean[] visited = new boolean[graph.length];

        //System.out.println(findConnectedComponentsCount(graph));

        List<List<Integer>> connectedComponents = findConnectedComponentsUsingDFS(graph);
        for(List<Integer> conn: connectedComponents){
            System.out.println();
            for(Integer i: conn){
                System.out.print(i+"->");
            }
        }
    }
    private static ArrayList<Edge>[] loadGraph(){

        int[][][] input = {{{0,1},{0,3}},
                {{1,0},{1,2}},
                {{2,1},{2,3}},
                {{3,0},{3,2},{3,4}},
                {{4,3},{4,5},{4,6}},
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
