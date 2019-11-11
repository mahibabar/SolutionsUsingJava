package concurrency.producer.consumer;

import java.util.*;

public class PCMain {
    public static void main(String[] args) {

        Queue<Integer> q = new LinkedList<Integer>();

        Producer p = new Producer(q, 10);
        Consumer c = new Consumer(q, 10);

        p.produce();
        c.consumer();
    }
}


class Producer {

    private Queue<Integer> queue;
    private int MAX_COUNT;

    public Producer(Queue<Integer> queue, int capacity) {
        this.queue = queue;
        this.MAX_COUNT = capacity;
    }

    public void produce() {

        Runnable r = () -> {

            long start = System.currentTimeMillis();
            boolean stop = false;

            while (true && !stop) {
                synchronized (queue) {
                    while (queue.size() == MAX_COUNT) {
                        try {
                            System.out.println("Producer is waiting....");
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    if(System.currentTimeMillis() - start >= 2000) {
                        queue.add(-9999);
                        stop = true;
                    }
                    Double d= Math.random() * 10;
                    int abs = d.intValue();
                    queue.add(abs);
                    System.out.println("Produced " + abs);
                    queue.notify();
                }
            }
        };

        Thread thread = new Thread(r);
        thread.start();
    }
}

class Consumer {

    private Queue<Integer> queue;
    int MAX_COUNT;

    public Consumer(Queue<Integer> queue, int capacity) {
        this.queue = queue;
        this.MAX_COUNT = capacity;
    }

    public void consumer() {


        Runnable r = () -> {

            boolean shouldStop = false;

            while(true) {
                synchronized (queue) {
                    while(queue.isEmpty()) {

                        if(shouldStop) {
                            System.out.println("Killing Consumer....");
                            System.exit(0);
                        }

                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    Integer poll = queue.poll();
                    if(poll == -9999) {
                        shouldStop =true;
                    }
                    System.out.println("Consumed message: " + poll);
                    queue.notify();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        };

        Thread t = new Thread(r);
        t.start();
        t.interrupt();
    }
}

