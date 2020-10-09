package ua.kpi.completable.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompleteExceptionally {

  public static void main(String[] args)  {
    CompletableFuture<String> first = new CompletableFuture<>();
    first.completeExceptionally(new RuntimeException("exception"));
    try {
      System.out.println(first.get());
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (ExecutionException e) {
      System.out.println(e.getCause().getMessage());
    }

  }
}
