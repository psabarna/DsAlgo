package grokking.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStrofUniqueChars {
    public static int lengthOfLongestSubstring(String s) {

        int start=0, end =0;
        int counter=0;// no of repeating chars
        Map<Character, Integer> chars = new HashMap<>();
        int maxUnique=0;
        while(end<s.length()){
            char c = s.charAt(end);
            chars.put(c, chars.getOrDefault(c,0)+1);
            if(chars.get(c)>1){
                counter++;
            }
            end ++;


            while(counter>0){
                char c2 = s.charAt(start);
                if(chars.get(c2)>1){
                    counter --;
                }
                chars.put(c2,chars.get(c2)-1);
                start++;
            }
            if(end-start>maxUnique){
                maxUnique = end-start;
            }
        }
        return maxUnique;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("aab"));
    }
}
