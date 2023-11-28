package grokking.modifiedbibinarysearch;
/*
Given an array of lowercase letters sorted in ascending order, find the smallest letter in the given array greater than a given ‘key’.

Assume the given array is a circular list, which means that the last letter is assumed to be connected with the first letter. This also means that the smallest letter in the given array is greater than the last letter of the array and is also the first letter of the array.

Write a function to return the next letter of the given ‘key’.

https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
 */
public class NextLetter {
    public static char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length-1;
        int mid;
        if(target>letters[end] || target< letters[start]){
            return letters[0];
        }
        while(start<=end){
            mid = start + (end-start)/2;

            if(target>= letters[mid]){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return letters[(start+1)%letters.length];
    }

    public static void main(String[] args) {
        char[] chars = new char[]{'e', 'e', 'g', 'g'};
        System.out.println(nextGreatestLetter(chars,'e'));
    }

}
