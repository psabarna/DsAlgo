package algo.expert.array.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of distinct numbers and a target number, find all quadraples that sum up to the target
 */
public class FourNumberSum {

    //Bruteforse
    //O(n^4) time
    public static List<int[]> fourNumberSum(int[] array, int targetSum) {
        List<int[]> quadraplets = new ArrayList<>();
        for(int i = 0; i< array.length; i++){
            for(int j = i+1; j< array.length; j++){
                for(int k = j+1; k< array.length; k++){
                    for(int l = k+1; l< array.length; l++){
                        if(array[i]+array[j]+array[k]+array[l] == targetSum){
                            quadraplets.add(new int[]{array[i],array[j],array[k],array[l]});
                        }
                    }
                }
            }
        }
        return quadraplets;
    }

    public static List<int[]> fourNumberSum1(int[] array, int targetSum) {
        List<int[]> quadraplets = new ArrayList<>();
        Map<Integer,List<int[]>> twoNumberSums = new HashMap<>();
        for(int i = 0; i< array.length; i++){
            for(int j = i+1; j< array.length; j++){
                int search = targetSum- array[i] - array[j];
                if(twoNumberSums.containsKey(search)){
                    for(int[] entry: twoNumberSums.get(search)){
                        quadraplets.add(new int[]{entry[0], entry[1], array[i], array[j]});
                    }
                }
            }
            for(int k =0; k<i; k++){
                int sum = array[k]+array[i];
                List<int[]> lists = twoNumberSums.getOrDefault(sum, new ArrayList<>());
                lists.add(new int[]{array[k], array[i]});
                twoNumberSums.put(sum, lists);
            }
        }
        return quadraplets;
    }

    public static void main(String[] args) {
        int[] input = {7, 6, 4, -1, 1, 2};
        List<int[]> quadraplets = fourNumberSum1(input, 16);
        for(int[] quadraple: quadraplets){
            for(int j: quadraple){
                System.out.print(j + " ");
            }
            System.out.println("");
        }

    }
}
