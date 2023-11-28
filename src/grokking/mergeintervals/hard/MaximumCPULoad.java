package grokking.mergeintervals.hard;

import java.util.Arrays;
import java.util.List;

public class MaximumCPULoad {

  class Job{
    int start;
    int end;
    int load;

    public Job(int start, int end, int load) {
      this.start = start;
      this.end = end;
      this.load = load;
    }
  }
  public static int maxCpuLoad(int[][] jobs){
    if(jobs.length==0){
      return 0;
    }
    Arrays.sort(jobs, (a,b)-> Integer.compare(a[0], b[0]));
    int i=0;
    int j =1;
    int maxLoad = jobs[0][2];
    while(j< jobs.length){

    }
    return 0;
  }
  public static void main(String[] args) {

  }

}
