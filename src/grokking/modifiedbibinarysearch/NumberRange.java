package grokking.modifiedbibinarysearch;
/*
Given an array of numbers sorted in ascending order, find the range of a given number ‘key’.
The range of the ‘key’ will be the first and last position of the ‘key’ in the array.

Write a function to return the range of the ‘key’. If the ‘key’ is not present return [-1, -1].
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 */
public class NumberRange {
    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1,-1};
        res[1]  = searchRange(nums, target, true);
        if(res[1] != -1){
            res[0] = searchRange(nums, target, false);
        }
        return res;
    }


    public static int searchRange(int[] nums, int target, boolean findLast) {
        int keyIndex = -1;
        int start = 0;
        int end = nums.length -1;
        int mid;
        while(start<=end){
            mid = start+ (end-start)/2;

            if(target>nums[mid]){
                start= mid+1;
            }else if(target< nums[mid]){
                end = mid-1;
            }else{
                keyIndex = mid;
                if(findLast){
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }

        }

        return keyIndex;
    }


    public static void main(String[] args) {
        int[] arr = new int[] {5,7,7,8,8,10};
        System.out.println(searchRange(arr,6));
    }
}
