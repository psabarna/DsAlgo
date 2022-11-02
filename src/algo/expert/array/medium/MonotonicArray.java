package algo.expert.array.medium;

/**
 * Given an array detect if it is monotonic
 * Array is monotonic if its elements are entirely non-increasing or non-decreasing
 * Ex: input= [-1, -5, -10, -1100, -1100, -1101, -1102, -9001]
 * output = true
 */
public class MonotonicArray {
    public static boolean isMonotonic(int[] arr){
        if(arr.length<=1){
            return true;
        }

        int trend = Integer.compare(arr[0], arr[1]) ;

        for(int i =2; i<arr.length; i++){
            int currentTrend = Integer.compare(arr[i-1], arr[i]);
            if(trend==0){
                trend = currentTrend;
                continue;
            }
            if(currentTrend!=0 && currentTrend !=trend ){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {

        int[] arr = {-1, -5, -10, -1100, -1100, -1101, -1102, -9001};
        System.out.println(isMonotonic(arr));

    }
}
