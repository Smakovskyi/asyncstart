package ua.kpi;


import java.util.List;

public class ParallelStreams {

  public static void main(String[] args) {
    List.of("1","2").parallelStream().forEach(System.out::println);
  }

}
