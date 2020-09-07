package quenue;
/*
 * Solved!!!
 * https://www.acmicpc.net/problem/18258
 * 큐2
 * 
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class basic_quenue_2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int b=0;
		Queue<Integer> que = new LinkedList<>();
		String a;
		st = new StringTokenizer(br.readLine(), " ");
		int cnt = Integer.parseInt(st.nextToken());	
		
		for(int i=0; i<cnt; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			a = st.nextToken();
			
			if(a.equals("push")) {
				b = Integer.parseInt(st.nextToken());
				que.add(b);
			}

			else if(a.equals("front"))
				bw.write((que.isEmpty()?-1:que.peek())+"\n");
			else if(a.equals("back")) 
				bw.write((que.isEmpty()?-1:b)+"\n");
			else if(a.equals("size"))
				bw.write(que.size()+"\n");
			else if(a.equals("pop")) 
				bw.write((que.isEmpty()?-1:que.poll())+"\n");
			else if(a.equals("empty")) 
				bw.write((que.isEmpty()?1:0)+"\n");
		}
    bw.flush();
    bw.close();
	}
}