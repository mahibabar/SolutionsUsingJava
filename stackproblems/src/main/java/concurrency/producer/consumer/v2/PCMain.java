package concurrency.producer.consumer.v2;


import java.util.concurrent.*;

public class PCMain {
    public static void main(String[] args) {

        Model model = new Model(10);
        Producer p = new Producer(model);
        Consumer c = new Consumer(model);

        p.produce();
        c.consumer();
    }
}

class Model {

    private BlockingQueue<Integer> q;
    private volatile boolean isRunning;
    private int capacity;

    public Model(int capacity) {
        this.capacity = capacity;
        this.q = new ArrayBlockingQueue<Integer>(10);
        this.isRunning = true;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public BlockingQueue<Integer> getQ() {
        return q;
    }
}


class Producer {

    private Model model;

    public Producer(Model model) {
        this.model = model;
    }

    public void produce() {

        Runnable r = () -> {

            long start = System.currentTimeMillis();

            while (true && model.isRunning()) {


                Double d = Math.random() * 100;
                int abs = d.intValue();
                try {
                    model.getQ().put(abs);
                    System.out.println("Produced " + abs);
                    //Thread.sleep(200);

                    if(System.currentTimeMillis() - start > 500) {
                        model.setRunning(false);
                        System.out.println("Producer signaling Stop");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };

        Thread thread = new Thread(r);
        thread.start();
    }
}

class Consumer {

    private Model model;

    public Consumer(Model model) {
        this.model = model;
    }

    public void consumer() {

        Runnable r = () -> {

            while(true) {
                try {
                    if(model.getQ().isEmpty() && !model.isRunning()) {
                        System.out.println("Stopping Consumer");
                        break;
                    }
                    System.out.println("Consumed " + model.getQ().take());
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };

        Thread t = new Thread(r);
        t.start();
    }
}