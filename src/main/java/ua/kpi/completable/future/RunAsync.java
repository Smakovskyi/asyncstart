package ua.kpi.completable.future;

import java.util.concurrent.CompletableFuture;

public class RunAsync {

  public static void main(String[] args) throws Exception{
    CompletableFuture<Void> hello = CompletableFuture
        .runAsync(() -> System.out.println("Hello " +
            Thread.currentThread().getName()));

    hello.thenAccept(v -> System.out.println("World!"
        + Thread.currentThread().getName()));
  }
}
