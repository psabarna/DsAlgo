package grokking.mergeintervals.challenge;

import java.util.*;

public class MinimumMeetingRoom {

    static class Appointment {
        int start;
        int end;

        public Appointment(int start, int end) {
            this.start = start;
            this.end = end;
        }

    }

    public static int getMeetingRoomCount(List<Appointment> appointmentList){
        Collections.sort(appointmentList, (a,b)->(Integer.compare(a.start,b.start)));
        Map<Integer,Integer> roomBookingTimeMap = new HashMap<>();
        for(Appointment app: appointmentList){
            boolean isAccommodated = false;
            for(Map.Entry<Integer,Integer> entry: roomBookingTimeMap.entrySet()){
                if(entry.getValue()<= app.start){
                    roomBookingTimeMap.put(entry.getKey(), app.end);
                    isAccommodated = true;
                    break;
                }
            }

            if(!isAccommodated){
                roomBookingTimeMap.put(roomBookingTimeMap.size()+1, app.end);
            }
        }
        return roomBookingTimeMap.size();
    }

    public static int getMeetingRoomCount1(List<Appointment> appointmentList){
        Collections.sort(appointmentList, (a,b)->(Integer.compare(a.start,b.start)));
        PriorityQueue<Appointment> minHeap = new PriorityQueue<>(appointmentList.size(), (a,b)->Integer.compare(a.end,b.end));
        int roomCount = 0;
        for(Appointment app: appointmentList){
            while(!minHeap.isEmpty() && minHeap.peek().end<app.start){
                minHeap.poll();
            }
            minHeap.offer(app);
            roomCount = Math.max(roomCount, minHeap.size());
        }
        return roomCount;
    }


    public static void main(String[] args) {
        List<Appointment> appointmentList = new ArrayList<>();
        appointmentList.add(new Appointment(6,8));
        appointmentList.add(new Appointment(7,12));
        appointmentList.add(new Appointment(9,10));

        System.out.println(getMeetingRoomCount1(appointmentList));
    }

}
