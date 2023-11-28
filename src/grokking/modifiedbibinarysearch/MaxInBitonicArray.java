package grokking.modifiedbibinarysearch;
/*
Find the maximum value in a given Bitonic array.
An array is considered bitonic if it is monotonically increasing and then monotonically decreasing.
Monotonically increasing or decreasing means that for any index i in the array arr[i] != arr[i+1].

https://leetcode.com/problems/peak-index-in-a-mountain-array/description/
 */
public class MaxInBitonicArray {
    public static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length-1;

        while(start<end){
            int mid = start + (end-start)/2;
            if(arr[mid]>arr[mid+1]){
                end = mid;
            }else{
                start = mid+1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,8,12,4,2};
        System.out.println(peakIndexInMountainArray(arr));
    }

}
