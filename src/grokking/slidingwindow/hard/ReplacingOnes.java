package grokking.slidingwindow.hard;

public class ReplacingOnes {
    public static int findLength(int[] arr, int k){
        int start = 0, end = 0;
        int windowOneCount=0;
        int maxLength=0;
        while(end<arr.length){
            if(arr[end]==1){
                windowOneCount++;
            }
            while(end-start+1-windowOneCount>k){
                if(arr[start] == 1){
                    windowOneCount--;
                }
                start++;
            }
            maxLength = Math.max(maxLength, end-start+1);
            end++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(findLength(new int[]{0,1,1,0,0,0,1,1,0,1,1}, 2));
    }
}
