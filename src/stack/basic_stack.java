package stack;
/*
 * solved!
 * 
 * https://www.acmicpc.net/problem/10828
 * 스택 
 * 
 * push X: 정수 X를 스택에 넣는 연산이다.
 * pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * size: 스택에 들어있는 정수의 개수를 출력한다.
 * empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
 * top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 */
import java.util.Scanner;
import java.util.Stack;

public class basic_stack {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      Stack<Integer> stack = new Stack<Integer>();
	  Scanner sc = new Scanner(System.in);
      int cnt = sc.nextInt();
  
      for(int i=0; i<cnt; i++) {
    	  String input = sc.next();
    	  if(input.contains("push")) {
    		int input2 = sc.nextInt();
    		stack.push(input2);
    	  }else if(input.equals("pop")){
    		 System.out.println(stack.isEmpty()?-1:stack.pop());
    	  }else if(input.equals("size")) {
    		  System.out.println(stack.size());
    	  }else if(input.equals("empty")) {
    		 System.out.println(stack.isEmpty()?1:0);
    	  }else if(input.equals("top")) {
    		System.out.println(stack.isEmpty()?-1:stack.peek());
    	  }
      }
      sc.close();
   }
}