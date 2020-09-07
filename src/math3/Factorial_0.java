package math3;

import java.util.Scanner;

/*
 * Solved!
 * https://www.acmicpc.net/problem/1676
 * 팩토리얼 0의 개수
 */
public class Factorial_0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		int count2 = 0;
		int count5 = 0;
		int temp=0;
		for (int i=1;i<N+1;i++) {
			temp = i;
			while(temp%2==0) {
				temp/=2;
				count2++;
			}
			while(temp%5==0) {
				temp/=5;
				count5++;
			}
		}
		System.out.println(count2<count5? count2:count5);
	}
}
