package stack;

import java.util.Scanner;
import java.util.Stack;

public class Stack_Sequence {
	static StringBuilder sb = new StringBuilder();
	static Scanner sc = new Scanner(System.in);
	static int N,cnt=1;
	static Stack<Integer> stack;
	static int[] input;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		N = sc.nextInt();
		input = new int[N+1];
		stack = new Stack<Integer>();
		for (int i=1;i<N+1;i++) {
			input[i] = sc.nextInt();
		}
		for (int i=1;i<N+1;i++) {
			stack.push(i);
			sb.append("+\n");
			while (stack.peek()==input[cnt]) {
				stack.pop();
				sb.append("-\n");
				cnt+=1;
				if(stack.isEmpty()) break;
			}
		}
		if(cnt!=N+1) {
			System.out.println("NO");
		}
		else System.out.println(sb);
	}
}
