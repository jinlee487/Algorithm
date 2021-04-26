package greedy_algorythm;
import java.util.*;
import java.io.*;
public class Polomino {
    /*
 * SOLVED!!
 * https://www.acmicpc.net/problem/1343
 * 폴리오미노 
*/
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		char[] input = br.readLine().toCharArray();
        Queue<Character> que = new LinkedList<Character>();
        Stack<Character> stack = new Stack<Character>();
		for(int i=0;i<input.length;i++){
			que.add(input[i]);
		}
        //System.out.println(que);
        char c; 
		StringBuilder str = new StringBuilder();
		for(;!que.isEmpty();){
            c = que.poll();
            //System.out.println("");

            //System.out.println ( "this is c = > " + c);
            if(c=='X'){
                stack.add(c);
                //System.out.println ( "this is que = > " + que + " que.size() => "  + que.size());
                //System.out.println ( "this is stack = > " + stack + " stack.size() => "  + stack.size());

                if(stack.size() == 4){
                    str.append("AAAA");
                    stack.clear();
                }
                continue;
            } else if(c=='.'){
                if (stack.size() == 2){
                    //System.out.println ( "this is que = > " + que + " que.size() => "  + que.size());
                    //System.out.println ( "this is stack = > " + stack + " stack.size() => "  + stack.size());
                    str.append("BB");
                    str.append(".");
                    stack.clear();
                } else if(stack.isEmpty()){
                    str.append(".");
                    continue;
                } else {
                    str = new StringBuilder(); 
					str.append(Integer.toString(-1));
					break;
                }
			}
        }
        if(stack.size() == 4){
            str.append("AAAA");
            stack.clear();
        } else if (stack.size() == 2){
            str.append("BB");
            stack.clear();
        } else if(!stack.isEmpty()){
            str = new StringBuilder(); 
            str.append(Integer.toString(-1));
        }
        bw.write(str.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
