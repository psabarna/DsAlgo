package algo.expert.array.medium;

import java.util.Arrays;
import java.util.List;

public class TripletWithSmallSum {
  public static int smallerTriplet(int[] nums, int target){
    Arrays.sort(nums);
    int count = 0;
    for(int i =0; i<nums.length-1; i++){
      int j = i+1;
      int k = nums.length-1;
      int t = target-nums[i];
      while(j<k){
        if(t-nums[j]-nums[k]>0){
          count += (k-j);
          j++;
        }else{
          k--;
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {
    int[] nums = {-1, 4,2, 1, 3};
    System.out.println(smallerTriplet(nums, 5));
  }

}
