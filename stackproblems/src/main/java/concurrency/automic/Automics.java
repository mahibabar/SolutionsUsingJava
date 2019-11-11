package concurrency.automic;

import java.util.concurrent.atomic.*;

public class Automics {
    public static void main(String[] args) {
        AtomicBoolean ab = new AtomicBoolean();
        System.out.println(ab.get());

        ab.compareAndSet(false, true);

        System.out.println(ab.get());
    }
}
