package ua.kpi.future;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

public class FutureIsNotCompleted {

  public static void main(String[] args) throws Exception {
    Future<String> future = ForkJoinPool.commonPool().submit(

        ()->{
              //Thread.currentThread().setDaemon(false);
              System.out.println(Thread.currentThread().isDaemon());
              System.out.println(Thread.currentThread().getName());
              Thread.sleep(100);
              System.out.println("Hello world!");
              return "Hello";
        } );

    future.get();
    Thread.sleep(10);
  }

}
