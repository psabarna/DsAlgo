package dp;

/**
 * Find the ways a 2/N surface can be tiled using tiles of shape 2/1(domino)
 */
public class DominoTiling {
  public static int noOfWaysTiling(int n){
    int[] dp = new int[n+1];
    dp[1] = 1;
    dp[2] = 2;
    for (int i = 3; i<=n; i++){
      dp[i] = dp[i-1] + dp[i-2];
    }
    return dp[n];
  }

  public static void main(String[] args) {
    System.out.println(noOfWaysTiling(4));
  }
}
