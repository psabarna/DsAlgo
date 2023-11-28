package dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given N items where each item has some weight and profit associated with it and also given a bag with capacity W,
 * [i.e., the bag can hold at most W weight in it]. The task is to put the items into the bag such that the
 * sum of profits associated with them is the maximum possible.
 *
 * Ex: W = 4, profit[] = {1, 2, 3}, weight[] = {4, 5, 1}
 * It is not possible to put a part of an item into the bag
 *
 * Print the items put into the bag
 *https://www.geeksforgeeks.org/printing-items-01-knapsack/
 */

public class KnapSack01Print {


    public static List<Integer> maxProfitBottomUp(int W, int wt[], int val[]){
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
        List<Integer> bag =  new ArrayList<>();
        int i =  wt.length;
        int j = W;
        while(i>0 && j>0){

            if(dp[i][j] != dp[i-1][j]){ // This item contributed to the bag
                bag.add(wt[i-1]);
                j = j-wt[i-1];
            }
            i = i-1;
        }
        Collections.reverse(bag);
        return bag;

    }

    public static void main(String[] args) {
        int[] wt = {10, 20, 30};
        int[] value = {60,100,120};
        int W = 50;
        System.out.println(maxProfitBottomUp(W,wt, value));
    }

}
