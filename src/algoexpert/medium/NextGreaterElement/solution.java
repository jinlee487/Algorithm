package algoexpert.medium.NextGreaterElement;
import java.util.*;

class Program {

  public int[] nextGreaterElement(int[] array) {
    // Write your code here.
		int[] answer = new int[array.length];
		Arrays.fill(answer,-1);
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=0;i<array.length*2;i++){
			int idx = i%array.length;
			while(stack.size()>0 && array[stack.peek()] < array[idx]){
				answer[stack.pop()] = array[idx];
			}
			stack.push(idx);
		}
		return answer;
  }
}
