package algo.expert.recursion.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a list of measuring cups with their low and high line, also a target low and high,
 * return if the target can be measured using measuring cups
 */
public class AmbigiousMeasurements {

    public static boolean ambiguousMeasurements(int[][] measuringCups, int low, int high) {
        Map<String, Boolean> mem = new HashMap<>();
        return ambiguousMeasurements(measuringCups, low, high, mem) ;
    }

    public static boolean ambiguousMeasurements(int[][] measuringCups, int low, int high, Map<String, Boolean> mem) {
        if(mem.get(low+":"+high)!=null){
            return mem.get(low+":"+high);
        }
        if(low<0 && high<0){
            return false;
        }
        boolean canBeMeasured = false;
        for(int[] cup: measuringCups){
            if(low<=cup[0] && cup[1]<=high){
                canBeMeasured = true;
                break;
            }
            canBeMeasured = ambiguousMeasurements(measuringCups, low-cup[0], high-cup[1], mem);
            if(canBeMeasured){
                break;
            }
        }
        mem.put(low+":"+high, canBeMeasured);
        return canBeMeasured;
    }

    public static void main(String[] args) {
        int[][] cups = new int[][] {{200, 210}, {450, 465}, {800, 850}};
        int low = 2100;
        int high = 2300;

        System.out.println(ambiguousMeasurements(cups, low, high));
    }

}
