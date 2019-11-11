package ds.arrays;

public class ArrayNumberMultiplication {
    public static void main(String[] args) {
        int input[] = new int[] {2,4,5,7,8};
        int firstNum = 0;
        int secondNum = 0;
        boolean isPresent = false;
        // Get the first num.
        for (int i=0; i<input.length; i++) {
            int mod = 25%input[i];
            if (mod == 0) {
                secondNum = 25/input[i];
                firstNum = input[i];
                // Check if the second number is present in the array.
                if (checkValueInArray(input, secondNum)) {
                    isPresent = true;
                    break;
                }
            }
        }
        if (isPresent) {
            System.out.println( "First Number : " + firstNum + " and Second Number : " + secondNum);
        } else {
            System.out.println("Number's multiple of 20 not available.");
        }
    }
    private static boolean checkValueInArray(int numList[], int value) {
        boolean isPresent = false;
        // Check if the second number is present in the array.
        for (int j=0; j<numList.length; j++) {
            if (numList[j] == value) {
                isPresent = true;
                break;
            }
        }
        return isPresent;
    }
}
