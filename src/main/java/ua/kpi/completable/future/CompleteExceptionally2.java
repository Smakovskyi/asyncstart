package ua.kpi.completable.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompleteExceptionally2 {

  public static void main(String[] args) {
    CompletableFuture<String> first = CompletableFuture.supplyAsync(()->
    {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      return "hello";

    });
    first.completeExceptionally(new RuntimeException("exception"));
    try {   System.out.println(first.get());  } catch (InterruptedException e) {
      e.printStackTrace(); } catch (ExecutionException e) {
      System.out.println(e.getCause().getMessage());
    }

  }
}
