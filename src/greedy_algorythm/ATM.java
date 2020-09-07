package greedy_algorythm;
/*
 * Solved!
 * https://www.acmicpc.net/problem/11399
 * ATM
 */
import java.util.Arrays;
import java.util.Scanner;

public class ATM {
	static int N,sum;
	static int[] list, greedy;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		list = new int[N+1];
		greedy = new int[N+1];
		for (int i=0;i<N;i++) {
			list[i] = sc.nextInt();
		}
		sc.close();
		Arrays.sort(list);
//		for (int i=0;i<N+1;i++) {
//			System.out.println(list[i]);
//		}
		greedy[0]=list[0];
		sum = list[0];
		for (int i=1;i<N+1;i++) {
			greedy[i] = sum + list[i] + greedy[i-1];
			sum += list[i];
		}
		System.out.println(greedy[N]);
	}
}
