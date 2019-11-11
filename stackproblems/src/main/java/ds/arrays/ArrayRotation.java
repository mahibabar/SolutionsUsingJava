package ds.arrays;

public class ArrayRotation {

    public static void main(String[] args) {
        int a[] = new int[]{1,2,3,4,5,6};

        int k = 1;
        rotateArray(a, k);

        for (int j: a) {
            System.out.println(j);
        }

    }

    private static void rotateArray(int[] a, int k) {
        int l = a.length;
        for(int i=0;i<k; i++) {
            a[i] = a[i] + a[l - 1 - i];
            a[l - 1 - i] = a[i] - a[l - 1 - i];
            a[i] = a[i] - a[l - 1 - i];
        }
    }
}
