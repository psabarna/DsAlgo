package algo.expert.sorting;

import java.util.Arrays;

public class RadixSort {

/*
  Time: O(nd) space : O(n) where d is the number of digit in max number present in array
  Approach: Implement count sort on every digit
 */
  public static int[] sortArray(int[] nums) {
    int max = Integer.MIN_VALUE;
    for(int n: nums){
      max = Math.max(max, n);
    }
    int exp =1;
    while(max/exp>0){
      nums = sort(nums, exp);
      exp *=10;
    }
    return nums;
  }

  public static int[] sort(int[] nums, int exp) {
    int[] res = new int[nums.length] ;
    int[] freq = new int[10];
    for(int n : nums){
      freq[(n/exp)%10] +=1;
    }
    for(int i =1; i< freq.length; i++){
      freq[i] = freq[i] +freq[i-1];
    }
    for(int i = nums.length-1; i>=0; i--){
      int pos = freq[((nums[i]/exp)%10)]-1;
      freq[((nums[i]/exp)%10)] -=1;

      res[pos] = nums[i];
    }
    return  res;
  }

  public static void main(String[] args) {
    int[] arr = new int[]{1,2,3,15,10,6,7,8};
    arr = sortArray(arr);


    Arrays.stream(arr).forEach(System.out:: println);
  }

}
