package ua.kpi.completable.future;

import java.util.concurrent.CompletableFuture;

public class ThenCompose {

  public static void main(String[] args) {
    CompletableFuture<String> first = CompletableFuture
        .supplyAsync(() -> "first");
    CompletableFuture<Void> result = first
        .thenCompose( str -> CompletableFuture.supplyAsync(
            () -> str + " second"))
            .thenAccept(System.out::println);
    result.join();
    System.out.println(result.isDone());
  }
}
