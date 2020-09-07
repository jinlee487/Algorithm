package dynamic_programming;

import java.util.Scanner;

/*
 * SOLVED!!
 * https://www.acmicpc.net/problem/2163
 * 초코릿 자르기
 * 초콜릿 크기 n*m
 * 조각 n*m 개 
 * 
 * (1≤N, M≤300)
 * 
*/public class Cut_Choco {
	static int n;
	static int m;
	static int cut_times;
	static int list[][];
	static Scanner sc = new Scanner(System.in);


	public static void input_int() {
		String input = sc.nextLine();    // get the entire line after the prompt 
		String[] numbers = input.split(" "); // split by spaces
		n = Integer.parseInt(numbers[0]);
		m = Integer.parseInt(numbers[1]);
		list = new int[n+1][m+1];
	}
	public static int cut_choco(int x,int y) {
		if (x==0||y==0)
			return 0;
		if (list[x][y]!=-1) return (list[x][y]);
		if (x==1||y==1)
			list[x][y] = x*y-1+cut_choco(x-1,y-1);
		else
			list[x][y] = x*y-(x-1)*(y-1)+cut_choco(x-1,y-1);
		return list[x][y];
	}
//	public static void printarray(int[][] x) {
//	for (int i=0;i<n+1;i++) 
//		for (int j=0;j<m+1;j++)
//			if (x[i][j]!=-1)
//				System.out.printf("list[%d][%d]=%d\t",i,j,x[i][j]);
//	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input_int();
		for (int i=0;i<n+1;i++)
			for (int j=0;j<m+1;j++)
				list[i][j] = -1;
		if (m==0) {
			System.out.println(0);
		}	
		else {
		list[1][1]=0;
		cut_times=cut_choco(n,m);
		System.out.println(cut_times);
//		printarray(list);
		}
	}	
}
