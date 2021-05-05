package dfs;
import java.io.*;
import java.util.*;
/* 
Solved!
https://www.acmicpc.net/problem/2583
영역 구하기 
*/
class B2583 {
    static int M,N,K,count;
    static int[][] arr;
    static PriorityQueue<Integer> pq = new PriorityQueue<Integer>(); 
    static int[] arrx = {-1,1,0,0}, arry = {0,0,-1,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[M][N];
        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            fillRectangle(
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())
                );
        }
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(arr[i][j]==0){
                    count = 1;
                    arr[i][j] = 1;
                    dfs(j,i);
                    pq.add(count);
                }
            }
        }
        StringBuilder str = new StringBuilder();
        str.append(pq.size()+ "\n");
        for(;!pq.isEmpty();){
            str.append(pq.poll() + " ");
        }
        bw.write(str.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    public static void dfs(int x,int y){
        for(int i=0;i<4;i++){
            int nextx = x + arrx[i];
            int nexty = y + arry[i];
            if(check(nextx,nexty)){
                arr[nexty][nextx] = 1;
                count ++;
                dfs(nextx,nexty);
            }
        }
    }
    public static Boolean check(int x, int y){
        if(x<0||y<0||M<=y||N<=x){
            return false;
        }
        if(arr[y][x]==1){
            return false;
        }
        return true;
    }
    public static void fillRectangle(int sx,int sy, int ex, int ey){
        for(int i=sy;i<ey;i++){ 
            for(int j=sx;j<ex;j++){
                arr[i][j] = 1;
            }
        }
    }
}