package grokking.cyclicsort.easy;
// 542310
//
public class FindDuplicateNumber {
    public static int findDuplicateNumber(int[] nums){
        int i =0;
        while (i< nums.length){
            int num = nums[i];
            if(num!=i+1 ){
                if(num == nums[num-1]){
                    return num;
                }
                nums[i] = nums[num-1];
                nums[num-1] = num;
            }else{
                i++;
            }
        }

        return nums.length;
    }
    public static void main(String[] args) {
        int arr[] ={2,4,1,4,4};
        System.out.println(findDuplicateNumber(arr));
    }
}
