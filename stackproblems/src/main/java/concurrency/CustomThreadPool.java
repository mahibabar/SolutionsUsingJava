package concurrency;

import java.util.concurrent.*;
import java.util.stream.*;

public class CustomThreadPool {

    private int noOfThreads;
    private LinkedBlockingQueue<Runnable> queue;
    private PollWorker[] threads;

    public CustomThreadPool(int threadCount) {
        this.noOfThreads = threadCount;
        this.queue = new LinkedBlockingQueue<>();
        this.threads = new PollWorker[threadCount];

        for(int i =0; i< this.noOfThreads; i++) {
            threads[i] = new PollWorker();
            threads[i].start();
        }
    }

    public void submit(Runnable task) {

        synchronized (queue) {
            queue.add(task);
            queue.notify();
        }
    }

    public void shutdown() {

    }

    private class PollWorker extends Thread {

        @Override
        public void run() {
            Runnable task;

            while (true) {
                synchronized (queue) {

                    while(queue.isEmpty()) {
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    task = queue.poll();
                }

                try{
                    task.run();
                } catch (RuntimeException e) {
                    System.out.println("Task execution failed ");
                }
            }
        }
    }

    public static void main(String[] args) {
        CustomThreadPool tp = new CustomThreadPool(2);
        tp.submit(()-> {
            System.out.println("Task1 submitted....");
            IntStream.range(0, 10).forEach(i -> System.out.println("Task1 " + i));
        });

        tp.submit(()-> {
            System.out.println("Task2 submitted....");
            IntStream.range(0, 10).forEach(i -> System.out.println("Task2 " + i));
        });

        tp.submit(()-> {
            System.out.println("Task3 submitted....");
            IntStream.range(0, 10).forEach(i -> System.out.println("Task3 " + i));
        });

        tp.submit(()-> {
            System.out.println("Task4 submitted....");
            IntStream.range(0, 10).forEach(i -> System.out.println("Task4 " + i));
        });

        tp.submit(()-> {
            System.out.println("Task5 submitted....");
            IntStream.range(0, 10).forEach(i -> System.out.println("Task5 " + i));
        });

        ConcurrentHashMap hm = new ConcurrentHashMap();


    }
 }

