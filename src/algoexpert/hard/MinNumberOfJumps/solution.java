package algoexpert.hard.MinNumberOfJumps;

import java.util.*;

class Program1 {
  public static int minNumberOfJumps(int[] array) {
    // Write your code here.
		//O(n^2) times | O(n) space
		int[] dp = new int[array.length];
		for(int i=0;i<dp.length;i++) dp[i] = i;
		// System.out.println(Arrays.toString(dp));
		for(int i=0;i<array.length;i++){
			for(int j=1;j<=array[i] && i+j<array.length;j++){
				dp[i+j] = Math.min(dp[i+j],dp[i]+1);
			}
		}
		// System.out.println(Arrays.toString(dp));
    return dp[dp.length-1];
  }
}

class Program2 {
  public static int minNumberOfJumps(int[] array) {
    // Write your code here.
		//O(n^2) times | O(n) space
		int[] dp = new int[array.length];
		for(int i=0;i<dp.length;i++) dp[i] = i;
		// System.out.println(Arrays.toString(dp));
		for(int i=1;i<array.length;i++){
			for(int j=0;j<i;j++){
				if(array[j]>=i-j) dp[i] = Math.min(dp[j]+1,dp[i]);
			}
		}
		// System.out.println(Arrays.toString(dp));
    return dp[dp.length-1];
  }
}

class Program3 {
  public static int minNumberOfJumps(int[] array) {
    // Write your code here.
		if(array.length==1) return 0;
		int dp = 0;
		int maxReach = array[0];
		int steps = array[0];
		for(int i=1;i<array.length-1;i++){
			maxReach = Math.max(maxReach,i+array[i]);
			steps--;
			if(steps==0){
				dp++;
				steps = maxReach-i;
			}
		}
    return dp+1;
  }
}
