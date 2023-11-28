package algo.expert.sorting;

import java.util.Arrays;

public class HeapSort {

/*
  Time: O(nlog(n)) space : O(1)
  Approach: heapify the array first, then take out the top of heap to end and then heapify it recursively
 */
  public static int[] sortArray(int[] nums) {
    for(int i = (nums.length/2)-1; i>=0; i--){
      heapify(nums, i, nums.length);
    }
    for(int i =0; i< nums.length; i++){
      swap(nums, 0, nums.length-i-1);
      heapify(nums, 0, nums.length-i-1);
    }
    return nums;
  }
  public static void heapify(int[] nums, int i, int N){
    int largest = i;
    int l = 2*i + 1;
    int r = 2*i + 2;

    if(l<N && nums[l]> nums[largest]){
      largest = l;
    }
    if(r<N && nums[r]>nums[largest]){
      largest = r;
    }
    if(largest!=i){
      swap(nums, largest, i);
      heapify(nums, largest, N);
    }

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
