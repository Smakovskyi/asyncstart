package ua.kpi.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FirstExecutor {
  private static String getThreadName(){
    return " " + Thread.currentThread().getName();
  }
  public static void main(String[] args) throws Exception {
    ExecutorService pool = Executors.newCachedThreadPool();
    Future<?> future = pool.submit(() -> System.out.println(getThreadName()));
    System.out.println(future.isDone());
    Future<Integer> integerFuture = pool.submit(() -> 2 + 2);
    System.out.println(integerFuture.get());
  }
}
