package grokking.slidingwindow.easy;

public class MaximumSubArrayOfSizeK {

    public static int findMaxSumSubArray(int[] arr, int k){
        int start = 0;
        int end = 0;
        int windowSum = 0;
        while(end<k){
            windowSum += arr[end];
            end++;
        }
        int largestSum = windowSum;
        while(end<arr.length){
            windowSum = windowSum-arr[start]+arr[end];
            largestSum = Math.max(windowSum, largestSum);
            end++;
            start++;
        }
        return largestSum;
    }

    public static int findMaxSumSubArray2(int[] arr, int k){
        int start = 0;
        int end = 0;
        int windowSum = 0;
        int largestSum = 0;
        while(end<arr.length){
            windowSum = windowSum+arr[end];
            if(end-k+1>=0){
                largestSum = Math.max(windowSum, largestSum);
                windowSum-= arr[end-k+1];
            }
            end++;
        }
        return largestSum;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,5,1,3,2};
        System.out.println(findMaxSumSubArray(arr,2));
        System.out.println(findMaxSumSubArray2(arr,2));
    }
}
