package ua.kpi;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;

public class LectureSamples {
    public static void main(String[] args) throws Exception {
        CompletableFuture.runAsync(
                () -> System.out.println(Thread.currentThread().getName()))
                .get();
        System.out.println(Thread.currentThread().getName());
        System.out.println("=========================================");
        int first = 1, second = 2, third = 3, fourth = 4;
        CompletableFuture.supplyAsync( () -> {
            System.out.println(Thread.currentThread().getName());
            return first + second;
        }).thenApply( x->{
            System.out.println(Thread.currentThread().getName());
            return x+third;
        }).thenApplyAsync( x ->{
            System.out.println(Thread.currentThread().getName());
            return x+fourth;
        } ).thenAccept( res ->{
            System.out.println(Thread.currentThread().getName());
            System.out.println("Sum=" + res);
        });
        System.out.println("=========================================");
        CompletableFuture.supplyAsync( () -> {
            System.out.println(Thread.currentThread().getName());
            return first + second;
        }).thenApplyAsync( x->{
            System.out.println(Thread.currentThread().getName());
            return x+third;
        }).thenApplyAsync( x ->{
            System.out.println(Thread.currentThread().getName());
            return x+fourth;
        }).thenAcceptAsync( res ->{
            System.out.println(Thread.currentThread().getName());
            System.out.println("Sum=" + res);
        });
        System.out.println("=========================================");
        CompletableFuture<Integer> sum12 = CompletableFuture.supplyAsync(() -> first + second);
        CompletableFuture<Integer> sum34 = CompletableFuture.supplyAsync(() -> third + fourth);
        sum12.thenCombine(sum34, (a, b) -> a + b).thenAccept((sum) -> System.out.println("Sum = " + sum));

    }
}
