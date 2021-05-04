package dfs;

import java.util.*;
import java.io.*;
/*
 * Solved!!
 * https://www.acmicpc.net/problem/1987
 * 
 * 알파벳
 * 
 * in this question, we have to save all the traversed nodes in a set 
 * so that we can refer back to and find the traversed depth
 * we also have to save the set to a list becaue we have to save the 
 * excect path that we took
 * 
 * my first attempt didnt work because working the keys took too much time.
 * must remember to minimize time how ever possible
 */
public class B1987 {

    private static int r, c, max = Integer.MIN_VALUE; 
    private static int[][] board; 
    private static boolean[] visit = new boolean[26]; 
    private static int[] dx = {0, 0, 1, -1}; 
    private static int[] dy = {1, -1, 0, 0}; 
    public static void main(String[] args) throws Exception { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        r = Integer.parseInt(st.nextToken()); 
        c = Integer.parseInt(st.nextToken()); 
        board = new int[r][c]; 
        String temp; 
        for (int i = 0; i < r; i++) { 
            temp = br.readLine(); 
            for (int j = 0; j < c; j++) { 
                board[i][j] = temp.charAt(j) - 'A'; 
            } 
        } 
        visit[board[0][0]] = true;
        dfs(0, 0, 1); 
        System.out.println(max); 
    } 
    private static void dfs(int x, int y, int count) { 
        if (max < count) max = count; 
        int nx, ny; 
        for (int i = 0; i < 4; i++) { 
            nx = x + dx[i]; 
            ny = y + dy[i]; 
            if (isValid(nx, ny)) { 
                int num = board[nx][ny]; 
                if (!visit[num]) { 
                    visit[num] = true; 
                    dfs(nx, ny, count + 1); 
                    visit[num] = false; 
                } 
            } 
        } 
    } 
    private static boolean isValid(int x, int y) { 
        if (x < 0 || y < 0 || x >= r || y >= c) return false; 
        return true; 
    }



    // static char[][] arr;
    // static int R, C;
    // static ArrayList<Integer> arrayList = new ArrayList<Integer>();
    // public static void main(String[] args) throws Exception {
    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //     BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    //     StringTokenizer st = new StringTokenizer(br.readLine());
    //     R = Integer.parseInt(st.nextToken());
    //     C = Integer.parseInt(st.nextToken());
    //     arr = new char[R][C];
    //     for(int i=0;i<R;i++){
    //         arr[i] = br.readLine().toCharArray();
    //     }
    //     HashSet<Character> set = new HashSet<Character>();
    //     dfs(0,0,set);
    //     // we start aat 0, 0 and traverse to see how far we get
    //     Collections.sort(arrayList,Collections.reverseOrder());
    //     bw.write(Integer.toString(arrayList.get(0)));
    //     bw.flush();
    //     bw.close();
    //     br.close();
    // }
    // public static int dfs(int x, int y,HashSet<Character> set){
    //     HashSet<Character> s = new HashSet<>();
    //     s.addAll(set);
    //     if(x<0||y<0||R<=x||C<=y){
    //         return 0;
    //     }
    //     if(s.contains(arr[x][y])){
    //         return 0;
    //     }
    //     int a,b,c,d;
    //     s.add(arr[x][y]);
    //     a=dfs(x-1,y,s);
    //     b=dfs(x+1,y,s);
    //     c=dfs(x,y-1,s);
    //     d=dfs(x,y+1,s);
    //     if(a==0&&b==0&&c==0&&d==0){
    //         // we hit a deadend, this is one of the final nodes. 
    //         // we can save the list now.
    //         arrayList.add(s.size());
    //         return 1;
    //     }
    //     return 0;

    // }
}
