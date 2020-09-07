package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * Solved!
 * https://www.acmicpc.net/problem/1149
 * RGB 거리
 */
public class RGB {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int dp[][] = new int[N+1][4];	
		int[][] cost = new int[N+1][4];

		for (int i = 1; i < N+1; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j < 4; j++)
			{
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp[1][1] = cost[1][1];
		dp[1][2] = cost[1][2];
		dp[1][3] = cost[1][3];
		
		for (int i = 2; i < N+1; i++)
		{
			dp[i][1] = Integer.min(dp[i-1][2], dp[i-1][3]) + cost[i][1];
			dp[i][2] = Integer.min(dp[i-1][1], dp[i-1][3]) + cost[i][2];
			dp[i][3] = Integer.min(dp[i-1][1], dp[i-1][2]) + cost[i][3];
		}
		int min = Integer.min(dp[N][1],dp[N][2]);
		min = Integer.min(min, dp[N][3]);
		System.out.print(min);
	}
}
