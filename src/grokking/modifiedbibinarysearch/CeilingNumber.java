package grokking.modifiedbibinarysearch;
/*

https://leetcode.com/problems/search-insert-position/description/
 */
public class CeilingNumber {

    public static int ceiling(int[] arr, int key){

        int start = 0;
        int end = arr.length-1;
        if(arr[end]<key){
            return -1;
        }
        while(start<=end){
            int mid = start + (end-start)/2;
            if(arr[mid] == key){
                return mid;
            }

            if(arr[mid]<key){
                start = mid+1;
            }else {
                end = mid-1;
            }

        }

       return start;


    }



    public static void main(String[] args) {
        int[] arr =  new int[]{4,6,10};
       /* System.out.println(ceiling(arr, 6));
        System.out.println(ceiling(arr, -1));
        System.out.println(ceiling(arr, 17));
        arr =  new int[]{1,3,8,10,15};
        System.out.println(ceiling(arr, 12));*/

        arr =  new int[]{1,3,5,6};
        System.out.println(ceiling(arr, 2));

    }
}
