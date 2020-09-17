package kakao_Blind_2020;
import java.util.ArrayList;
import java.util.Stack;
public class problem_1 {
	public static void main(String[] args) {
		problem_1 t1 = new problem_1();
		String new_id = "";
		for(int i=0;i<100;i++) {
			new_id += Integer.toString(i);
		}
		System.out.println("this is new_id => " + new_id);
		System.out.println(t1.solution(new_id));
	}
	public String solution(String new_id) {
		
		
		
		String answer = new_id.toLowerCase();
		
		ArrayList<Character> charlist = new ArrayList<>();
		Stack<Character> charstack = new Stack<>();
		
		
		
		for(int i=0;i<answer.length();i++) {
			if((answer.charAt(i) >= 'a' && answer.charAt(i) <= 'z')|| answer.charAt(i) == '-'|| answer.charAt(i) == '_'||
					answer.charAt(i) == '.'||(answer.charAt(i) >= '1' && answer.charAt(i) <= '9')||(answer.charAt(i)=='0')) {
				charlist.add(answer.charAt(i));
			}
		}
		for(int i=charlist.size()-1;i>=0;i--) {
			if(charstack.isEmpty()) {
				charstack.push(charlist.get(i));
			}else {
				if(charstack.peek() == '.' && charlist.get(i) == '.') {
					continue;
				}else {
					charstack.push(charlist.get(i));
				}
			}
		}
		
		
		charlist.clear();
		while(!charstack.isEmpty()) {
			charlist.add(charstack.pop());
		}
		if(!charlist.isEmpty() && charlist.get(0) == '.') {
			charlist.remove(0);
		}
		if(!charlist.isEmpty() && charlist.get(charlist.size()-1) == '.') {
			charlist.remove(charlist.size()-1);
		}
		if(charlist.isEmpty()) {
			charlist.add('a');
		}
		int size = charlist.size();

		for(int i=size-1; i>=15;i--) {
			charlist.remove(i);
		}
		
		if(!charlist.isEmpty() && charlist.get(0) == '.') {
			charlist.remove(0);
		}
		if(!charlist.isEmpty() && charlist.get(charlist.size()-1) == '.') {
			charlist.remove(charlist.size()-1);
		}
		if(charlist.size() <= 2) {
			char ch = charlist.get(charlist.size()-1);
			while(charlist.size() < 3) {
				charlist.add(ch);
			}
		}
		
		answer = "";
		for(int i=0;i<charlist.size();i++) {
			answer += charlist.get(i);
		}
		return answer;
	}

}