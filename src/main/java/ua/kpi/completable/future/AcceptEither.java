package ua.kpi.completable.future;

import java.util.concurrent.CompletableFuture;

public class AcceptEither {

  public static void main(String[] args) {
    CompletableFuture<String> first = CompletableFuture
        .supplyAsync(() -> "first");
    CompletableFuture<String> second = CompletableFuture
        .supplyAsync( () -> "second");
    CompletableFuture<Void> result = first
        .acceptEither(second, str -> System.out.println(str));
  }
}
