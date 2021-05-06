package bfs;
import java.io.*;
import java.util.*;
/* 
Solved!
https://www.acmicpc.net/problem/14502
연구소
since the time limit is 2 seconds, 
we can use backtracking to spread the virus
*/
class Virus { 
    int x;
    int y;
    Virus (int x,int y) {
        this.x = x; 
        this.y = y;
    }
    @Override
    public String toString(){
        return "x: " + x + " y: "  + y;
    }

}
public class B14502 {
    static int[] arrx = {1,-1,0,0}, arry = {0,0,-1,1};
    static Queue<Virus> q1 = new LinkedList<Virus>();
    static ArrayList<Virus> q2 = new ArrayList<Virus>();
    static ArrayList<Virus> arrayList = new ArrayList<Virus>();
    static Stack<Virus> stack = new Stack<Virus>();
    static boolean[] visit;
    static int[][] arr1;
    static int[][] arr2;
    static int N,M,ans=Integer.MAX_VALUE;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr1 = new int[N][M];
        arr2 = new int[N][M];
        for(int i=0;i<N;i++){  
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                arr1[i][j] = Integer.parseInt(st.nextToken());
                arr2[i][j] = arr1[i][j];
                if(arr1[i][j]==2){
                    q1.add(new Virus(i,j));
                    q2.add(new Virus(i,j));
                }
                if(arr1[i][j]==0){
                    arrayList.add(new Virus(i,j));
                }
            }
        }
        
        for(int i=0;i<arrayList.size()-2;i++){
            visit = new boolean[arrayList.size()]; 
            stack.add(arrayList.get(i));
            visit[i] = true;
            dfs(i);
            visit[i] = false;
            stack.pop();
        }
        bw.write(Integer.toString(arrayList.size()-ans-3));
        bw.flush();
        bw.close();
        br.close();
    }
    public static void dfs(int idx){
        if(stack.size() == 3){
            wall(stack);
            bfs();
            cloneArray();
            return;
        }
        for(int i=idx+1;i<arrayList.size();i++){
            if(!visit[i]){
                stack.add(arrayList.get(i));
                visit[idx] = true;
                dfs(i);
                visit[idx] = false;
                stack.pop();
            }
        }
    }
    public static void cloneArray(){
        for(int i=0;i<arr1.length;i++){
            arr1[i] = arr2[i].clone();
        }
        for(int i=0;i<q2.size();i++){
            q1.add(q2.get(i));
        }   
    }
    public static void wall(Stack<Virus> stack){
        Virus v;
        Stack<Virus> temp = new Stack<Virus>();
        for(;!stack.isEmpty();){
            v = stack.pop();
            temp.add(v);
            arr1[v.x][v.y] = 1;
        }
        for(;!temp.isEmpty();){
            stack.add(temp.pop());
        }
    } 
    public static void bfs(){
        int nx,ny,count=0;
        Virus v;

        for(;!q1.isEmpty();){
            v = q1.poll();
            for(int j=0;j<4;j++){
                nx = v.x + arrx[j];
                ny = v.y + arry[j];
                if(check(nx,ny)){
                    count ++;
                    q1.add(new Virus(nx,ny));
                    arr1[nx][ny] = 1;
                }
            }
        }
        ans = Math.min(ans,count);
    }
    public static boolean check(int x,int y){
        if(x<0||y<0||N<=x||M<=y){
            return false;
        }
        if(arr1[x][y]!=0){
            return false;
        }
        return true;    
    }
}
