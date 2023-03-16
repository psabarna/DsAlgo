package grokking.fastslow.challenge;

public class CycleInCircularArray {

    public static int getIdxAfterMove(int[] input,boolean isForward, int idx){
        int prevIdx = idx;
        boolean direction = input[idx]>0;
        if(direction!=isForward){
            return -1;
        }
        idx = (idx + input[idx]) % input.length;
        if(idx<0){
            idx= input.length+idx;
        }
       if(idx==prevIdx){
           return -1;
       }
        return idx;
    }
    public static boolean isLoop(int[] input){
        //int i =0;
        for(int i =0 ; i< input.length; i++){
            boolean isForward = input[i]>0;
            int slow = i;
            int fast = i;
            do{
                slow = getIdxAfterMove(input, isForward, slow);
                fast = getIdxAfterMove(input, isForward,fast);
                if(fast!=-1){
                    fast = getIdxAfterMove(input, isForward, fast);
                }
            }while(slow!=-1 && fast!=-1 && slow !=fast);
            if(slow!=-1 && slow==fast){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] input = {1,4,-1,2,2};
        System.out.println(isLoop(input));
    }


}
