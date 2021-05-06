package bfs;

import java.io.*;
import java.util.*;

/* 
Solved!
https://www.acmicpc.net/problem/2178
미로탐색
this problem is how to handle a one way nodes
and how to handle the time complexity 
*/
class V{
    int x;
    int y;
    V(int x, int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public String toString(){
        return "x: " + x + " y: "  + y;
    }
}
public class B1697 {
     
    static int[] arrx = {1,-1,0,0}, arry = {0,0,-1,1};
    static boolean[][] visit;
    static int[][] arr;
    static int N,M;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }
        bfs(0,0);
        bw.write(Integer.toString(arr[N-1][M-1]));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void bfs(int x, int y){
        // System.out.println("\nthis is new bfs => x: " + x + " y: " + y);
        Queue<V> q = new LinkedList<V>();
        q.add(new V(x,y));
        while(!q.isEmpty()){
            // System.out.println("this is current q => " + q);
            V v = q.poll();
            // System.out.println("this is v => " + v);
            visit[x][y] = true;
            for(int dir = 0; dir<4; dir++){
                int nx = v.x + arrx[dir];
                int ny = v.y + arry[dir];
                if(check(nx,ny)){
                    q.add(new V(nx,ny));
                    visit[nx][ny] = true;
                    arr[nx][ny] = arr[v.x][v.y] + 1;
                }
            }
        }
    }
    public static boolean check(int x, int y){
        if(x<0||y<0||N<=x||M<=y){
            return false;
        }
        if(arr[x][y]==0){
            return false;
        }
        if(visit[x][y]){
            return false;
        }
        return true;
    }
}
