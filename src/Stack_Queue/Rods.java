package Stack_Queue;

import java.util.Stack;

public class Rods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String arrangement = "()(((()())(())()))(())";
		System.out.println(solution(arrangement));
	}
    public static int solution(String arrangement) {
        int answer = 0;
        if(arrangement==null) return answer;
        Stack <Character> stack = new Stack<Character>();
        boolean cut=false;
        char current;
        for (int i=0, cnt=0;i<arrangement.length();i++) {
        	current = arrangement.charAt(i);
        	if(!stack.isEmpty()&&current==')') {
        		stack.pop();
        		if(!cut) {
	        		cut = true;
	        		cnt-=1;
	        		answer+=cnt;
//	        		System.out.println("current => "+ current);
//	        		System.out.println("cnt => " + cnt);
//	        		System.out.println("answer => "+ answer);
//	        		System.out.println("");
        		}
        		else {
	        		cnt-=1;
	        		answer+=1;
//	        		System.out.println("current => "+ current);
//	        		System.out.println("cnt => " + cnt);
//	        		System.out.println("answer => "+ answer);
//	        		System.out.println("");
        		}

        	}
        	else {
        		stack.add(current);
        		cnt+=1;
        		cut = false;
//        		System.out.println("current => "+ current);
//        		System.out.println("cnt => " + cnt);
//        		System.out.println("");
        	}
        }
        return answer;
    }
}
