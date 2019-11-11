package concurrency;

import java.util.concurrent.*;
import java.util.concurrent.ExecutorService;

public class ThreadPoolWithThreadFactory {

    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool(new MyThreadFactory());

        es.submit(() -> {
            System.out.println("Submitted....");
        });

        es.shutdown();

        char ch = 'a';
        char chz = 'z';
        int a = (int)ch;
        int z = (int)chz;
        System.out.println("a = " + a + " z= " + z);
    }
}

class MyThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setName("My-Thread-Factory");
        return t;
    }
}