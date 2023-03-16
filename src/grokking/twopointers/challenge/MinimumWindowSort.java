package grokking.twopointers.challenge;

import java.util.Arrays;

public class MinimumWindowSort {

    public static int[] findSmallestWindowToSort(int[] input){
        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;
        for(int i =1; i <input.length-1; i++){
            if(input[i-1]>input[i] || input[i+1]<input[i]){
                smallest = Math.min(smallest, input[i]);
                largest = Math.max(largest, input[i]);
            }
        }
        int low =0;
        int high = input.length-1;
        while(low< high){
            if(input[low]>= smallest && input[high]<=largest){
                break;
            }
            if(input[low]< smallest){
                low++;
            }
            if(input[high]> largest){
                high --;
            }

        }
        return Arrays.copyOfRange(input, low, high+1);
    }

    public static void main(String[] args) {
        int[] windowToSort = findSmallestWindowToSort(new int[]{1,3,-3,-1,0,7,10});
        for(int i: windowToSort){
            System.out.print(i + " ");
        }
    }
}
