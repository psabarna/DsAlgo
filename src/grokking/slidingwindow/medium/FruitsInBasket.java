package grokking.slidingwindow.medium;

import java.util.HashMap;
import java.util.Map;

/*
Given an array of characters where each character represents a fruit tree, you are given two baskets and your goal is to put maximum number of fruits in each basket. The only restriction is that each basket can have only one type of fruit.
You can start with any tree, but once you have started you can’t skip a tree. You will pick one fruit from each tree until you cannot, i.e., you will stop when you have to pick from a third fruit type.
Write a function to return the maximum number of fruits in both the baskets.
 */
public class FruitsInBasket {

    public static int maxFruitCountOf2Types(char[] fruits){
        Map<Character, Integer> fruitCountMap = new HashMap<>();
        int maxFruitCount = Integer.MIN_VALUE;
        int start =0;
        int end = 0;
        int diffFruitCount = 0;
        while(end< fruits.length){
            char c = fruits[end];
            fruitCountMap.put(c, fruitCountMap.getOrDefault(c,0)+1);
            if(fruitCountMap.get(c)==1){
                diffFruitCount++;
            }
            while(diffFruitCount>2){
                char c2 = fruits[start];
                fruitCountMap.put(c2,fruitCountMap.get(c2)-1);
                if(fruitCountMap.get(c2)==0){
                    diffFruitCount--;
                }
                start++;
            }

            if(diffFruitCount==2){
                maxFruitCount = Math.max(maxFruitCount, end-start+1);
            }
            end++;
        }
        return maxFruitCount;
    }
    
    public static void main(String[] args) {
        char[] fruits = {'A','C','C','A','C'} ;
        //This problem is same as longest substr with 2 different characters
        System.out.println(maxFruitCountOf2Types(fruits));
    }
}
