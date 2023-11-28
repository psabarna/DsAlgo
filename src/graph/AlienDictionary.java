package graph;

import java.util.*;

public class AlienDictionary {

    public static String findOrder(String[] words){
        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character,Integer> inDegree =  new HashMap<>();
        for (String word: words){
            for(char c: word.toCharArray()){
                graph.put(c, new ArrayList<>());
                inDegree.put(c, 0);
            }


        }
        //build graph
        for(int i =0; i< words.length-1; i++){
            String w1 = words[i]; String w2 = words[i+1];
            int minLength = Math.min(w1.length(), w2.length());
            for(int j =0; j< minLength; j++){
                if(w1.charAt(j)!=w2.charAt(j)){
                    graph.get(w1.charAt(j)).add(w2.charAt(j));
                    inDegree.put(w2.charAt(j), inDegree.get(w2.charAt(j))+1);
                    break;
                }
            }


        }
        //Find all sources
        Queue<Character> sources = new LinkedList<>();
        for(Map.Entry<Character,Integer> entry : inDegree.entrySet()){
            if(entry.getValue()==0){
                sources.add(entry.getKey());
            }
        }

        List<Character> sortedOrder = new ArrayList<>();

        while(!sources.isEmpty()){
            char vertex = sources.poll();
            sortedOrder.add(vertex);
            for(char adj : graph.get(vertex) ){
                inDegree.put(adj, inDegree.get(adj)-1);
                if(inDegree.get(adj) == 0){
                    sources.add(adj);
                }
            }
        }
        if(sortedOrder.size()!=inDegree.size()){
            return "";
        }
        return sortedOrder.toString();
    }


    public static void main(String[] args) {
        String[] input = null;
        input = new String[]{"ba", "bc", "ac", "cab"};
        System.out.println(findOrder(input));
        input = new String[]{"cab", "aaa", "aab"};
        System.out.println(findOrder(input));
        input = new String[]{"ywx", "wz", "xww", "xz", "zyy", "zwz"};
        System.out.println(findOrder(input));

    }
}
