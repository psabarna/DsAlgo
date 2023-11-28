package grokking.mergeintervals.hard;

import java.util.Comparator;

public class Room implements Comparator {
    public int id;
    public int freeFrom;
    Room(int id, int freeFrom){
      this.id=id;
      this.freeFrom=freeFrom;
    }

    @Override
    public int compare(Object o1, Object o2) {
      Room r1 = (Room)o1;
      Room r2 = (Room)o2;
      final int compare = Integer.compare(r1.freeFrom, r2.freeFrom);
      if(compare!=0){
        return compare;
      }
      return Integer.compare(r1.id, r2.id);
    }


}
