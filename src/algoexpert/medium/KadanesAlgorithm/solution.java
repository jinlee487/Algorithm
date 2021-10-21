package algoexpert.medium.KadanesAlgorithm;
import java.util.*;

class Program {
  public static int kadanesAlgorithm(int[] array) {
    // Write your code here
		// O(n) time | O(1) space
		int answer = array[0];
		for(int i=1;i<array.length;i++){
			array[i] = Math.max(array[i],array[i]+array[i-1]);
			answer = Math.max(answer,array[i]);
		}
    return answer;
  }
}
