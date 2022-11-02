package algo.expert.array.easy;

import java.util.HashMap;
import java.util.Map;

public class TournamentWinner {

    //O(n) time, O(k) space, n is number of competitions and k is number of teams
    public static String findWinner(String[][] competitions, int[] result){
        if(competitions.length!= result.length){
            return "Invalid Input";
        }
        Map<String, Integer> points =  new HashMap<>();
        String winner = null;
        int winnerPoint =0;
        for(int i = 0; i <result.length; i++){
            String[]comp = competitions[i];
            int pts = points.getOrDefault(comp[1-result[i]], 0)+3;
            points.put(comp[1-result[i]],pts);
            if(pts>winnerPoint){
                winnerPoint = pts;
                winner = comp[1-result[i]];
            }
        }
        return winner;
    }

    public static void main(String[] args){
        String[][] competitions = {
                {"HTML", "C#"},
                {"C#", "Python"},
                {"Python", "HTML"}
            };
        int[] result = {0, 0, 1};
        System.out.println(findWinner(competitions, result));
    }
}
