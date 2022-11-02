package algo.expert.array.easy;

import java.util.*;

public class NonConstructibleChange {

    //Bruteforce
    //O(n^2) time, O(n^2) space
    public static int minNonconstructibleChange(int[] coins ){
        Set<Integer> uniqueCoins = new HashSet<Integer>();
        for (int coin: coins){
            List<Integer> newCoins = new ArrayList<Integer>();
            newCoins.add(coin);
            for(Integer uc: uniqueCoins){
                newCoins.add(coin+uc);
            }
            uniqueCoins.addAll(newCoins);
        }
        for(int i =1; i<Integer.MAX_VALUE; i++){
            if(!uniqueCoins.contains(i)){
                return i;
            }
        }
        return 0;
    }

    // O(nlog(n) time, O(1) space
    public static int minNonconstructibleChangeOptimal(int[] coins ){
        Arrays.sort(coins);
        int change =0;
        for (int coin: coins){
            if(coin>change+1){
                break;
            }
            change+=coin;
        }
        return change+1;
    }

    public static void main(String[] args){
        int[] coins = {5, 7, 1, 1, 2, 3, 22};
        System.out.println(minNonconstructibleChangeOptimal(coins));
    }
}
