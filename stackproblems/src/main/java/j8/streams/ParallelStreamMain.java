package j8.streams;

import java.util.*;
import java.util.stream.*;

public class ParallelStreamMain {
    public static void main(String[] args) {

        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};

        IntStream sequential = Arrays.stream(arr).sequential();
        IntStream parallel = Arrays.stream(arr).parallel();

        System.out.println("Processing sequential stream...");
        compute(sequential);

        System.out.println("Processing parallel stream...");
        compute(parallel);

    }

    private static void compute(IntStream stream) {
        stream.forEach(i -> {
            System.out.println("Printing " + i);
            System.out.println(Thread.currentThread().getName() );
        });
    }
}
