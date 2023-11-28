package dp;
/*
Find number of ways you can tile a surface 3/N with dominos(2/1)
 */
public class DominoTiling3 {

  public static int tilingWayCount(int n) {
    int[][] dp = new int[n+1][8];
    dp[0][7] = 1;
    for(int i =1; i<=n; i++){
      dp[i][0] += dp[i-1][7];
      dp[i][1] += dp[i-1][6];
      dp[i][2] += dp[i-1][5];
      dp[i][3] += dp[i-1][4];

      dp[i][4] += dp[i-1][7];
      dp[i][4] += dp[i-1][3];

      dp[i][5] += dp[i-1][2];

      dp[i][6] += dp[i-1][7];
      dp[i][6] += dp[i-1][1];

      dp[i][7] += dp[i-1][6];
      dp[i][7] += dp[i-1][4];
      dp[i][7] += dp[i-1][0];
    }
    return dp[n][7];
  }


  public static void main(String[] args) {
    System.out.println(tilingWayCount(6));
  }

}
