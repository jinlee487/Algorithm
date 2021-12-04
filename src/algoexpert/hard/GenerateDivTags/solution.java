package algoexpert.hard.GenerateDivTags;

import java.util.*;

class Program1 {

  public ArrayList<String> generateDivTags(int numberOfTags) {
    // Write your code here.
		// brute force
		ArrayList<String> answer = new ArrayList<String>();
		ArrayList<String> array = new ArrayList<String>();
		array.add("<div>");
		generateDivTags(numberOfTags, answer, array, 1 ,0);
    return answer;
  }
	public void generateDivTags(int numberOfTags, ArrayList<String> answer, ArrayList<String> array, int openCount, int closeCount){		
		if(numberOfTags <= openCount && numberOfTags <= closeCount) {
			System.out.println(array);
			if(check(array)){
				answer.add(String.join("",array));
			}
			return;
		}
		String open = "<div>";
		String close = "</div>";
		if(openCount < numberOfTags && closeCount < numberOfTags){
			array.add(open);
			generateDivTags(numberOfTags, answer, array, openCount+1 , closeCount);
			array.remove(array.size()-1);
		}
		if(closeCount < numberOfTags){
			array.add(close);
			generateDivTags(numberOfTags, answer, array, openCount, closeCount+1);
			array.remove(array.size()-1);
		}
		return;
	}
	public boolean check(ArrayList<String> array){
		Stack<String> stack = new Stack<String>();
		String open = "<div>";
		String close = "</div>";
		for(int i=0;i<array.size();i++){
			if(!stack.isEmpty() && stack.peek().equals(open) && array.get(i).equals(close)){
				stack.pop();
			} else {
				stack.add(array.get(i));			
			}
		}
		return stack.size() == 0;
	}
}

class Program2 {

  public ArrayList<String> generateDivTags(int numberOfTags) {
    // Write your code here.
		// brute force
		ArrayList<String> answer = new ArrayList<String>();
		generateDivTags(numberOfTags, numberOfTags, "", answer);
    return answer;
  }
	public void generateDivTags(int opening, int closing, String prefix, ArrayList<String> answer){		
		if(0 < opening){
			String newPrefix = prefix + "<div>";
			generateDivTags(opening-1, closing, newPrefix, answer);
		}
		if(opening < closing){
			String newPrefix = prefix + "</div>";
			generateDivTags(opening, closing-1, newPrefix, answer);
		}
		if(closing == 0) answer.add(prefix);
		return;
	}
}
