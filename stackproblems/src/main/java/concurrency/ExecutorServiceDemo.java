package concurrency;

import java.util.concurrent.*;
import java.util.concurrent.ExecutorService;

public class ExecutorServiceDemo {
    public static void main(String[] args) {


        Executors.newCachedThreadPool();



        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() -> {
            System.out.println("Submitted task..");
            throw new RuntimeException("Exception....");
        });

        executorService.submit(() -> {
            System.out.println("Running another task");
        });


        ExecutorService executorService1 = Executors.newFixedThreadPool(1);
        executorService1.submit(() -> {
            System.out.println("Submitted task..");
            throw new RuntimeException("Exception....");
        });

        executorService1.submit(() -> {
            System.out.println("Running another task");
            throw new Exception();
        });

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        scheduledExecutorService.scheduleAtFixedRate(()-> {
            System.out.println("Running scheduled task...");
            throw new RuntimeException();
        }, 0, 100, TimeUnit.MILLISECONDS);
    }
}
