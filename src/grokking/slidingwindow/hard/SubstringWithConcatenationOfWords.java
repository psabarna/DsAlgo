package grokking.slidingwindow.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfWords {
    public static List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> target = new HashMap<>();
        List<Integer> matches = new ArrayList<>();
        for(String word: words){
            target.put(word, target.getOrDefault(word, 0)+1);
        }
        int noOfWords = words.length;
        int wordSize =  words[0].length();

        int start=0;
        while(start<= s.length()- noOfWords*wordSize){
            Map<String, Integer> windowWords = new HashMap<>();
            for(int j=0; j<noOfWords; j++){
                String word = s.substring(start+j*wordSize, start+(j+1)*wordSize);
                windowWords.put(word, windowWords.getOrDefault(word,0)+1);
                if(windowWords.get(word) > target.getOrDefault(word,0)){
                    break;
                }
                if(j+1 == noOfWords){
                    matches.add(start);
                }
            }


            start++;
        }




        return matches;
    }

    public static void main(String[] args) {
        System.out.println(findSubstring("catfoxcat", new String[]{"cat", "fox"}));
    }
}
