package grokking.mergeintervals.challenge;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 1-4 3
 * 2-5 4
 * 7-9 6
 *
 * 1-2 3
 * 2-4 7
 * 4-5 3
 * 7-9 6
 */
public class MaximumCpuLoad {
    static class Job{
        int start;
        int end;
        int cpuLoad;

        public Job(int start, int end, int cpuLoad) {
            this.start = start;
            this.end = end;
            this.cpuLoad = cpuLoad;
        }
    }
    public static int findMaxCpuLoad(List<Job> jobs){
        int maxLoad = 0;
        Collections.sort(jobs, (a,b)->Integer.compare(a.start,b.start));
        PriorityQueue<Job> activeJobs = new PriorityQueue<>(jobs.size(), (a,b)->Integer.compare(a.end, b.end));
        int currentLoad = 0;
        for(Job job :jobs){
            while(!activeJobs.isEmpty() && activeJobs.peek().end< job.start){
                currentLoad-=activeJobs.poll().cpuLoad;
            }
            activeJobs.offer(job);

            currentLoad += job.cpuLoad;

            maxLoad = Math.max(maxLoad, currentLoad);
        }
        return maxLoad;
    }
    public static void main(String[] args) {
        List<Job> input = Arrays.asList(new Job(1,4,3),new Job(2,5,4), new Job(7,9,6));
        System.out.println("Max Cpu Load = "+ findMaxCpuLoad(input));

        List<Job> input1 = Arrays.asList(new Job(6,7,10),new Job(2,4,11), new Job(8,12,15));
        System.out.println("Max Cpu Load = "+ findMaxCpuLoad(input1));

        List<Job> input2 = Arrays.asList(new Job(1,4,2),new Job(2,4,1), new Job(3,6,5));
        System.out.println("Max Cpu Load = "+ findMaxCpuLoad(input2));

    }

}
