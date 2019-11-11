package concurrency;

import java.util.*;
import java.util.concurrent.*;

public class ConcurrentNavigableMapMain {
    public static void main(String[] args) {
        NavigableMap<Integer, String> map = new ConcurrentSkipListMap<>();
        map.put(1,"One");
        map.put(2, "Two");
        map.put(3,"Three");
        map.put(4,"Four");
        map.put(5, "Five");
        map.put(6, "Six");

        SortedMap<Integer, String> integerStringSortedMap = map.headMap(4);
        System.out.println(integerStringSortedMap);

        System.out.println(map.tailMap(4, true));

        Semaphore sp = new Semaphore(1);

        Executors.newSingleThreadExecutor();

        Executors.newCachedThreadPool();
        Executors.newFixedThreadPool(10);
        Executors.newScheduledThreadPool(10);

    }
}
