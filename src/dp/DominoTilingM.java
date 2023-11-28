package dp;

/**
 * Find the ways a M/N surface can be tiled using tiles of shape M/1(domino)
 */
public class DominoTilingM {
  public static int noOfWaysTiling(int n, int m){
    int[] dp = new int[n+1];

    for (int i = 1; i<=n; i++){
      if(i< m){
        dp[i] = 1;
      }else if(i ==m){
        dp[i] = 2;
      }else {
        dp[i] = dp[i - 1] + dp[i - m];
      }
    }
    return dp[n];
  }

  public static void main(String[] args) {
    System.out.println(noOfWaysTiling(4, 3));
  }
}
