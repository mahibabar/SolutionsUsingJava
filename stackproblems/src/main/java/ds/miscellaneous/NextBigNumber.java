package ds.miscellaneous;

import java.util.*;

public class NextBigNumber {

    public static void main(String[] args) {
        int num = 4525;

        int parseInt = getNext(num);

        System.out.println("NextBig number of " + num + " is: " + parseInt);
    }


    private static int getNext(int num) {

        String str = String.valueOf(num);
        char[] chars = str.toCharArray();

        if(num < 10) {
            return num;
        } else if(num < 100) {
            if(chars[0] < chars[1])
                return Integer.parseInt("" + chars[1] + chars[0]);
        }

        char start = chars[0];
        char init = chars[1];

        String substring = str.substring(2);
        char[] chars1 = substring.toCharArray();
        Arrays.sort(chars1);

        int foundIndex = 0;
        char nextBig = init;

        for(int i =0 ; i< chars1.length ; i++) {
            if(chars1[i] >= init) {
                nextBig = chars1[i];
                foundIndex = i;
                break;
            }
        }
        System.out.println("FoundIndex: " + foundIndex + " nextIndex: " + foundIndex);

        int lastIndex = ((foundIndex + 1) < chars1.length) ? (foundIndex + 1) : chars1.length;
        String s = substring.substring(0, foundIndex) + substring.substring(lastIndex) + init;

        char[] arr = s.toCharArray();
        Arrays.sort(arr);

        return Integer.parseInt("" + start + nextBig + new String(arr));
    }
}
