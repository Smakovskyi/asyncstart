package ua.kpi.completable.future;

import java.util.concurrent.CompletableFuture;

public class RunAfterEither {
  public static void main(String[] args) {
    CompletableFuture<String> first = CompletableFuture
        .supplyAsync(() -> "first");
    CompletableFuture<String> second = CompletableFuture
        .supplyAsync( () -> "second");
    CompletableFuture<Void> result = first
        .runAfterEither(second, () -> System.out.println("Hello!"));
    System.out.println(result.isDone());
  }
}
