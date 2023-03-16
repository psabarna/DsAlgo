package grokking.cyclicsort.easy;
// 542310
//
public class MissingNumber {
    public static int findMissingNumber(int[] nums){
        int i =0;
        while (i< nums.length){
            int num = nums[i];
            if(num!=i && num<nums.length){
                nums[i] = nums[num];
                nums[num] = num;
            }else{
                i++;
            }
        }

        for(i =0; i< nums.length; i++){
            if(nums[i]!=i){
                return i;
            }
        }
        return nums.length;
    }
    public static void main(String[] args) {
        int arr[] ={8,3,5,2,4,6,0,1};
        System.out.println(findMissingNumber(arr));
    }
}
