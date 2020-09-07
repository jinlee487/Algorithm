package quenue;
/*
 * Solved!!!
 * https://www.acmicpc.net/problem/10866
 * 덱
 * 
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Basic_deque {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Deque<Integer> deque = new LinkedList<>();
		st = new StringTokenizer(br.readLine(), " ");
		int cnt = Integer.parseInt(st.nextToken());	
		String a;
		for(int i=0; i<cnt; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			a = st.nextToken();
			if(a.equals("push_back")) {
				int b = Integer.parseInt(st.nextToken());	
				deque.addLast(b);
			}
			else if(a.equals("push_front")) {
				int b = Integer.parseInt(st.nextToken());	
				deque.addFirst(b);
			}
			else if(a.equals("pop_front")) {
				bw.write((deque.isEmpty()?-1:deque.pop())+"\n");
			}
			else if(a.equals("pop_back")) {
				bw.write((deque.isEmpty()?-1:deque.removeLast())+"\n");
			}
			else if(a.equals("size")) {
				bw.write(deque.size()+"\n");
			}
			else if(a.equals("empty")) {
				bw.write((deque.isEmpty()?1:0)+"\n");
			}
			else if(a.equals("front")) {
				bw.write((deque.isEmpty()?-1:deque.peek())+"\n");
			}
			else if(a.equals("back")) {
				bw.write((deque.isEmpty()?-1:deque.peekLast())+"\n");
			}
		}
		bw.flush();
	}
}
