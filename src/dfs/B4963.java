package dfs;

import java.util.*;
import java.io.*;

/*
 * Solved!!
 * https://www.acmicpc.net/problem/4963
 * 
 * 섬의 개수
 * 
 * this question is a continuation of previous dfs problems
 * but now we can traverse diagonaly in a 2d array
 * 
 */
public class B4963 {
    static int[][] arr;
    static int N,M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st;
        StringBuilder str = new StringBuilder();
        while(true){
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            arr = new int[N][M];
            if(N==0&&M==0){
                break;
            }
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<M;j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int count = 0;
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(arr[i][j] == 1){
                        dfs(i,j);
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
        } 
        arr[x][y] = 0;

        dfs(x-1,y-1);
        dfs(x+1,y+1);

        dfs(x-1,y);
        dfs(x,y-1);

        dfs(x+1,y);
        dfs(x,y+1);

        dfs(x+1,y-1);
        dfs(x-1,y+1);
        
        return 0;
    }
}
