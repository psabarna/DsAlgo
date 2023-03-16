package grokking.mergeintervals.medium;

import java.util.ArrayList;
import java.util.List;

public class IntervalIntersection {
    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

    }

    public static List<Interval> intersect(List<Interval> list1, List<Interval> list2){
        int i =0;
        int j=0;
        List<Interval> intersected = new ArrayList<>();
        while(i<list1.size() && j<list2.size()){
            Interval interval1 = list1.get(i);
            Interval interval2 = list2.get(j);
            if((interval2.start <=interval1.start && interval1.start<= interval2.end) || (interval2.start>=interval1.start && interval2.start<=interval1.end)){
                intersected.add(new Interval(Math.max(interval1.start, interval2.start), Math.min(interval1.end, interval2.end)));

            }
            {

                if (interval1.end < interval2.end) {
                    i++;
                } else if(interval1.end >interval2.end) {
                    j++;
                }else{
                    i++;
                    j++;
                }
            }

        }
        return intersected;
    }

    public static void main(String[] args) {

        List<Interval> list1 = new ArrayList<>();
        list1.add(new Interval(1,3));
        list1.add(new Interval(5,7));
        list1.add(new Interval(9,12));

        List<Interval> list2 = new ArrayList<>();
        list2.add(new Interval(5,10));
        //list2.add(new Interval(5,7));
        List<Interval> intersected = intersect(list1,list2);
        for(Interval interval: intersected){
            System.out.println(interval.start+"->"+interval.end);
        }

    }
}
