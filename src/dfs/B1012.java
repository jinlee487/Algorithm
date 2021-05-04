package dfs;
import java.util.*;
import java.io.*;

/*
 * Solved!!
 * https://www.acmicpc.net/problem/1012
 * 
 * 유기농 배추
 * 
 * this question is very similar to https://www.acmicpc.net/problem/2667
 * 
 * 
 */
public class B1012 {

    static int[][] arr; 
    static int M, N;
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int K, m, n, count; 
        StringTokenizer st ;
        StringBuilder str = new StringBuilder();
        for(int i=0;i<T;i++){
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            arr = new int[N][M];
            for(int[] a : arr){
                Arrays.fill(a, 0);
            }
            for(int j=0;j<K;j++){
                st = new StringTokenizer(br.readLine());
                m = Integer.parseInt(st.nextToken());
                n = Integer.parseInt(st.nextToken());
                arr[n][m] = 1;
            }
            // System.out.println("this is arr input => ");
            // for(int[] a : arr){
            //     System.out.println(Arrays.toString(a));
            // }
            count = 0;
            for(int j=0;j<N;j++){
                for(int k=0;k<M;k++){
                    if(arr[j][k]!=0){
                        dfs(j,k);
                        count ++;
                    }
                }
            }
            str.append(count + "\n");
        }
        bw.write(str.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    public static int dfs(int x, int y) {
        if(x<0||y<0||N<=x||M<=y){
            return 0;
        }
        if(arr[x][y] == 0){
            return 0;
        } else {
            arr[x][y] = 0;
        }
        dfs(x-1,y);
        dfs(x+1,y);
        dfs(x,y-1);
        dfs(x,y+1);
        return 0;
    }
}
