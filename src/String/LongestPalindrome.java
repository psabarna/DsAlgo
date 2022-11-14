package String;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {

  public static int longestPalindrome(String s) {
    Map<Character, Integer> cfm = new HashMap<>();
    for(Character c: s.toCharArray()){
      cfm.put(c, cfm.getOrDefault(c, 0)+1);
    }
    int noOfOdds = 0;
    for(Map.Entry<Character,Integer> entry: cfm.entrySet()){
      if((entry.getValue()%2) != 0){
        noOfOdds+=1;
      }
    }

    return s.length()-noOfOdds+1;
  }
  public static void main(String[] args) {
    String input = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
    System.out.println(longestPalindrome(input));
  }
}
