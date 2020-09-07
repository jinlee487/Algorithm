package quenue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Spinning_deque {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Deque<Integer> deque = new LinkedList<>();
		
		for (int i=1;i<N+1;i++) {
			deque.add(i);
		}
		
		st = new StringTokenizer(br.readLine());
		ArrayList<Integer> list;
		int pos, size, left, right, cnt=0, target = 0,temp=0;
		
		for (int i=1;i<M+1;i++) {
			target = Integer.parseInt(st.nextToken());

			list = new ArrayList<Integer>(deque);
			pos = list.indexOf(target); 
			size = list.size(); 
			left = pos; // head와의 거리
			right = size - pos - 1; // tail과의 거리
//			System.out.println("*********************");
//			System.out.println("target => " + target);
//			System.out.println("현재 list => ");
//			System.out.println(list);
//			System.out.println("*********************");
			while(true) {
				if (deque.peek()==target) {
					temp=deque.pop();
//					System.out.println("첫 번째 원소를 뽑아낸다 => " + temp+"\n");
					break;
				}
				if (left<=right) {
					temp=deque.pop();
					deque.addLast(temp);
//					System.out.println("왼쪽으로 한 칸 이동시킨다 => " + temp);
//					System.out.println("cnt => " + (cnt+1)+"\n");
					cnt++;
				}
				else if(right<left) {
					temp=deque.removeLast();
					deque.addFirst(temp);
//					System.out.println("오른쪽으로 한 칸 이동시킨다 => " + temp);
//					System.out.println("cnt => " + (cnt+1)+"\n");
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}
