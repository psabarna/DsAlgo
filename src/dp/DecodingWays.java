package dp;

public class DecodingWays {
  public static int numDecodings(String s) {

    return numDecodings(s, 0);
  }

  public static  int numDecodings(String s, int idx) {
    if(idx> s.length()){
      return 0;
    }
    if(idx==s.length()){
      return 1;
    }
    int ways = 0;
    ways+=numDecodings(s, idx+1);

    if(idx!= s.length()-1 && s.charAt(idx)>'0' && s.charAt(idx)<3
        && s.charAt(idx+1)<7){
      ways += numDecodings(s, idx+2);
    }
    return ways;
  }

  public static void main(String[] args) {
    System.out.println(numDecodings("12"));
  }

}
