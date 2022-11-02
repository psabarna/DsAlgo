package algo.expert.recursion.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {
    public static void buildPermutations(int[] arr, int curr, List<List<Integer>> permutations){
        if(curr == arr.length-1){
            permutations.add(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        }
        for(int i = curr; i<arr.length; i++){
            swap(arr, curr, i);
            buildPermutations(arr, curr+1, permutations);
            //backtracking since we need to go back to original form
            swap(arr, curr, i);
        }

    }


    public static void buildPermutations(List<Integer> arr, List<Integer> curr, List<List<Integer>> permutations){
        if(arr.size() == 0 && curr.size()>0){
            permutations.add(curr);
        }else {
            for (int i = 0; i < arr.size(); i++) {
                List<Integer> newCurr = new ArrayList<>(curr);
                newCurr.add(arr.get(i));
                List<Integer> newArr = new ArrayList<>(arr);
                newArr.remove(i);
                buildPermutations(newArr, newCurr, permutations);

            }
        }

    }
    public static void swap(int[] arr, int idx1, int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> permutations = new ArrayList<>();
        //buildPermutations(nums, 0, permutations);
        buildPermutations(Arrays.stream(nums).boxed().collect(Collectors.toList()), new ArrayList<>(), permutations);
        for(List<Integer> perm: permutations){
            for (int num: perm){
                System.out.print( num +" ");
            }
            System.out.println( );
        }
    }
}
