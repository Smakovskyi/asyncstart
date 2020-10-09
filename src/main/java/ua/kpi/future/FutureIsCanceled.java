package ua.kpi.future;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

public class FutureIsCanceled {

  public static void main(String[] args) throws Exception {
    Future<String> future = ForkJoinPool.commonPool().submit(()->"Hello");
    Thread.sleep(100);
    boolean canceled = future.cancel(true);
    System.out.println(canceled);//returns true if future was canceled
  }

}
