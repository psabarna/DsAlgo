package grokking.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubString {
        public static String minWindow(String s, String t) {
            if(t.length()>s.length()){
                return "";
            }
            Map<Character, Integer> source = new HashMap<>();
            Map<Character, Integer> target = new HashMap<>();
            for(char c: t.toCharArray()){
                target.put(c, target.getOrDefault(c, 0)+1);
            }

            int start=0, end =0;
            int match = 0;
            String mws = null;
            while(end<s.length()){
                char c = s.charAt(end);
                if(target.containsKey(c)){
                    source.put(c,source.getOrDefault(c,0)+1);
                    if(source.get(c).equals(target.get(c))){
                        match++;
                    }
                }
                end++;

                while(match==target.size()){
                    if(source.size()==target.size()){
                        if(mws==null || mws.length()>end-start){
                            mws = s.substring(start,end);
                        }
                    }

                    char c2 = s.charAt(start);
                    if(target.containsKey(c2)){
                        source.put(c2,source.get(c2)-1);
                        if(target.get(c2)-source.get(c2)>0){
                            match--;
                        }
                    }
                    start++;
                }
            }
            return mws;
        }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC",
                "ABC"));

    }

}
