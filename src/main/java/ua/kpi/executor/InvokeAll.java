package ua.kpi.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class InvokeAll {
  public static void main(String[] args) throws Exception {
    List<Callable<Integer>>  tasks = new ArrayList<>();
    tasks.add(() -> 1 + 1);
    tasks.add(() -> 2 + 2);
    tasks.add(() -> 3 + 3);
    ExecutorService pool = Executors.newCachedThreadPool();
    List<Future<Integer>> futures = pool.invokeAll(tasks);
    for(Future<Integer> future : futures){
      System.out.println(future.get());
    }

  }
}
