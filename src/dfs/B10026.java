package dfs; 
import java.util.*;
import java.io.*;
/* 
Solved!
https://www.acmicpc.net/problem/10026
적록색약
input choices => R(빨강), G(초록), B(파랑) 
(1 ≤ N ≤ 100)

*/
class B10026 {
    static int N, count;
    static int[] arrx = {-1,1,0,0}, arry = {0,0,-1,1};
    static char[][] arr1,arr2;
    static char current;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr1 = new char[N][N];
        arr2 = new char[N][N];
        for(int i=0;i<N;i++){
            char[] temp = br.readLine().toCharArray();
            arr1[i] = temp.clone();
            arr2[i] = temp.clone();
        }
        StringBuilder str = new StringBuilder();
        count = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(arr1[i][j]!='X'){
                    current = arr1[i][j];
                    count ++;
                    arr1[i][j] = 'X';
                    dfs1(j,i);
                }
            }
        }
        str.append(count + " ");
        count = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(arr2[i][j]!='X'){
                    current = arr2[i][j];
                    count ++;
                    arr2[i][j] = 'X';
                    dfs2(j,i);
                }
            }
        }
        str.append(count + " ");
        bw.write(str.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    public static void dfs1(int x, int y) {
        for(int i=0;i<4;i++){
            int nextx = x + arrx[i];
            int nexty = y + arry[i];
            if(check1(nextx,nexty)){
                arr1[nexty][nextx] = 'X';
                dfs1(nextx,nexty);
            }
        }
        return;
    }
    public static Boolean check1(int x, int y){
        if(x<0||y<0||N<=x||N<=y){
            return false;
        }
        if(current!=arr1[y][x]){
            return false;
        }
        return true;
    }
    public static void dfs2(int x, int y) {
        for(int i=0;i<4;i++){
            int nextx = x + arrx[i];
            int nexty = y + arry[i];
            if(check2(nextx,nexty)){
                arr2[nexty][nextx] = 'X';
                dfs2(nextx,nexty);
            }
        }
        return;
    }
    public static Boolean check2(int x, int y){
        if(x<0||y<0||N<=x||N<=y){
            return false;
        }
        if((current=='B'&&arr2[y][x]!='B')||(current!='B'&&arr2[y][x]=='B')){
            return false;
        }
        if(arr2[y][x]=='X'){
           return false;
        }
        return true;
    }
}