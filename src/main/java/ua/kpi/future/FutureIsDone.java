package ua.kpi.future;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

public class FutureIsDone {

  public static void main(String[] args) throws Exception {
    Future<String> future = ForkJoinPool.commonPool().submit(()->"Hello");
    while (!future.isDone()){
      Thread.sleep(10);
    }
    System.out.println(future.get());
  }

}
