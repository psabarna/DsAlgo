package grokking.mergeintervals.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConflictingAppointment {
    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

    }
    //Expected that appointments are sorted
    public static boolean canAttendAllMeetings(List<Interval> appointments){
        int prevEnd = Integer.MIN_VALUE;
        Collections.sort(appointments, (a,b)->Integer.compare(a.start,b.start));
        for(Interval appointment: appointments){
            if(appointment.start<prevEnd){
                return false;
            }
            prevEnd = appointment.end;
        }
        return true;
    }
    public static void main(String[] args) {

        List<Interval> list1 = new ArrayList<>();
        list1.add(new Interval(6,7));
        list1.add(new Interval(2,4));
        list1.add(new Interval(8,12));

        System.out.println(canAttendAllMeetings(list1));

    }
}

