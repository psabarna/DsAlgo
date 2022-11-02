package algo.expert.array.hard;

import java.util.ArrayList;
import java.util.List;

/**
 *  Traverse a given 2d array in zig zag fashion
 *  Ex:
 * Input: [
 *   [1, 3, 4, 10],
 *   [2, 5, 9, 11],
 *   [6, 8, 12, 15],
 *   [7, 13, 14, 16]]
 *   Output: [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16]
 */
public class ZigZagTraversal {
    public static List<Integer> zigzagTraverse(int[][] arr){
        List<Integer> zigzag = new ArrayList<>();
        int i =0, j =0;
        String direction = "down";
        while(i<arr.length && j< arr[0].length){
            zigzag.add(arr[i][j]);
           if(direction == "down"){
               if(i== arr.length-1){
                   j=j+1;
                   direction = "up";
               }else if(j==0){
                   i = i+1;
                   direction = "up";
               }else{
                   i++;
                   j--;
               }
           }else{
               if(j== arr[0].length-1){
                   i++;
                   direction = "down";
               }else if(i==0){
                    j++;
                   direction = "down";
               }else{
                   i--;
                   j++;
               }

           }

        }
        return zigzag;
    }

    public static  void main(String[] args){
        int[][] input = {{1, 3, 4}, {2, 5, 9}, {6, 8, 12}, {7, 13, 14}};
        List<Integer> zigzag = zigzagTraverse(input);
        for(int i: zigzag){
            System.out.println(i);
        }

    }

}
