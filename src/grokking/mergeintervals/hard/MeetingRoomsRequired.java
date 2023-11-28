package grokking.mergeintervals.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MeetingRoomsRequired {
  public static int countRooms(int[][] meetings){
    Arrays.sort(meetings, (a,b)-> Integer.compare(a[0], b[0]));
    List<int[]> roomFreeTime = new ArrayList<>();

    for(int[] meeting: meetings){
      if(!book(roomFreeTime, meeting)){
        roomFreeTime.add(new int[]{meeting[1], 24});
      }
    }
    return roomFreeTime.size();
  }

  public static int countRooms2(int[][] meetings){
    Arrays.sort(meetings, (a,b)-> Integer.compare(a[0], b[0]));

    PriorityQueue<int[]> rooms = new PriorityQueue<>(meetings.length, (a,b)-> Integer.compare(a[1], b[1]));
    for(int[] meeting: meetings){
      if(!rooms.isEmpty() && meeting[0]>= rooms.peek()[1]){
        rooms.poll();
      }
      rooms.offer(meeting);
    }
    return rooms.size();
  }

  private static boolean book(List<int[]> freeTimes, int[] meeting){
    for(int[] free: freeTimes){
      if(meeting[0]>=free[0]){
        free[0] = meeting[1];
        return true;
      }
    }
    return false;
  }
  public static void main(String[] args) {
    int[][] m1 = {{1,4}, {2,5}, {7,9}};
    int[][] m2 =  {{6,7}, {2,4}, {8,12}};
    int[][] m3 = {{1,4}, {2,3}, {3,6}};
    int[][] m4 = {{4,5}, {2,3}, {2,4}, {3,5}};
    System.out.println(countRooms2(m1));
    System.out.println(countRooms2(m2));
    System.out.println(countRooms2(m3));
    System.out.println(countRooms2(m4));
  }

}
