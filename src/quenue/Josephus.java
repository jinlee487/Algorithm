package quenue;
/*
 * Solved!
 * https://www.acmicpc.net/problem/11866
 * 요세푸스 문제
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Josephus {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());	
		int K = Integer.parseInt(st.nextToken());	
		Queue<Integer> que1 = new LinkedList<>();
		Queue<Integer> que2 = new LinkedList<>();
		for (int i=1;i<N+1;i++) {
			que1.add(i);
		}
		for (int i=1;que1.isEmpty()!=true;i++) {
			if(i%K==0)
				que2.add(que1.poll());
			else que1.add(que1.poll());
		}
		bw.write("<"+(que2.toString()).substring(1, que2.toString().length()-1)+">");
		bw.flush();
	}
}
