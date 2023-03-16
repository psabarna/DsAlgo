package dp;
//TODO
public class MaxSubArraySumCyclic {

    public static int maxSubarraySumCircular(int[] nums) {
        int[] maxSubs = new int[nums.length];
        maxSubs[0] = nums[0];
        int max = nums[0];
        for(int i =1; i < nums.length; i++){
            maxSubs[i] = Math.max(maxSubs[i-1]+nums[i],nums[i]);
            if(maxSubs[i]>max){
                max= maxSubs[i];
            }
        }

        if(maxSubs[nums.length-1]+nums[0]<max){
            return max;
        }

        maxSubs[0] = maxSubs[nums.length-1]+nums[0];
        max = maxSubs[0];

        for(int i =1; i< nums.length && nums[i]>=0; i++){
            max = max+nums[i];
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {5,-3,5};
        System.out.println(maxSubarraySumCircular(arr));
    }

}
