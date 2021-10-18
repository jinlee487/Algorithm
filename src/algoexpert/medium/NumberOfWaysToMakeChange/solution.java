package algoexpert.medium.NumberOfWaysToMakeChange;

import java.util.*;

class Program {
  public static int numberOfWaysToMakeChange(int n, int[] denoms) {
    // Write your code here.
		int[] answer = new int[n+1];
		answer[0] = 1;
		for(int i=0;i<denoms.length;i++){
			for(int j=1;j<n+1;j++){
				if(denoms[i]<=j){
					answer[j] += answer[j-denoms[i]];
				}
			}
		}
    return answer[n];
  }
}
