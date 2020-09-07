package dynamic_programming;



/*
 * https://www.acmicpc.net/problem/12865
 * 평범한 배낭
 * https://fbtmdwhd33.tistory.com/60
 * 
 */
import java.util.*;

public class Ordinary_Knapsack {
	static int N, W;
	static int[] weight,cost;
	static int[][] dp;
	public static void main(String[] args)   {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		W = sc.nextInt();
		weight = new int[N+1];
		cost = new int[N+1];
		dp = new int[N+1][W+1];
		for (int i=1;i<N+1;i++) {
			weight[i] = sc.nextInt();
			cost[i] = sc.nextInt();			
		}
		sc.close();
		for (int i=1;i<N+1;i++) {
			for (int j=1;j<W+1;j++) {
				//printArray();
				dp[i][j]=dp[i-1][j];
				if (j-weight[i]>=0 ) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]] + cost[i]);
				}
				
			}
		}
		
		System.out.println(dp[N][W]);
	}
	public static void printArray() { 
		System.out.println("");
		for (int j=1;j<W+1;j++) {
			System.out.println("new");
			for (int i=1;i<N+1;i++) {
				System.out.print(dp[i][j]+"\t");
			}
		}
	}
	
}








