package com.mb.stackproblems;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author mahesh_babar
 * Apr 30, 2018 3:41:17 PM
 *
**/
public class ParenthesisBalancing {

	public static void main(String[] args) {
		//String str = "[{(())}]()[]";
		if(args ==null || args.length == 0) {
			throw new IllegalArgumentException("Invalid Input....");
		}
		String str = args[0];
		
		if(validate(str)) {
			System.out.println("Well balanced brackets...");
		} else {
			System.out.println("Unbalanced...");
		}
	}

	private static boolean validate(String str) {
		
		Map<Character, Character> chMap = new HashMap<>();
		chMap.put('{', '}');
		chMap.put('(', ')');
		chMap.put('<', '>');
		chMap.put('[', ']');
		
		Stack<Character> stack = new Stack<>();
		
		char[] charArr = str.toCharArray();
		if(null == charArr || charArr.length ==1 || !(charArr.length%2 ==0)) {
			return false;
		}
		
		for(Character ch : str.toCharArray()) {
			if(!stack.empty()) {
				
				char chprev = stack.pop();
				if(chMap.get(chprev) == ch) {
					//no need to push poped ch
				} else {
					stack.push(chprev);
					stack.push(ch);
				}
			} else {
				stack.push(ch);
			}
		}
		
		if(stack.isEmpty()) {
			return true;
		}
		
		return false;	
	}

}
