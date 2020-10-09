package ua.kpi.completable.future;

import java.util.concurrent.CompletableFuture;

public class ThenRun {

  public static void main(String[] args) {
    CompletableFuture<Void> result = CompletableFuture
        .supplyAsync(() -> "run")
        .thenRun( () -> System.out.println("Hello world!") );
    System.out.println(result.isDone());
  }
}
