package ds.arrays;

import java.util.*;

public class NumbersAddUptoN {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        int sum = 7;

        Set<Integer> set = new HashSet<>();

        for(int i=0; i< arr.length; i++) {
            int diff = sum - arr[i];

            if(set.contains(diff)) {
                System.out.println("Two numbers are: " + arr[i] + " " + diff);
                break;
            } else {
                set.add(arr[i]);
            }
        }
    }
}
