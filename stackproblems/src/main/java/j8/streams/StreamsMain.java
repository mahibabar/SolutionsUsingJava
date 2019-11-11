package j8.streams;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class StreamsMain {
    public static void main(String[] args) {

        Supplier<String> s = () -> { return UUID.randomUUID().toString();};

        Stream<String> uuidStream = Stream.generate(s);
        uuidStream.forEach(System.out::println);
    }
}
