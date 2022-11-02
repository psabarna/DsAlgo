package algo.expert.array.veryhard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LineThroughPoints {

    public static int lineThroughPoints(int[][] points) {
        // Write your code here.
        int maxCommonSlopeCnt = 0;
        Map<Double, Set<String>> slopes = new HashMap<>();
        for(int idx1 =0; idx1< points.length; idx1++){
            int[] pt1 = points[idx1];
            for(int idx2 = idx1+1; idx2< points.length; idx2++){
                int[] pt2 = points[idx2];
                double slope = Integer.MAX_VALUE;
                if(pt2[0]!= pt1[0]) {
                    slope = (double) (pt2[1] - pt1[1]) / (pt2[0] - pt1[0]);
                    slope = Math.round(slope * 100) / 100D;
                }
                Set<String> slopePoints = slopes.getOrDefault(slope, new HashSet<>());
                slopePoints.add(pt1[0]+""+pt1[1]);
                slopePoints.add(pt2[0]+""+pt2[1]);
                slopes.put(slope, slopePoints);
                if(slopePoints.size()> maxCommonSlopeCnt){
                    maxCommonSlopeCnt = slopePoints.size();
                }
            }
        }
        return maxCommonSlopeCnt;
    }
    public static void main(String[] args) {
        int[][] input = {
                {1, 1},
                {2, 2},
                {3, 3},
                {0, 4},
                {-2, 6},
                {4, 0},
                {2, 1}
                        };

        int[][] points = {
                {3, 3},
                {0, 4},
                {-2, 6},
                {4, 0},
                {2, 1},
                {3, 4},
                {5, 6},
                {0, 0}
        };


        System.out.println(lineThroughPoints(points)  );
    }
}
