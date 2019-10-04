package ua.kpi;

import java.util.concurrent.CompletableFuture;
import javax.sound.midi.Soundbank;

public class CompletableFutureRunner {

  public static void sayHelloWorld(){
    try{
      Thread.sleep(1000);
    }catch (Exception ex){

    }
    System.out.println( "Hello World from thread "  + Thread.currentThread().getName());
  }

  public static void main(String[] args) throws Exception {
    CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
      //sayHelloWorld();
      return "first";
    });
    Object result = CompletableFuture.anyOf(
        CompletableFuture.supplyAsync(() -> "first"),
        CompletableFuture.supplyAsync(() -> "second")
    ).get();
    System.out.println(result);
    //Thread.sleep(2000);
    System.out.println("===========all==Of============");
    CompletableFuture<Void> voidCompletableFuture = CompletableFuture
        .allOf(CompletableFuture.supplyAsync(() ->{sayHelloWorld(); return "first";}),
            CompletableFuture.supplyAsync(() -> "second"));
    voidCompletableFuture.thenRun(()-> System.out.println("first & second are finished"));
    Thread.sleep(2000);

    System.out.println("==============accept either=========");
    CompletableFuture<Void> voidCompletableFuture1 = CompletableFuture.supplyAsync(()->{sayHelloWorld(); return "first";})
        .acceptEither(CompletableFuture.supplyAsync(() -> "second"),
    (String res) -> System.out.println(res) );
    Thread.sleep(2000);
    System.out.println("=======then accept==============");
    CompletableFuture.supplyAsync(()->{sayHelloWorld(); return "first";})
        .thenAccept( res -> System.out.println("second " + res + " " + Thread.currentThread().getName()));
    Thread.sleep(2000);
    System.out.println();
    System.out.println("========then apply==============");
    CompletableFuture.supplyAsync(()->{sayHelloWorld(); return "first";})
        .thenApply( (param) -> param + " second")
        .thenApply( (param) -> param + " third")
        .thenAccept(System.out::println).get();
    System.out.println("======run==after==Either=====");
    CompletableFuture<String> first = CompletableFuture
        .supplyAsync(() -> "first");
    first.runAfterEither(CompletableFuture.supplyAsync(() -> "second") ,
        () -> {
          System.out.println("One of them completed");
        });
    System.out.println("============then===combine=============");

    CompletableFuture.supplyAsync(()->"first")
                     .thenCombine( CompletableFuture.supplyAsync(()->"second") ,
                         (arg1, arg2) -> arg1 + " " + arg2 )
        .thenAccept(System.out::println);
  }

}
