package algoexpert.medium.MinNumberOfCoinsForChange;

import java.util.*;

class Program {
  public static int minNumberOfCoinsForChange(int n, int[] denoms) {
    // Write your code here.
		// O(nd) time | O(n) space
		int[] dp = new int[n+1];
		int toCompare = 0;
		Arrays.sort(denoms);
		Arrays.fill(dp,Integer.MAX_VALUE);
		dp[0] = 0;

		for(int denom : denoms){
			for(int i=1;i<dp.length;i++){
				if(i<denom) continue; 
				if(dp[i-denom] == Integer.MAX_VALUE) {
					toCompare = dp[i-denom];
				} else {
					toCompare = dp[i-denom] + 1;
				}
				dp[i] = Math.min(dp[i],toCompare);				
			}			
		}
		return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
  }
}
