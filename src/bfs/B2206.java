package bfs;

import java.util.*;
import java.io.*;
/* 
Solved!
https://www.acmicpc.net/problem/2206
미로탐색벽 부수고 이동하기
for this problem, we add w to Move and we give visit vales of the w so that we can always have the 
traveling node which has not passed the wall the right of way.
*/

class Move {
    int x;
    int y;
    int c;
    int w;
    Move(int x, int y, int c, int w){
        this.x = x; 
        this.y = y; 
        this.c = c;
        this.w = w;
    }
    @Override
    public String toString(){
        return "x: " + x + " y: " + y + " c: " + c + " w: " + w;
    }
}
class B2206 {
    static int N,M,answer=-1;
    static char[][] arr;
    static int[][] visit;
    static int[] arrx = {1,-1,0,0}, arry = {0,0,-1,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        visit = new int[N][M];
        for(int i=0;i<N;i++){
            arr[i] = br.readLine().toCharArray();
        }
        for(int[] v : visit){
            Arrays.fill(v,Integer.MAX_VALUE);
        }
        bfs();
        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
        br.close();
    }
    public static void bfs(){
        int count=1,nx,ny;
        Move move;
        if(last(0,0,N-1,M-1)){
            answer = count;
            return;
        }
        Queue<Move> que = new LinkedList<Move>();
        que.add(new Move(0,0,count,0));
        visit[0][0] = 0;
        while(!que.isEmpty()){
            move = que.poll();
            for(int i=0;i<4;i++){
                nx = move.x + arrx[i];
                ny = move.y + arry[i];
                if(last(nx,ny,N-1,M-1)){
                    answer = move.c+1;
                    return;
                }    
                if(check(nx,ny,N-1,M-1,move.w)){
                    if(arr[nx][ny]=='1'){
                        if(move.w==0){
                            visit[nx][ny] = move.w+1;
                            que.add(new Move(nx,ny,move.c+1,move.w+1));
                        }
                    } else {
                        visit[nx][ny] = move.w;
                        que.add(new Move(nx,ny,move.c+1,move.w));
                    }
                }
            }
        }
    }
    public static boolean check(int x, int y, int dx, int dy, int w){
        if(x<0||y<0||dx<x||dy<y){
            return false;
        }
        if(visit[x][y] <= w){
            return false;
        }
        return true;
    }
    public static boolean last(int x, int y, int dx, int dy){
        if(x==dx&&y==dy){
            return true;
        }
        return false;
    }
}











/* 

class Move {
    int x;
    int y;
    int c;
    Move(int x, int y, int c){
        this.x = x; 
        this.y = y; 
        this.c = c;
    }
    @Override
    public String toString(){
        return "x: " + x + " y: " + y + " c: " + c;
    }
}

class B2206 {
    static int N,M,answer=Integer.MAX_VALUE;
    static int[][] arr;
    static boolean[][] visit;
    static int[] arrx = {1,-1,0,0}, arry = {0,0,-1,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        String[] temp;
        int[] a;
        ArrayList<int[]> arrayList = new ArrayList<int[]>();
        for(int i=0;i<N;i++){
            temp = br.readLine().split("");
            for(int j=0;j<M;j++){
                arr[i][j] = Integer.parseInt(temp[j]);
                if(arr[i][j]==1){
                    a = new int[2];
                    a[0] = i;
                    a[1] = j;
                    arrayList.add(a);
                }
            }
        }
        int x,y;
        for(int i=0;i<arrayList.size();i++){
            x = arrayList.get(i)[0];
            y = arrayList.get(i)[1];
            arr[x][y] = 0;
            visit = new boolean[N][M];
            bfs();
            arr[x][y] = 1;
        }
        visit = new boolean[N][M];
        bfs();
        bw.write(Integer.toString(answer==Integer.MAX_VALUE?-1:answer));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void bfs(){
        int count=1,nx,ny;
        Move move;
        if(last(0,0,N-1,M-1)){
            answer = Math.min(answer,count);
            return;
        }
        Queue<Move> que = new LinkedList<Move>();
        que.add(new Move(0,0,count));
        visit[0][0] = true;
        while(!que.isEmpty()){
            move = que.poll();
            for(int i=0;i<4;i++){
                nx = move.x + arrx[i];
                ny = move.y + arry[i];
                if(last(nx,ny,N-1,M-1)){
                    answer = Math.min(answer,move.c+1);
                    return;
                }
                if(check(nx,ny,N-1,M-1)){
                    visit[nx][ny] = true;
                    que.add(new Move(nx,ny,move.c+1));
                }
            }
        }
    }

    public static boolean check(int x, int y, int dx, int dy){
        if(x<0||y<0||dx<x||dy<y){
            return false;
        }
        if(visit[x][y]==true){
            return false;
        }
        if(arr[x][y]==1){
            return false;
        }
        return true;
    }
    
    public static boolean last(int x, int y, int dx, int dy){
        if(x==dx&&y==dy){
            return true;
        }
        return false;
    }


}

 */
