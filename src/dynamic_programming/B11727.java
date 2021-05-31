package dynamic_programming;
import java.io.*;
import java.util.*;

/* 
Solved!
https://www.acmicpc.net/problem/11727
2xn 타일링 2
*/


//bottom up method
public class B11727 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        if(N!=1){
            arr[0] = 1;
            arr[1] = 1;
            arr[2] = 3;
            for(int i=3;i<N+1;i++){
                arr[i] = (arr[i-1] + 2 * arr[i-2])%10007;
            }
            bw.write(Integer.toString(arr[N]));
            bw.flush();
            bw.close();
            br.close();
        } else {
            arr[0] = 1;
            arr[1] = 1;
            bw.write(Integer.toString(arr[N]));
            bw.flush();
            bw.close();
            br.close();
        }
    }
}

// //top down method
// public class B11727 {
//     static int[] arr;
//     public static void main(String[] args) throws Exception {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//         int N = Integer.parseInt(br.readLine());
//         arr = new int[N+1];
//         if(N!=1){
//             arr[0] = 1;
//             arr[1] = 1;
//             arr[2] = 3;
//             bw.write(Integer.toString(dp(N)));
//             bw.flush();
//             bw.close();
//             br.close();
//         } else {
//             arr[0] = 1;
//             arr[1] = 1;
//             bw.write(Integer.toString(arr[N]));
//             bw.flush();
//             bw.close();
//             br.close();
//         }
//     }
//     private static int dp(int N){
//         if (arr[N] > 0) {
//             return arr[N];
//         }
//         arr[N] = (dp(N-1) + 2 * dp(N-2))%10007;
//         return arr[N];
//     }
// }