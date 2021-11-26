package algoexpert.hard.ShortenPath;

import java.util.*;

class Program {
  public static String shortenPath(String path) {
    // Write your code here;
		Stack<String> stack = new Stack<String>();
		String[] arr = path.split("/");
		StringBuilder answer = new StringBuilder();
		int i = 0;
		if(arr.length==0) return "/";
		if(arr[i].equals("")) {
			answer.append("/");
			i++;
		}
		for(;i<arr.length;i++){
			if(arr[i].equals("") || arr[i].equals(".")) {
				continue;
			} else if(arr[i].equals("..")){
				if(stack.size()!=0) {
					if(!stack.peek().equals("..")) stack.pop();
					else stack.add(arr[i]);
				} else {
					if(answer.length()==0) stack.add(arr[i]);
				}
			} else {
				stack.add(arr[i]);
			}
		}
		answer.append(String.join("/", stack));
    return answer.toString();
  }
}
