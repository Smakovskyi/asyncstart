package ua.kpi.completable.future;

import java.util.concurrent.CompletableFuture;

public class ThenAcceptAsync {
  private static String getThreadName(){
    return " " + Thread.currentThread().getName();
  }
  public static void main(String[] args) {
    CompletableFuture<Void> result = CompletableFuture
        .supplyAsync(() -> "Hello " + getThreadName()  )
        .thenApplyAsync(s -> s + " world!" + getThreadName())
        .thenAcceptAsync( res -> System.out.println(res + getThreadName()) );
    System.out.println(result.isDone());
  }
}
