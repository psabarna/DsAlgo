package algo.expert.array.veryhard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppartmentHunting {

    public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {
        // Write your code here.
        List<Map<String,Integer>> minDistances= new ArrayList<>();
        //left to right
        Map<String,Integer> prevDist = new HashMap<>();
        int[] maxDistForBlock = new int[blocks.size()];
        for(int i =0; i< blocks.size(); i++){
            Map<String,Integer> leftDist = new HashMap<>();
            Map<String, Boolean> block = blocks.get(i);
            int max =0 ;
            for(String req: reqs){
                int dist =0;
                if(!block.get(req)){
                    dist = prevDist.getOrDefault(req, blocks.size()+1)+1;

                }
                leftDist.put(req, dist );
                if(dist > max){
                    max = dist;
                }
            }
            maxDistForBlock[i] = max;
            prevDist =  leftDist;
            minDistances.add(leftDist);
        }

        //right to left


        for(int i =blocks.size()-2; i>= 0; i--){
            Map<String,Integer> minDist = minDistances.get(i);
            prevDist =  minDistances.get(i+1);
            int max = 0;
            for(String req: reqs){
                int min = Math.min(minDist.get(req), prevDist.get(req)+1);
                if(min>max){
                    max = min;
                }
                minDist.put(req, min);
            }
            maxDistForBlock[i] = max;
            minDistances.set(i, minDist);
        }

        int minD = maxDistForBlock[0];
        int minDistIdx = 0;
        for(int i =1; i < maxDistForBlock.length; i++){
            if(maxDistForBlock[i]<minD){
                minD = maxDistForBlock[i];
                minDistIdx = i;
            }
        }

        return minDistIdx;
    }

    public static void main(String[] args) {
        Map<String, Boolean> block1 = Map.of("gym", false, "school", true, "store",false);
        Map<String, Boolean> block2 = Map.of("gym", true, "school", false, "store",false);
        Map<String, Boolean> block3 = Map.of("gym", true, "school", true, "store",false);
        Map<String, Boolean> block4 = Map.of("gym", false, "school", true, "store",false);
        Map<String, Boolean> block5 = Map.of("gym", false, "school", true, "store",true);

        List<Map<String, Boolean>> blocks = new ArrayList<>();
        blocks.add(block1);
        blocks.add(block2);
        blocks.add(block3);
        blocks.add(block4);
        blocks.add(block5);
        String [] reqs = new String[]{"gym", "school", "store"};

        System.out.println(apartmentHunting(blocks, reqs));

    }
}
