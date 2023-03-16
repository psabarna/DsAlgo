package grokking.twopointers.challenge;

import java.util.*;

public class QuadrupleSum {
    //THis one would work well if array has unique numbers
    public static List<List<Integer>> searchQuadruple(int[] input, int target){
        List<List<Integer>> quadruples = new ArrayList<>();
        Map<Integer, List<List<Integer>>> sums = new HashMap<>();

        for(int i =0; i< input.length-1; i++){
            for(int j = i+1; j< input.length; j++ ){
                int sum = input[i]+input[j];
                if(sums.containsKey(target-sum)){
                    for(List<Integer> pairs: sums.get(target-sum)) {
                        List<Integer> quadruple = new ArrayList<>();
                        quadruple.addAll(pairs);
                        quadruple.add(input[i]);
                        quadruple.add(input[j]);
                        quadruples.add(quadruple);
                    }
                }

            }

            for(int k =0; k<i; k++){
                List<List<Integer>> pairList = sums.getOrDefault(input[k]+input[i],new ArrayList<>());
                pairList.add(Arrays.asList(input[k], input[i]));
                sums.put(input[k]+input[i],pairList);
            }

        }
        return quadruples;
    }

    /**
     *
     * @param input
     * @param target
     * @return
     */
    public static List<List<Integer>> searchQuadruple1(int[] input, int target){
        List<List<Integer>> quadruples = new ArrayList<>();
        Arrays.sort(input);
        for(int i =0; i< input.length-3; i++){
            if(i>0 && input[i] == input[i-1]){
                continue;
            }
            for(int j = i+1; j< input.length-2; j++ ){
                if( j>i+1 && input[j] == input[j-1]){
                    continue;
                }
                searchPairs(input, i, j, target, quadruples);
            }
        }
        return quadruples;
    }

    public static void searchPairs(int[] input, int first, int second, int target, List<List<Integer>> quadruples){
        int low = second+1;
        int high = input.length-1;
        while(low<high){

            while(low<high && low>second+1 && input[low] == input[low-1]){
                low++;
            }
            while(low<high && high< input.length-1 && input[high] == input[high+1]){
                high--;
            }
            int sum = input[first]+input[second]+input[low]+input[high];
            if( sum== target){
                quadruples.add(Arrays.asList(input[first],input[second],input[low],input[high]));
                low++;
                high--;
            }else if(sum<target){
                low++;
            }else{
                high--;
            }
        }
    }
    public static void main(String[] args) {
        int[] input = {4, 1, 2, -1, 1, -3};
        List<List<Integer>> quadruples = searchQuadruple1(input, 1);
        for(List<Integer> quadruple: quadruples){
            System.out.println(quadruple);
        }
    }
}
