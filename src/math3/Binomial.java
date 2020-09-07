package math3;

import java.util.Scanner;

/*
 * Solved
 * https://www.acmicpc.net/problem/11050
 * 이항계수1
 * https://oper6210.tistory.com/76
 */
public class Binomial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		sc.close();
		int x = factorial(N)/(factorial(N-K)*factorial(K));
		System.out.println(x);
	}
	public static int factorial(int n) {
		int output=1;
		for(int i=n;0<i;i--) {
			output *= i;
		}
		return output;
	}
	

}
