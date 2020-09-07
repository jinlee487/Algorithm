package math3;

import java.util.Scanner;

/*
 * Solved!
 * https://www.acmicpc.net/problem/2004
 * 조합 0의 개수
 */
class number {
	int count2 = 0;
	int count5 = 0;
	public int getCount2() {
		return count2;
	}
	public void setCount2(int count2) {
		this.count2 = count2;
	}
	public int getCount5() {
		return count5;
	}
	public void setCount5(int count5) {
		this.count5 = count5;
	}
}
public class Combination_0 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		sc.close();
		number n = new number();
		number m = new number();
		number nm = new number();
		calc(n,N);
		calc(m,M);
		calc(nm,N-M);
		int c2=n.getCount2()-m.getCount2()-nm.getCount2();
		int c5=n.getCount5()-m.getCount5()-nm.getCount5();
		System.out.println(c2<c5? c2:c5);
	}
	public static void calc(number c,int num) {
		int temp=0;
		int count2 = c.getCount2();
		int count5 = c.getCount5();
		for (int i=1;i<num+1;i++) {
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
		c.setCount2(count2);
		c.setCount5(count5);
	}
}
