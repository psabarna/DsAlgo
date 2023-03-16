package grokking.cyclicsort.challenge;

public class CorruptPair {

    public static int[] findCorruptPair(int[] nums){
        int i =0;
        while(i< nums.length){
            int num = nums[i];
            if(num-1!=i){
                if(num != nums[num-1]) {
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
                return new int[]{i+1, nums[i]};
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] input = {3,1,2,3,6,4};
        int[]  cp = findCorruptPair(input);
        System.out.println(cp[0]+" "+cp[1]);
    }
}
