package dfs;

import java.util.*;
import java.io.*;
/* 
Solved
https://www.acmicpc.net/problem/2644
촌수 계산
This question is asking for the shortest path between a and b 
normally I use a hashmap, but for the purpose of learning I will only use an array
*/
public class B2644 {
    static int n, m, a, b, count, ans=Integer.MAX_VALUE;
    static int[][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1][n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());   
        m = Integer.parseInt(br.readLine());
        int x,y;
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            arr[x][y] = 1;
            arr[y][x] = 1;
        }
        for(int i=1;i<n+1;i++){
            count = 0;
            if(arr[a][i]!=0){
                arr[a][i] = 0;
                arr[i][a] = 0;
                count ++;
                dfs(a,i);
                count --;
                arr[a][i] = 1;
                arr[i][a] = 1;
            }
        }
        if(ans == Integer.MAX_VALUE){
            ans = -1;
        }
        bw.write(Integer.toString(ans));
        bw.flush();
        bw.close();
        br.close();
    }
    public static void dfs(int parent, int child){
        if(child == b) {
            ans = Math.min(count,ans);
            return;
        }
        for(int i=1;i<n+1;i++){
            if(arr[child][i]!=0){
                arr[child][i] = 0;
                arr[i][child] = 0;
                count ++;
                dfs(child,i);
                count --;
                arr[child][i] = 1;
                arr[i][child] = 1;
            }
        }
        return;
    }
}
