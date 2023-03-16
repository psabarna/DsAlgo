package grokking.slidingwindow.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstrWithKDistChar {
    public static int findLongestSubStrWithKDistinctChar(String str, int k){

        Map<Character, Integer> charMap = new HashMap<>();
        int start =0;
        int end = 0;
        int maxLength = Integer.MIN_VALUE;
        int count = 0;
        while(end<str.length()){
            char c = str.charAt(end);
            charMap.put(c, charMap.getOrDefault(c,0)+1);
            if(charMap.get(c).equals(1)){
                count++;
            }
            while(count>k){
                char c2 = str.charAt(start);
                charMap.put(c2, charMap.get(c2)-1);
                if(charMap.get(c2)==0){
                    count--;
                }
                start++;
            }
            if(count==k){
                maxLength = Math.max(maxLength, end-start+1);
            }
            end++;
        }

        return maxLength;
    }
    public static void main(String[] args) {
        System.out.println(findLongestSubStrWithKDistinctChar("cbbebi", 3));
    }
}
