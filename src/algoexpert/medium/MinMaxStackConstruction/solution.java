package algoexpert.medium.MinMaxStackConstruction;

import java.util.*;

class Program {
  // Feel free to add new properties and methods to the class.
  static class MinMaxStack {
		List<int[]> minMaxStack = new ArrayList<int[]>();
		List<Integer> stack = new ArrayList<Integer>();
    public int peek() {
      // Write your code here.
      return stack.get(stack.size()-1);
    }

    public int pop() {
      // Write your code here.
			minMaxStack.remove(minMaxStack.size()-1);
      return stack.remove(stack.size()-1);
    }

    public void push(Integer number) {
      // Write your code here.
			int[] newMinMax = new int[2];
			newMinMax[0] = number;
			newMinMax[1] = number;
			if(minMaxStack.size()>0) {
				newMinMax[0] = Math.min(number,minMaxStack.get(minMaxStack.size()-1)[0]);
				newMinMax[1] = Math.max(number,minMaxStack.get(minMaxStack.size()-1)[1]);
			}
			minMaxStack.add(newMinMax);
			stack.add(number);
    }

    public int getMin() {
      // Write your code here.
      return minMaxStack.get(minMaxStack.size()-1)[0];
    }

    public int getMax() {
      // Write your code here.
      return minMaxStack.get(minMaxStack.size()-1)[1];
    }
  }
}
