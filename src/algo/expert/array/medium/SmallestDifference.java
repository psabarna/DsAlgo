package algo.expert.array.medium;

import java.util.Arrays;

/**GIven two int array find a pair of numbers(one from each array) whose absolute difference is closest to zero
 * [-1, 5, 10, 20, 28, 3]
 * [26, 134, 135, 15, 17]
 *
 * output: [28, 26]
 * Difference between 28 and 26 is
 */
public class SmallestDifference {
    //BruteForce
    //O(n*m) time || Space O(1)
    public static int[] findClosestPair1(int[] arr1, int[] arr2){
        int smallestDiff = Integer.MAX_VALUE;
        int[] closestPair = new int[2];
        for (int i =0; i<arr1.length; i++){
            for(int j= 0; j<arr2.length; j++){
                if(Math.abs(arr1[i]-arr2[j])<smallestDiff){
                    smallestDiff = Math.abs(arr1[i]-arr2[j]);
                    closestPair= new int[]{arr1[i], arr2[j]};
                }
            }
        }
        return closestPair;
    }

    //O(nlog(n)+m log(m)) time | space O(1)
    public static int[] findClosestPair2(int[] arr1, int[] arr2){
        int smallestDiff = Integer.MAX_VALUE;
        int[] closestPair = new int[2];
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int i =0 ,j =0;
        while (i<arr1.length && j<arr2.length){

                if(Math.abs(arr1[i]-arr2[j])<smallestDiff){
                    smallestDiff = Math.abs(arr1[i]-arr2[j]);
                    closestPair= new int[]{arr1[i], arr2[j]};
                }
                if(smallestDiff == 0){
                    break;
                }
                if(arr1[i]<arr2[j]) {
                    i++;
                }else {
                    j++;
                }

        }
        return closestPair;
    }

    public static void main(String[] args){
        int[] arr1 = {-1, 5, 10, 20, 28, 3};
        int[] arr2 = {26, 134, 135, 15, 17};
        int[] closestPair = findClosestPair2(arr1, arr2);
        for(int i=0;i<closestPair.length;i++){
            System.out.println(closestPair[i]);
        }

    }
}
