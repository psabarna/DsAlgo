package algo.expert.recursion.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * No of ways you can ride a staircase from 0th step to given target step if you are allowed to take maximum kth step(i.e 1, 2,3 .. upto k-1 step in one go)
 */

public class StairCase {
    //O(k^n) time O(n) Space
    public static int noOfWaysToRide(int target, int maxStep){
        if(target<0){
            return 0;
        }else if(target==1 || target ==0){
            return 1;
        }else{
            int ways = 0;
            int i =1;
            while (i<=maxStep){
                ways+=noOfWaysToRide(target-i, maxStep);
                i++;
            }
            return ways;
        }
    }

    //With Memoization
    //O(k*n) time O(n) Space
    public static int noOfWaysToRide1(int target, int maxStep, Map<Integer,Integer> stepMap){
        if(stepMap.containsKey(target)){
            return stepMap.get(target);
        }else if(target<0){
            return 0;
        } else{
            int ways = 0;
            int i =1;
            while (i<=maxStep){
                ways+=noOfWaysToRide(target-i, maxStep);
                i++;
            }
            stepMap.put(target, ways);
            return ways;
        }
    }


    //With Tabulation
    //O(n*k) time, O(n) space
    public static int noOfWaysToRide3(int target, int maxStep){
        int[] tab = new int[target+1];
        tab[0]=1;
        //tab[1]=1;

        for(int i =1; i<=target; i++){
            int ways =0;
           for(int j =1; j<=maxStep; j++){
               if(i-j >=0){
                   ways+= tab[i-j];
               }
           }
            tab[i] = ways;
        }
        return tab[target];
    }

    public static void main(String[] args) {
        System.out.println(noOfWaysToRide(4, 3));
        Map<Integer,Integer> stepMap = new HashMap<>();
        stepMap.put(0,1);
        stepMap.put(1,1);

        System.out.println(noOfWaysToRide1(4, 3, stepMap));
        System.out.println(noOfWaysToRide3(4, 3));

    }
}
