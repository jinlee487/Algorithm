package dynamic_programming;

import java.util.*;
import java.io.*;
/* 
https://www.acmicpc.net/problem/11048
이동하기 
basic dynamic programming
*/
class B11048 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int[][] arr = new int[n + 1][m + 1];
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for (int j = 1; j <= m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                arr[i][j] += Math.max(arr[i][j-1],Math.max(arr[i-1][j], arr[i-1][j-1]));
            }
        }
        bw.write(Integer.toString(arr[n][m]));
        bw.flush();
        bw.close();
        br.close();
    }
}