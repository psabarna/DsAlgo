package algo.expert.sorting;

import java.util.Arrays;

public class CountSort {

/*
  Time: O(n) space : O(n)
  Approach: Count the frequencies, add each frequencies with last number frequency to indicate upto which index this number needs to be filled up.
  As per freq index fill up the result array
 */
  public static int[] sortArray(int[] nums) {
    int[] res = new int[nums.length] ;
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    for(int n: nums){
      min = Math.min(min, n);
      max = Math.max(max, n);
    }
    int[] freq = new int[max-min+1];
    for(int n : nums){
      freq[n-min] +=1;
    }
    for(int i =1; i< freq.length; i++){
      freq[i] = freq[i] +freq[i-1];
    }
    int j =0;
    for(int i =0; i<freq.length; i++){
      int f = freq[i];
      while(j<f){
        res[j] = i+min;
        j++;
      }
    }
    return  res;
  }



  public static void main(String[] args) {
    int[] arr = new int[]{1,2,3,5,1,2,3,5};
    arr = sortArray(arr);


    Arrays.stream(arr).forEach(System.out:: println);
  }

}
