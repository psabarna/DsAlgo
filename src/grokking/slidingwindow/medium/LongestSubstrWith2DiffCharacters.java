package grokking.slidingwindow.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstrWith2DiffCharacters {

    public static String longestSubstr(String str, int distincts){
        int start = 0, end = 0, count =0;
        Map<Character, Integer> map = new HashMap<>();
        String max = "";
        while(end<str.length()){
            char c = str.charAt(end);
            map.put(c, map.getOrDefault(c, 0)+1);
            if(map.get(c)==1){
                count++;
            }
            end++;

            while(count>2){
                char c2 = str.charAt(start);
                map.put(c2, map.get(c2)-1);
                if(map.get(c2)==0){
                    count--;
                }
                start++;
            }

            if(count==distincts && end-start>max.length()){
                max = str.substring(start, end);
            }

        }
        return max;
    }
    public static void main(String[] args) {
        System.out.println(longestSubstr("aaaaaaabcddddd",2));
    }
}
