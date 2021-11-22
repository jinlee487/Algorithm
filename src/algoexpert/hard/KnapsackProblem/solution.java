package algoexpert.hard.KnapsackProblem;
import java.util.*;

class Program {
  public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
    // Write your code here.
    // O(nc) time | O(nc) space where c is the capacity
		int[][] dp = new int[items.length+1][capacity+1];
		for(int i=1;i<items.length+1;i++){
			int currentWeight = items[i-1][1];
			int currentValue = items[i-1][0];
			for(int c=0;c<capacity+1;c++){
				if(currentWeight>c) dp[i][c] = dp[i-1][c];
 				else dp[i][c] = Math.max(dp[i-1][c],dp[i-1][c-currentWeight]+currentValue);
			}
		}
    return knapsackProblem(dp,items,dp[items.length][capacity]);
  }
	public static List<List<Integer>> knapsackProblem(int[][] dp, int[][] items, int weight){
		List<List<Integer>> sequence = new ArrayList<List<Integer>>();
		List<Integer> totalWeight = new ArrayList<Integer>();
		totalWeight.add(weight);
		sequence.add(totalWeight);
		sequence.add(new ArrayList<Integer>());
		int i = dp.length-1;
		int c = dp[0].length-1;
		while(i>0){
			if(dp[i][c] == dp[i-1][c]) i--;
			else {
				sequence.get(1).add(0,i-1);
				c -= items[i-1][1];
				i--;
			}
			if(c==0) break;
		}
		return sequence;
	}
}
