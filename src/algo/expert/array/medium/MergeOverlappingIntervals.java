package algo.expert.array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of arbitrary Intervals, merge the overlapping intervals.
 *Ex: Input:  [   [1, 2], [6, 8], [3, 5],[4, 7],[9, 10] ]
 *  Output [   [1, 2], [3, 8],[9, 10] ]
 */
public class MergeOverlappingIntervals {

    public static int[][] mergeOverlappingIntervals(int[][] intervals) {
        // Write your code here.
        Arrays.sort(intervals, (a, b)->Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();
        int i=0;

        while(i< intervals.length){
            int[] mergedInterval = intervals[i];
            int  j =i+1;
            while(j<intervals.length && intervals[j][0]<=mergedInterval[1]){
                mergedInterval = new int[]{ Math.min(mergedInterval[0], intervals[j][0]), Math.max(mergedInterval[1], intervals[j][1]) };
                j++;
            }
            merged.add(mergedInterval);

            i = j;

        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {   {1, 2}, {6, 8}, {3, 5},{4, 7},{9, 10} };
        int[][] merged = mergeOverlappingIntervals(intervals);
        for (int[] interval : merged){
            System.out.println(interval[0]+"-"+interval[1]);
        }

    }
}
