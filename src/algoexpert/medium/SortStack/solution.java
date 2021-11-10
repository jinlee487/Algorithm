package algoexpert.medium.SortStack;
import java.util.*;

class Program1 {

  public ArrayList<Integer> sortStack(ArrayList<Integer> stack) {
    // Write your code here.
		// O(n^2) time | O(n) space where n is the length of the stack
		if(stack.isEmpty()) return stack;
		int currentNumber = stack.remove(stack.size()-1);
		sortStack(stack);
		while(!stack.isEmpty()&&currentNumber<stack.get(stack.size()-1)){
			int nextNumber = stack.remove(stack.size()-1);
			stack.add(currentNumber);
			currentNumber = nextNumber;
			sortStack(stack);
		}
		stack.add(currentNumber);
    return stack;
  }
}


class Program2 {

  public ArrayList<Integer> sortStack(ArrayList<Integer> stack) {
    // Write your code here.
		if(stack.size() == 0) return stack;
		int current = stack.remove(stack.size()-1);
		sortStack(stack);
		sortStack(stack,current);
    return stack;
  }
	public void sortStack(ArrayList<Integer> stack, int value){
		if(stack.size()==0||stack.get(stack.size()-1)<=value) {
			stack.add(value);
			return;
		}
		int current = stack.remove(stack.size()-1);
		sortStack(stack,value);
		stack.add(current);
	}
}
