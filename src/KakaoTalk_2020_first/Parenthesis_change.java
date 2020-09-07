package KakaoTalk_2020_first;

import java.util.Stack;

public class Parenthesis_change {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String input = ")()()()())()(()()()()()(";
		System.out.println(calc(input));
	}

	public static String calc(String s) {
		String[] list = s.split("");
		String[] output = new String[list.length];
		String result="";
		Stack<String> stack = new Stack<String>();
		Stack<Integer> loc = new Stack<Integer>();
		String val;
		int idx;
		for(int i=0; i<list.length; i++) {
			val = list[i];
	    	idx = i;
	    	if(val.equals(")") && !stack.isEmpty() && stack.peek().equals("(")) {
	    		
	    		output[loc.pop()] = stack.pop();
	    		output[idx] = val;
				continue;
	
	    	}
	    	else {
    			stack.push(val);
    			loc.push(idx);
	    	}
		}

		if(!stack.isEmpty()) {
			int size = stack.size();
			for (int i=0;i<size;i++) {
				val = stack.pop();
				val = val.equals("(")? ")":"(";
	    		output[loc.pop()] = val;
			}
		}
		for (String t:output)
			result+=t;
		return result;	
	}
}
