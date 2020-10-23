package ua.kpi.completable.future;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class HandleWithOptional {

  public static void main(String[] args) throws Exception {
    CompletableFuture
        .supplyAsync(() -> {
          //return "aaa";
          throw new RuntimeException("Error message");
        })
        .handle((res, ex) -> res != null ? Optional.of(res) :
            Optional.empty())
        .thenApply( opt -> opt.map(s -> s + "!!!!" ) )
        .get().ifPresent( System.out::println );

  }

}
