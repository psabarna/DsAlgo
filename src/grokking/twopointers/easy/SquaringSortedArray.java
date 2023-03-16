package grokking.twopointers.easy;

public class SquaringSortedArray {
    public static int[] makeSquares(int[] input){
        int i =0, j = input.length-1;
        int[] squares = new int[input.length];
        int k = input.length-1;
        while(k>=0){
            if(Math.abs(input[i])>Math.abs(input[j])){
                squares[k] = input[i]*input[i];
                i++;
            }else{
                squares[k] = input[j]*input[j];
                j--;
            }

            k--;
        }
        return squares;
    }

    public static void main(String[] args) {
        int[] sqrs = makeSquares(new int[]{2,-1,0,2,3});
        for(int i: sqrs){
            System.out.print(i+" ");
        }
    }
}
