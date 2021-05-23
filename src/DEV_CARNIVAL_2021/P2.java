package DEV_CARNIVAL_2021;
import java.io.*;
import java.util.*;
//for this problem, I will use bfs algorithm 
class U {
    int x1;
    int y1;
    int x2;
    int y2;
    int c;
    U(int x1, int y1, int x2, int y2, int c){
        this.x1 = x1; this.y1 = y1; this.x2 = x2; this.y2 = y2; this.c = c;
    }
    @Override
    public String toString(){
        return "x1: " + x1 + " y1: "+ y1 + " x2: " +x2 + " y2: " +y2;
    }

}
class P2 {
    static char[][] arr;
    static int[][] visit;
    static int[] arrx = {-1,1,0,0}, arry = {0,0,-1,1};
    static int answer=-1, N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        visit = new int[N][N];
        for(int[] v: visit){
            Arrays.fill(v, 1);
        }
        for(int i=0;i<N;i++){
            arr[i] = br.readLine().toCharArray();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());       
        bfs(x1, y1, x2, y2);
        System.out.println(answer);
	}
    private static void bfs(int x1,int y1,int x2,int y2){
        int count=0, nx1,ny1,nx2,ny2, fx1, fy1, fx2, fy2;
        boolean u1=false, u2=false;
        if(arr[x1][y1]=='D'&&arr[x2][y2]=='D'){
            answer = count;
            return; 
        }
        Queue<U> que = new LinkedList<U>();
        U u = new U(x1, y1, x2, y2, count);
        que.add(u);
        while(!que.isEmpty()){
            u = que.poll();
            for(int i=0;i<4;i++){
                nx1 = u.x1 + arrx[i];
                ny1 = u.y1 + arry[i];
                for(int j=0;j<4;j++){
                    nx2 = u.x2 + arrx[j];
                    ny2 = u.y2 + arry[j];
                    if(check(nx1,ny1,2)||check(nx2,ny2,3)){
                        if(check(nx1,ny1,2)){
                            fx1 = nx1;
                            fy1 = ny1;
                            visit[fx1][fy1]*=2;
                        } else {
                            fx1 = u.x1;
                            fy1 = u.y1;
                        }
                        if(check(nx2,ny2,3)){
                            fx2 = nx2;
                            fy2 = ny2;
                            visit[fx2][fy2]*=3;
                        } else {
                            fx2 = u.x2;
                            fy2 = u.y2;
                        }
                        if(arr[fx1][fy1]=='D'){
                            u1 = true;
                        }
                        if(arr[fx2][fy2]=='D'){
                            u2 = true;
                        }
                        if(u1&&u2){
                            answer = u.c +1;
                            return;
                        }
                        que.add(new U(fx1,fy1,fx2,fy2,u.c+1));
                    }
                }
            }
        }
    }
    private static boolean check(int x, int y, int u){
        if(x<0||y<0||N<=x||N<=y){
            return false;
        }
        if(visit[x][y]%u==0){
            return false;
        }
        if(arr[x][y]=='X'){
            return false;
        }
        return true;
    }
}