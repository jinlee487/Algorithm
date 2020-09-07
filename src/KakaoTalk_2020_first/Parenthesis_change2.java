package KakaoTalk_2020_first;

import java.util.Stack;

public class Parenthesis_change2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "(()())()";
		System.out.println(calc(input));
	}
	public static String calc(String s) {
		if (s.equals("")) return s;
		int c=0;
		String temp,u,v,answer = "";
		Stack<String> stack = new Stack<String>();
		stack.push(s.substring(0,1));
		for (int i=1;i<s.length()+1;i++) {
			c = i;
			
			if (i<s.length()) 
				temp = s.substring(i,i+1);
			else {
				break;
			}
			if(!stack.isEmpty()){
				if(!stack.peek().equals(temp)) {
					stack.pop();
				
				}
				else {
					stack.push(temp);
				}
			}
			else {
				break;
			}
		}
		

		u = s.substring(0,c);
		v = s.substring(c,s.length());
		
		if(u.substring(0,1).equals("(")) {
			answer += u+calc(v);
		}
		else {
			answer += "("+calc(v)+")";
			u=u.substring(1, u.length()-1);
			for (int j=0;j<u.length();j++) {
				if(u.substring(j,j+1).equals(")"))
					answer += "(";
				else {
					answer +=")";
				}
			}
		}
		return answer;
	}
}
