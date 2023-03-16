package grokking.twopointers.easy;

public class RemoveDuplicates {

    public static int remove(int[] arr){
        int i =0, j =1;
        while(j<arr.length){
            if(arr[i]!=arr[j]){
                arr[i+1] = arr[j];
                i++;
            }
            j++;
        }
        return i+1;
    }

    public static void main(String[] args) {
        int[] arr  = new int[]{2,3,3,3,6,9,9};
        System.out.println(remove(arr));
    }
}
