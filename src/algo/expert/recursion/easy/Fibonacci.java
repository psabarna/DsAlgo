package algo.expert.recursion.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Consider Fibonacci series
 *  0,1,1,2,3,5,8
 *  Given a number(1 to n) give nth Fibonacci number
 *  Ex: for 1 return 0
 *  for 2 return 1
 *  for 3 return 2
 */
public class Fibonacci {
    //O(2^n) time O(n) space
    public static int getNthFib(int n) {
        if(n==1) return 0;
        if(n==2) return 1;
        return getNthFib(n-1) + getNthFib(n-2);
    }

    //Using Memoization
    //O(n) time O(n) space
    public static int getNthFib(int n, Map<Integer, Integer> fibMap) {
        if(fibMap.containsKey(n)){
            return fibMap.get(n);
        }

        int nthFib = getNthFib(n-1, fibMap) + getNthFib(n-2, fibMap);
        fibMap.put(n, nthFib);
        return nthFib;
    }

    //Without Recursion
    //O(n) time O(1) space
    public static int getNthFibWithoutRecursion(int n) {
        int[] lastTwo = {0,1};
        for(int i =3; i<=n; i++){
            int nthFib = lastTwo[0]+ lastTwo[1];
            lastTwo[0] = lastTwo[1];
            lastTwo[1] = nthFib;
        }
        if(n==1) return lastTwo[0];

        return lastTwo[1];
    }

    public static void main(String[] args) {
        System.out.println(getNthFib(6));
        Map<Integer, Integer> fibMap= new HashMap<>();

        //Using Memoization
        fibMap.put(1,0);
        fibMap.put(2, 1);
        System.out.println(getNthFib(6, fibMap));
        System.out.println(getNthFibWithoutRecursion(6));
    }
}
