package greedy_algorythm;
import java.util.*;
import java.io.*;
/*
 * SOLVED!!
 * https://www.acmicpc.net/problem/9009
 * 피보나치
*/

public class Fibonacci {    
    static int[] dp;
    static int curr=0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine()); 
        int[] arr = new int[T];

        for(int i=0;i<T;i++){
            arr[i] =  Integer.parseInt(br.readLine()); 
        }
        dp = new int[45];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2; i<dp.length; i++){
			dp[i] = dp[i-2] + dp[i-1];
        }
        ArrayList<Integer> arrayList; 
        for(int i=0;i<arr.length;i++){
            curr = arr[i];
            arrayList = new ArrayList<Integer>();
            for(int j=dp.length-1;-1<j;j--){
                if(curr<dp[j]){
                    continue;
                }else{
                    curr-=dp[j];
                    arrayList.add(dp[j]);
                }
                if(curr == 0){
                    Collections.sort(arrayList);
                    for(int a : arrayList){
                        bw.write(a + " ");
                    }
                    break;
                }
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
