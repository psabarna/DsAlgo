package algo.expert.array.easy;

/*
Given two arrays check if 2nd array is subsequence of array1.
The subsequence of an array is not necessarily adjacent in the array but appear in same order.
 */

public class ValidateSubSequence {
    //O(n) time, O(1) space
    public static boolean validate(int[] arr1, int[] arr2){
        int i=0, j=0;
        while(i<arr1.length && j<arr2.length){
            if(arr1[i] == arr2[j]){
                j++;
            }
            i++;
        }
        return j==arr2.length;

    }
    public static void main(String[] args) {
        int[] arr1 = {5, 1, 22, 25, 6, -1, 8, 10};
        int[] arr2 = {1, 6, -1, 10};
        System.out.println(validate(arr1, arr2));
    }
}
