package stack;

import java.util.Scanner;
import java.util.Stack;

/*
 * solved!!
 * 
 * https://www.acmicpc.net/problem/9012
 * 괄호
 */
public class Parenthesis_stack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  Scanner sc = new Scanner(System.in);
	      int cnt = sc.nextInt();
	      sc.nextLine();
	      String input;
	      String[] list;
	      for (int i=0;i<cnt;i++) {
		      Stack<String> stack = new Stack<String>();
	    	  input = sc.nextLine();
	    	  list = input.split("");
		      for(int j=0; j<list.length; j++) {
		    	  input = list[j];
		    	  if(input.equals(")")) {
		    		 try {
		    			 stack.pop();
					} catch (Exception e) {
						stack.push(input);
						break;
					}
		    		  
		    	  }
		    	  else {
		    		  stack.push(input);
		    	  }
		      }
		      System.out.println(stack.isEmpty()?"YES":"NO");
	      }
	      sc.close();
	}
}
