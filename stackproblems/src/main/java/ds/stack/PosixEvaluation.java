package ds.stack;

import java.util.*;

public class PosixEvaluation {

    public static void main(String[] args) {
        String expr = "10 5 - 11 +";

        String[] arr = expr.split("\\s");

        List<String> operators = new ArrayList<String>(){{
            add("+");
            add("-");
            add("/");
            add("*");
        }};

        Stack<String> stack = new Stack<String>();

        for(String str : arr) {

            if(operators.contains(str)) {
                String first = stack.pop();
                String second = stack.pop();
                stack.push(String.valueOf(operate(first,second, str)));
            } else {
                stack.push(str);
            }
        }
        System.out.println(stack.pop());


    }

    private static int operate(String first, String second, String str) {
        Integer d1 = Integer.parseInt(first);
        Integer d2 = Integer.parseInt(second);

        switch(str) {
            case "+":
                return d1 + d2;

            case "-":
                return d1 - d2;

            case "/":
                return d1 / d2;

            case "*":
                return d1 * d2;

        }

        return -1;
    }
}
