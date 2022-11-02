package algo.expert.array.medium;

/**Given an array and a value move all occurrence of that value to the end of array
 * input: [2, 1, 2, 2, 2, 3, 4, 2], 2
 * output: [1, 3, 4, 2, 2, 2, 2, 2], 1,3,4 can appear in any order and this movement should be done in place
 */
public class MoveElementToEnd {
    //O(n) time | O(1) Space
    public static void moveElementToEnd(int[] arr, int element){
        int i =0;
        int j = arr.length-1;
        while(i<j){
            if(arr[i]==element){
                arr[i] = arr[j];
                arr[j] = element;
                j--;
            }else{
                i++;
            }
        }

    }
    public static void main(String[] args){
        int[] arr = {2, 1, 2, 2, 2, 3, 4, 2};
        moveElementToEnd(arr, 2);
        for (int i: arr){
            System.out.println(i);
        }

    }
}
