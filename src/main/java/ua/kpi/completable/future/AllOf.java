package ua.kpi.completable.future;

import java.util.concurrent.CompletableFuture;

public class AllOf {

  public static void main(String[] args) throws Exception {
    CompletableFuture<String> first = CompletableFuture
        .supplyAsync(() -> "first");
    CompletableFuture<String> second = CompletableFuture
        .supplyAsync( () -> "second");
    CompletableFuture<Void> voidFuture = CompletableFuture.allOf(first, second);
    voidFuture.get();
    System.out.println(first.isDone());
    System.out.println(second.isDone());
  }
}
