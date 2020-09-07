package math3;

import java.util.Scanner;

/*
 * 
 * https://www.acmicpc.net/problem/11653
 * 소인수분해 
 */
public class Factorization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		int num = N;
		for (int i=2;;i++) {
			if(num%i==0) {
				System.out.println(i);
				num /= i;
				i--;
			}
			if(num==1)
				break;
		}
	}
}
