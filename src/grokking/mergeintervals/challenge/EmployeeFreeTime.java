package grokking.mergeintervals.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 1-3, 5-6
 *
 */
public class EmployeeFreeTime {
    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static class EmployeeInterval {
        int employeeNo;
        int intervalNo;
        Interval interval;

        public EmployeeInterval(int employeeNo, int intervalNo, Interval interval) {
            this.employeeNo = employeeNo;
            this.intervalNo = intervalNo;
            this.interval = interval;
        }
    }
    //Bruteforce(implemented only for two)
    /*public static List<Interval> getEmployeeFreeTime(List<List<Interval>> schedules){
        List<List<Interval>> freeTimes = new ArrayList<>();
        // Your code will replace this placeholder return statement
        for(List<Interval> schedule: schedules) {
            ArrayList<Interval> freeTime = new ArrayList<>();
            Interval prev = schedule.get(0);
            for (int i = 1; i < schedule.size(); i++) {
                freeTime.add(new Interval(prev.end, schedule.get(i).start));
                prev = schedule.get(i);
            }
            freeTimes.add(freeTime);
        }
        List<Interval>  ans = new ArrayList<>();
        List<Interval> free1 = freeTimes.get(0);
        List<Interval> free2 = freeTimes.get(1);

        int i =0; int j =0;
        while(i < free1.size() && j<free2.size()){
            Interval f1 = free1.get(i);
            Interval f2 =  free2.get(j);
            if((f1.start>=f2.start&& f1.start<=f2.end) || (f2.start>=f1.start && f2.start<=f1.end)){
                ans.add(new Interval(Math.max(f1.start, f2.start), Math.min(f1.end, f2.end)));
            }
            if(f1.end<f2.end){
                i++;
            }else{
                j++;
            }
        }


        return ans;

    }*/
    //Optimal Using PriorityQueue
    public static List<Interval> getEmployeeFreeTime(List<List<Interval>> schedules){

        List<Interval>  ans = new ArrayList<>();
        PriorityQueue<EmployeeInterval> queue = new PriorityQueue<>((a,b)-> Integer.compare(a.interval.start,b.interval.start));
        for(int i =0; i<schedules.size(); i++){
            queue.offer(new EmployeeInterval(i, 0, schedules.get(i).get(0)));
        }
        Interval prev = queue.peek().interval;
        while(!queue.isEmpty()){
            EmployeeInterval queueTop = queue.poll();

            if(prev.end<queueTop.interval.start){
                ans.add(new Interval(prev.end, queueTop.interval.start));
            }
            if(queueTop.intervalNo<schedules.get(queueTop.employeeNo).size()-1){
                queue.offer(new EmployeeInterval(queueTop.employeeNo, queueTop.intervalNo+1,schedules.get(queueTop.employeeNo).get(queueTop.intervalNo+1)));
            }
            if(queueTop.interval.end> prev.end){
                prev = queueTop.interval;
            }
        }

        return ans;

    }

    public static void main(String[] args) {
        List<List<Interval>> input = new ArrayList<>();
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1,3), new Interval(5,6))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2,3), new Interval(6,8))));
        List<Interval> result = getEmployeeFreeTime(input);
        System.out.println("Free intervals: ");
        for(Interval interval: result){
            System.out.println(interval.start+"->"+ interval.end);
        }

        input = new ArrayList<>();
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1,3), new Interval(9,12))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2,4))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(6,8))));
        result = getEmployeeFreeTime(input);
        System.out.println("Free intervals: ");
        for(Interval interval: result){
            System.out.println(interval.start+"->"+ interval.end);
        }


        input = new ArrayList<>();
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1,3))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2,4))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(3,5), new Interval(7,9))));
        result = getEmployeeFreeTime(input);
        System.out.println("Free intervals: ");
        for(Interval interval: result){
            System.out.println(interval.start+"->"+ interval.end);
        }
    }
}
