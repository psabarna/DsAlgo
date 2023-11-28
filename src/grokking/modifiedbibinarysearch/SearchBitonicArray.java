package grokking.modifiedbibinarysearch;

/*
Given a Bitonic array, find if a given ‘key’ is present in it.
An array is considered bitonic if it is monotonically increasing and then monotonically decreasing. Monotonically increasing or decreasing means that for any index i in the array arr[i] != arr[i+1].

Write a function to return the index of the ‘key’. If the ‘key’ is not present, return -1.
https://leetcode.com/problems/find-in-mountain-array/description/
 */
public class SearchBitonicArray {

    public static int search(int[] arr, int key, int start, int end){
        boolean isAsc = arr[start]<arr[end];

        while(start<end){
            int mid = start + ((end-start)/2);
            if(arr[mid] == key){
                return mid;
            }
            if(isAsc){
                if(key>arr[mid]){
                    start = mid+1;
                }else {
                    end = mid-1;
                }
            }else{
                if(key>arr[mid]){
                    end = mid-1;
                }else {
                    start = mid+1;
                }
            }
        }
        return arr[start] == key? start: -1;
    }

    public static int bitonicSearch(int[] arr, int key){
        int peak = MaxInBitonicArray.peakIndexInMountainArray(arr);
        int idx = search(arr, key, 0, peak);;
        return idx!=-1 ? idx : search(arr, key,  peak+1, arr.length-1);
    }
    public static void main(String[] args) {
        int[] arr  = new int[]{1,3,8,12,4,2};
        int key  = 4;
        System.out.println(bitonicSearch(arr,key));
    }
}
