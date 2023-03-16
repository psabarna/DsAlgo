package grokking.twopointers.medium;

import java.util.Arrays;

/**
 Given an array arr of unsorted numbers and a target sum, count all triplets in it such that arr[i] + arr[j] + arr[k] < target
 where i, j, and k are three different indices. Write a function to return the count of such triplets
 */
public class TripletWithSmallerSum {

    public static int searchTriplets(int[] arr, int target){
        Arrays.sort(arr);
        int smallCount = 0;
        for(int i =0 ; i<arr.length-2; i++){

            int j = i+1, k = arr.length-1;
            while(j<k){
                int sum = arr[i]+arr[j]+arr[k];
                if(sum<target){
                    smallCount += k-j;
                    j++;

                }else {
                    k--;
                }
            }

        }

        return smallCount;
    }

    public static void main(String[] args) {
        int smallCount = searchTriplets(new int[]{-1,0,2,3}, 3);
        System.out.println(smallCount);
    }
}
