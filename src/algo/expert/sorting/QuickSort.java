package algo.expert.sorting;

import java.util.Arrays;

public class QuickSort {

/*
  Time: O(nlog(n)) space : O(1)
  Approach: Take any element as pivot,
 */
  public static int[] sortArray(int[] nums) {
    sortEndPivot(nums, 0, nums.length-1);
    return nums;
  }


  public static int[] sortEndPivot(int[] nums, int l,int r){
    if(r<=l){
      return nums;
    }
    int pivot = nums[r];
    int j = l-1;
    for(int i =l; i<r; i++){
      if(nums[i]< pivot){
        swap(nums, i, j+1);
        j++;
      }
    }
    swap(nums, j+1,r);
    sortEndPivot(nums, l, j);
    sortEndPivot(nums, j+2, r);
    return nums;
  }
  private static void swap(int[] nums, int i, int j){
    int temp =nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
  public static void main(String[] args) {
    int[] arr = new int[]{1,2,3,15,10,6,7,8};
    arr = sortArray(arr);
    Arrays.stream(arr).forEach(System.out:: println);
  }

}
