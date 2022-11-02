package algo.expert.array.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
GIven the final scores of an exam for a list of students, you need to reward students.
You decide to do so fairly by giving them arbitrary rewards following two rules.
 1. All students must receive at least one reward
 2. Any given student must receive strictly more reward than adjacent students(immediate left or right)
    with a lower score and must strictly fewer rewards then the adjacent students with higher score.

 Ex: Scores: [8, 4, 2, 1, 3, 6, 7, 9, 5]
 Output: 25 ([4, 3, 2, 1, 2, 3, 4, 5, 1])

 */

public class MinRewards {

    //BruteForce
    // Bestcase O(n) || Worst case O(n^2)
    public static int minRewards1(int[] scores) {
        int [] awards = new int[scores.length];
        Arrays.fill(awards, 1);
        boolean deviationFound = true;
        int counter =0;
        while(deviationFound){
            deviationFound = false;

            for (int i =1; i< scores.length; i++){
                counter++;
                if(scores[i]<scores[i-1] && awards[i]>=awards[i-1]){
                    awards[i-1] = awards[i-1]+1;
                    deviationFound = true;
                }
                if(scores[i]>scores[i-1] && awards[i]<= awards[i-1]){
                    awards[i] = awards[i]+1;
                    deviationFound = true;
                }

            }
        }
        System.out.println(counter);
        return getSum(awards);
    }

    // O(n^2) time || O(n) space
    public static int minRewards2(int[] scores) {
        // Write your code here.
        int[] awards = new int[scores.length];
        awards[0] = 1;
        for (int i =1; i<scores.length; i ++){
            if(scores[i]>scores[i-1]){
                awards[i] = awards[i-1]+1;
            }else{
                awards[i] = 1;
                for (int j =i-1; j>=0 && scores[j]> scores[j+1] && awards[j]<=awards[j+1]; j--){
                    awards[j] = awards[j]+1;
                }
            }
        }
        return getSum(awards);

    }

    // O(n) time || O(n) space
    public static int minRewards3(int[] scores) {
        int[] awards = new int[scores.length];
        Arrays.fill(awards, 1);
        for(int i =1; i< scores.length; i++){
            if(scores[i]>scores[i-1] && awards[i]<= awards[i-1]){
                awards[i] = awards[i-1]+1;
            }
        }

        for(int i = scores.length-2; i>=0; i-- ){
            if(scores[i]>scores[i+1] && awards[i]<= awards[i+1]){
                awards[i] = awards[i+1]+1;
            }
        }
        return getSum(awards);
    }

    //using local min
    // O(n) time || O(n) space
    public static int minRewards4(int[] scores) {
        int[] awards = new int[scores.length];
        //find local min indexes
        List<Integer> localMins=  new ArrayList<>();
        if(scores.length==1){
            localMins.add(0);
        }else{
            for(int i =0; i< scores.length; i++){
                if((i==0 && scores[i]<scores[i+1])
                        || (i == scores.length-1 && scores[i]<scores[i-1])
                        || (scores[i]<scores[i+1] && scores[i]<scores[i-1])
                ){
                    localMins.add(i);
                }

            }
        }

        //Expand From local Mins
        for(int minIdx: localMins){
            awards[minIdx] = 1;
            //Expand Left
            int i = minIdx-1;
            while(i>=0 && scores[i]> scores[i+1] && awards[i]<awards[i+1]){
                awards[i] = awards[i+1]+1;
                i--;
            }

            //Expand right
            int j = minIdx+1;
            while(j<scores.length && scores[j] > scores[j-1] && awards[j]<=awards[j-1]){
                awards[j] = awards[j-1]+1;
                j++;
            }


        }


        return getSum(awards);
    }


    private static int getSum(int[] awards) {
        int sum = 0 ;
        for(int award: awards){
            System.out.println(award);
            sum+=award;
        }
        return sum;
    }

    public static void main(String[] args){
        int[] scores = {8, 4, 2, 1, 3, 6, 7, 9, 5};
        System.out.println(minRewards1(scores));

    }
}
