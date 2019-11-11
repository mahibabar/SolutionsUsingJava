package ds.arrays;

public class NextBigNumber {
    public static void main(String[] args) {
        int input = 218795;
        int tokens[] = new int[countDigits(input)]; // The number of digits should be provided.
        String outputStr = "";
        // Tokenization.
        int count = tokens.length - 1;
        int tempInput = input;
        while((tempInput%10) != 0) {
            tokens[count] = tempInput%10;
            tempInput = tempInput/10;
            count--;
        }
        if (tokens.length == 1) { // Check for single digit number.
            outputStr = String.valueOf(input);
        } else if (tokens.length == 2) { // Check for double digit number.
            if (tokens[1] > tokens[0]) {
                outputStr = String.valueOf(tokens[1]) + String.valueOf(tokens[0]);
            } else {
                outputStr = String.valueOf(input);
            }
        } else if (tokens.length > 2) { // Check for more then two digit number.
            int firstDigit = tokens[0];
            int nextBiggestNumber = 0;
            boolean isNumberStored = true;
            String tempSortedNumStr = "";
            // Create a temp array.
            int tempCounter = 0;
            int tempArray[] = new int[tokens.length - 1];
            for (int j=1; j<tokens.length; j++) {
                tempArray[tempCounter] = tokens[j];
                tempCounter++;
            }
            int index = checkArrayIsAsecAndReturnIndex(tempArray) + 1;
            if (index == 0) { // The temp array is reverse asecending sorted.
                int nextNum1 = nextBigestNumber(tokens);
                int newArray[] = new int[tokens.length - 1];
                int testIndex = 0;
                for (int d=0; d<tokens.length; d++) {
                    if (tokens[d] != nextNum1) {
                        newArray[testIndex] = tokens[d];
                        testIndex++;
                    }
                }
                int nextSortedArray[] = storeAscending(newArray);
                outputStr = String.valueOf(nextNum1);
                for (int e=0; e<nextSortedArray.length; e++) {
                    outputStr = outputStr + String.valueOf(nextSortedArray[e]);
                }
            } else {
                int tempIndex = 0;
                int tempNewArray[] = new int[tokens.length - index];
                for (int l=index; l<tokens.length; l++) {
                    tempNewArray[tempIndex] = tokens[l];
                    tempIndex++;
                }
                int nextNum = nextBigestNumber(tempNewArray);
                int newTobeSortedArray[] = new int[tempNewArray.length-1];
                tokens[index] = nextNum;
                int abc = 0;
                for (int m=0; m<tempNewArray.length; m++) {
                    if (tempNewArray[m] != nextNum) {
                        newTobeSortedArray[abc] = tempNewArray[m];
                        abc++;
                    }
                }
                int newSortedArray[] = storeAscending(newTobeSortedArray);
                for (int n=0; n<=index; n++) {
                    outputStr = outputStr + String.valueOf(tokens[n]);
                }
                for (int p=0; p<newSortedArray.length; p++) {
                    outputStr = outputStr + String.valueOf(newSortedArray[p]);
                }
            }
        }
        System.out.println(outputStr);
    }
    // Count number of digit in a number.
    private static int countDigits(int num) {
        int count = 0;
        int input = num;
        while (input > 0) {
            input = input / 10;
            count++;
        }
        return count;
    }
    // Calculate next biggest number.
    private static int nextBigestNumber(int numList[]) {
        int arrayLength = numList.length;
        int tempBigest = 0;
        int nextBigest = 0;
        for (int i=1; i< arrayLength; i++) {
            int tmp = numList[i] - numList[0];
            if (tmp > 0 ) {
                if (tempBigest == 0 ) {
                    tempBigest = tmp;
                    nextBigest = numList[i];
                } else if (tempBigest > 0 && tmp < tempBigest) {
                    tempBigest = tmp;
                    nextBigest = numList[i];
                }
            }
        }
        if (tempBigest > 0) {
            return nextBigest;
        }
        return numList[0];
    }
    // Check if array is in ascending from reverse order, if not return the non matching index.
    private static int checkArrayIsAsecAndReturnIndex(int numList[]) {
        int index = 0;
        int i=numList.length-1;
        int j=i-1;
        while (i>=0 && j>=0) {
            if (!(numList[i] < numList[j])) {
                index = j;
                break;
            }
            i--;
            j--;
        }
        return index;
    }
    // Sort the array in ascending order.
    private static int[] storeAscending(int numList[]) {
        for (int i=0; i<numList.length; i++) {
            for (int j=i+1; j<numList.length; j++) {
                if (numList[j] < numList[i]) {
                    int tmp = numList[i];
                    numList[i] = numList[j];
                    numList[j] = tmp;
                }
            }
        }
        return numList;
    }
}