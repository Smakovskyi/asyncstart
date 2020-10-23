package ua.kpi.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

public class FutureException {

  public static void main(String[] args) {
    Future<Integer> future = ForkJoinPool.commonPool().submit(
        () -> {throw new IllegalArgumentException("Sample");} );

    try {
      System.out.println(future.get());
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (ExecutionException e) {
      System.out.println(e.getCause().getClass());
      System.out.println(e.getCause().getMessage());
    }
  }
}
