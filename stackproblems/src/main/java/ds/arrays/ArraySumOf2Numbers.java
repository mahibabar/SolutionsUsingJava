package ds.arrays;

import java.util.*;

public class ArraySumOf2Numbers {
    public static void main(String[] args) {
        //int arr[] = new int[]{-8, 1, 4, 6, 10, 45};
        int arr[] = new int[]{7, 9, 4, 6, 1, 45};

        Arrays.sort(arr);

        int l=0, r=arr.length -1 ;
        int sum =16;

        for (int i =0; i< arr.length; i++) {

            int result =arr[l] + arr[r];

            if(result == sum) {
                System.out.println("Found pair " + arr[l] + " and " + arr[r]);
                break;
            }

            if(result < sum) {
                l++;
            }

            if(result > sum) {
                r--;
            }
        }
    }
}
