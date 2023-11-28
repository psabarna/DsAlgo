package grokking.cyclicsort.easy;

import java.util.ArrayList;
import java.util.List;

// 542310
//
public class FindAllDuplicateNumbers {
    public static List<Integer> findAllDuplicates(int[] nums){
        int i =0;
        List<Integer> duplicates = new ArrayList<>();
        while (i< nums.length){
            int num = nums[i];
            if(num!=i+1 ){
                if(num == nums[num-1]){
                    duplicates.add(num);
                    i++;
                }else {
                    nums[i] = nums[num - 1];
                    nums[num - 1] = num;
                }
            }else{
                i++;
            }
        }

        return duplicates;
    }


    public static List<Integer> findDuplicates(int[] nums) {
        int i =0 ;
        List<Integer> dup = new ArrayList<>();
        while(i<nums.length){
            if(nums[i]>=1 && nums[i]<=nums.length && nums[i]!=i+1){
                if(nums[nums[i]-1] == nums[i]){
                    System.out.println(i+" "+ nums[i] +" " +nums[nums[i]-1]);
                    dup.add(nums[i]);
                    i++;
                }else{
                    swap(nums, i, nums[i]-1);
                }
            }else{
                i++;
            }

        }

        return dup;
    }
    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String[] args) {
        int arr[] ={3,4,4,5,5};
        System.out.println(findDuplicates(arr));
    }
}
