package bfs;
import java.io.*;
import java.util.*;

/* 
Solved!
https://www.acmicpc.net/problem/7576
토마토
this question is similar to problem 2573 빙산
*/
class Tomato {
    int x;
    int y;
    Tomato(int x, int y){
        this.x = x; this.y = y;
    }
}
public class B7576 {
    static int[] arrx = {1,-1,0,0}, arry = {0,0,-1,1};
    static Queue<Tomato> q = new LinkedList<Tomato>();
    static int[][] arr;
    static int N,M,time,goal=0,current=0;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]==1){
                    q.add(new Tomato(i,j));
                }
                if(arr[i][j]!=-1){
                    goal++;
                }
            }
        }
        current = q.size();
        for(int i=0;;i++){
            time = i;
            if(bfs()==0){
                if(goal!=current){
                    time = -1;
                }
                break;
            }
        }
        bw.write(Integer.toString(time));
        bw.flush();
        bw.close();
        br.close();
    }
    public static int bfs(){
        int nx,ny,c=0, qsize = q.size();
        Tomato t;
        for(int i=0;i<qsize;i++){
            t = q.poll();
            for(int j=0;j<4;j++){
                nx = t.x + arrx[j];
                ny = t.y + arry[j];
                if(check(nx,ny)){
                    arr[nx][ny] = 1;
                    q.add(new Tomato(nx,ny));
                    c ++;
                }
            }
        }
        current += c;
        return c;
    }
    public static boolean check(int x, int y){
        if(x<0||y<0||N<=x||M<=y){
            return false;
        }
        if(arr[x][y]==-1||arr[x][y]==1){
            return false;
        }
        return true;
    }
}
