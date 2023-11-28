package algo.leet;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {

        public static boolean checkInclusion(String s2, String s1) {
            for(int i =0; i<=(s1.length()-s2.length()); i++){
                String sub = s1.substring(i, i+s2.length());
                System.out.println("s1 = "+sub+"s2 = "+s2);
                if(isPermutation(sub, s2)){
                    return true;
                }

            }
            return false;

        }
        public static boolean isPermutation(String s2, String s1){

            Map<Character, Integer> map = new HashMap<>();
            for(char c: s1.toCharArray()){
                map.put(c,map.getOrDefault(c,0)+1);
            }
            for(char c: s2.toCharArray()){
                map.put(c,map.getOrDefault(c,0)-1);
                if(map.get(c)==0){
                    map.remove(c);
                }
            }
            System.out.println(map.size());
            return map.size()>0? false: true;

        }

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab","eidbaooo"));
    }

}
