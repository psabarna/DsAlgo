package algo.expert.array.medium;

import java.util.*;

/**
 * Given an array of numbers and a target sum, find all distinct triplets whose sum is the target
 * Numbers in each triplet should be in order and triplets themselves should be in order
 */

public class ThreeNumberSum {

    //O(n^2) time
    public static  List<int[]> findCombinations2(int[] arr, int target){
        Arrays.sort(arr);

        List<int[]> combinations = new ArrayList<>();
        Set<Integer> set = new HashSet<Integer>();
        for(int i =0; i<arr.length; i++){
            for(int j=i+1; j< arr.length; j++){
                if(set.contains(target - arr[i]- arr[j])){
                    int[] comb = new int[]{target - arr[i]- arr[j], arr[i], arr[j]};
                    //Arrays.sort(comb);
                    combinations.add(comb);
                }
            }
            set.add(arr[i]);
        }
        Collections.reverse(combinations);
        return combinations;
    }

    public static  List<int[]> findCombinations3(int[] arr, int target){
        Arrays.sort(arr);

        List<int[]> combinations = new ArrayList<>();

        for(int i =0; i<arr.length-2; i++){
            int start = i+1;
            int end = arr.length-1;
            while(start < end){
                if(target == (arr[i]+ arr[start]+ arr[end])){
                    int[] comb = new int[]{arr[i], arr[start], arr[end]};
                    combinations.add(comb);
                    start++;
                    end--;
                }else if(target >(arr[i]+ arr[start]+ arr[end])){
                    start++;
                }else{
                    end--;
                }
            }

        }

        return combinations;
    }

    //BruteForce
    //O(n^3) time
    public static  List<int[]> findCombinations1(int[] arr, int target){
        Arrays.sort(arr);
        List<int[]> combinations = new ArrayList<>();
        for(int i =0; i<arr.length; i++){
            for(int j=i+1; j< arr.length; j++){
                for(int k=j+1; k<arr.length; k++){
                    if((arr[k]+ arr[i]+ arr[j])== target){
                        int[] comb = new int[]{arr[i], arr[j], arr[k]};
                        //Arrays.sort(comb);
                        combinations.add(comb);
                    }
                }

            }

        }
        return combinations;
    }

    public static void main(String[] args){
        int[] arr = {-3,0,1,2,-1,1,-2};//{12, 3, 1, 2, -6, 5, -8, 6};
        List<int[]> combs = findCombinations1(arr, 0);
        for(int[] comb: combs){
            System.out.println(comb[0]+" "+comb[1]+ " "+comb[2]);
        }
    }
}
