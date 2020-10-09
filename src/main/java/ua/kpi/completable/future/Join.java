package ua.kpi.completable.future;

import java.util.concurrent.CompletableFuture;

public class Join {

  public static void main(String[] args) {
    String hello = CompletableFuture
        .supplyAsync(() -> "Hello ")
        .join();
    System.out.println(hello);
  }

}
