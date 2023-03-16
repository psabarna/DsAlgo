package grokking.slidingwindow.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramsInString {

    public static List<Integer> findAnagrams(String str, String pattern){
        List<Integer> anagramIdxList = new ArrayList<>();
        Map<Character, Integer> targetMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();
        int start =0, end =0, match = 0;
        for (char c: pattern.toCharArray()){
            targetMap.put(c, targetMap.getOrDefault(c,0)+1);
        }
        while(end<str.length()){
            char c = str.charAt(end);
            if(targetMap.containsKey(c)) {
                windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
                if (targetMap.get(c).equals(windowMap.get(c))){
                    match++;
                }
            }

            while(end-start+1>pattern.length()){
                char c2= str.charAt(start);
                if(targetMap.containsKey(c2)) {
                    windowMap.put(c2, windowMap.get(c2) - 1);
                    if (!targetMap.get(c2).equals(windowMap.get(c2))) {
                        match--;
                    }
                }
                start++;
            }
            if(match== targetMap.size()){
                anagramIdxList.add(start);
            }
            end++;
        }
        return anagramIdxList;

    }
    public static void main(String[] args) {
        System.out.println(findAnagrams("ppqp","pq"));
    }
}
