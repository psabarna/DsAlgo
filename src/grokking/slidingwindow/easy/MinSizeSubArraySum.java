package grokking.slidingwindow.easy;

public class MinSizeSubArraySum {
    public static int findMinSizeSubArray(int[] arr, int target){
        int start =0;
        int end=0;
        int sum =0;
        int minSize = Integer.MAX_VALUE;
        while (end<arr.length){
            sum+=arr[end];
            while(sum>=target){
                minSize = Math.min(minSize, end-start+1);
                sum-=arr[start];
                start++;
            }
                end++;


        }

        return minSize;
    }
    public static void main(String[] args) {
        int[] arr = {2,1,5,2,3,2};
        System.out.println(findMinSizeSubArray(arr,7));

    }
}
