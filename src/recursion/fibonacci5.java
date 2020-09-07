package recursion;
/*
 * Solved!
 * https://www.acmicpc.net/problem/10870
 * 피보나치수 5
 */
import java.util.Scanner;

public class fibonacci5 {
	static int[] list;
	static int input;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextInt();
        scanner.close();
		list = new int[input+1];

			
		calc(); 
	}
	public static int calc() {
		if (input == 0) {
			System.out.println(0);
			return 0;
		}
		if (input == 1) {
			System.out.println(1);
			return 0;
		}
		if (input == 2) {
			System.out.println(1);
			return 0;
		}
		fib();
		return 0;
	}
	public static void fib() {
		list[0]=0;
		list[1]=1;
		list[2]=1;
		for(int i=2;i<input+1;i++) {
			list[i]=list[i-1]+list[i-2];
		}
		System.out.println(list[input]);
	}
}
