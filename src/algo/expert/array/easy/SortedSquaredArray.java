package algo.expert.array.easy;

import java.util.Arrays;

public class SortedSquaredArray {
    //using sorting
    //O(nlog(n)) time | O(1) space
    public static int[] sortedSquaredArray1(int[] arr){
        for (int i =0; i<arr.length; i++){
            arr[i] = arr[i]*arr[i];
        }
        Arrays.sort(arr);
        return arr;
    }

    //using smaller and larger index pointer
    //O(n) time | O(n) space
    public static int[] sortedSquaredArray2(int[] arr){
        int[] ssa = new int[arr.length];
        int smallIdx = 0;
        int largeIdx = arr.length-1;
        for(int i = arr.length-1; i>=0; i--){

            if(Math.abs(arr[smallIdx])>Math.abs(arr[largeIdx])){
                ssa[i] = arr[smallIdx]*arr[smallIdx];
                smallIdx++;
            }else{
                ssa[i] = arr[largeIdx]*arr[largeIdx];
                largeIdx--;
            }

        }

        return ssa;
    }
    public static void main(String[] args) {
        int[] arr = {-5,-4, -3, 3, 4, 5, 6};
        printArray(sortedSquaredArray2(arr));

    }

    public static void printArray(int[] arr){
        for(int i: arr){
            System.out.println(i);
        }
    }
}
