package ua.kpi.completable.future;

import java.util.concurrent.CompletableFuture;

public class AnyOf {

  public static void main(String[] args) throws Exception {
    CompletableFuture<String> first = CompletableFuture
        .supplyAsync(() -> "first");
    CompletableFuture<String> second = CompletableFuture
        .supplyAsync( () -> "second");
    CompletableFuture<Object> result = CompletableFuture.anyOf(first, second);
    System.out.println(result.get());
    System.out.println(first.isDone());
    System.out.println(second.isDone());
  }
}
