package algo.expert.sorting;

import java.util.Arrays;

public class InsertionSort {

  /**
   * Time: O(n^2) Space: O(1)
   * Approach: if the key element is smaller than its predecessor, compare to its previous elements.
   */
  public static int[] sortArray(int[] nums) {
    for(int i =1; i<nums.length; i++){
      if(nums[i]<nums[i-1]) {
        int j = i;
        while(j>=1 && nums[j]<nums[j-1]){
          int temp = nums[j-1];
          nums[j-1] = nums[j];
          nums[j] = temp;
          j--;
        }
      }
    }
    return nums;
  }
  public static void main(String[] args) {
    int[] arr = new int[]{1,2,3,15,10,6,7,8};
    arr = sortArray(arr);
    Arrays.stream(arr).forEach(System.out:: println);
  }

}
