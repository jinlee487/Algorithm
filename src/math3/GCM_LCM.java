package math3;

import java.util.Scanner;

/*
 * 
 * https://www.acmicpc.net/problem/2609
 * 최대공약수 최대공배수 
 */
public class GCM_LCM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N1 = sc.nextInt();
		int N2 = sc.nextInt();
		sc.close();
		int GCM=1, LCM=1;
		for (int i=2;i<=N1||i<=N2;i++) {
			if(N1%i==0&&N2%i==0) {
				N1/=i;N2/=i;
				LCM*=i--;
			}	
		}
		GCM = LCM*N1*N2;
		System.out.println(LCM);
		System.out.println(GCM);
	}
}
