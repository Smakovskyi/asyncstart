package ua.kpi.completable.future;

import java.util.concurrent.CompletableFuture;

public class ThenAccept {

  public static void main(String[] args) {
    CompletableFuture<Void> result = CompletableFuture
        .supplyAsync(() -> "Hello")
        .thenApply(s -> s + " world!")
        .thenApplyAsync(s -> s + " add smth." )
        .thenAccept/*Async*/( res -> System.out.println(res + Thread.currentThread().getName()) );
    //result.join();
    System.out.println(result.isDone());
  }
}
