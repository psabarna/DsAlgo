package grokking.slidingwindow.hard;

import java.util.HashMap;
import java.util.Map;

public class CharacterReplacement {

    public static int findLength(String str, int k){
        int start = 0, end =0;
        Map<Character, Integer> charFreq = new HashMap<>();
        int largestFreq = 0;
        int maxLength = 0;
        while(end<str.length()){
            char c = str.charAt(end);
            charFreq.put(c, charFreq.getOrDefault(c, 0)+1);
            largestFreq = Math.max(largestFreq, charFreq.get(c));

            while(end-start+1 -largestFreq>k){
                char c2 = str.charAt(start);
                charFreq.put(c2,charFreq.get(c2)-1);
                start++;
            }
            maxLength = Math.max(maxLength, end-start+1);
            end++;
        }
        return maxLength;
    }

    public static void main(String[] args) {

    }
}
