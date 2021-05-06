package bfs;
import java.io.*;
import java.util.*;

/* 
Solved!
https://www.acmicpc.net/problem/7576
토마토
this question is similar to problem 7576 토마토1
this is a continuation of the previous problem 토마토1
*/
class Tomato2 {
    int x;
    int y;
    int h;
    Tomato2(int x, int y,int h){
        this.x = x; 
        this.y = y; 
        this.h = h;
    }
}
public class B7569 {
    static int[] arrx = {1,-1,0,0,0,0}, arry = {0,0,-1,1,0,0}, arrh = {0,0,0,0,-1,1};
    static Queue<Tomato2> q = new LinkedList<Tomato2>();
    static int[][][] arr;
    static int N,M,H,time,goal=0,current=0;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        arr = new int[N][M][H];
        int input;
        for(int k=0;k<H;k++){
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<M;j++){
                    input = Integer.parseInt(st.nextToken());
                    arr[i][j][k] = input;
                    if(arr[i][j][k]==1){
                        q.add(new Tomato2(i,j,k));
                    }
                    if(arr[i][j][k]!=-1){
                        goal++;
                    }
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
        int nx,ny,nh,c=0, qsize = q.size();
        Tomato2 t;
        for(int i=0;i<qsize;i++){
            t = q.poll();
            for(int j=0;j<6;j++){
                nx = t.x + arrx[j];
                ny = t.y + arry[j];
                nh = t.h + arrh[j];
                if(check(nx,ny,nh)){
                    arr[nx][ny][nh] = 1;
                    q.add(new Tomato2(nx,ny,nh));
                    c ++;
                }
            }
        }
        current += c;
        return c;
    }
    public static boolean check(int x, int y, int h){
        if(x<0||y<0||h<0||N<=x||M<=y||H<=h){
            return false;
        }
        if(arr[x][y][h]==-1||arr[x][y][h]==1){
            return false;
        }
        return true;
    }
}
