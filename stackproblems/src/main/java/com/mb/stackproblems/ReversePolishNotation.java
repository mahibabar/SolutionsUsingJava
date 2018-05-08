package com.mb.stackproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author mahesh_babar
 * May 8, 2018 5:22:40 PM
 *
**/
public class ReversePolishNotation {

	public static void main(String[] args) {
		//sample input 10 5 / 11 +
		//output (10/5) + 11
				if(args ==null || args.length <3) {
					throw new IllegalArgumentException("Invalid Input....");
				}
				
				List<String> asList = Arrays.asList(args);
				
				System.out.println("Input is: " + asList);
				System.out.println("Result is: " + eval(asList));
	}

	private static double eval(List<String> asList) {
		
		if(null == asList || asList.size() <3 ) {
			return -1;
		}
		
		@SuppressWarnings("serial")
		List<String> operators = new ArrayList<String>() {{
			add("+");
			add("-");
			add("/");
			add("*");
		}};
		
		Stack<String> stack = new Stack<>();
		
		for(String input : asList) {
			if(operators.contains(input)) {
				String second = stack.pop();
				String first = stack.pop();
				
				double result = operate(first, second, input);
				stack.push("" + result);
			} else {
				stack.push(input);
			}
		}
		
		return Double.parseDouble(stack.pop());
		
	}

	private static double operate(String first, String second, String operator) {
		
		double d1 = Double.parseDouble(first.trim());
		double d2 = Double.parseDouble(second.trim());
		
		switch(operator) {
			case "+" :
				return d1 + d2;
			
			case "-" :
				return d1 - d2;
			
			case "/" :
				return d1 / d2;
			
			case "*" :
				return d1 * d2;

			default: 
				return -1;
				
		}
	}

}
