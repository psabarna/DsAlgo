package algo.expert.sorting;

import java.util.Arrays;

public class BubbleSort {

  /**
   * Time: O(n^2) Space: O(1)
   * Approach: In each loop keep comparing consecutive elements, if later one is larger swap with it previous one
   * at the end of one loop large one will be at the end of array, keep repeating the same for the rest of the array
   */
  public static int[] sortArray(int[] nums) {
    for(int i =nums.length-1; i>0; i--){
      boolean swapped = false;
      for(int j=1; j<=i; j++){
        if(nums[j]< nums[j-1]){
          swapped = true;
          int temp = nums[j];
          nums[j] = nums[j-1];
          nums[j-1] = temp;
        }
        if(!swapped){
          break;
        }
      }

    }
    return nums;
  }

  //This is recursive version of same
  public static int[] sortArray(int[] nums, int n) {
      if(n==1){
        return nums;
      }
      for(int j=1; j<=n-1; j++){
        if(nums[j]< nums[j-1]){
          int temp = nums[j];
          nums[j] = nums[j-1];
          nums[j-1] = temp;
        }

      }

    return sortArray(nums, n-1);
  }
  public static void main(String[] args) {
    int[] arr = new int[]{5,1,1,2,0,0};
    arr = sortArray(arr, arr.length);
    Arrays.stream(arr).forEach(System.out:: println);
  }

}
