package dynamic_programming;
import java.io.*;
import java.util.*;

/* 
Solved!
https://www.acmicpc.net/problem/11726
2xn 타일링
*/


//bottom up method
public class B11726 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        arr[0] = 1;
        arr[1] = 1;
        for(int i=2;i<N+1;i++){
            arr[i] = (arr[i-1] + arr[i-2])%10007;
        }
        bw.write(Integer.toString(arr[N]));
        bw.flush();
        bw.close();
        br.close();
    }
}

// //top down method
// public class B11726 {
//     static int[] arr;
//     public static void main(String[] args) throws Exception {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//         int N = Integer.parseInt(br.readLine());
//         arr = new int[N+1];
//         bw.write(Integer.toString(dp(N)));
//         bw.flush();
//         bw.close();
//         br.close();
//     }
//     private static int dp(int N){
//         if (N == 0 || N == 1){
//             return 1;
//         }
//         if (arr[N] > 0) {
//             return arr[N];
//         }
//         arr[N] = (dp(N-1) + dp(N-2))%10007;
//         return arr[N];
//     }
// }