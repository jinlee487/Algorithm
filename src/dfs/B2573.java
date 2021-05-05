package dfs;
import java.io.*;
import java.util.*;
/* 
https://www.acmicpc.net/problem/2573
빙산
칸에 있는 높이는 일년마다 그 칸에 동서남북 
네 방향으로 붙어있는 0이 저장된 칸의 개수만큼 줄어든다. 
*/

public class B2573 {
	static int[][] arr;
	static int[][] visit;
	static int N, M, 
        max=Integer.MIN_VALUE,
        fx=-1,fy=-1,
        time,count=0;
    static int[] arrx = {-1,1,0,0}, arry = {0,0,-1,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        int temp;
		for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                temp = Integer.parseInt(st.nextToken());
                arr[i][j] = temp;
            } 
        }

        boolean end = false;
        e:
        for(int i=0;;i++){
            if(end){
                break;
            }
            
            time = i;
            count = 0;
            visit = new int[N][M];

            if(0<i){
                if(melt()){
                    System.out.println("\n melt = false!! time => " + time) ;
                    for(int[] a : arr){
                        System.out.println(Arrays.toString(a));
                    }
                    time = 0;
                    break;
                }   
            }


            System.out.println("\n this is after melt ! time => " + time) ;
            for(int[] a : arr){
                System.out.println(Arrays.toString(a));
            }
            for(int j=1;j<N;j++){
                for(int k=1;k<M;k++){
                    if(0<arr[j][k]&&visit[j][k]==0){
                        count ++; 
                        if(1<count){
                            end = true;
                            System.out.println("count => " + count + " end is true");
                            break e;
                        }
                        visit[j][k] = 1;
                        dfs(k,j);
                        System.out.println("\n this is after dfs ! ");

                        for(int[] a : visit){
                            System.out.println(Arrays.toString(a));
                        }
                    }
                }
            }
        }
		bw.write(Integer.toString(time));
        bw.flush();
        bw.close();
        br.close();
	}
    public static boolean melt() {
        int check = 0;
        int[][] coast = new int[N][M];
        for(int j=1;j<N;j++){
            for(int k=1;k<M;k++){
                if(arr[j][k]!=0){
                    int count = 0;
                    for(int i=0;i<4;i++){
                        int nx = k + arrx[i];
                        int ny = j + arry[i];
                        if(nx<0||ny<0||M<=nx||N<=ny){
                            continue;
                        } else {
                            if(arr[ny][nx]==0){
                                count ++;
                            }
                        }
                    }
                    coast[j][k] = count;
                }
            }
        }
        System.out.println("\n this is coast ! ");

        for(int[] a : coast){
            System.out.println(Arrays.toString(a));
        }

        for(int j=1;j<N;j++){
            for(int k=1;k<M;k++){
                if(coast[j][k]!=0){
                    arr[j][k]=coast[j][k]<arr[j][k]?arr[j][k]-coast[j][k]:0;
                }
            }
        }
        for(int j=1;j<N;j++){
            for(int k=1;k<M;k++){
                check = Math.max(arr[j][k],check);
            }
        }
        if(check==0){
            return true;
        }
        return false;
    }
	public static void dfs(int x, int y) {
        for(int i=0;i<4;i++){
            int nx = x + arrx[i];
            int ny = y + arry[i];
            if(check(nx,ny)){
                visit[ny][nx] = 1;
                dfs(nx,ny);
            }
        }
	}
    public static boolean check(int x, int y) {
        if(x<0||y<0||M<=x||N<=y){
            return false;
        }
        if(visit[y][x]==1){
            return false;
        }
        if(arr[y][x]<1){
            return false;
        }
        return true;
    }
	
}