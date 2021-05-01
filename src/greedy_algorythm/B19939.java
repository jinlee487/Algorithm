package greedy_algorythm;

import java.util.*;
import java.io.*;
 
/*
 * SOLVED!!
 * https://www.acmicpc.net/problem/19939
 * 박 터트리기
*/

public class B19939 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[K+1];
        int ans = 0;
        for(int i=1;i<K+1;i++){
            if(i<=N){
                arr[i] = i ;
                N -= i;
            } else {
                //this means there is not enough balls to put into the arr[i] with a distinct value
                ans = -1;
                break;
            }
        }
        // System.out.println("this is arr => " + Arrays.toString(arr));
        if(-1!=ans){
            while(0<N){
                // System.out.println("this is N = > " + N);
                int idx = N<K?K+1-N:1;
                // System.out.println("this is idx => " + idx);
                // there is left over balls to be distributed 
                for(int i=idx;i<K+1;i++){
                    arr[i] += 1;
                    N-=1;
                }
            }
            // System.out.println("this is arr => " + Arrays.toString(arr));

            ans=arr[K]-arr[1];
        }
        bw.write(Integer.toString(ans));
        bw.flush();
        bw.close();
        br.close();
        
    }
}
 