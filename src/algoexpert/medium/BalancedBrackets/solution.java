package algoexpert.medium.BalancedBrackets;

import java.util.*;

class Program {
  public static boolean balancedBrackets(String str) {
    // Write your code here.
		// O(n) time | O(n) space
		Stack<Character> stack = new Stack<Character>();
		Character current;
		Character s;
		HashMap<Character, Character> hash = new HashMap<Character, Character>();
		hash.put(')','(');
		hash.put(']','[');
		hash.put('}','{');
		for(int i=0;i<str.length();i++){
			current = str.charAt(i);
			if(current =='('|| current =='{'|| current =='['){
				stack.add(current);
			} else if(hash.containsKey(current)) {
				if(!stack.isEmpty()){
					s = stack.pop();
					if(s != hash.get(current)) return false;
				} else return false;
			} 
		}
    return stack.size() == 0;
  }
}
