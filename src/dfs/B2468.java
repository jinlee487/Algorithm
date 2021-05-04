package dfs;
import java.io.*;
import java.util.*;
/*
https://www.acmicpc.net/problem/2468
안전영역
for this problem we have to find the maximum number of islands 
that are formed by the rain. 
we have to control the level of rain water and scale until we find the 
max number of island before it decrease at the next scale 
*/
public class B2468 {

    static int[][] arr,check;
    static int count,w,N;
    private static int[] dx = {0, 0, 1, -1}; 
    private static int[] dy = {1, -1, 0, 0}; 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        StringTokenizer st;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(!arrayList.contains(arr[i][j])){
                    arrayList.add(arr[i][j]);
                }
            }
        }
        Collections.sort(arrayList);
        int ans=1;
        for(Integer waterLevel : arrayList){
            count = 0;
            w = waterLevel;
            check = new int[N][N];
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(w<arr[i][j]&&check[i][j]!=1){
                        dfs(i,j);
                        count ++;
                    }
                }
            }
            if(ans<=count){
                ans = count;
            } 
        }
        bw.write(Integer.toString(ans));
        bw.flush();
        bw.close();
        br.close();
    }
    public static int dfs(int x, int y) {
        int nx, ny;
        for (int i = 0; i < 4; i++) { 
            nx = x + dx[i]; 
            ny = y + dy[i]; 
            if (isValid(nx, ny)) { 
                if (w<arr[nx][ny]&&check[nx][ny]!=1) { 
                    check[nx][ny] = 1;
                    dfs(nx, ny); 
                } 
            } 
        }
        return 0;
    }
    private static boolean isValid(int x, int y) { 
        if (x < 0 || y < 0 || x >= N || y >= N) return false; 
        return true; 
    }
}
