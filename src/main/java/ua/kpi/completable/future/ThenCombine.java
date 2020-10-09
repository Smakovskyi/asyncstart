package ua.kpi.completable.future;

import java.util.concurrent.CompletableFuture;

public class ThenCombine {

  public static void main(String[] args) {
    CompletableFuture<String> first = CompletableFuture
        .supplyAsync(() -> "first");
    CompletableFuture<String> second = CompletableFuture
        .supplyAsync( () -> "second");
    CompletableFuture<Void> result = first
        .thenCombine( second, (f, s) -> f + " " + s)
        .thenAccept(System.out::println);
    System.out.println(result.isDone());
  }

}
