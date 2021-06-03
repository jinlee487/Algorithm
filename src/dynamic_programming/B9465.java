package dynamic_programming;
import java.io.*;
import java.util.*;
/* 
Solved!
https://www.acmicpc.net/problem/9465
스티커
dynamic programming memoization
*/
class B9465 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine()), N;
        int[][] arr, dp;
        StringTokenizer st;
        StringBuilder str = new StringBuilder();
        for(int i=0;i<T;i++){
            N  = Integer.parseInt(br.readLine());
            arr = new int[2][N+1];
            dp = new int[2][N+1];
            for(int j=0;j<2;j++){
                st = new StringTokenizer(br.readLine());
                for(int k=1;k<N+1;k++){
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];
            for (int j=2;j<N+1;j++) {
                dp[0][j] = Math.max(dp[1][j-1], dp[1][j-2]) + arr[0][j];
                dp[1][j] = Math.max(dp[0][j-1], dp[0][j-2]) + arr[1][j];
            }
           str.append(Math.max(dp[0][N], dp[1][N])+"\n");
        }
        bw.write(str.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}