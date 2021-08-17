package dynamic_programming;
import java.util.*;
import java.io.*;
/* 
https://codeforces.com/problemset/problem/996/A
A. Hit the Lottery
Solved
*/
public class C996 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        int[] arr = {100,20,10,5,1};
        for(int i=0;i<arr.length||n<0;i++){
            answer += n/arr[i];
            n %= arr[i];
        }       
        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
