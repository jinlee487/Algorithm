package greedy_algorythm;

import java.util.Arrays;
import java.util.Scanner;

/*
 * SOLVED!!
 * https://www.acmicpc.net/problem/2839
 * 설탕 배달
 * 
*/
public class sugar {
	public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        int num = sc.nextInt();
        int[] dp = new int[num+1];
        Arrays.fill(dp,5001);
        for(int i=1;i<dp.length;i++){
            if(i%3==0 && i%15!=0){
                dp[i]=i/3;
            }
            else if (i%5==0){
                dp[i]=i/5;
            }
            if(i>5){
                dp[i] = Math.min( dp[i], Math.min(dp[i-3]+1,dp[i-5]+1));
            }
        }
        if(dp[num]==5001){
            dp[num] = -1;
        }
        System.out.println(dp[num]);
    }
}