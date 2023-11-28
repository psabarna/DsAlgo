package graph;

import java.util.*;

public class AllTopologicalPath {
    public static void printOrders(int tasks, int[][] prerequisites){
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer,Integer> inDegree =  new HashMap<>();
        for (int i =0;i< tasks; i++){
            graph.put(i, new ArrayList<>());
            inDegree.put(i, 0);

        }
        //build graph
        for(int [] edge: prerequisites){
            graph.get(edge[0]).add(edge[1]);
            inDegree.put(edge[1], inDegree.get(edge[1])+1);
        }
        //Find all sources
        Queue<Integer> sources = new LinkedList<>();
        for(Map.Entry<Integer,Integer> entry : inDegree.entrySet()){
            if(entry.getValue()==0){
                sources.add(entry.getKey());
            }
        }
        List<Integer> sortedOrder = new ArrayList<>();

        printAllTopologicalOrders(graph, sources, inDegree, sortedOrder);
    }
    public static Queue<Integer> cloneQueue(Queue<Integer> sources){
        Queue<Integer> clone = new LinkedList<>();
        for(Integer num: sources){
            clone.add(num);
        }
        return clone;
    }
    public static void printAllTopologicalOrders(Map<Integer,List<Integer>> graph, Queue<Integer> sources, Map<Integer,Integer> inDegree, List<Integer> sortedOrder){
        if(!sources.isEmpty()){
            for(Integer vertex: sources){
                sortedOrder.add(vertex);
                Queue<Integer> clone = cloneQueue(sources);
                clone.remove(vertex);
                List<Integer> children = graph.get(vertex);
                for(int child: children){
                    inDegree.put(child, inDegree.get(child)-1);
                    if(inDegree.get(child)==0){
                        clone.add(child);
                    }
                }
                printAllTopologicalOrders(graph, clone, inDegree, sortedOrder);
                sortedOrder.remove(sortedOrder.size()-1);
                for(int child: children){
                    inDegree.put(child, inDegree.get(child)+1);
                }
            }
        }

        if(sortedOrder.size()==inDegree.size()){
            System.out.println(sortedOrder);
        }

    }
    public static void main(String[] args) {

        int[][] edges = null;
        List<Integer> sorted = null;

       /*
       edges = new int[][]{{3,2}, {3,0}, {2,0}, {2,1}};
       sorted = sortUsingDFS(4,edges);
        print(sorted);
        edges = new int[][]{{4,2}, {4,3}, {2,0}, {2,1}, {3,1}};
        sorted = sortUsingDFS(5,edges);
        */
        //edges = new int[][]{{6,4}, {6,2}, {5,3}, {5,4}, {3,0}, {3,1}, {3,2}, {4,1}};


        edges = new int[][]{{0,3},{0,1},{1,2}, {2,3}, {4,3}, {4,5}, {5,6}, {4,6} } ;
        //edges = new int[][]{{5,2},{5,0},{4,0}, {4,1}, {2,3}, {3,1} } ;
        printOrders(7, edges);

    }
}
