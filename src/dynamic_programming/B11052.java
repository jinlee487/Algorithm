package dynamic_programming;
import java.io.*;
import java.util.*;
/* 
Solved!
https://www.acmicpc.net/problem/11052
카드 구매하기
basic dynamic programming 
*/
class B11052 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N+1];
        int[] dp = new int[N+1];
        for(int i=1;i<N+1;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1;i<N+1;i++){
            for(int j=1;j<i+1;j++){
                dp[i] = Math.max(dp[i],dp[i-j]+arr[j]);
            }
        }
        bw.write(Integer.toString(dp[N]));
        bw.flush();
        bw.close();
        br.close();
    }
}