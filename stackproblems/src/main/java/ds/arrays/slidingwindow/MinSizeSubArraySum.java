package ds.arrays.slidingwindow;

import java.util.*;
import java.util.function.*;

public class MinSizeSubArraySum {
    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 3, 4, 5};
        int total = 10;

        int sum =0;
        int minLen = Integer.MAX_VALUE;
        int start =0;

        for(int end = 0;end<arr.length;end++) {
            sum+= arr[end];

            while(sum >= total) {
                minLen = Math.min(minLen, end -start +1);
                sum -= arr[start];
                start++;
            }
        }

        System.out.println("Min length is: " + minLen);
    }
}
