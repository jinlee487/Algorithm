package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

/*
 * 
 * https://www.acmicpc.net/problem/4949
 * 균형잡힌 세상
 */
public class Balanced_world_stack {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] list,slist;
		int count = 0;
		String s="";
		String ss="";
		while(sc.hasNextLine()) {
			s = sc.next();
			if(s.equals("(")||s.equals(")")||s.equals("[")||
				s.equals("]")||s.equals(" ")||s.equals(".")) {
				ss += s;
				count+=1;
			}
		}
		list = ss.split("\\.");
		
		for (int i=0;i<count-1;i++) {
		    Stack<String> stack = new Stack<String>();
			slist = list[i].split("");
			for (int j=0;j<slist.length;j++) {
				if (slist[j].equals("(")||slist[j].equals("[")) {
					stack.push(slist[j]);
				}
				else if (slist[j].equals(")")||slist[j].equals("]")) {
					if (stack.isEmpty()) {
						stack.push(slist[j]);
						break;
					}
					else if(stack.peek().equals("[")&&slist[j].equals("]")) {
						stack.pop();
					}
					else if(stack.peek().equals("(")&&slist[j].equals(")")) {
						stack.pop();
					}
					else {
						stack.push(slist[j]);
						break;
					}
				}
			}
		    System.out.println(stack.isEmpty()?"YES":"NO");
		}
		sc.close();
	}
}










