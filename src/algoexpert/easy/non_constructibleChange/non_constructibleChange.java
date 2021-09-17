package algoexpert.easy.non_constructibleChange;
import java.util.*;

class non_constructibleChange {
    
  public int nonConstructibleChange(int[] coins) {
    // O(nlogn) time | O(1) space - where n is the number of coins
		Arrays.sort(coins);
		int s = 0;
		for(int coin : coins){
			if(s+1<coin){
				return s+1;
			}
			s += coin;		
		}
    return s+1;
  }
}


