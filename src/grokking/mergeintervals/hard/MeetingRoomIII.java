package grokking.mergeintervals.hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomIII {



    public static int mostBooked(int n, int[][] meetings) {
      int[] count = new int[n];
      Room r1 = new Room(0,0);

      Arrays.sort(meetings, (a,b)->
          Integer.compare(a[0], b[0])
      );
      PriorityQueue<Room> rq = new PriorityQueue();

      rq.offer(new Room(0,0));
      rq.offer(new Room(1,0));
      rq.offer(new Room(2,0));
      int max = Integer.MIN_VALUE;
      for(int[] meeting: meetings){
        Room room = rq.poll();

        room.freeFrom = Math.max(room.freeFrom, meeting[0]) + (meeting[1]-meeting[0]);
        rq.offer(room);
        count[room.id]+=1;
        max= Math.max(max, count[room.id]);
      }
      return max;
    }

  public static void main(String[] args) {
    int[][] meetings = {{0,10},{1,5},{2,7},{3,4}};
    System.out.println(mostBooked(2, meetings));
  }

}
