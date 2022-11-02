package algo.expert.array.medium;
/*
    Given an array, return an array of same length where each element of the array is equal to product of every other number of the input array
    Ex: input [1,3,7, 5]
    Output [105, 35, 15, 21]
 */
public class ArrayOfProducts {

    //Bruteforce
    //O(n^2)  time | O(n)space
    public int[] arrayOfProducts1(int[] array) {
        int[] leftMult  = new int[array.length];
        int[] rightMult  = new int[array.length];
        leftMult[0] = 1;
        for(int i =1; i<array.length; i++){
            leftMult[i] = leftMult[i-1] * array[i-1];
        }
        rightMult[array.length-1] = 1;
        for(int j =array.length-2; j>=0; j--){
            rightMult[j] = rightMult[j+1] * array[j+1];
        }
        for(int i =0; i<array.length;i++){
            array[i] = leftMult[i] * rightMult[i];
        }
        return array;
    }

    //O(n)  time | O(n)space
    public int[] arrayOfProducts2(int[] array) {
        // Write your code here.
        int[] multArr =  new int[array.length];
        for(int i=0; i<array.length; i++){
            int leftMult = 1;
            for(int j =0; j<i; j++){
                leftMult = leftMult * array[j];
            }
            int rightMult = 1;
            for(int k = i+1; k< array.length; k++){
                rightMult  =  rightMult * array[k];
            }
            multArr[i] = leftMult * rightMult;
        }
        return multArr;
    }

    //O(n)  time | O(n)space
    public int[] arrayOfProducts3(int[] array) {
        int[] prod  = new int[array.length];

        prod[0] = 1;
        for(int i =1; i<array.length; i++){
            prod[i] = prod[i-1] * array[i-1];
        }
        int  rightMult = 1 ;
        for(int j =array.length-2; j>=0; j--){
            rightMult = rightMult * array[j+1];
            prod[j] = prod[j] * rightMult;
        }
        return prod;
    }

}
