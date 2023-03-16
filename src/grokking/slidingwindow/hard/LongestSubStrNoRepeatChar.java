package grokking.slidingwindow.hard;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStrNoRepeatChar {

    public static int findLongestNonRepeatSubStr(String input){
        Map<Character, Integer> charMap = new HashMap<>();
        int start=0;
        int end=0;
        int max = Integer.MIN_VALUE;
        while(end<input.length()){
            char c = input.charAt(end);
            charMap.put(c, charMap.getOrDefault(c,0)+1);

            while(charMap.size()<end-start+1){
                char c2= input.charAt(start);
                charMap.put(c2, charMap.get(c2)-1);
                if(charMap.get(c2)==0){
                    charMap.remove(c2);
                }
                start++;
            }
            if(charMap.size()== end-start+1 && end-start+1>max){
                max = end-start+1;
            }
            end++;
        }
        return max;
    }

    public static int findLongestNonRepeatSubStr1(String input){
        Map<Character, Integer> charIndexMap = new HashMap<>();
        int start=0;
        int end=0;
        int max = Integer.MIN_VALUE;
        while(end<input.length()){
            char c = input.charAt(end);
            if(charIndexMap.containsKey(c)){
                start = Math.max(charIndexMap.get(c)+1, start);
            }
            charIndexMap.put(c, end);
            max = Math.max(max, end-start+1);
            end++;
        }
        return max;
    }
    public static void main(String[] args) {
        System.out.println(findLongestNonRepeatSubStr1("abbbb"));
    }
}
