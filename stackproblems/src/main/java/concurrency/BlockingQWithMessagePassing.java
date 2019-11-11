package concurrency;

import java.util.concurrent.*;

public class BlockingQWithMessagePassing {
    public static void main(String[] args) {
        Exchanger<Boolean> excg = new Exchanger();
        BlockingQueue<String> bq = new ArrayBlockingQueue<>(5);

        Producer p = new Producer(bq, excg);
        Consumer c = new Consumer(bq, excg);

        Thread thread = new Thread(p);
        Thread thread1 = new Thread(c);
        thread.start();
        thread1.start();

        try {
            thread.join();
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class Producer implements Runnable {

    private BlockingQueue<String> queue;
    private Exchanger<Boolean> exchanger;

    public Producer(BlockingQueue queue, Exchanger<Boolean> exchanger) {
        this.queue = queue;
        this.exchanger = exchanger;
    }

    @Override
    public void run() {

        for(int i=0 ; i< 10 ; i++) {
            try {
                queue.put(" " + i);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            Boolean exchange = exchanger.exchange(false);
            System.out.println("Producer Exchanged value: is: " + exchange);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable {

    private BlockingQueue<String> queue;
    private Exchanger<Boolean> exchanger;

    public Consumer(BlockingQueue<String> queue, Exchanger exchanger) {
        this.queue = queue;
        this.exchanger = exchanger;
    }

    @Override
    public void run() {

        try {
            Boolean exchange = exchanger.exchange(true);
            System.out.println("Exchanged value: is: " + exchange);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("Consumed: " + queue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
