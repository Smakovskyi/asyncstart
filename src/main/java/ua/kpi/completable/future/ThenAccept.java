package ua.kpi.completable.future;

import java.util.concurrent.CompletableFuture;

public class ThenAccept {

  public static void main(String[] args) {
    CompletableFuture<Void> result = CompletableFuture
        .supplyAsync(() -> "Hello")
        .thenApply(s -> s + " world!")
        .thenAccept( res -> System.out.println(res) );
    System.out.println(result.isDone());
  }
}
