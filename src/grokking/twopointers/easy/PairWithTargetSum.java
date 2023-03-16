package grokking.twopointers.easy;

public class PairWithTargetSum {
    //Given array is sorted
    public static int[] search(int[] arr, int target){

        int i = 0, j = arr.length-1;
        while(i<j){
            if(arr[i]+arr[j] == target){
                return new int[]{i,j};
            }
            if(arr[i]+arr[j]>target){
                j--;
            }else{
                i++;
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] result = search(new int[]{1,2,3,4,6}, 6 );
        for(int i: result){
            System.out.print(i+ " " );
        }
    }
}
