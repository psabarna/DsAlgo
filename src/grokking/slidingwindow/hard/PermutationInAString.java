package grokking.slidingwindow.hard;

import java.util.HashMap;
import java.util.Map;

public class PermutationInAString {
    public static boolean findPermutation(String str, String target){
        Map<Character, Integer> targetMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();
        int start =0, end =0, match = 0;
        for (char c: target.toCharArray()){
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

            while(end-start+1>target.length()){
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
                return true;
            }
            end++;
        }
        return false;
    }
    public static void main(String[] args) {

        System.out.println(findPermutation("bcdxabcdy","bcdyabcdx"));
    }
}
