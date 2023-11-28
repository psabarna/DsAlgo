package concurrency.countdown;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Worker implements Runnable {
  int id;
  private List<String> outputScraper;
  private CountDownLatch countDownLatch;

  public Worker(List<String> outputScraper, CountDownLatch countDownLatch, int id) {
    this.outputScraper = outputScraper;
    this.countDownLatch = countDownLatch;
    this.id = id;
  }

  @Override
  public void run() {
    doSomeWork();

  }
  public void doSomeWork(){
    try {
      Thread.sleep(30000);
      //outputScraper.forEach(System.out::println);
    }catch (Exception e){
      e.printStackTrace();
    }
  }
}