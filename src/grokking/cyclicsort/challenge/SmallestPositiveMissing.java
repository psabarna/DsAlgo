package grokking.cyclicsort.challenge;

public class SmallestPositiveMissing {

    public static int findSmallestMissing(int[] nums){
        int i =0;
        while(i< nums.length){
            int num = nums[i];
            if(num-1!=i){
                if(num>0 && num<nums.length && num != nums[num-1]) {
                    nums[i] = nums[num - 1];
                    nums[num - 1] = num;
                }else{
                    i++;
                }
            }else {
                i++;
            }
        }

        for(i =0; i< nums.length; i++){
            if(nums[i]!=i+1){
                return i+1;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        int[] input = {-3,1,5,4,2};
        int  cp = findSmallestMissing(input);
        System.out.println(cp);
    }
}
