package dfs;

import java.io.*;
import java.util.*;
/* 
Solved!
https://www.acmicpc.net/problem/9466
텀 프로젝트
this problem is how to handle a one way nodes
and how to handle the time complexity 
*/
public class B9466 {
    static int[] arr, visit, dp;
    static int count,s;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n, T = Integer.parseInt(br.readLine());
        StringBuilder str = new StringBuilder();
        for(int i=0;i<T;i++){
            n = Integer.parseInt(br.readLine());
            arr = new int[n+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1;j<n+1;j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            // System.out.println(Arrays.toString(arr));
            str.append(init(n)+"\n");
        }
        bw.write(str.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    public static int init(int n){
        dp = new int[n+1];
        visit = new int[n+1];
        count = 0;
        for(int i=1;i<n+1;i++){
            // System.out.println("this is start i => " + i);
            dfs(i);
        }
        return n-count;
    }
    public static void dfs(int x) {
        // System.out.println("this is x => " + x);
        if(visit[x]==1){
            return;
        }
        visit[x] = 1;
        int nextNode = arr[x];
        if(visit[nextNode]!=1){
            dfs(nextNode);
        }
        else{
            if(dp[nextNode]!=1){
                // System.out.println("in the dp => nn" + nextNode);
                count ++;
                for(int i=nextNode;i != x; i = arr[i]){
                    // System.out.println("this is i => " + i);
                    count++;
                }
            }
        }

        dp[x] = 1;
        // System.out.println("this is dp => " + Arrays.toString(dp));
        // System.out.println("this is visit => " + Arrays.toString(visit));

    }   
}
