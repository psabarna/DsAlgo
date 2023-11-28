package graph;

import java.util.*;

public class ReconstructSequence {

    public static boolean canConstructOriginal(int[] original, int[][] subs){
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer,Integer> inDegree =  new HashMap<>();

        for(int [] sub: subs){
            for(int i =0; i< sub.length; i++) {
                graph.putIfAbsent(sub[i], new ArrayList<>());
                inDegree.putIfAbsent(sub[i], 0);
            }
        }
        //build graph
        for(int [] sub: subs){
            for(int i =0; i< sub.length-1; i++){
                graph.get(sub[i]).add(sub[i+1]);
                inDegree.put(sub[i+1], inDegree.get(sub[i+1])+1);
            }
        }
        //Find all sources
        Queue<Integer> sources = new LinkedList<>();
        for(Map.Entry<Integer,Integer> entry : inDegree.entrySet()){
            if(entry.getValue()==0){
                sources.add(entry.getKey());
            }
        }
        List<Integer> sortedOrder = new ArrayList<>();
        while(!sources.isEmpty()){
            //if source is more than 1 at any point it leads to multiple combinations
            if(sources.size()>1){
                return false;
            }
            int vertex = sources.poll();
            //check if mismatch at in next source and original seq
            if(original[sortedOrder.size()] != vertex){
                return false;
            }
            sortedOrder.add(vertex);
            for(int adj : graph.get(vertex) ){
                inDegree.put(adj, inDegree.get(adj)-1);
                if(inDegree.get(adj) == 0){
                    sources.add(adj);
                }
            }
        }

        return sortedOrder.size()==original.length;
    }

    public static Queue<Integer> cloneQueue(Queue<Integer> sources){
        Queue<Integer> clone = new LinkedList<>();
        for(Integer num: sources){
            clone.add(num);
        }
        return clone;
    }

    public static void main(String[] args) {
        boolean res = canConstructOriginal(new int[]{1,2,3,4}, new int[][]{new int[]{1,2}, new int[]{2,3}, new int[]{3,4}});
        System.out.println(res);
    }
}
