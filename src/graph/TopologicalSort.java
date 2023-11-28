package graph;

import java.util.*;


public class TopologicalSort {

    public static List<Integer> [] buildAdjacency(int vertices, int[][] edges){
        List<Integer> [] adjacency = new List[vertices];
        for(int i =0; i<vertices; i++){
            adjacency[i] = new ArrayList<>();
        }

        for(int[] edge: edges){
            adjacency[edge[0]].add(edge[1]);
        }
        return adjacency;
    }
    //DFS based
    public static List<Integer> sortUsingDFS(int vertices, int[][] edges){
        List<Integer> sortedOrder = new ArrayList<>();
        List<Integer> [] adjacency = buildAdjacency(vertices, edges);
        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();
        for(int i =0; i< vertices; i++){
            dfs(adjacency, i, visited, stack);
        }
        while(!stack.isEmpty()) {
            sortedOrder.add(stack.pop());
        }
        return sortedOrder;
    }

    public static List<Integer> [] buildGraph(int vertices, int[][] edges, Map<Integer, Integer> indegree){

        List<Integer> [] adjacency = new List[vertices];
        for(int i =0; i<vertices; i++){
            indegree.put(i,0);
            adjacency[i] = new ArrayList<>();
        }

        for(int[] edge: edges){
            indegree.put(edge[1], indegree.get(edge[1])+1);
            adjacency[edge[0]].add(edge[1]);
        }
        return adjacency;
    }

    //Using indegree
    public static List<Integer> sortUsingKahns(int vertices, int[][] edges){
        List<Integer> sortedOrder = new ArrayList<>();
        Map<Integer,Integer> indegreeMap = new HashMap<>();
        List<Integer> [] adjacency = buildGraph(vertices, edges, indegreeMap);
        Queue<Integer> sources =  new ArrayDeque<>();
        //build sources
        for(Map.Entry<Integer,Integer> entry: indegreeMap.entrySet()){
            if(entry.getValue()==0){
                sources.add(entry.getKey());
            }
        }

        while(!sources.isEmpty()){
            int vertex = sources.poll();
            sortedOrder.add(vertex);
            for(int adj : adjacency[vertex] ){
                indegreeMap.put(adj, indegreeMap.get(adj)-1);
                if(indegreeMap.get(adj) == 0){
                    sources.add(adj);
                }
            }
        }

        return sortedOrder;
    }

    public static void dfs(List<Integer>[] adjacency, int vertex, boolean[] visited, Stack<Integer> stack){
        if(visited[vertex]) {
            return;
        }

        visited[vertex] = true;
        for(Integer end: adjacency[vertex]){
            dfs(adjacency, end, visited, stack );
        }
        stack.push(vertex);

    }

    public static void main(String[] args) {
        int[][] edges = null;//{{3,2}, {3,0}, {2,0}, {2,1}};
        List<Integer> sorted = null;

       /* sorted = sortUsingDFS(4,edges);
        print(sorted);
        edges = new int[][]{{4,2}, {4,3}, {2,0}, {2,1}, {3,1}};
        sorted = sortUsingDFS(5,edges);
        */
        //edges = new int[][]{{6,4}, {6,2}, {5,3}, {5,4}, {3,0}, {3,1}, {3,2}, {4,1}};


        edges = new int[][]{{0,3},{0,1},{1,2}, {2,3}, {4,3}, {4,5}, {5,6}, {4,6} } ;
        //edges = new int[][]{{5,2},{5,0},{4,0}, {4,1}, {2,3}, {3,1} } ;

        sorted = sortUsingDFS(7,edges);

        print(sorted);

        sorted = sortUsingKahns(7,edges);
        print(sorted);

    }
    public static void print(List<Integer> sorted){
        System.out.println();
        sorted.stream().forEach(System.out::print);
    }
}
