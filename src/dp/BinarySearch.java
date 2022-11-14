package dp;

public class BinarySearch {

  public static int search(int[] nums, int target) {
    return search(nums, 0, nums.length-1, target);
  }

  public static  int search(int[] nums,int start, int end, int target) {
    if(start<end){
      int mid = (start +end)/2;
      if(target>=nums[mid]){
        return search(nums, mid, end, target);
      }else if(target<nums[mid]){
        return search(nums, start, mid-1, target);
      }
    }

    return nums[start] == target? start :-1;

  }

  public static void main(String[] args) {
    int[] arr = {-1,0,3,5,9,12};
    System.out.println(search(arr, 9));
  }

}
