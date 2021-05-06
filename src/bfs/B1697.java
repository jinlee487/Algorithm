package bfs;

import java.io.*;
import java.util.*;

/* 
Solved!
https://www.acmicpc.net/problem/1697
숨바꼭질
BFS + DP 문제
BFS는 Queue로 구현하고
DFS는 재귀로 구현한다
*/

public class B1697 {
     
    static int[] arrx = {1,-1};
    static int[] arr, dp;
    static int N,K;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[100001];
        dp = new int[100001];
        bfs(N);
        bw.write(Integer.toString(dp[K]-1));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void bfs(int x){
        dp[x] = 1;
        // System.out.println("\nthis is new bfs => x: " + x );
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(x);
        int nx, cx;
        while(!q.isEmpty()){
            // System.out.println("this is current q => " + q);
            cx = q.poll();
            // System.out.println("this is cx => " + cx);
            for(int i = 0; i<3; i++){
                if(i==2){
                    nx = cx*2;
                } else {
                    nx = cx + arrx[i];
                }
                if(check(nx)){
                    q.add(nx);
                    dp[nx] = dp[cx] + 1;
                    if(nx == K){
                        return;
                    }
                }
            }
        }
    }
    public static boolean check(int x){
        if(x<0||100001<=x){
            return false;
        }
        if(dp[x]!=0){
            return false;
        }
        return true;
    }
}
