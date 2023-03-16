package grokking.twopointers.easy;

public class RemoveAllInstances {

    public static int remove(int[] arr, int key){
        int i =-1, j =0;
        while(j<arr.length){
            if(arr[j]!=key){
                arr[i+1] = arr[j];
                i++;
            }
            j++;
        }
        return i+1;
    }

    public static void main(String[] args) {
        int[] arr  = new int[]{2,3,3,3,6,9,9};
        System.out.println(remove(arr,3));
    }
}
