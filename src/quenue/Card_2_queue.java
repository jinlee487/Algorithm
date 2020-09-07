package quenue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * Solved!
 * https://www.acmicpc.net/problem/2164
 * 카드 2
 */
public class Card_2_queue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		Queue<Integer> que = new LinkedList<>();
		if (N==1){System.out.println(N); System.exit(0);}
		for (int i=2;i<N+1;i+=2) {
			que.add(i);
		}
		for(int i=((N%2==0)==true?1:0);que.size()!=1;i++) {
			if (i%2==1)
				que.poll();
			if(i%2==0) {
				que.add(que.poll());
			}
		}
		System.out.println(que.poll());
	}
}





