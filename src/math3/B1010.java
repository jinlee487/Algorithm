package math3;
import java.io.*;
import java.util.*;
/* 
Solved!
https://www.acmicpc.net/problem/1010
다리 놓기
dynamic programming memoization combination
문제 해설: https://st-lab.tistory.com/194
*/
class B1010 {
	
	static int[][] dp = new int[30][30];
 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		int N, M;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");	
			N = Integer.parseInt(st.nextToken());	// N = r
			M = Integer.parseInt(st.nextToken());	// M = n
			sb.append(combi(M, N)).append('\n');
		}
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
	}
	private static int combi(int n, int r) {
		if(dp[n][r] > 0) {
			return dp[n][r]; 
		}
		if(n == r || r == 0) {
			return dp[n][r] = 1;
		}
		return dp[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
	}
}