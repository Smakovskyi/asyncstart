package ua.kpi;

import com.sun.tools.javac.util.List;

public class ParallelStreams {

  public static void main(String[] args) {
    List.of("1","2").parallelStream().forEach(System.out::println);
  }

}
