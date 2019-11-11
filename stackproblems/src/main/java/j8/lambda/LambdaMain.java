package j8.lambda;

import java.util.*;

public class LambdaMain {
    public static void main(String[] args) {

        //Type Inference type for (first, second) detected from context i.e. Comparator<String>
        Comparator<String> comparator = (first, second) -> first.length() - second.length();

        Comparator<String> TypedComparator = (String first, String second) -> first.length() - second.length();

        //does not compile as no type is present in context
        //Comparator comparator = (first, second) -> first.length() - second.length();

        //treats type as Object
        Comparator comparator3 = (first, second) -> first.hashCode() - second.hashCode();
    }
}
