package grokking.mergeintervals.medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InsertInterval {
    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

    }
    public static List<Interval> insert(List<Interval> intervalList, Interval newInterval){
        List<Interval> mergedIntervals = new ArrayList<>();
        Iterator<Interval> iterator = intervalList.iterator();
        Interval interval = iterator.next();

        int i =0;
        while(i< intervalList.size() && intervalList.get(i).end< newInterval.start){
            mergedIntervals.add(intervalList.get(i));
            i++;
        }
        
        while(i< intervalList.size() && intervalList.get(i).start< newInterval.end ){
            newInterval.start = Math.min(intervalList.get(i).start, newInterval.start);
            newInterval.end = Math.max(intervalList.get(i).end, newInterval.end);
            i++;
        }
        mergedIntervals.add(newInterval);
        while(i<intervalList.size()){
            mergedIntervals.add(intervalList.get(i));
            i++;
        }
        return mergedIntervals;
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(1,3));
        input.add(new Interval(5,7));
        input.add(new Interval(8,12));
        List<Interval>  merged = insert(input, new Interval(4,10));
        for(Interval interval: merged){
            System.out.println(interval.start+"->"+ interval.end);
        }
    }
}