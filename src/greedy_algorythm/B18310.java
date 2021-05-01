package greedy_algorythm;
import java.util.*;
import java.io.*;

/*
 * SOLVED!!
 * https://www.acmicpc.net/problem/18310
 * 안테나
 * 
 * In this problem, we have to find the median of the array.
*/
public class B18310 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int idx; 
        if(N%2==0){
            idx = N/2-1;
        } else{
            idx = (N+1)/2-1;
        }
        // if it is even, we can get the first of the two houses closest to the median
        // if it is odd, we can add 1 then divide by 2 
        // we subtract by 1 to match the arrays index starting from 0 
        // System.out.println("this is arr => " + Arrays.toString(arr));
        bw.write(Integer.toString(arr[idx]));
        bw.flush();
        bw.close();
        br.close();
    }
} 