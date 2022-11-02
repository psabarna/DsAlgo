package algo.expert.recursion.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mnemonics {
    public static void getMnemonics(String pn, String curr, List<String> mnemonics, int idx, Map<Character,String> km){
        if(curr.length()==pn.length()){
            mnemonics.add(curr);
        }else{
            for (Character c: km.get(pn.charAt(idx)).toCharArray()){
                getMnemonics(pn, curr+c, mnemonics, idx+1, km);
            }
        }
    }

    public static void main(String[] args) {
        String pn = "1905";
        List<String> mnemonics =  new ArrayList<>();
        getMnemonics(pn, "", mnemonics, 0, getMap());
        for(String mnemonic: mnemonics){
            System.out.println(mnemonic);
        }
    }

    public static Map<Character,String> getMap(){

        Map<Character, String> map = new HashMap<>();
        map.put('1', "1" );
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        map.put('0',"0");
        return map;
    }
}
