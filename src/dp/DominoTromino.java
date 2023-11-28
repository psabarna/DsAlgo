package dp;

public class DominoTromino {
    public static int numTilings(int n) {
        int MOD = 1000000007;
        if(n<=2){
            return n;
        }
        int[][] dp = new int[n+1][4];
        //dp[1][0] = 1;
        //dp[1][1] = 1;
        //dp[1][2] = 1;

        dp[0][3] = 1;
        dp[1][3] = 1;
        dp[2][0] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[2][3] = 2;


        for(int i =3; i<=n; i++){
            dp[i][0]  = (dp[i-1][3]);

            dp[i][1] = (dp[i-1][2]+ dp[i-1][0]);

            dp[i][2] = (dp[i-1][1] + dp[i-1][0]);

            dp[i][3] = (dp[i-1][3] + dp[i-1][1] + dp[i-1][2]+ dp[i-1][0]);
        }
        return (int)(dp[n][3] % MOD);
    }

    public static void main(String[] args) {
        
    }


}
