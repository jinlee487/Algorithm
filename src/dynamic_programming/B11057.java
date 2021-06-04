package dynamic_programming;
import java.util.*;
import java.io.*;

/* 
Solved!
https://www.acmicpc.net/problem/11057
오르막수
dynamic programming memoization
*/

class B11057 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N+1][10];
        for(int i =0; i<10; i++){
            arr[1][i] = 1;
        }
        for(int i=2; i<N+1; i++){
            for(int j=0; j<10; j++){
                for(int k=0; k<=j; k++){
                    arr[i][j] += arr[i-1][k];
                    arr[i][j] %= 10007;
                }
            }
        }
        // for(int[] a:arr){
        //     System.out.println(Arrays.toString(a));
        // }
        // j is the last digit. If j==1, it means whatever number we have currently is ending with j.
        // for example, 11,21,31,41,51,61,71,81,91. Out of these numbers, 11 is the only ascending number. 
        // therefore, we put 1 in arr[2][1]
        int sum = 0;
        for(int i=0; i<10; i++){
            sum += arr[N][i];
        }
        bw.write(Integer.toString(sum%10007));
        bw.flush();
        bw.close();
        br.close();
    }
}
