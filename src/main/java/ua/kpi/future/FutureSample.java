package ua.kpi.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureSample {

  public static void main(String[] args) {
    Future<Integer> future = ForkJoinPool.commonPool().submit( () -> 100500);

    try {
      System.out.println(future.get(1, TimeUnit.SECONDS));
    } catch (InterruptedException | ExecutionException | TimeoutException e ) {
      e.printStackTrace();
    }
  }

}
