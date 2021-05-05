package dfs;
import java.io.*;
import java.util.*;
/* 
https://www.acmicpc.net/problem/1937
욕심쟁이 판타
because there is a timecomplexity, 
we have to use dfs + dp to solve this problem.
*/

public class B1937 {
	static int[][] arr;
    static int[][] dp;
	static int n,count;
    static int[] arrx = {-1,1,0,0}, arry = {0,0,-1,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int ans=0;
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        dp = new int[n][n];
        StringTokenizer st;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                ans = Math.max(ans, dfs(i, j));
            }
        }
        bw.write(Integer.toString(ans));
        bw.flush();
        bw.close();
        br.close();
    }
    public static int dfs(int x, int y) {
        if (dp[x][y] != 0) {
            return dp[x][y];
        }
        dp[x][y] = 1;
        //System.out.println("this is x: " + x + " y: " + y + " c: " + c + " count: " + count);
        int nx, ny;
        for(int i=0;i<4;i++){
            nx = x + arrx[i];
            ny = y + arry[i];
            if(check(nx,ny,arr[x][y])){
                dp[x][y] = Math.max(dp[x][y], dfs(nx, ny) + 1);
                dfs(nx, ny);
            }
        }
        return dp[x][y];
    }
    public static boolean check(int x, int y, int b) {
        if(x<0||y<0||n<=x||n<=y){
            return false;
        }
        if(arr[x][y]<=b){
            return false;
        }
        return true;
    }
}
