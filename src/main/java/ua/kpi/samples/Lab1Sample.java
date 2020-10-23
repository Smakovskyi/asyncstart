package ua.kpi.samples;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Lab1Sample {

  public static void main(String[] args) {
    int[] array = new int[100];
    Arrays.fill(array, 1);

    IntStream.range(0, array.length)
        .peek( index -> { array[index] += index; } )
        .forEach( x ->{});

    IntStream arrayStream = IntStream.of(array)
        .map( val -> val *2 )
        .boxed()
        .map( Object::toString)
        .map( val -> val + val)
        .peek(System.out::println)
        .mapToInt(Integer::valueOf);


    arrayStream.forEach(System.out::println);

  }

}
