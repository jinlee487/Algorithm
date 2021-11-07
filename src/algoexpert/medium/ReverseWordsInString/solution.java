package algoexpert.medium.ReverseWordsInString;
import java.util.*;

class Program1 {

  public String reverseWordsInString(String string) {
    // Write your code here.
		StringBuilder word = new StringBuilder();
		StringBuilder space = new StringBuilder();
		Stack<String> stack = new Stack<String>();
		for(int i=0;i<string.length();i++){
			if(string.charAt(i)==' '){
				if(0<word.length()){
					stack.add(word.toString());
					word = new StringBuilder();
				}	
				space.append(" ");				
			} else {
				if(0<space.length()){
					stack.add(space.toString());
					space = new StringBuilder();
				}
				word.append(string.substring(i,i+1));
			}
		}
		if(0<word.length()) stack.add(word.toString());
		else stack.add(space.toString());
		word = new StringBuilder();
		for(int i=0, count = stack.size();i<count;i++){
			word.append(stack.pop());
		}
    return word.toString();
  }
}

class Program2 {

  public String reverseWordsInString(String string) {
    // Write your code here.
		ArrayList<String> words = new ArrayList<String>();
		int start = 0 ; 
		for(int i=0;i<string.length();i++){
			if(string.charAt(i)==' '){
				words.add(string.substring(start,i));
				start = i;
			} else if(string.charAt(start) == ' '){
				words.add(" ");
				start = i;
			}
		}
		words.add(string.substring(start));
		Collections.reverse(words);
    return String.join("",words);
  }
}

class Program3 {

  public String reverseWordsInString(String string) {
    // Write your code here.
		char[] characters = string.toCharArray();
		reverse(characters,0,characters.length-1);
		int start = 0;
		while(start<characters.length){
			int end = start;
			while(end<characters.length && characters[end] != ' ') end++;
			reverse(characters,start,end-1);
			start = end + 1;
		}
    return new String(characters);
  }
	public char[] reverse(char[] list, int start, int end){
		while(start<end){
			char temp = list[start];
			list[start++] = list[end];
			list[end--] = temp;
		}
		return list;
	}
}
