package quenue;

import java.io.*;
import java.util.*; 

public class AC_queue {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static Deque<Integer> deque;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		List<String> templist;
		String f, slist;
		int s;
		for (int i=1;i<N+1;i++) {
			
			st = new StringTokenizer(br.readLine()," ");
			f = st.nextToken();
			
			st = new StringTokenizer(br.readLine()," ");
			s = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine()," ");
			slist = st.nextToken();
			
			if(!slist.equals("[]")) {
				templist = Arrays.asList(slist.substring(1, slist.length() - 1).split(","));
				deque = new ArrayDeque<Integer>();
				for(String v: templist) {
					deque.add(Integer.parseInt(v));
				}			
			}
			else {
				deque = new ArrayDeque<Integer>();
			}
			
			boolean check=true;
			boolean reverse = false; 
			for(int j=0;j<f.length();j++) {
				if(f.charAt(j)=='R') {	
					reverse = (reverse==true?false:true);
				}
				else if(f.charAt(j)=='D') {
					
					if(deque.isEmpty()) {
						check = false;
						break;
					}
					else if (reverse==true) {
						deque.removeLast();
					}
					else deque.removeFirst();
				}
			}
			
			if (check==true) {
				if (reverse!=true) {
					bw.write("[");
					while (!deque.isEmpty()) {
						bw.write((Integer.toString(deque.removeFirst())));
						if(!deque.isEmpty()) bw.write(",");
					}
					bw.write("]\n");
				}
				
				else {
					bw.write("[");
					while (!deque.isEmpty()) {
						bw.write((Integer.toString(deque.removeLast())));
						if(!deque.isEmpty()) bw.write(",");
					}
					bw.write("]\n");
				}
			}
			else bw.write("error\n");
		}
		bw.flush();
	}
}




















