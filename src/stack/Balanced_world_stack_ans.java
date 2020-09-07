package stack;

import java.util.Scanner;
import java.util.Stack;

public class Balanced_world_stack_ans {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Character> st = new Stack<Character>();
		char temp;
		while (true) {
			st.clear();
			String s = sc.nextLine();
			if (s.equals(".")) {
				break;
			}

			for (int i = 0; i < s.length(); i++) {
				temp = s.charAt(i);
				if (temp == '(' || temp == '[') {
					st.push(temp);
				} else if (temp == ')' || temp == ']') {
					if (st.isEmpty() || (st.peek() == '(' && temp == ']') || (st.peek() == '[' && temp == ')')) {
						st.push(temp);
						break;
					}
					st.pop();
				}
			}
			if (!st.isEmpty())
				System.out.println("no");
			else
				System.out.println("yes");
		}
		sc.close();
	}
}           