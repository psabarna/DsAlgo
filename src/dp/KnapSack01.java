package dp;

/**
 * Given N items where each item has some weight and profit associated with it and also given a bag with capacity W,
 * [i.e., the bag can hold at most W weight in it]. The task is to put the items into the bag such that the
 * sum of profits associated with them is the maximum possible.
 *
 * Ex: W = 4, profit[] = {1, 2, 3}, weight[] = {4, 5, 1}
 * It is not possible to put a part of an item into the bag
 *https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
 */

public class KnapSack01 {
    public static int maxProfitRec(int W, int wt[], int val[], int idx){
        if(idx>=wt.length){
            return 0;
        }
        int profit = 0 ;
        if(wt[idx]>W){
            profit =  maxProfitRec(W, wt, val, idx+1);
        }else{
            profit =  Math.max(maxProfitRec(W, wt, val, idx+1), val[idx]+maxProfitRec(W-wt[idx], wt, val, idx+1));
        }
        return profit;
    }

    public static int maxProfitMem(int W, int wt[], int val[], int idx, int[][] dp){
        if(idx>=wt.length){
            return 0;
        }
        int profit = 0 ;
        if(dp[idx][W] != -1) {
            if (wt[idx] > W) {
                profit = maxProfitRec(W, wt, val, idx + 1);
            } else {
                profit = Math.max(maxProfitMem(W, wt, val, idx + 1, dp), val[idx] + maxProfitMem(W - wt[idx], wt, val, idx + 1, dp));
            }
            dp[idx][W] = profit;
        }
        return profit;

    }

    public static int maxProfitBottomUp(int W, int wt[], int val[]){
        int[][] dp =  new int[wt.length+1][W+1];

        for(int i =1; i<= wt.length; i++){
            for(int j =1; j<=W; j++){
                if(wt[i-1]<=j){
                    dp[i][j] =  Math.max(dp[i-1][j], val[i-1]+dp[i-1][j-wt[i-1]] );
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[wt.length][W];

    }

    public static void main(String[] args) {
        int[] wt = {1, 2, 3};
        int[] value = {10, 15, 40};
        int W = 6;
        System.out.println(maxProfitRec(W, wt, value, 0));

        int[][] dp = new int[wt.length][W+1];
        System.out.println(maxProfitMem(W, wt, value, 0, dp));
        System.out.println(maxProfitBottomUp(W,wt, value));
    }

}
