package grokking.cyclicsort.challenge;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FirstKMissing {

    public static List<Integer> findFirstKMissing(int[] nums, int k){
        int i =0;
        List<Integer> missingNums = new ArrayList<>();
        while(i< nums.length){
            int num = nums[i];
            if(num-1!=i){
                if(num>0 && num<nums.length && num != nums[num-1]) {
                    nums[i] = nums[num - 1];
                    nums[num - 1] = num;
                }else{
                    i++;
                }
            }else {
                i++;
            }
        }
        Set<Integer> extraNumbers = new HashSet<>();
        for(i =0; i< nums.length; i++){
            if(nums[i]!=i+1){
                missingNums.add( i+1);
                extraNumbers.add(nums[i]);
                if(missingNums.size()==k){
                    break;
                }
            }
        }
        while(missingNums.size()<k){
            if(!extraNumbers.contains(i+1)) {
                missingNums.add(i + 1);
            }
            i++;
        }
        return missingNums;
    }

    public static void main(String[] args) {
        int[] input = {3,-1,4,5,5};
        List<Integer> missingNums = findFirstKMissing(input,3);
        for(int k: missingNums) {
            System.out.print(k +" ");
        }
    }
}
