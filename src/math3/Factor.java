package math3;
/*
 * SOLVED!
 * https://www.acmicpc.net/problem/1037
 * 약수 
 * 
 */
import java.util.Arrays;
import java.util.Scanner;

public class Factor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] list = new int[N];
		for (int i=0;i<list.length;i++) {
			list[i] = sc.nextInt();
		}
		sc.close();
		Arrays.sort(list);
		int num = list[0]*list[N-1];
		System.out.println(num);
	}
}
