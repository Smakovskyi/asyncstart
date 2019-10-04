package ua.kpi;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import lombok.SneakyThrows;

public class TwoTaskRunner {


  @SneakyThrows
  public String firstLongTask(){
    Thread.sleep(3000);
    return "first Result";
  }

  @SneakyThrows
  public String secondLongTask(){
    Thread.sleep(3000);
    return "second Result";
  }


  public String thirdTask(String param){
    return "third Result" + param;
  }


  public String firstTaskWithException(){
    throw new RuntimeException("Exception in the first rask");
  }

  public String sequentialFlow(){
    String firstResult = firstLongTask();
    String secondResult = secondLongTask();
    String result = thirdTask(firstResult + secondResult);
    return result;
  }

  @SneakyThrows
  public String parallelFlow(){
    CompletableFuture<String> first = CompletableFuture.supplyAsync( ()->firstLongTask() );
    CompletableFuture<String> second = CompletableFuture.supplyAsync( ()->secondLongTask());
    return first.thenCombine( second, (res1, res2) -> res1 + res2)
          .thenApply(this::thirdTask).get();
  }

  @SneakyThrows
  public String parallelFlowWithException(){
    CompletableFuture<String> first = CompletableFuture.supplyAsync( ()->firstTaskWithException() );
    CompletableFuture<String> second = CompletableFuture.supplyAsync( ()->secondLongTask());
    return first.thenCombine( second, (res1, res2) -> res1 + res2)
        .thenApply(this::thirdTask)
        .exceptionally((exception)->"completed with exception"+exception.getMessage())
        .get();
  }


  @SneakyThrows
  public CompletableFuture<String> asyncFlow(){
    CompletableFuture<String> first = CompletableFuture.supplyAsync( ()->firstLongTask() );
    CompletableFuture<String> second = CompletableFuture.supplyAsync( ()->secondLongTask());
    return first.thenCombine( second, (res1, res2) -> res1 + res2)
        .thenApplyAsync(this::thirdTask);
  }

  @SneakyThrows
  public CompletableFuture<String> asyncFlowWithException(){
    CompletableFuture<String> first = CompletableFuture.supplyAsync( ()->firstTaskWithException() );
    CompletableFuture<String> second = CompletableFuture.supplyAsync( ()->secondLongTask());
    return first.thenCombine( second, (res1, res2) -> res1 + res2)
        .thenApplyAsync(this::thirdTask);
  }


  @SneakyThrows
  public static void main(String[] args) {
    TwoTaskRunner twoTaskRunner = new TwoTaskRunner();
   /* String result = twoTaskRunner.sequentialFlow();
    System.out.println(result);

    String parallelResult = twoTaskRunner.parallelFlow();
    System.out.println(parallelResult);

    CompletableFuture<String> asyncResult = twoTaskRunner.asyncFlow();
    System.out.println("We have result");
    asyncResult.thenAccept(System.out::println);
*/

    String result = twoTaskRunner.parallelFlowWithException();
    System.out.println(result);

    CompletableFuture<String> stringCompletableFuture = twoTaskRunner.asyncFlowWithException();
    stringCompletableFuture.handle((res,ex)->
      ex == null ? "Result = " + res: "Error " + ex.getMessage()
    ).thenAccept(System.out::println);

    Thread.sleep(4000);

  }

}
