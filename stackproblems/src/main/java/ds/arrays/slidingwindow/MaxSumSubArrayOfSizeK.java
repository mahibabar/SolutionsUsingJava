package ds.arrays.slidingwindow;

public class MaxSumSubArrayOfSizeK {

    public static void main(String[] args) {

        int[] arr = new int[]{1,2,3,4,5};
        int win = 2;

        int max = 0;

        for(int i=0;i<arr.length;i++) {

            int sum =0;

            if(i+win-1 < arr.length) {
                for(int j=0;j<win;j++)
                sum += arr[i+j];
            }
            if(sum > max) {
                max = sum;
            }
        }
        System.out.println("Result: " + max);
    }
}
