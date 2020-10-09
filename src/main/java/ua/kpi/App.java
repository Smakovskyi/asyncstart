package ua.kpi;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.Future;

/**
 * Hello world!
 *
 */
public class App {

    public static void sayHelloWorld(){
        CompletionStage completionStage;

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println( "Hello World from thread "  + Thread.currentThread().getName());
    }

    public static void main( String[] args ) throws ExecutionException, InterruptedException {
        ForkJoinPool.commonPool().execute( App::sayHelloWorld );
        System.out.println( "Hello World from thread "  + Thread.currentThread().getName());
        sayHelloWorld();
        int first = 2;
        int second = 3;

        Future<Integer> submit = ForkJoinPool.commonPool().submit(() -> first + second );
        System.out.println("we are waiting for the sum");
        System.out.println(submit.get());
    }
}
