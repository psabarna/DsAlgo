package grokking.twopointers.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumCloseToTarget {
    public static List<Integer> searchTriplet(int[] arr, int target){
        Arrays.sort(arr);
        List<Integer> triplet = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;

        for(int i =0 ; i<arr.length-2; i++){
            if(i>0 && arr[i]==arr[i-1]){
                continue;
            }

            int j = i+1, k = arr.length-1;
            while(j<k){
                int diff = target-(arr[i]+arr[j]+arr[k]);
                if(diff == 0){
                    return Arrays.asList( arr[i],arr[j], arr[k]);

                }
                if(Math.abs(diff)<minDiff){
                    minDiff = Math.abs(diff);
                    triplet = Arrays.asList( arr[i],arr[j], arr[k]);
                }
                   if (diff>0) {
                        j++;
                    } else {
                        k--;
                    }
            }



        }

        return triplet;
    }

    public static void main(String[] args) {
        System.out.println(searchTriplet(new int[]{-3,-1,1,2}, 0));
    }
}
