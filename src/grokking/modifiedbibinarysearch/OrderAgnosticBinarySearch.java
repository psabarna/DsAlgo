package grokking.modifiedbibinarysearch;

/*
Given a sorted array of numbers, find if a given number ‘key’ is present in the array.
Though we know that the array is sorted, we don’t know if it’s sorted in ascending or descending order. You should assume that the array can have duplicates.
 */
public class OrderAgnosticBinarySearch {

    public static int search(int[] arr, int key){
        boolean isAsc = true;
        int start = 0;
        int end = arr.length-1;
        if(arr[end]< arr[start]){
            isAsc = false;
        }
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

    public static void main(String[] args) {
        int[] arr =  new int[]{4,6,10};
        System.out.println(search(arr, 10));
        arr =  new int[]{10,6,4};
        System.out.println(search(arr, 4));
        System.out.println(search(arr, 10));
        arr =  new int[]{1,2,3,4,5,6,7};
        System.out.println(search(arr, 5));
        System.out.println(search(arr, 8));
        arr = new int[]{2};
        System.out.println(search(arr, 0));

    }
}
