package stack;
/*
 * solved!
 * 
 * https://www.acmicpc.net/problem/10773
 * 제로
 */
import java.util.Scanner;
import java.util.Stack;

public class Zero_stack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	      Stack<Integer> stack = new Stack<Integer>();
		  Scanner sc = new Scanner(System.in);
	      int cnt = sc.nextInt();
	      for(int i=0; i<cnt; i++) {
	    	  int input = sc.nextInt();
	    	  if(input==0) {
	    		  stack.pop();
	    	  }
	    	  else {
	    		  stack.push(input);
	    	  }
	      }
	      int sum = 0;
	      int ss=stack.size();
	      for(int i=0;i<ss;i++){
	          sum += stack.pop();
	      }
	      System.out.println(sum);
	      sc.close();
	}
}
