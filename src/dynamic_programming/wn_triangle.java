package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * solved!!
 * https://www.acmicpc.net/problem/1932
 * 정수 삼각형
*/

public class wn_triangle {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int dp[][] = new int[N+2][N+2];	
		int[][] t = new int[N+1][N+1];
		for (int i = 1; i < N+1; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int j = 1;
			for (;j < i+1; j++)
			{
				t[i][j] = Integer.parseInt(st.nextToken());
			}
		}
//		printarray(t);
		if (N==0) {
			System.out.println(0);
		}
		else {
			dp[1][1] = t[1][1];		
			for (int i = 2; i < N+1;){
				int j=1;
				for (; j < i+1;j++) {
					dp[i][j]  = Integer.max(dp[i-1][j], dp[i-1][j-1]) + t[i][j];
					}
				i++;
			}
			int max = dp[N][0];
			for(int i = 1; i < N+1;i++)
				if(dp[N][i] > max)
					max = dp[N][i];
			System.out.println(max);
//			printarray(dp);
		}
	}
//	public static void printarray(int[][] x) {
//		for (int i=0;i<x.length;i++) {
//			for (int j=0;j<x.length;j++) {
//				System.out.printf("%d\t",x[i][j]);
//			}
//			System.out.println("");
//		}
//	}
}
