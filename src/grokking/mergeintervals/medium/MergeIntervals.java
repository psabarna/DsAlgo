package grokking.mergeintervals.medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MergeIntervals {
    static class Interval{
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static List<Interval> merge(List<Interval> intervalList){
        List<Interval> mergedIntervals = new ArrayList<>();
        Iterator<Interval> iterator = intervalList.iterator();
        Interval interval = iterator.next();
        int start = interval.start;
        int end = interval.end;

        while(iterator.hasNext()){
            interval = iterator.next();

            if(interval.start<=end){
                end = Math.max(end, interval.end);
            }else{
                mergedIntervals.add(new Interval(start,end));
                start = interval.start;
                end = interval.end;
            }
        }
        mergedIntervals.add(new Interval(start,end));
        return mergedIntervals;
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(1,4));
        input.add(new Interval(2,5));
        input.add(new Interval(7,9));
        List<Interval>  merged = merge(input);
        for(Interval interval: merged){
            System.out.println(interval.start+"->"+ interval.end);
        }

    }
}
