package ua.kpi.executor.scheduled;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Scheduled {
  public static int delay(int seconds)  {
    try { Thread.sleep(seconds * 1000);
    } catch (InterruptedException e) { e.printStackTrace();}
    return seconds;
  }
  public static void main(String[] args) throws Exception {
    ScheduledExecutorService scheduledPool =
        Executors.newScheduledThreadPool(4);
    scheduledPool.scheduleWithFixedDelay( () -> {delay(1);
      System.out.println("work");}, 1,1, TimeUnit.SECONDS);

  }
}
