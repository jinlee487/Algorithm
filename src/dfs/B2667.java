package dfs;
import java.util.*;
import java.io.*;

/*
 * Solved!!
 * https://www.acmicpc.net/problem/2667
 * 
 * 단지번호붙이기
 * 
 * */
public class B2667 {
    static ArrayList<ArrayList<Vector<Integer>>> arrayList;   
    static char[][] arr;
    static int idx=0;
    static int N; 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        for(int i=0;i<N;i++){
            arr[i] = br.readLine().toCharArray();
        }
        // for(char[] a : arr){
        //     System.out.println( Arrays.toString(a));
        // }
        arrayList = new ArrayList<ArrayList<Vector<Integer>>>();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(arr[i][j]=='1'){
                    arrayList.add(new ArrayList<Vector<Integer>>());
                    dfs(i,j);
                    idx ++;
                }
            }
        }
        bw.write(Integer.toString(arrayList.size())+"\n");

        Collections.sort(arrayList, new Comparator<ArrayList<Vector<Integer>>>(){
            @Override
            public int compare(ArrayList<Vector<Integer>> o1, ArrayList<Vector<Integer>> o2){
                return o1.size() - o2.size();
            }
        });

        for(ArrayList<Vector<Integer>> a: arrayList){
            // System.out.println("this is a => " + a);
            bw.write(Integer.toString(a.size())+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    public static int dfs(int x, int y){
        if(N<=x||x<0||y<0||N<=y){
            return 0;
        }
        if(arr[x][y]=='0'){
            return 0;
        }
        if(arr[x][y]=='1'){
            Vector<Integer> vector = new Vector<Integer>(2);
            vector.add(x);
            vector.add(y);
            arrayList.get(idx).add(vector);
            arr[x][y] = '0';
        }
        dfs(x-1,y);
        dfs(x,y-1);
        dfs(x,y+1);
        dfs(x+1,y);
        
        return 0;
    }
}
