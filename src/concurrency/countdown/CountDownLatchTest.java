package concurrency.countdown;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CountDownLatchTest {
  protected static Set<Integer> runningJobs = new HashSet<>();
  public static void main(String[] args) {
    List<Integer> ids = IntStream.range(1,98).boxed().collect(Collectors.toList());
    AtomicInteger counter = new AtomicInteger();
    ExecutorService executorService = Executors.newFixedThreadPool(20);


    final Collection<List<Integer>> values = ids.stream()
        .collect(Collectors.groupingBy(it -> counter.getAndIncrement() / 10)).values();
    for(List<Integer> batch : values) {
      runBatch(executorService, batch);
    }



  }

  private static void runBatch(ExecutorService executorService, List<Integer> batch) {

      CountDownLatch countDownLatch = new CountDownLatch(2);
      try{
        for(Integer id: batch){
          try {
            synchronized (runningJobs){
              runningJobs.add(id);
              runningJobs.notifyAll();
            }
            executorService.execute(new Worker(Arrays.asList(new String[]{" id " + id + "running"}), countDownLatch, id));
            System.out.println("Executed for job id:"+id);
          }finally{
            //System.out.println("Execution finished for id = "+id);

            System.out.println("Counted down for id = "+id);
            countDownLatch.countDown();
            synchronized (runningJobs) {
              runningJobs.remove(id);
              runningJobs.notifyAll();
            }
          }
        }
        System.out.println("Count down Await");
        countDownLatch.await();
        System.out.println("Count down Await Released");
      }catch(Exception e){
        System.out.println("Inside Outer Catch");
      }
      holdOn();

  }

  public static void holdOn() {
    int parallerJobCount =10; long waitTimeoutMillis = 3000;
    while (true) {
      synchronized (runningJobs) {
        try {
          //Wait till 70% of planner tasks are done.
          if (runningJobs.size() >= parallerJobCount * 0.7) {
            System.out.println(" need to wait since running_job_count={"+ runningJobs.size()+"} is more than 70pct of parallel_job_count={"+parallerJobCount);
            runningJobs.wait(waitTimeoutMillis);
          } else {
            System.out.println("holdOn completed, current total_planning_job_count={"+ runningJobs.size());
            break;
          }
        } catch (InterruptedException e) {
          System.out.println(" Interrupted exception while waiting for few jobs to finish");
          e.printStackTrace();
          Thread.currentThread().interrupt();
          break;
        }
      }
    }
  }

}
