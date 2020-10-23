package ua.kpi.completable.future;

import java.util.concurrent.CompletableFuture;

public class ThenCombineAsync {

  public static void main(String[] args) {
    CompletableFuture<String> first = CompletableFuture
        .supplyAsync(() -> "first");
    CompletableFuture<String> second = CompletableFuture
        .supplyAsync( () -> "second");
    CompletableFuture<String> third = CompletableFuture
        .supplyAsync( () -> "third");
    CompletableFuture<Void> result = first
        .thenCombineAsync( second, (f, s) -> f + " " + s)
        .thenCombineAsync( third, (f, s) -> f + " " + s)
        .thenApplyAsync( String::toUpperCase )
        .thenAcceptAsync(System.out::println);
    result.join();
    System.out.println(result.isDone());
  }
}
