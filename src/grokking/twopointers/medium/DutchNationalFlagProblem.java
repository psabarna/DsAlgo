package grokking.twopointers.medium;
/*
2 2 0 1 2 0
0 2 0 1 2 2
0 1 0 2 2 2

10210


 */

public class DutchNationalFlagProblem {
    public static void sort(int[] input){
        int zeroEnd = 0;

        int twoStart = input.length-1;

        for(int i =0; i<= twoStart; ){
            if(input[i]==0){
                swap(input, zeroEnd, i);
                i++;
                zeroEnd++;
            }else if(input[i]==1){
                i++;
            }else{
                swap(input, i, twoStart);
                twoStart--;
            }
        }

    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] input = {2 ,2 ,0 ,1 ,2 ,0};
        sort(input);
        for (int i : input){
            System.out.print(i +" ");
        }
    }
}
