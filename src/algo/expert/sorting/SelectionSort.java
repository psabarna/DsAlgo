package algo.expert.sorting;

import java.util.Arrays;

public class SelectionSort {

  /**
   * Time: O(n^2) Space: O(1)
   * Approach: In each loop find the smallest element in remaining array and
   * swap it with the left most of the remaining array
   */
  public static int[] sortArray(int[] nums) {
    for(int i =0; i<nums.length-1; i++){

      int minIdx = i;
      for(int j = i+1; j< nums.length; j++){
        if(nums[j]<nums[minIdx]){
          minIdx = j;
        }

      }
      int temp = nums[i];
      nums[i] = nums[minIdx];
      nums[minIdx] = temp;
    }
    return nums;
  }
  public static void main(String[] args) {
    int[] arr = new int[]{5,1,1,2,0,0};
    arr = sortArray(arr);
    Arrays.stream(arr).forEach(System.out:: println);
  }

}
