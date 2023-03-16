package grokking.slidingwindow.hard;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubString {
    public static String minWindowSubStr(String str, String pattern){

        Map<Character, Integer> targetMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();
        int start =0, end =0, match = 0;
        String minWindow = "";
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

            while(match==targetMap.size()){
                if(minWindow.length()==0 || minWindow.length()> end-start+1){
                    minWindow = str.substring(start, end+1);
                }
                char c2= str.charAt(start);
                if(targetMap.containsKey(c2)) {
                    windowMap.put(c2, windowMap.get(c2) - 1);
                    if (!targetMap.get(c2).equals(windowMap.get(c2))) {
                        match--;
                    }
                }
                start++;
            }

            end++;
        }
        return minWindow;
    }
    public static void main(String[] args) {
        System.out.println(minWindowSubStr("aabdec","abc"));
    }
}
