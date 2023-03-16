package grokking.fastslow.medium;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static boolean find(int num){
        Set<Integer> sqrs = new HashSet<>();
        sqrs.add(num);
        while(num!=1 ){
            int sqrSum = getNumSqrSum(num);
            if(sqrs.contains(sqrSum)){
                return false;
            }
            sqrs.add(sqrSum);
            num = sqrSum;
        }
        return  true;
    }

    public static boolean find1(int num){
        int fast = num;
        int slow = num;
        do{
            slow = getNumSqrSum(slow);
            fast = getNumSqrSum(getNumSqrSum(fast));
        }while(fast !=slow);
        return slow == 1;
    }

    public static int getNumSqrSum(int num){
        int sqrSum = 0;
        while(num>0){
            int res = num %10;
            num = num/10;
            sqrSum = sqrSum + res*res;
        }
        return  sqrSum;
    }

    public static void main(String[] args) {
        System.out.println(find(23));
        System.out.println(find(12));

        System.out.println(find1(23));
        System.out.println(find1(12));
    }
}
