package ua.kpi;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ExceptionHandlingSample {
    public static void main(String[] args) {
        CompletableFuture.supplyAsync( () -> 2)
                .thenApplyAsync( x -> x*2)
                .thenApplyAsync( x -> {
                    throw new RuntimeException();
                } )
                .handle( (res, ex) -> {
                    if(ex != null){
                        System.out.println("An exception is occurred " + ex.toString());
                        return -1;
                    }else{
                        System.out.println("Result = " + res);
                        return res;
                    }
                }).thenAccept(res -> System.out.println(res));
        System.out.println("==================================");
        CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(() -> 2)
                .thenApplyAsync(x -> x * 2)
                .thenApplyAsync(x -> {
                    throw new RuntimeException();
                })
                .thenAccept(res -> System.out.println(res));
        try{
            completableFuture.get();
        }catch (InterruptedException | ExecutionException ex){
            System.out.println(ex.getCause());
        }
        System.out.println("=======================================");
        CompletableFuture.supplyAsync( () -> 2)
                .thenApplyAsync( x -> x*2)
                .thenApplyAsync( x -> {
                    throw new RuntimeException();
                })
                .exceptionally(ex -> {
                    System.out.println(ex);
                    return -1;
                })
                .thenAccept(res -> System.out.println(res));
    }
}
