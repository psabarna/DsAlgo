package grokking.twopointers.medium;

import java.util.*;

public class TripletSumToZero {
    //This does not give unique triplets
    public static List<List<Integer>> searchTriplets(int[] arr){

        List<List<Integer>> triplets = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        for(int i =0 ; i<arr.length-1; i++){
            for(int j = i; j< arr.length; j++){
                if(visited.contains(0-arr[i]-arr[j])){
                    triplets.add(Arrays.asList(0-arr[i]-arr[j], arr[i],arr[j]));
                }
            }
            visited.add(arr[i]);
        }

        return triplets;
    }

    public static List<List<Integer>> searchTriplets1(int[] arr){
        Arrays.sort(arr);
        List<List<Integer>> triplets = new ArrayList<>();
        for(int i =0 ; i<arr.length-2; i++){
            if(i>0 && arr[i]==arr[i-1]){
                continue;
            }
            int target = -arr[i];
            int j = i+1, k = arr.length-1;
            while(j<k){
                if(arr[j]+arr[k]== target){
                    triplets.add(Arrays.asList( arr[i],arr[j], arr[k]));
                    j++;
                    k--;
                    while(j<k && arr[j]==arr[j-1]){
                        j++;
                    }
                    while(j<k && arr[k]== arr[k+1]){
                        k--;
                    }

                }else if(arr[j]+arr[k] > target){
                    k--;
                }else{
                    j++;
                }
            }



        }

        return triplets;
    }
    public static void main(String[] args) {
        int[] input = new int[]{-3,0,1,2,-1,1,-2};
        List<List<Integer>> triplets = searchTriplets1(input);
        for(List<Integer> triplet: triplets){
            System.out.println(triplet);
           /* for(Integer i: triplet){
                System.out.print(i);
            }*/
        }
    }
}
