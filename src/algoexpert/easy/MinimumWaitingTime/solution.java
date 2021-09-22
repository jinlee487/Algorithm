package algoexpert.easy.MinimumWaitingTime;

import java.util.*;

class Program {

  public int minimumWaitingTime1(int[] queries) {
    // Write your code here.
		Arrays.sort(queries);
		int answer = 0;
		int wait = 0;
		for(int i=1;i<queries.length;i++){
			wait += queries[i-1];
			answer += wait;
		}
    return answer;
  }
  public int minimumWaitingTime2(int[] queries) {
    // Write your code here.
		Arrays.sort(queries);
		int answer = 0 ; 
		for(int i=0;i<queries.length;i++){
			answer += queries[i] * (queries.length-1-i);
		}
    return answer;
  }
}
