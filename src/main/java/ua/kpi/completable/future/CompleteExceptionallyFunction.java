package ua.kpi.completable.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompleteExceptionallyFunction {



  private static CompletableFuture<String> doSmth(CompletableFuture<String> in){
    return in.thenCompose( str -> {
      if (!str.isBlank()) {
        return CompletableFuture.supplyAsync(() -> str.toUpperCase());
      }
      CompletableFuture<String> result = new CompletableFuture<>();
      result.completeExceptionally(new RuntimeException("empty"));
      return result;
    });
  }

  public static void main(String[] args)  {
    CompletableFuture<String> first = CompletableFuture.supplyAsync(()->"aaa");
    //new CompletableFuture<>();
    //first.completeExceptionally(new RuntimeException("our exception"));
    first = doSmth(first);
    try {
      System.out.println(first.get());
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (ExecutionException e) {
      System.out.println(e.getCause().getClass());
      System.out.println(e.getCause().getMessage());
    }

  }
}
