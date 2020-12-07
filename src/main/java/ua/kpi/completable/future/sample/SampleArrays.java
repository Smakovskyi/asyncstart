package ua.kpi.completable.future.sample;

import java.util.List;
import java.util.OptionalDouble;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SampleArrays {

  static int[] createArray(int size){
    int[] result = new int[size];
    Random rnd = new Random();
    for(int i=0; i<size; i++ ){
      result[i] = rnd.nextInt(size);
    }
    return result;
  }

  public static void main(String[] args) {
     int arraySize = 100;
     //arr1 -> avg
     //arr2 -> filter > avg1
     //arr3 ->
    CompletableFuture<OptionalDouble> avg = CompletableFuture
        .supplyAsync(() -> createArray(arraySize))
        .thenApplyAsync(arr -> IntStream.of(arr).average());
    CompletableFuture<List<Integer>> secondFiltered = CompletableFuture
        .supplyAsync(() -> createArray(arraySize))
        .thenCombine( avg, (arr, av) -> filterArray(arr, av));
    CompletableFuture<List<Integer>> third = CompletableFuture
        .supplyAsync(() -> createArray(arraySize))
        .thenApplyAsync( (ar) ->IntStream.of(ar).boxed().collect(Collectors.toList()));

    CompletableFuture<List<Integer>> listCompletableFuture = secondFiltered
        .thenCombine(third, (lst, ar) -> lst.stream().filter(el -> ar.contains(el))
            .collect(Collectors.toList()));

    listCompletableFuture.thenAccept( System.out::println );

    listCompletableFuture.join();


  }

  private static List<Integer> filterArray(int[] arr, OptionalDouble av) {
    return  av.isPresent() ? IntStream.of(arr).filter( el -> el > av.getAsDouble() )
        .boxed().collect(Collectors.toList())
        : IntStream.of(arr).boxed().collect(Collectors.toList() );
  }

}
