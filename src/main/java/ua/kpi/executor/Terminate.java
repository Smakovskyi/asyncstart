package ua.kpi.executor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Terminate {
  public static int delay(int seconds)  {
    try { Thread.sleep(seconds * 1000);
    } catch (InterruptedException e) { e.printStackTrace();}
    return seconds;
  }
  public static void main(String[] args) throws ExecutionException, InterruptedException {
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    Future<Integer> first = executorService.submit(() -> delay(1));
    Future<Integer> second = executorService.submit(() -> delay(2));
    executorService.shutdown();
    System.out.println(first.get());
    System.out.println(second.get());
    executorService.submit(() -> delay(3));
  }
}
