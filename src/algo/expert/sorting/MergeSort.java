package algo.expert.sorting;

import java.util.Arrays;

public class MergeSort {

/*
  Time: O(nlog(n)) space : O(n)
  Approach: Keep dividing the array till it can not be divided further and then merge them
 */
  public static int[] sortArray(int[] nums) {
    sort(nums, 0, nums.length-1);
    return nums;
  }
  public static int[] merge(int[] nums, int l, int m, int r){
    int[] left  =  new int[m-l+1];
    int[] right = new int[r-m];
    for(int i =0; i<m-l+1; i++){
      left[i] = nums[l+i];
    }
    for(int i =0; i<r-m; i++){
      right[i] = nums[m+1+i];
    }
    int i = 0;
    int j = 0;
    int k = l;
    while(i<left.length && j<right.length){
      if(right[j]<left[i]){
        nums[k] = right[j];
        j++;
      }else {
        nums[k] = left[i];
        i++;
      }
      k++;
    }
    while(i<left.length){
      nums[k] = left[i];
      i++;
      k++;
    }
    while(j<right.length){
      nums[k] = right[j];
      j++;
      k++;
    }
    return nums;
  }

  public static int[] sort(int[] nums, int l,int r){
    if(l<r){
      int m = l+ ((r-l)/2);
      sort(nums, l, m);
      sort(nums, m+1, r);
      merge(nums, l,m,r);
    }
    return nums;
  }
  public static void main(String[] args) {
    int[] arr = new int[]{1,2,3,15,10,6,7,8};
    arr = sortArray(arr);
    Arrays.stream(arr).forEach(System.out:: println);
  }

}
