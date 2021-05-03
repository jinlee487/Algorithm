package greedy_algorythm;

import java.util.*;
import java.io.*;
 
/*
 * SOLVED!!
 * https://www.acmicpc.net/problem/14754
 * Pizza Boxes
 * 
 * the key is that all the boxes have different heights. 
 * so we can simply find the tallest going by row, then column 
 * loop, and add the boxes that arent the tallest.
 * ****All heights are between 0 and 10^9 inclusive and the heights are all different.*****
 * because the heights are as tall as 10^9 we have to use long type for our answer variable.
*/

public class B14754 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        Boolean[][] bool = new Boolean[n][m];
        for(Boolean[] b : bool){
            Arrays.fill(b, false);
        }
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
            arr[i][j] = Integer.parseInt(st.nextToken()); 
            }
        //    System.out.println("this is arr => " + Arrays.toString(arr[i]));
        } 
        int max,idx;
        for(int i=0;i<n;i++){ 
            max = Integer.MIN_VALUE;
            idx = -1;
            for(int j=0;j<m;j++){
                if(max<arr[i][j]){
                    max = arr[i][j];
                    idx = j;
                }
            }
            bool[i][idx] = true;
        }
        for(int i=0;i<m;i++){ 
            max = Integer.MIN_VALUE;
            idx = -1;
            for(int j=0;j<n;j++){
                if(max<arr[j][i]){
                    max = arr[j][i];
                    idx = j;
                }
            }
            bool[idx][i] = true;
        }
        Long ans = 0L;
        for(int i=0;i<n;i++){ 
            for(int j=0;j<m;j++){
                if(!bool[i][j]){
                    ans += arr[i][j];
                }
            }
        }
        bw.write(Long.toString(ans));
        bw.flush();
        bw.close();
        br.close();
    }
}
 