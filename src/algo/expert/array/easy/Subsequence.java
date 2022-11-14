package algo.expert.array.easy;

public class Subsequence {

  public boolean isSubsequence(String s, String t) {
    int i=0, j=0;
    while(i<s.length() && j<t.length()){
      if(s.charAt(i)==t.charAt(j)){
        j+=1;
      }
      i+=1;
    }
    return j == t.length();
  }

  public static void main(String[] args) {
    System.out.println("");
  }

}
