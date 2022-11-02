package algo.expert.recursion.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowerSet {
    public static List<List<Integer>> powerSet(List<Integer> array) {
        // Write your code here.
        List<List<Integer>> powersets = new ArrayList<>();
        powerSetHelper(array, new ArrayList<>(), powersets);
        return powersets;
    }

    public static void powerSetHelper(List<Integer> array, List<Integer> current, List<List<Integer>> powerSet){
        if(array.size()==0){
            powerSet.add(current);
        }else {
            List<Integer> newArray = new ArrayList<>(array);
            newArray.remove(0);
            List<Integer> newCurrent = new ArrayList<>(current);
            powerSetHelper(newArray, current, powerSet);
            newCurrent.add(array.get(0));
            powerSetHelper(newArray, newCurrent, powerSet);
        }
    }

    public static List<List<Integer>> powerSet2(List<Integer> array) {
        // Write your code here.
        List<List<Integer>> powersets = new ArrayList<>();
        powerSetHelper(array, new ArrayList<>(), powersets);
        return powersets;
    }

    public static void powerSetHelper2(List<Integer>  arr, List<Integer> ss, int idx, List<List<Integer>> ps){
        ps.add(ss);
        if(ss.size() == ss.size()){
            return;
        }
        for(int i = idx; i< ss.size(); i++){

        }
    }

    public static void main(String[] args) {
        Integer[] numArray = {1,2,3};
        List<Integer> nums = Arrays.asList(numArray);
        List<List<Integer>> powers = powerSet(nums);

        for(List<Integer> power: powers){
            for (int num: power){
                System.out.print( num +" ");
            }
            System.out.println( );
        }
    }
}
