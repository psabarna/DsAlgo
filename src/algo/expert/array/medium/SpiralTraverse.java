package algo.expert.array.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraverse {
    public static List<Integer> spiralTraverse(int[][] arr){
        List<Integer> spiral =  new ArrayList<>();
        int rs = 0, cs= 0;
        int re = arr.length-1;
        int ce = arr[0].length-1;
        while(rs<=re && cs<= ce){

            spiral(arr, rs, re, cs, ce, spiral);
            rs++; cs++; re--; ce--;

        }
        return spiral;
    }


    //Using recursion
    public static void spiralTraverse(int[][] arr, int rs, int re, int cs, int ce, List<Integer> spiral){

        if(rs>re || cs>ce){
            return;
        }

        spiral(arr, rs, re, cs, ce, spiral);
        spiralTraverse(arr, rs+1,  re-1,cs+1, ce-1, spiral);





    }

    private static void spiral(int[][] arr, int rs, int re, int cs, int ce, List<Integer> spiral) {
        //top row
        for(int i = cs; i<= ce; i++){
            spiral.add(arr[rs][i]);
        }
        //rightMost column
        for(int i = rs +1; i<= re; i++){
            spiral.add(arr[i][ce]);
        }
        //bottom row
        for(int i = ce -1; i>= cs; i--){

            //If there is only one row left then it is already printed in first loop
            if(rs == re){
                break;
            }
            spiral.add(arr[re][i]);
        }
        //left column
        for(int i = re -1; i> rs; i--){
            //If there is only one column left then it is already printed in second loop
            if(cs == ce){
                break;
            }
            spiral.add(arr[i][cs]);
        }
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4},
                {12, 13, 14, 5},
                {11, 16, 15, 6},
                {10, 9, 8, 7}
                };

        List<Integer> spiral = new ArrayList<>();
        //arr = new int[][]{ {1, 2, 3}, {8, 9, 4}, {7, 6, 5}};
        spiral = spiralTraverse(arr);
       // spiralTraverse(arr, 0, arr.length-1, 0, arr[0].length-1, spiral);

        for(int el: spiral){
            System.out.println(el);
        }
    }

}
