package ua.kpi.completable.future;

import java.util.concurrent.CompletableFuture;

public class SupplyAsync {
  public static void main(String[] args) throws Exception{
    CompletableFuture<String> helloFuture = CompletableFuture
        .supplyAsync(() -> "Hello " + Thread.currentThread().getName())
        .thenApplyAsync( (res)->res + " World!");

    System.out.println(helloFuture.get());
  }
}
