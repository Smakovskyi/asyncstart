package ua.kpi.completable.future;

import java.util.concurrent.CompletableFuture;

public class Handle {

  public static void main(String[] args) throws Exception {
    CompletableFuture<Object> errorMessage = CompletableFuture
        .supplyAsync(() -> {
          throw new RuntimeException("Error message");
        })
        .handle((res, ex) -> res != null ? res : ex.getCause().getMessage())
        .thenApply( s ->s + "!!!!!" );
    System.out.println( errorMessage.get() );
  }

}
